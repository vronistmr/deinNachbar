//Lukas

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


@WebServlet("/ServletKategorieBearbeiten")
public class ServletKategorieBearbeiten extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(lookup="java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int kategorieID = Integer.parseInt(request.getParameter("kategorieID"));
		String eingabe = request.getParameter("neuerName");
		
		update(kategorieID, eingabe);
		
		response.sendRedirect("./ServletStartseite");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void update(int kategorieID, String NeueKategorie) throws ServletException{
		//in Anzeigen-Tabelle neuen Namen hinterlegen 
		try(Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("UPDATE anzeige SET anzeige.kategorie = ? WHERE anzeige.kategorie = (SELECT kategorie.kategorie FROM kategorie WHERE kategorie.kategorieID = ?)")){
			
				pstmt.setString(1, NeueKategorie);
				pstmt.setInt(2, kategorieID);
				pstmt.executeUpdate();
				
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		
		// in Kategorie-Tabelle neuen Namen hinterlegen 
		try(Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("UPDATE kategorie SET kategorie = ? WHERE kategorieID = ?")){
			
				pstmt.setString(1, NeueKategorie);
				pstmt.setInt(2, kategorieID);
				pstmt.executeUpdate();
				
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		
	}
}