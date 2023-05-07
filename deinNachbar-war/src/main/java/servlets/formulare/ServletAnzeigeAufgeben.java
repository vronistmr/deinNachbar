package servlets.formulare;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.math.BigDecimal;

import beans.formulare.BeanAnzeigeAufgeben;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
//Veronika
/**
 * Servlet implementation class ServletAnzeigeAufgeben
 */
@WebServlet("/ServletAnzeigeAufgeben")
public class ServletAnzeigeAufgeben extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		HttpSession session = request.getSession();
		session.setAttribute("AnzeigeAufgebenForm", beanAnzeigeAufgeben);
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
