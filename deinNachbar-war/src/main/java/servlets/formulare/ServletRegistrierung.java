//Veronika

package servlets.formulare;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import beans.formulare.BeanBenutzerdaten;
import jakarta.annotation.Resource;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ServletRegistrierung")
public class ServletRegistrierung extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup = "java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		BeanBenutzerdaten beanRegistrieren = new BeanBenutzerdaten();

		beanRegistrieren.setVorname(request.getParameter("vorname"));
		beanRegistrieren.setEmail(request.getParameter("email"));
		beanRegistrieren.setPasswort(request.getParameter("passwort"));
		beanRegistrieren.setStandort(request.getParameter("standort"));

		if(emailNeuPruefen(beanRegistrieren.getEmail())){
			// DB-Zugriff
			persist(beanRegistrieren);

			
			request.setAttribute("registrierenForm", beanRegistrieren);
			response.sendRedirect("./index.jsp");
		}else {
			response.sendRedirect("html/fehlerausgabe.jsp");
		}
		
		
	}

	private void persist(BeanBenutzerdaten beanRegistrieren) throws ServletException {
		// DB-Zugriff
		String[] generatedKeys = new String[] { "benutzerID" }; // Name der Spalte(n), die automatisch generiert
																// wird(werden)

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO benutzer (vorname,email,passwort,standort) VALUES (?,?,?,?)", generatedKeys)) {

			// Zugriff über Klasse java.sql.PreparedStatement
			pstmt.setString(1, beanRegistrieren.getVorname());
			pstmt.setString(2, beanRegistrieren.getEmail());
			pstmt.setString(3, beanRegistrieren.getPasswort());
			pstmt.setString(4, beanRegistrieren.getStandort());

			pstmt.executeUpdate();

			// Generierte(n) Schlüssel auslesen (funktioniert nur mit PreparedStatement)
			try (ResultSet rs = pstmt.getGeneratedKeys()) {
				while (rs.next()) {
					beanRegistrieren.setBenutzerID(rs.getInt(1));
				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
	}

	private boolean emailNeuPruefen(String email) throws ServletException {
		boolean emailneu;

		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM benutzer WHERE email = ?;")) {
			
			pstmt.setString(1, email);

			try (ResultSet rs = pstmt.executeQuery()) {
			if(rs != null && rs.next()) {
				emailneu=false;
			} else {
				emailneu=true;
			}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}

	return emailneu;
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}