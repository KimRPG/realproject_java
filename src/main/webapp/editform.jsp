<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.crud.dao.BoardDAO, com.crud.bean.BoardVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Form</title>
</head>
<body>

<%
	BoardDAO boardDAO = new BoardDAO();
	String id=request.getParameter("id");	
	BoardVO u=boardDAO.getBoard(Integer.parseInt(id));
%>

<h1>Edit Form</h1>
<form action="editpost.jsp" method="post">
<input type="hidden" name="id" value="<%=u.getId() %>"/>
<table>
	<tr><td>Name:</td><td><input type="text" name="name" value="<%=u.getName() %>"/></td></tr>
	<tr><td>HguID:</td><td><input type="text" name="hguid" value="<%=u.getHguid() %>"/></td></tr>
	<tr><td>Age:</td>
		<td> <input style="width:60%; margin-top:10px;" class="text" type="range" id="age" name="age" required>
			<span id="ageValue">0</span>
		</td></tr>
	<tr><td>Gender:</td><td>
		<input type="radio" name="gender" value="남자">남자
		<input type="radio" name="gender" value="여자">여자
	</td></tr>
	<tr><td>Email:</td><td><input type="text" name="email" value="<%=u.getEmail() %>"/></td></tr>
	<tr><td>Major:</td><td><input type="text" name="major" value="<%=u.getMajor() %>"/></td></tr>
	<tr><td>RC:</td><td>
		<select name="rc" id="rc">
			<option value="손양원">손양원</option>
			<option value="장기려">장기려</option>
			<option value="토레이">토레이</option>
			<option value="카이퍼">카이퍼</option>
			<option value="카마이클">카마이클</option>
			<option value="열송학사">열송학사</option>
		</select></td></tr>
	<tr><td>Nickname:</td><td><input type="text" name="nickname" value="<%=u.getNickname() %>"/></td></tr>
	<tr><td>Club:</td><td><input type="text" name="club" value="<%=u.getClub() %>"/></td></tr>
<tr><td colspan="2"><input type="submit" value="Edit Post"/>
<input type="button" value="Cancel" onclick="history.back()"/></td></tr>
</table>
</form>

<script>
	function updateAuthorValue() {
		var authorInput = document.getElementById('age');
		var authorValue = document.getElementById('ageValue');
		authorValue.textContent = authorInput.value;
	}
	var authorInput = document.getElementById('age');
	authorInput.addEventListener('input', updateAuthorValue);
	updateAuthorValue();
</script>

</body>
</html>