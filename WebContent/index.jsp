<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>软件首页</title>
</head>
<body>
	<%
		String flag ="";
	    Object obj =session.getAttribute("flag");
	    if( obj !=null){
	    	flag = obj.toString();
	    }
	    if(flag.equals("login_success")){
	%>
<%  	}else{  %>
	<a href="<%= request.getContextPath()%>/login.jsp">登陆</a>
<%	}  %>


	<br>
	<br>
     <a href="<%=request.getContextPath()%>/login.jsp">用户登陆</a>
	<br>
     <br>
     <a href="<%=request.getContextPath()%>/Select.jsp">查询电影</a> 	

 <!--    <form action="Select.jsp" method="post">
   		<input type="submit"  value="查询">
   	</form>	 -->
     <br>
	<br>
	<a href="Delect.jsp">删除电影</a>
	<br>
	<br>
	<a href="Insert.jsp">添加电影</a>
	<br>
	<br>
	<a href="Update.jsp">修改电影</a>
	<br>
</body>
</html>