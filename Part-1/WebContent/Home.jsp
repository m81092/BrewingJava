<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<%-- 	<form action="${pageContext.request.contextPath}/BookDetails" method="get"> --%>
<!-- 		<input type="submit"></input><br> -->
<!-- 		<br> -->
<!-- 	</form> -->
<%request.getRequestDispatcher("/BookDetails").include(request,response);%>
</body>
</html>