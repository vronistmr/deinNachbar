//Veronika

package servlets.formulare;
import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import beans.formulare.BeanBenutzerdaten;
import beans.formulare.BeanLogindaten;
import jakarta.annotation.Resource;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/ServletIndex")
public class ServletIndex extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(lookup="java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BeanLogindaten beanLogin = new BeanLogindaten();
		BeanBenutzerdaten benutzer = new BeanBenutzerdaten();
		
		beanLogin.setEmail(request.getParameter("email"));
		beanLogin.setPasswort(request.getParameter("passwort"));
		
		benutzer = autentify(beanLogin);
		
		 
		    
		if (benutzer.getBenutzerID() != null) {
			//Erfolgreicher Login
			HttpSession session = request.getSession();
		    session.setAttribute("loginForm", benutzer);
		    response.sendRedirect("./ServletStartseite");
		} else {
			//Login fehlgeschlagen: mit Java Script Meldung anzeigen
			response.sendRedirect("html/fehlerausgabe.jsp");
			
				}
		
	}

	private BeanBenutzerdaten autentify(BeanLogindaten beanLogin) throws ServletException {
		BeanBenutzerdaten benutzerDaten = new BeanBenutzerdaten();
		// DB-Zugriff
		try (Connection con = ds.getConnection();
		     PreparedStatement pstmt = con.prepareStatement("SELECT * FROM benutzer WHERE email = ? AND passwort = ?")) {
			
			pstmt.setString(1, beanLogin.getEmail());
			pstmt.setString(2, beanLogin.getPasswort());
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs != null && rs.next()) {
					benutzerDaten.setBenutzerID(Integer.valueOf(rs.getInt("benutzerID")));
					benutzerDaten.setVorname(rs.getString("vorname"));
					benutzerDaten.setEmail(rs.getString("email"));
					benutzerDaten.setPasswort(rs.getString("passwort"));
					benutzerDaten.setStandort(rs.getString("standort"));
					benutzerDaten.setIstAdmin(Boolean.valueOf(rs.getInt("admin") == 1 ? true : false));
				}
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}

		return 	benutzerDaten;
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}