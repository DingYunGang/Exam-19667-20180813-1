import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update() {
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
		//doGet(request, response);
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		
		int id =Integer.valueOf( request.getParameter("id"));
		System.out.println(id);
		String title = request.getParameter("title");
		System.out.println(title);
		String content = request.getParameter("content");
		System.out.println(content);
		int language = Integer.valueOf( request.getParameter("language"));
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
                String sql = "update film set film_id=?,title=?,description=?,language_id=? where film_id='"+id+"';";
				PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
				ps.setInt(1, id);
				ps.setString(2, title);
				ps.setString(3,content);
				ps.setInt(4, language);
				int row = ps.executeUpdate();
				if(row > 0){
				 System.out.println("成功修改了 " + row + "条数据！");
				}
				ps.close();
				conn.close();
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
	            out.print("修改数据成功");
			} catch (Exception e) {
				System.out.print("信息修改失败！");
				e.printStackTrace();
			}
	}

}
