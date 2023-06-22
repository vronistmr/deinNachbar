// Tobi

package servlets.formulare;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import javax.sql.DataSource;

import beans.formulare.BeanAnzeige;
import beans.formulare.BeanBenutzerdaten;
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/ServletAnzeigeAnzeigen")
public class ServletAnzeigeAnzeigen extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;
	private int benutzerID;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		int anzeigeid = Integer.parseInt(request.getParameter("anzeigeid"));

		BeanAnzeige anzeigebean = anzeigen(anzeigeid);
		
		benutzerID = Integer.valueOf(((BeanBenutzerdaten) request.getSession().getAttribute("loginForm")).getBenutzerID());
		
		//request Scope ausreichend - Bean wird durch DB-Select neu befüllt 
		//forward ausreichend da nur Lesender Zugriff
		request.setAttribute("AnzeigeForm", anzeigebean);
		RequestDispatcher disp = request.getRequestDispatcher("html/anzeigenAnzeigen.jsp");
		disp.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private BeanAnzeige anzeigen(int anzeigeid) throws ServletException {
		
		BeanAnzeige anzeige = new BeanAnzeige();
		
		// DB-Zugriff

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT anzeige.*, benutzer.vorname, benutzer.email FROM anzeige JOIN benutzer ON anzeige.benutzerID = benutzer.benutzerID WHERE anzeigeID = ?")) {

			pstmt.setInt(1, anzeigeid);
			try (ResultSet rs = pstmt.executeQuery()) {

				while (rs.next()) {
					

					Integer anzeigeID = Integer.valueOf(rs.getInt("anzeigeID"));
					anzeige.setAnzeigeID(anzeigeID);

					String anzeigeArt = rs.getString("anzeigeArt");
					anzeige.setAnzeigeArt(anzeigeArt);

					Integer benutzerID = Integer.valueOf(rs.getInt("benutzerID"));
					anzeige.setBenutzerID(benutzerID);
					
					String email = rs.getString("email");
					anzeige.setEmail(email);

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
					
					String vorname = rs.getString("vorname");
					anzeige.setVorname(vorname);

				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		
		//Lukas
		//prüfen, ob gebucht
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT COUNT(*) FROM gebuchte WHERE benutzerID = ? AND anzeigeID = ?")){
				pstmt.setInt(1, benutzerID);
				pstmt.setInt(2, anzeigeid);
				
				try (ResultSet rs = pstmt.executeQuery()) {
		            if (rs.next()) {
		                int count = rs.getInt(1);
		                boolean entryExists = count > 0;
	
		                if (entryExists) {
		                    boolean gebucht = true;
		                    anzeige.setGebucht(gebucht);
		                } else {
		                	boolean gebucht = false;
		                    anzeige.setGebucht(gebucht);
		                }
		            }
				}
		} catch (Exception ex) {
		throw new ServletException(ex.getMessage());
		}
		return anzeige;
	}
}