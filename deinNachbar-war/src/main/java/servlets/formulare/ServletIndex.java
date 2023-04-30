package servlets.formulare;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

import beans.formulare.BeanIndex;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
//Veronika
/**
 * Servlet implementation class ServletIndex
 */
@WebServlet("/ServletIndex")
public class ServletIndex extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		BeanIndex beanIndex = new BeanIndex();
		
		beanIndex.setEmail(request.getParameter("email"));
		beanIndex.setPasswort(request.getParameter("passwort"));
		
		HttpSession session = request.getSession();
		session.setAttribute("loginForm", beanIndex);
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
