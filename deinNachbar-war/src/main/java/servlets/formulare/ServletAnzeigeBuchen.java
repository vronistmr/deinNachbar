package servlets.formulare;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import beans.formulare.BeanBenutzerdaten;
import beans.formulare.BeanBuchen;
import jakarta.annotation.Resource;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//Lukas
/**
* Servlet implementation class ServletRegistrierung
*/
@WebServlet("/ServletRegistrierung")
public class ServletAnzeigeBuchen extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup="java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		BeanBuchen beanAnzeigeBuchen = new BeanBuchen();
		beanAnzeigeBuchen.setBenutzerID(Integer.valueOf(((BeanBenutzerdaten) request.getSession().getAttribute("loginForm")).getBenutzerID()));
		beanAnzeigeBuchen.setAnzeigeID(Integer.valueOf(request.getParameter("anzeigeID")));
		
		// DB-Zugriff
		persist(beanAnzeigeBuchen);
		
		HttpSession session = request.getSession();
		session.setAttribute("buchenForm", beanAnzeigeBuchen);
		response.sendRedirect("html/anzeigeAnziegen");
	}
	
	private void persist(BeanBuchen beanAnzeigeBuchen) throws ServletException {
		// DB-Zugriff
		try (Connection con = ds.getConnection(); 
			PreparedStatement pstmt = con.prepareStatement(
					"INSERT INTO gebuchte (benutzerID,anzeigeID) VALUES (?,?)")){

			
			// Zugriff über Klasse java.sql.PreparedStatement
			pstmt.setInt(1, beanAnzeigeBuchen.getBenutzerID());
			pstmt.setInt(2, beanAnzeigeBuchen.getAnzeigeID());
		
			pstmt.executeUpdate();
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
