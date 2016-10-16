<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script language="javascript" src="<%=request.getContextPath()%>/script/jquery-1.3.2.min.js"></script>
<script type="text/javascript">
function add(){
	window.location.href="addjsp.do";
}
function upd(id,userName,password){
//url
	window.location.href="upuser.do?id="+id+"&userName="+userName+"&password="+password;	
}

function del(id){
	$.ajax( {
		type: "POST",
		url:'<%=request.getContextPath()%>/del.do?id=' + id+"t="+Math.random(),
		dataType: "json",
		//dataType:"text",
		//dataType:"script",
		success : function(data) {
			if(data.del == "true"){
				$("#" + id).remove();
				window.location.href="selectall.do";//临时的方法
			}
			else{
				alert("删除失败！");
			}
		},
		error :function(){
			alert("操作失败");
		}
	});
	}
</script>
</head>
<body>
<input id="add" type="button" onclick="add()" value="添加"/>
<table  border="1" cellpadding="0" cellspacing="0">
   <tr> 
      <td align=center>用户id</td>
      <td align=center>用户名</td>
      <td align=center>用户密码</td>
      <td align=center colspan="2">操作</td>
   </tr>
  <c:forEach var="user" items="${userlist }" >
     <tr align="center">
     <td><c:out value="${user.id }"></c:out></td>
     <td><c:out value="${user.userName }"></c:out></td>
     <td><c:out value="${user.password }"></c:out></td>
     <td><input type="button" onclick="del('<c:out value="${user.id}"/>')" value="删除"/>
     <td><input type="button" onclick="upd('<c:out value="${user.id}"/>','<c:out value="${user.userName}"/>','<c:out value="${user.password}"/>')" value="更新"/>
     </tr>    
  </c:forEach>
  </table>
</body>
</html>

