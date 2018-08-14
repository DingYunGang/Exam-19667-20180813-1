<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加电影</title>
<script type="text/javascript">
	function check(form){
		with(form){
			 if(id.value == ""){
				alert("id不能为空");
				return false;
			}
		
			 if(title.value == ""){
					alert("标题不能为空");
					return false;
				}
			if(content.value == ""){
				alert("介绍不能为空");
				return false;
			}
			if(language.value == "0"){
				alert("必须选择语言");
				return false;
			}  
			return true;
		}
	}
</script>
</head>
<body>
<form action="insert" method="post" onsubmit="return check(this);">
		<table align="center" width="450">
			<tr>
				<td align="center" colspan="2">
					<h2>添加电影</h2>
					<hr>
				</td>
			</tr>
			<tr>
				<td align="right">电影id：</td>
				<td><input type="text" name="id" /></td>
			</tr>
			<tr>
				<td align="right">电影标题</td>
				<td><input type="text" name="title" /></td>
			</tr>
			<tr>
				<td align="right">电影介绍</td>
				<td><input type="text" name="content" /></td>
			</tr>
			<tr>
			<td align="right">电影语言</td>
			 <td>	<select name="language"  value="${curStatus}">     
 <option value="0">-请选择-</option>     
  <option value="1" <c:if test="${'1' eq curStatus}"></c:if>> English</option>     
  <option value="2" <c:if test="${'2' eq curStatus}"></c:if>> Italian</option> 
  <option value="3" <c:if test="${'3' eq curStatus}"></c:if>> Japanese</option>
  <option value="4" <c:if test="${'4' eq curStatus}"></c:if>> Mandarin</option>
  <option value="5" <c:if test="${'5' eq curStatus}"></c:if>> French</option>
  <option value="6" <c:if test="${'6' eq curStatus}"></c:if>> German</option>
 </select> 
 </td> 
			</tr>
			<tr>
				<td align="center" colspan="2">
					<input type="submit" value="添　加">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>