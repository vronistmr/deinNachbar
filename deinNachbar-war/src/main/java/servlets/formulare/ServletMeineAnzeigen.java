package servlets.formulare;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;

import javax.sql.DataSource;

import beans.formulare.BeanAnzeige;
import beans.formulare.BeanBenutzerdaten;
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletMeineAnzeigen
 */
@WebServlet("/ServletMeineAnzeigen")
public class ServletMeineAnzeigen extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(lookup="java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		int benutzerID = Integer.valueOf(((BeanBenutzerdaten) request.getSession().getAttribute("loginForm")).getBenutzerID());
		
		//DB-Zugriff
		List<BeanAnzeige> meineAnzeigen = read(benutzerID);
		
		//HttpSession session = request.getSession();
		//session.setAttribute("anzeigen", meineAnzeigen);
		//response.sendRedirect("./html/meineAnzeigen.jsp");
		
				request.setAttribute("anzeigen", meineAnzeigen);

				final RequestDispatcher dispatcher = request.getRequestDispatcher("./html/meineAnzeigen.jsp");
				dispatcher.forward(request, response);	
		
	}

	private List<BeanAnzeige> read(int benutzerID) throws ServletException {
		List<BeanAnzeige> anzeigen = new ArrayList<BeanAnzeige>();
		
		try (Connection con = ds.getConnection();
				 PreparedStatement pstmt = con.prepareStatement("SELECT DISTINCT * FROM anzeige WHERE benutzerID = ?")) {

				pstmt.setInt(1, benutzerID);;
				try (ResultSet rs = pstmt.executeQuery()) {
					
					while (rs != null && rs.next()) {
						BeanAnzeige anzeige = new BeanAnzeige();
						
						Integer anzeigeID = Integer.valueOf(rs.getInt("anzeigeID"));
						anzeige.setAnzeigeID(anzeigeID);

						String anzeigeArt = rs.getString("anzeigeArt");
						anzeige.setAnzeigeArt(anzeigeArt);

						anzeige.setBenutzerID(benutzerID);

						String beschreibung = rs.getString("beschreibung");
						anzeige.setBeschreibung(beschreibung);

						Integer umkreis = Integer.valueOf(rs.getInt("umkreis"));
						anzeige.setUmkreis(umkreis);

						String standort = rs.getString("standort");
						anzeige.setStandort(standort);

						String titelAnzeige = rs.getString("titelAnzeige");
						anzeige.setTitelAnzeige(titelAnzeige);

						Integer preis = Integer.valueOf(rs.getInt("preis"));
						anzeige.setPreis(preis);

						String preiskategorie = rs.getString("preiskategorie");
						anzeige.setPreiskategorie(preiskategorie);

						String kategorie = rs.getString("kategorie");
						anzeige.setKategorie(kategorie);

						Date datum = rs.getDate("datum");
						anzeige.setDatum(datum);

						Timestamp datetime = rs.getTimestamp("datum");
						anzeige.setDatetime(datetime);

						byte[] foto = rs.getBinaryStream("foto").readAllBytes();
						anzeige.setFoto(foto);
						
						anzeigen.add(anzeige);
					} 
				}
			} catch (Exception ex) {
				throw new ServletException(ex.getMessage());
			}
		
		return anzeigen;
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
