package main.java.com.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import main.java.com.beans.Coordonnees;
import main.java.com.beans.Ville;

/**
 * Servlet implementation class DistanceVilles
 */
@WebServlet("/DistanceVilles")
public class DistanceVilles extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DistanceVilles() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private static String readAll(Reader reader) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = reader.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static JSONArray readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONArray jarray = new JSONArray(jsonText);
			return jarray;
		} finally {
			is.close();
		}
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		JSONArray jsonArray = null;
		JSONObject json = null;
		List<Ville> listeVille = new ArrayList<Ville>();
		try {
			jsonArray = readJsonFromUrl("http://localhost:8181/ville");
		} catch (IOException | JSONException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < jsonArray.length(); i++) {
			json = jsonArray.getJSONObject(i);
			Ville ville = new Gson().fromJson(json.toString(), Ville.class);
			listeVille.add(ville);
		}
		request.setAttribute("listeVille", listeVille);
		request.setAttribute("nbreVilles", listeVille.size());
		
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/distanceVilles.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Ville ville1 = new Ville();
		ville1.setCoordonnees(new Coordonnees(request.getParameter("ville1").split(";")[0],
				request.getParameter("ville1").split(";")[1]));
		ville1.setNom_commune(request.getParameter("ville1").split(";")[2]);
		Ville ville2 = new Ville();
		ville2.setCoordonnees(new Coordonnees(request.getParameter("ville2").split(";")[0],
				request.getParameter("ville2").split(";")[1]));
		ville2.setNom_commune(request.getParameter("ville2").split(";")[2]);
		String distance = "La distance entre " + ville1.getNom_commune() + " et " + ville2.getNom_commune() + " est de "
				+ ville1.distanceAvec(ville2) + " km.";
		request.setAttribute("distance", distance);
		request.setAttribute("selection1", ville1.getNom_commune());
		request.setAttribute("selection2", ville2.getNom_commune());
		
		
		doGet(request, response);
	}

}
