//Veronika

package servlets.formulare;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.sql.DataSource;

import beans.formulare.BeanAnzeige;
import beans.formulare.BeanBenutzerdaten;
import jakarta.annotation.Resource;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;


@WebServlet("/ServletAnzeigeAufgeben")
@MultipartConfig(maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5
		* 5, location = "/tmp", fileSizeThreshold = 1024 * 1024)
public class ServletAnzeigeAufgeben extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		BeanAnzeige beanAnzeigeAufgeben = new BeanAnzeige();

		beanAnzeigeAufgeben.setAnzeigeArt(request.getParameter("anzeigeArt"));
		beanAnzeigeAufgeben.setTitelAnzeige(request.getParameter("titelAnzeige"));
		beanAnzeigeAufgeben.setPreis(Integer.valueOf(request.getParameter("preis")));
		beanAnzeigeAufgeben.setPreiskategorie(request.getParameter("preiskategorie"));
		beanAnzeigeAufgeben.setKategorie(request.getParameter("kategorie"));
		beanAnzeigeAufgeben.setStandort(request.getParameter("standort"));
		beanAnzeigeAufgeben.setUmkreis(Integer.valueOf(request.getParameter("umkreis")));
		beanAnzeigeAufgeben.setBeschreibung(request.getParameter("beschreibung"));
		beanAnzeigeAufgeben.setDatum(Date.valueOf(LocalDate.now()));
		beanAnzeigeAufgeben.setZeit(Time.valueOf(LocalTime.now()));
		beanAnzeigeAufgeben.setBenutzerID(Integer.valueOf(((BeanBenutzerdaten) request.getSession().getAttribute("loginForm")).getBenutzerID()));
		beanAnzeigeAufgeben.setVorname(((BeanBenutzerdaten) request.getSession().getAttribute("loginForm")).getVorname());



		
		// Foto
		Part foto = request.getPart("foto");
		// Datenbank Zugriff
		persist(beanAnzeigeAufgeben, foto);

		//Redirect, da Insert in DB
		//!Redirect braucht immer Session -> Reload der 2. URL -> Daten wären nicht mehr in request Scope
		HttpSession session = request.getSession();
		session.setAttribute("anzeigeNeu", beanAnzeigeAufgeben);
		response.sendRedirect("./html/neueAnzeige.jsp");
		
	}

	private void persist(BeanAnzeige beanAnzeigeAufgeben, Part foto) throws ServletException {
		String[] generatedKeys = new String[] {"anzeigeID"};

		// Speichern in Datenbank
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO anzeige (anzeigeArt,titelAnzeige, preis, preiskategorie, kategorie, standort, umkreis, beschreibung, foto, benutzerID, datum)"
								+ "VALUES (?,?,?,?,?,?,?,?,?,?,?)",generatedKeys)) {

			pstmt.setString(1, beanAnzeigeAufgeben.getAnzeigeArt());
			pstmt.setString(2, beanAnzeigeAufgeben.getTitelAnzeige());
			pstmt.setInt(3, beanAnzeigeAufgeben.getPreis());
			pstmt.setString(4, beanAnzeigeAufgeben.getPreiskategorie());
			pstmt.setString(5, beanAnzeigeAufgeben.getKategorie());
			pstmt.setString(6, beanAnzeigeAufgeben.getStandort());
			pstmt.setInt(7, beanAnzeigeAufgeben.getUmkreis());
			pstmt.setString(8, beanAnzeigeAufgeben.getBeschreibung());
			pstmt.setBinaryStream(9, foto.getInputStream());
			pstmt.setInt(10, beanAnzeigeAufgeben.getBenutzerID());
			pstmt.setTimestamp(11, Timestamp.from(Instant.now()));


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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}