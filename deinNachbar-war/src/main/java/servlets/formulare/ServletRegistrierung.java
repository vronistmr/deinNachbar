package servlets.formulare;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

import beans.formulare.BeanRegistrieren;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
//Veronika
/**
 * Servlet implementation class ServletRegistrierung
 */
@WebServlet("/ServletRegistrierung")
public class ServletRegistrierung extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		BeanRegistrieren beanRegistrieren = new BeanRegistrieren();
		
		beanRegistrieren.setVorname(request.getParameter("vorname"));
		beanRegistrieren.setEmail(request.getParameter("email"));
		beanRegistrieren.setPasswort(request.getParameter("passwort"));
		beanRegistrieren.setStandort(request.getParameter("standort"));
		
		HttpSession session = request.getSession();
		session.setAttribute("registrierenForm", beanRegistrieren);
		//JSP Seiten eigenltich nicht notwendig?
		response.sendRedirect("html/test.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
