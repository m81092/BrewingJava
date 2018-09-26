<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<%@ include file="Header.jsp" %>
</head>
<body>
<h4>Welcome to Bookworm, place where Canada shops</h4>
<a href="ShowCategories">View Categories</a><br><br>
<table border="1">
	<c:forEach var="items" items="${Categories}">
	<tr>
	<td>	${items.category}</td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>