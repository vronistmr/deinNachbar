//Tobi

package servlets.formulare;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/ServletKategorieLoeschen")
public class ServletKategorieLoeschen extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(lookup="java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
	
		// KategorieId und kategorie von zu gelöschter Kategorie aus QS lesen! Dafür müssen dem Button "Löschen" auf der Startseite die Id und die jeweilige kategorie übergeben werden!
		
		int kategorieId = Integer.parseInt(request.getParameter("kategorieID"));
		String kategorie = request.getParameter("kategorie");
		
		delete(kategorieId, kategorie);
		
		//html Seite neu laden?! dass Kategorie angezeigt wird
		response.sendRedirect("./ServletStartseite");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void delete(int kategorieId, String kategorie) throws ServletException {
		
		try (Connection con = ds.getConnection();
				 PreparedStatement pstmt = con.prepareStatement("DELETE FROM gebuchte WHERE gebuchte.anzeigeID IN(SELECT anzeige.anzeigeID FROM kategorie JOIN anzeige ON anzeige.kategorie = kategorie.kategorie WHERE kategorie.kategorieID = ?)")){
				pstmt.setInt(1, kategorieId);
				pstmt.executeUpdate();
			} catch (Exception ex) {
				throw new ServletException(ex.getMessage());
			}
		try (Connection con = ds.getConnection();
			 PreparedStatement pstmt = con.prepareStatement("DELETE FROM kategorie WHERE kategorieID = ?")){
			pstmt.setInt(1, kategorieId);
			pstmt.executeUpdate();
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		try (Connection con = ds.getConnection();
				 PreparedStatement pstmt = con.prepareStatement("DELETE FROM anzeige WHERE kategorie = ?")){
				pstmt.setString(1, kategorie);
				pstmt.executeUpdate();
			} catch (Exception ex) {
				throw new ServletException(ex.getMessage());
			}
	}
}