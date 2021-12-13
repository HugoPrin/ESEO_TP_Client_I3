package main.java.com.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import main.java.com.beans.Coordonnees;
import main.java.com.beans.Ville;

/**
 * Servlet implementation class InfoVille
 */
@WebServlet("/InfoVille")
public class InfoVille extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoVille() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp = 0;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd).replace("[", "").replace("]", "");
			JSONObject object = new JSONObject(jsonText);
			return object;
		} finally {
			is.close();
		}
	}
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String codeCommune = (String) request.getParameter("codeCommune");
		System.out.println("codeCommune passé"+codeCommune);
		JSONObject json = null;
		try {
			json = readJsonFromUrl("http://localhost:8181/ville?codeCommune=" + codeCommune);
		} catch (IOException | JSONException e) {
			e.printStackTrace();
		}
		Ville ville = new Gson().fromJson(json.toString(), Ville.class);
		request.setAttribute("ville", ville);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/infoVille.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if (request.getParameter("envoi").equals("Delete")) {
			System.out.println("btn pressé");
			URL url = new URL("http://localhost:8181/ville?code_commune_INSEE=" + request.getParameter("codeCommune"));
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("DELETE");
			if (con.getResponseCode() == 200) {
				this.getServletContext().getRequestDispatcher("/WEB-INF/villes.jsp").forward(request, response);
			}
		}
		
		
		
		
		if (request.getParameter("envoi").equals("Update")) {
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
			URL url = new URL("http://localhost:8181/ville?codeCommune=" + request.getParameter("codeCommune"));
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("PUT");
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
				this.getServletContext().getRequestDispatcher("/WEB-INF/villes.jsp").forward(request, response);

			}
		}
		
		doGet(request, response);
	}

}
