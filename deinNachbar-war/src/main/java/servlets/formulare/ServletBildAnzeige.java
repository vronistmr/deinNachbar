package servlets.formulare;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//Veronika
/**
 * Servlet implementation class ServletBildAnzeige
 */
@WebServlet("/ServletBildAnzeige")
public class ServletBildAnzeige extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	@Resource(lookup="java:jboss/datasources/MySqlThidbDS")
	private DataSource ds;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Servlet zum Auslesen eines Bildes aus einer DB und Rückgabe als binärer Datenstrom
				request.setCharacterEncoding("UTF-8");	// In diesem Format erwartet das Servlet jetzt die Formulardaten
				Long id = Long.valueOf(request.getParameter("anzeigeID"));
				
				// DB-Zugriff
				try (Connection con = ds.getConnection();
					 PreparedStatement pstmt = con.prepareStatement("SELECT foto FROM anzeige WHERE anzeigeID = ?") ) {
					pstmt.setLong(1, id);
					try (ResultSet rs = pstmt.executeQuery()) {
					
						if (rs != null && rs.next()) {
							Blob bild = rs.getBlob("foto");
							response.reset();
							long length = bild.length();
							response.setHeader("Content-Length",String.valueOf(length));
							
							try (InputStream in = bild.getBinaryStream()) {
								final int bufferSize = 256;
								byte[] buffer = new byte[bufferSize];
								
								ServletOutputStream out = response.getOutputStream();
								while ((length = in.read(buffer)) != -1) {
									out.write(buffer,0,(int) length);
								}
								out.flush();
							}
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
