package main.java.com.servlets;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import main.java.com.beans.Coordonnees;
import main.java.com.beans.Ville;

/**
 * Servlet implementation class AjouterVille
 */
@WebServlet("/AjouterVille")
public class AjouterVille extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterVille() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterVille.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if (request.getParameter("envoi").equals("Add")) {
			System.out.println("btn pressé update");
			
			String nom_commune = (String) request.getParameter("nom_commune");
			String codeCommune = (String) request.getParameter("codeCommune");
			String code_postal = (String) request.getParameter("code_postal");
			String libelle_acheminement = (String) request.getParameter("libelle_acheminement");
			String ligne_5 = (String) request.getParameter("ligne_5");
			String Latitude = (String) request.getParameter("Latitude");
			String Longitude = (String) request.getParameter("Longitude");
			
			Coordonnees coordonnees = new Coordonnees(Latitude, Longitude);
			Ville nouvelleVille = new Ville(codeCommune,nom_commune,code_postal,libelle_acheminement, ligne_5, coordonnees );
			
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = mapper.writeValueAsString(nouvelleVille);
			URL url = new URL("http://localhost:8181/ville");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			OutputStream os = null;
			try {
				os = con.getOutputStream();
				byte[] input = jsonString.getBytes("UTF-8");
				os.write(input, 0, input.length);
			} finally {
				os.close();
			}
			if (con.getResponseCode() == 200) {
				this.doGet(request, response);
				this.getServletContext().getRequestDispatcher("/WEB-INF/distanceVilles.jsp").forward(request, response);

			}
		}
		
		
		doGet(request, response);
	}

}
