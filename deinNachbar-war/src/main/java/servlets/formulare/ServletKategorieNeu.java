//Veronika
package servlets.formulare;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import beans.formulare.BeanKategorie;
import jakarta.annotation.Resource;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;


/**
 * Servlet implementation class KategorieBearbeiten
 */
@WebServlet("/ServletKategorieNeu")
public class ServletKategorieNeu extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(lookup = "java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		BeanKategorie beanKategorie = new BeanKategorie();
		
		beanKategorie.setKategorie(request.getParameter("neueKategorie"));
		// Foto
		Part kategoriebild = request.getPart("kategoriebild");

		persist(beanKategorie);
		
		HttpSession session = request.getSession();
		session.setAttribute("KategorieNeu", beanKategorie);
		//html Seite neu laden?! dass Kategorie angezeigt wird
	}

	private void persist(BeanKategorie beanKategorie) throws ServletException {
		String[] generatedKeys = new String[] {"kategorieID"};
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(
						"INSERT INTO kategorie (kategorie) VALUES (?)",generatedKeys)){

			pstmt.setString(1, beanKategorie.getKategorie());

			pstmt.executeUpdate();

			// Generierte(n) Schlüssel auslesen 
			try (ResultSet rs = pstmt.getGeneratedKeys()) {
				while (rs.next()) {
					beanKategorie.setKategorieID(rs.getInt(1));
				}
			}
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