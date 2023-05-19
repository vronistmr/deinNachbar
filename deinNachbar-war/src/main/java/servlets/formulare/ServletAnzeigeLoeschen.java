//Lukas
package servlets.formulare;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;

@WebServlet("/ServletAnziegeLoeschen")
public class ServletAnzeigeLoeschen extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(lookup="java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;
    
    public ServletAnzeigeLoeschen() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Servlet zur Entgegennahme von Formularinhalten, Löschen der Daten in einer DB und Generierung
				// eines Feldes zur Weitergabe an eine JSP
				request.setCharacterEncoding("UTF-8");	// In diesem Format erwartet das Servlet jetzt die Formulardaten
				Long id = Long.valueOf(request.getParameter("id"));
		
				// DB-Zugriff
				delete(id);
						
				// Scope "Request"
				request.setAttribute("deleteForm", id);
				
				// Weiterleiten an JSP
				final RequestDispatcher dispatcher = request.getRequestDispatcher("2_deleteentry.jsp");
				dispatcher.forward(request, response);	
			}
	private void delete(Long id) throws ServletException {
		
		// DB-Zugriff
		try (Connection con = ds.getConnection();
			 PreparedStatement pstmt = con.prepareStatement("DELETE FROM products WHERE id = ?")){
			pstmt.setLong(1, id);
			pstmt.executeUpdate();
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
