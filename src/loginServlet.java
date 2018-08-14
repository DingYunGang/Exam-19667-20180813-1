import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.mysql.jdbc.ResultSet;
/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public loginServlet() {
		super();
	}
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	
		HttpSession session = request.getSession();//获取session
		Object name = session.getAttribute("name");//从session中获取用户名
	
		session.invalidate(); //注销session
		response.sendRedirect("login.jsp"); //跳转到login.jsp页面
	}
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String returnUrl = request.getParameter("return_url");
		String name = request.getParameter("uname");
	//	System.out.println(name+" "+returnUrl);
		 try {
	         Class.forName("com.mysql.jdbc.Driver");
	     } catch (ClassNotFoundException e) {
	         System.out.println("找不到驱动程序类，加载驱动失败！");
	         e.printStackTrace();
	     }
		 String url = "jdbc:mysql://localhost:3306/sakila?serverTimezone=UTC&characterEncoding=utf-8";
	     String username = "root";
	     String password = "1872";
	    RequestDispatcher rd =null;
	     try {
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();
			String sql = "select * from customer where first_name= '"+name+"';";
			ResultSet i = (ResultSet) stmt.executeQuery(sql);
			if(i.next()) {
				System.out.print("登陆成功");
				request.getSession().setAttribute("flag", "login_success");
				if(returnUrl != null) {
					rd = request.getRequestDispatcher(returnUrl);
					rd.forward(request, response);
				}else {
					rd = request.getRequestDispatcher("/index.jsp");
					rd.forward(request, response);
				}
	          // request.getRequestDispatcher("/index.jsp").forward(request,response); 
			//	response.sendRedirect("/index.jsp");
			}else {
				request.getSession().setAttribute("flag", "login_error");
				request.setAttribute("msg","登陆失败");
				rd = request.getRequestDispatcher("/login.jsp");
				rd.forward(request, response);
				
				//response.sendRedirect("/login.jsp");
				//System.out.print("失败");
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	     
	}
 
}