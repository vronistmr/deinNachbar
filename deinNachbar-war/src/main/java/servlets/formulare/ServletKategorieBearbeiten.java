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
		// TODO Auto-generated method stub
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void persist() throws ServletException{
		try(Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("UPDATE kategorie" + "SET kategorie = ?" + "WHERE id = ?")){
			
				pstmt.setString(1, );
				pstmt.setString(2, );
				
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
	}
}