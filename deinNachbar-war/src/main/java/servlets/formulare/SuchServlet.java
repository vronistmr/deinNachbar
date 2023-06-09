// Tobi

package servlets.formulare;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.sql.Date;
import java.util.List;

import javax.sql.DataSource;

import beans.formulare.BeanAnzeige;
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SuchServlet")
public class SuchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String suchString = request.getParameter("suchstring");

		List<BeanAnzeige> anzeigen = search(suchString);

		request.setAttribute("Anzeigen", anzeigen);
		RequestDispatcher disp = request.getRequestDispatcher("html/suchErgebnisse.jsp");
		disp.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	private List<BeanAnzeige> search(String suchString) throws ServletException {

		suchString = (suchString == null || suchString == "") ? "%" : "%" + suchString + "%";
		List<BeanAnzeige> anzeigen = new ArrayList<BeanAnzeige>();

		// DB-Zugriff

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con
						.prepareStatement("SELECT * FROM anzeige WHERE titelAnzeige Like ? ORDER BY datum DESC")) {

			pstmt.setString(1, suchString);
			try (ResultSet rs = pstmt.executeQuery()) {

				while (rs.next()) {
					BeanAnzeige anzeige = new BeanAnzeige();

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

					anzeigen.add(anzeige);
				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		return anzeigen;
	}
}