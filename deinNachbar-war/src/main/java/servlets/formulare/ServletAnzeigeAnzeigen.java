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
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ServletAnzeigeAnzeigen")
public class ServletAnzeigeAnzeigen extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		int anzeigeid = Integer.parseInt(request.getParameter("anzeigeid"));

		BeanAnzeige anzeigebean = anzeigen(anzeigeid);
		
		//anzeigebean in request-Scope (wegen Such-/Leseoperation) hinterlegen und an anzeigenAnzeigen.jsp dispatchen/weiterleiten:
		/*
		request.setAttribute("AnzeigeForm", anzeigebean);
		RequestDispatcher disp = request.getRequestDispatcher("html/anzeigenAnzeigen.jsp");
		disp.forward(request, response);
		*/
		
		//in Session Scope hinterlegen (zwar Suchoperation, aber Bean muss auch nach dem Request für Übergabe der anzeigid an ServletAnzeigeBuchen 
		//noch vorhanden sein!:
		HttpSession session = request.getSession();
		session.setAttribute("AnzeigeForm", anzeigebean);
		response.sendRedirect("./html/anzeigenAnzeigen.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private BeanAnzeige anzeigen(int anzeigeid) throws ServletException {
		
		BeanAnzeige anzeige = new BeanAnzeige();
		
		// DB-Zugriff

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM anzeige WHERE anzeigeID = ?")) {

			pstmt.setInt(1, anzeigeid);
			try (ResultSet rs = pstmt.executeQuery()) {

				while (rs.next()) {
					

					Integer anzeigeID = Integer.valueOf(rs.getInt("anzeigeID"));
					anzeige.setAnzeigeID(anzeigeID);

					String anzeigeArt = rs.getString("anzeigeArt");
					anzeige.setAnzeigeArt(anzeigeArt);

					Integer benutzerID = Integer.valueOf(rs.getInt("benutzerID"));
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

				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		return anzeige;
	}

}
