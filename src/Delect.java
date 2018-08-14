

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.ResultSet;

/**
 * Servlet implementation class Delect
 */
@WebServlet("/Delect")
public class Delect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Delect() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
        String id = request.getParameter("sid");
		System.out.println(id);
		 try {
	         Class.forName("com.mysql.jdbc.Driver");
	     } catch (ClassNotFoundException e) {
	         System.out.println("找不到驱动程序类，加载驱动失败！");
	         e.printStackTrace();
	     }
		 String url = "jdbc:mysql://localhost:3306/sakila?serverTimezone=UTC&characterEncoding=utf-8";
	     String username = "root";
	     String password = "1872";
	     
	     try {
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			//set foreign_key_checks = 0;
			String sqll ="set foreign_key_checks = 0;";
			String sql = "delete from film where film_id= '"+id+"';";
			String sqlo ="set foreign_key_checks = 1;";
			stmt.execute(sqll);
			stmt.execute(sql);
			stmt.execute(sqlo);
			stmt.close();
			conn.close();
			System.out.println("删除成功");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
            out.print("删除成功");
            
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
