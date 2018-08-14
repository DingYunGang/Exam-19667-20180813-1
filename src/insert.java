import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.*;

/**
 * Servlet implementation class insert
 */
@WebServlet("/insert")
public class insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insert() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		System.out.println(id);
		String title = request.getParameter("title");
		System.out.println(title);
		String content = request.getParameter("content");
		System.out.println(content);
		String language = request.getParameter("language");
		System.out.println(language);
		
		 try {
	         Class.forName("com.mysql.jdbc.Driver");
	     } catch (ClassNotFoundException e) {
	         System.out.println("找不到驱动程序类，加载驱动失败！");
	         e.printStackTrace();
	     }
		 try {
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/sakila";
				String username = "root";
				String password = "1872";
				Connection conn = (Connection) DriverManager.getConnection(url,username,password);
String sql = "insert into film (film_id,title,description,release_year,language_id,original_language_id,rental_duration,rental_rate,\r\n" + 
						"length,replacement_cost,\r\n" + 
						"rating,special_features,last_update) values(?,?,?,'2006',?,null,'6','4.99','178','20.99','R',null,NOW())";
				PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
				ps.setString(1, id);
				ps.setString(2, title);
				ps.setString(3,content);
				ps.setString(4, language);
				int row = ps.executeUpdate();
				if(row > 0){
				 System.out.println("成功添加了 " + row + "条数据！");
				}
				ps.close();
				conn.close();
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
	            out.print("添加一条数据成功");
			} catch (Exception e) {
				System.out.print("信息添加失败！");
				e.printStackTrace();
			}
	     
	     
	}

}
