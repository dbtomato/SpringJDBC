<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加</title>
<% /* String userName=request.getAttribute("usreName").toString(); 
String password=request.getAttribute("password").toString();
String id=request.getAttribute("id").toString(); */ 
%>
<script type="text/javascript">
function turnback(){
	window.location.href="selectall.do";
}
</script>
</head>
<body>
<%String id=request.getAttribute("id").toString();
String userName=request.getAttribute("userName").toString();
String password=request.getAttribute("password").toString();
%>
<form method="post" action="update.do">
<table>
    <tr><td>id</td><td><input id="id" name="id" type="text" readOnly="readOnly"   value=<%=id %> ></td></tr>
	<tr><td>姓名</td><td><input id="userName" name="userName" type="text"  value=<%=userName %>></td></tr>
	<tr><td>密码</td><td><input id="password" name="password"  type="text" value=<%=password %>></td></tr>
	<tr><td colSpan="2" align="center"><input type="submit" value="提交"/>
	<input type="button" onclick="turnback()" value="返回" /> </td></tr>
</table>

</form>
</body>
</html>

