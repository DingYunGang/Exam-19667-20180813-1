<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="UTF-8" import="java.util.*" import = "java.sql.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查询</title>
<style type="text/css">
	td{font-size: 12px;}
	h2{margin: 0px}
</style>
</head>
<body>
 <table align="center" width="800" border="1" height="200"
		bordercolor="white" bgcolor="black" cellpadding="1" cellspacing="1">
		<tr bgcolor="white">
			<td align="center" colspan="8">
				<h2>所有电影</h2>
			</td>
		</tr>
		<tr align="center" bgcolor="#e1ffc1">
			<td><b>电影ID</b></td>
			<td><b>电影名称</b></td>
			<td><b>电影介绍</b></td>
			<td><b>语言</b></td>
		</tr>
		<%
		Class.forName("com.mysql.jdbc.Driver");
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "1872");
		Statement stmt = connect.createStatement();//从数据库里面取东西对比
		String sql = "select * from film,language where film.language_id = language.language_id limit 20;";
		ResultSet i = stmt.executeQuery(sql);
		// 遍历图书集合中的数据
		while (i.next()) {
		%>
		<tr align="center" bgcolor="white">
			<td><%=i.getString("film_id")%></td>
			<td><%=i.getString("title")%></td>
			<td><%=i.getString("description")%></td>
			<td><%=i.getString("language.name")%></td>
		</tr>
		<%
			}
			stmt.close();
			connect.close();
		%>
	</table>
</body>
</html>