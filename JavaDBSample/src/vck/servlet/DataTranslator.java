package vck.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DataTranslator
 */
@WebServlet(description = "Moving Data", urlPatterns = { "/MyPage" })
public class DataTranslator extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
//		String name = request.getParameter("name");
//		int age = Integer.parseInt(request.getParameter("age"));
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
		
//		out.println("<h1>"+"Name =" + name + "<br/>");
//		out.println("Age ="+ age + "</h1>");
//		out.close();
		 
		try {
			 String URL = "jdbc:sqlserver://localhost:1433;" + "databaseName=MyDB;sendStringParametersAsUnicode=false";
			 String DBUSER = "sqlserver";
			 String DBPASS = "sqlserver";
	         Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	         
	         Connection conn = DriverManager.getConnection(URL,DBUSER,DBPASS);
	         System.out.println("connected");
	         Statement statement = conn.createStatement();
	         String SQL = "SET NOCOUNT OFF;";
	         //String SQL_Create = "CREATE TABLE MYTAB" + "(Name varchar(100), Age int(100));";
	         String name = request.getParameter("name");
	 		 int age = Integer.parseInt(request.getParameter("age"));
	         String SQL1 = "INSERT INTO dbo.NewTab VALUES " + "(name, age,1,'14/06/1993')";

	         statement.addBatch(SQL);
//	         statement.addBatch(SQL_Create);
	         statement.addBatch(SQL1);
	         
	         statement.executeBatch();
	      } catch (Exception e) {
	         e.printStackTrace();
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
