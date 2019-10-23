<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dodavanje korisnika</title>
</head>
<form id="form-1" action="/TaskManagementServlet/UserServlet" method="post">
	        <table>
<tbody>
<tr>
<td><label for="input-1">Ime:</label></td>
<td><input id="input-1" name="name" placeholder="ime" type="text"/></td>
</tr>
<tr>
<td><label for="input-1">Korisničko ime:</label></td>
<td><input id="input-1" name="username" placeholder="korisničko ime" type="text"/></td>
</tr>
<tr>
<td><label for="input-1">Lozinka:</label></td>
<td><input id="input-1" name="password" placeholder="lozinka" type="password"/></td>
</tr>
<tr>
<td><label for="input-1">Uloga:</label></td>
<td>
	<select name="role">
			<option value="1">MANAGER</option>
			<option value="2">EMPLOYEE</option>
		</select>
</td>
</tr>
<tr>
<td></td>
<td>
	<input type="submit" value="Dodaj"  id="button-1"/>
</td>
</tr>
</tbody>
</table> 		
	</form>
	<h5>${message}</h5>
	<c:if test="${not empty users}">
	<h4>Spisak do sada registrovanih korisnika</h4>
		<table border="1">
		<tr>
			<th>Ime</th>
			<th>Korisničko ime</th>
			<th>Uloga</th>
		</tr>
		<c:forEach items="${users}" var="u">
			<tr>
				<td>${u.name}</td>
				<td>${u.username}</td>
				<td>${u.role.name}</td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>