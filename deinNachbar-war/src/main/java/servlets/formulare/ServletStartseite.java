//Veronika

package servlets.formulare;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import beans.formulare.BeanAnzeige;
import beans.formulare.BeanKategorie;
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
/**
 * Servlet implementation class ServletStartseite
 */
@WebServlet("/ServletStartseite")
public class ServletStartseite extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//Servlet lädt Kategorien und Anzeigen für die Startseite 
		List<BeanAnzeige> sucheAnzeigen = readAnzeigen("suche");
		List<BeanAnzeige> bieteAnzeigen = readAnzeigen("biete");
		List<BeanKategorie> kategorien = readKategorien();
		
		//Kategorien müssen in Session-Scope hinterlegt werden da kategorieID und kategorie-Werte noch zum Kategorien Löschen nach Request mit Löschen-Button benötigt werden!
		HttpSession session = request.getSession();
		
		request.setAttribute("suchenAnzeigen", sucheAnzeigen);
		request.setAttribute("bieteAnzeigen", bieteAnzeigen);
		HttpSession session = request.getSession();
	    session.setAttribute("kategorien", kategorien);


		final RequestDispatcher dispatcher = request.getRequestDispatcher("./html/startseite.jsp");
		dispatcher.forward(request, response);	
		
	}
	
	private List<BeanAnzeige> readAnzeigen(String anzeigeArtSQL) throws ServletException {
		List<BeanAnzeige> anzeigen = new ArrayList<BeanAnzeige>();
		
		try (Connection con = ds.getConnection();
				 PreparedStatement pstmt = con.prepareStatement("SELECT DISTINCT * FROM anzeige WHERE anzeigeArt = ? ORDER BY anzeigeID DESC;")) {

				pstmt.setString(1, anzeigeArtSQL);;
				try (ResultSet rs = pstmt.executeQuery()) {
					
					while (rs != null && rs.next()) {
						BeanAnzeige anzeige = new BeanAnzeige();
						
						Integer anzeigeID = Integer.valueOf(rs.getInt("anzeigeID"));
						anzeige.setAnzeigeID(anzeigeID);

						String anzeigeArt = rs.getString("anzeigeArt");
						anzeige.setAnzeigeArt(anzeigeArt);

						Integer benutzerID = (rs.getInt("benutzerID"));
						anzeige.setBenutzerID(benutzerID);

						String beschreibung = rs.getString("beschreibung");
						anzeige.setBeschreibung(beschreibung);

						Integer umkreis = (rs.getInt("umkreis"));
						anzeige.setUmkreis(umkreis);

						String standort = rs.getString("standort");
						anzeige.setStandort(standort);

						String titelAnzeige = rs.getString("titelAnzeige");
						anzeige.setTitelAnzeige(titelAnzeige);

						Integer preis = (rs.getInt("preis"));
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
	
	
	private List<BeanKategorie> readKategorien() throws ServletException {
		List<BeanKategorie> kategorien = new ArrayList<BeanKategorie>();
		
		try (Connection con = ds.getConnection();
				 PreparedStatement pstmt = con.prepareStatement("SELECT DISTINCT * FROM kategorie ORDER BY kategorie;")) {

				try (ResultSet rs = pstmt.executeQuery()) {
					
					while (rs != null && rs.next()) {
						BeanKategorie kategorieBean = new BeanKategorie();
						
						Integer kategorieID = rs.getInt("kategorieID");
						kategorieBean.setKategorieID(kategorieID);
						
						String kategorie = rs.getString("kategorie");
						kategorieBean.setKategorie(kategorie);

						kategorien.add(kategorieBean);
					} 
				}
			} catch (Exception ex) {
				throw new ServletException(ex.getMessage());
			}
				
		
		return kategorien;
		
	}


	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
