//Veronika

package servlets.formulare;
import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import beans.formulare.BeanBenutzerdaten;
import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ServletBuchungLoeschen")
public class ServletBuchungLoeschen extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(lookup = "java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int anzeigeID = Integer.parseInt(request.getParameter("anzeigeID"));
		int benutzerID = Integer.valueOf(((BeanBenutzerdaten) request.getSession().getAttribute("loginForm")).getBenutzerID());

		delete(anzeigeID, benutzerID);
		
		final RequestDispatcher dispatcher = request.getRequestDispatcher("./ServletMeineGebuchten");
		dispatcher.forward(request, response);
	
	}
	
	private void delete(int anzeigeID, int benutzerID) throws ServletException {
		try (Connection con = ds.getConnection();
			 PreparedStatement pstmt = con.prepareStatement("DELETE FROM gebuchte WHERE anzeigeID = ? AND benutzerID = ?;")){
			pstmt.setInt(1, anzeigeID);
			pstmt.setInt(2, benutzerID);
			
			pstmt.executeUpdate();
			
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}