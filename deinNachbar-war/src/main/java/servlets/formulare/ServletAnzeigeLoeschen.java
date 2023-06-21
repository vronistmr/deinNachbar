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


@WebServlet("/ServletAnzeigeLoeschen")
public class ServletAnzeigeLoeschen extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(lookup="java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;
    
    public ServletAnzeigeLoeschen() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				request.setCharacterEncoding("UTF-8");	
				int id = Integer.parseInt(request.getParameter("id"));
		
				delete(id);
				
				response.sendRedirect("./ServletMeineAnzeigen");	
			}
	
	private void delete(int id) throws ServletException {
		
		try (Connection con = ds.getConnection();
			 PreparedStatement pstmt = con.prepareStatement("DELETE FROM anzeige WHERE anzeigeID = ?")){
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement("DELETE FROM gebuchte WHERE anzeigeID = ?")){
				pstmt.setInt(1, id);
				pstmt.executeUpdate();
			} catch (Exception ex) {
				throw new ServletException(ex.getMessage());
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}