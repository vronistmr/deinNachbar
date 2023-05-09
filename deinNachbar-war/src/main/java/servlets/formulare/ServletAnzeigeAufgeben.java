package servlets.formulare;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.sql.DataSource;

import beans.formulare.BeanAnzeigeAufgeben;
import jakarta.annotation.Resource;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

//Veronika
/**
 * Servlet implementation class ServletAnzeigeAufgeben
 */
@WebServlet("/ServletAnzeigeAufgeben")
@MultipartConfig(maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5
		* 5, location = "/tmp", fileSizeThreshold = 1024 * 1024)
public class ServletAnzeigeAufgeben extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		BeanAnzeigeAufgeben beanAnzeigeAufgeben = new BeanAnzeigeAufgeben();

		beanAnzeigeAufgeben.setAnzeigeArt(request.getParameter("anzeigeArt"));
		beanAnzeigeAufgeben.setTitelAnzeige(request.getParameter("titelAnzeige"));
		beanAnzeigeAufgeben.setPreis(Integer.valueOf(request.getParameter("preis")));
		beanAnzeigeAufgeben.setPreiskategorie(request.getParameter("preiskategorie"));
		beanAnzeigeAufgeben.setKategorie(request.getParameter("kategorie"));
		beanAnzeigeAufgeben.setStandort(request.getParameter("standort"));
		beanAnzeigeAufgeben.setUmkreis(Integer.valueOf(request.getParameter("umkreis")));
		beanAnzeigeAufgeben.setBeschreibung(request.getParameter("beschreibung"));
		// Foto
		Part foto = request.getPart("foto");

		// Datenbank Zugriff
		persist(beanAnzeigeAufgeben, foto);

		HttpSession session = request.getSession();
		session.setAttribute("AnzeigeAufgebenForm", beanAnzeigeAufgeben);
		response.sendRedirect("html/anzeigenAnzeigen.jsp");
	}

	private void persist(BeanAnzeigeAufgeben beanAnzeigeAufgeben, Part foto) throws ServletException {
		String[] generatedKeys = new String[] {"anzeigeID"};

		// Auslesen der ID für die Fremdschlüssel preiskategorieID
		// Auslesen der ID für die Fremdschlüssel anzeigeArtID
		// Auslesen der ID für die Fremdschlüssel kategorieID
		int anzeigeArtID = 0;
		int preiskategorieID = 0;
		int kategorieID = 0;
		try (Connection con = ds.getConnection();
				PreparedStatement readAnzeigeArtID = con
						.prepareStatement("SELECT (anzeigeArtID) FROM anzeigeArt WHERE anzeigeArt = ?");
				PreparedStatement readPreiskategorieID = con
						.prepareStatement("SELECT (preiskategorieID) FROM preiskategorie WHERE preiskategorie = ?");
				PreparedStatement readKategorieID = con
						.prepareStatement("SELECT (kategorieID) FROM kategorie WHERE kategorie = ?")) {

			readAnzeigeArtID.setString(1, beanAnzeigeAufgeben.getAnzeigeArt());

			try (ResultSet rs = readAnzeigeArtID.executeQuery()) {
				if (rs != null && rs.next()) {
					anzeigeArtID = Integer.valueOf(rs.getInt("anzeigeArtID"));
				}
			}
			readPreiskategorieID.setString(1, beanAnzeigeAufgeben.getPreiskategorie());

			try (ResultSet rs = readPreiskategorieID.executeQuery()) {
				if (rs != null && rs.next()) {
					preiskategorieID = Integer.valueOf(rs.getInt("preiskategorieID"));
				}
			}

			readKategorieID.setString(1, beanAnzeigeAufgeben.getKategorie());

			try (ResultSet rs = readKategorieID.executeQuery()) {
				if (rs != null && rs.next()) {
					kategorieID = Integer.valueOf(rs.getInt("kategorieID"));
				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}

		// Speichern in Datenbank
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO anzeige (anzeigeArtID,titelAnzeige, preis, preiskategorieID, kategorieID, standort, umkreis, beschreibung, foto, benutzerID)"
								+ "VALUES (?,?,?,?,?,?,?,?,?,1)",generatedKeys)) {

			pstmt.setInt(1, anzeigeArtID);
			pstmt.setString(2, beanAnzeigeAufgeben.getTitelAnzeige());
			pstmt.setInt(3, beanAnzeigeAufgeben.getPreis());
			pstmt.setInt(4, preiskategorieID);
			pstmt.setInt(5, kategorieID);
			pstmt.setString(6, beanAnzeigeAufgeben.getStandort());
			pstmt.setInt(7, beanAnzeigeAufgeben.getUmkreis());
			pstmt.setString(8, beanAnzeigeAufgeben.getBeschreibung());
			pstmt.setBinaryStream(9, foto.getInputStream());

			pstmt.executeUpdate();

			// Generierte(n) Schlüssel auslesen (funktioniert nur mit PreparedStatement)
			try (ResultSet rs = pstmt.getGeneratedKeys()) {
				while (rs.next()) {
					beanAnzeigeAufgeben.setAnzeigeID(rs.getInt(1));

				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
