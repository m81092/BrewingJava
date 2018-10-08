<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<!-- <script type="text/javascript">
Could be Useful so donot delete this code snippet
window.onload=function() {
	   document.getElementById("categoryLink").onclick=function() {
	     var myForm = document.createElement("form");
	     myForm.action=this.href;// the href of the link
	     myForm.target="${pageContext.request.contextPath}/ShowCategories";
	     myForm.method="GET";
	     myForm.submit();
	     return false; // cancel the actual link
	   }
	 }
</script> -->
<title></title>
<%@ include file="Header.jsp"%>
</head>
<body>
	<div class="main">
		<!-- Commented because Image will move to another JSP 
		<div class="image" align="center">
			<img alt="home_img" src="images/home2.jpeg" height="90" width="150">
		</div> -->
		<h4>Welcome to Bookworm, place where Canada shops</h4>
		<h4>Categories</h4>
		<a href="${pageContext.request.contextPath}/ShowBooks?category=Business and Finance">Business and Finance</a><br> 
		<a href="${pageContext.request.contextPath}/ShowBooks?category=Biography and Memoir">Biography and Memoir</a><br> 
		<a href="${pageContext.request.contextPath}/ShowBooks?category=Computers">Computers</a><br> 
		<a href="${pageContext.request.contextPath}/ShowBooks?category=Entertainment">Entertainment</a><br>
		<a href="${pageContext.request.contextPath}/ShowBooks?category=History">History</a><br> 
		<a href="${pageContext.request.contextPath}/ShowBooks?category=Fiction">Fiction</a><br> 
		<a href="${pageContext.request.contextPath}/ShowBooks?category=Science Fiction">Science Fiction</a><br> 
		<a href="${pageContext.request.contextPath}/ShowBooks?category=Self-Help">Self-Help</a><br>
		<a href="${pageContext.request.contextPath}/ShowBooks?category=Health">Health</a><br> 
		<a href="${pageContext.request.contextPath}/ShowBooks?category=Science and Nature">Science and Nature</a><br>
		<a href="${pageContext.request.contextPath}/ShowBooks?category=Poetry">Poetry</a>
		<form action="${pageContext.request.contextPath}/ShowBooks"
			method=get>
			<input type="hidden" name="category" value="All"> <input
				class="fetch" type="Submit" value="Show All Books">
		</form>
		</div>
		<div class="body" align="right">
			<table class="booktable" border="3" >
			<tr><td>Author</td><td>BookID</td><td>Category</td><td>Price</td><td>Title</td>
	
				<c:forEach var="items" items="${allBook}">
					<tr>
						<td>${items.author}</td>
					
						<td>${items.bookid}</td>
					
						<td>${items.category}</td>
					
						<td>${items.price}</td>
					
						<td>${items.title}</td>
					</tr>
				</c:forEach>
			</table>
		
		
		<div class="feature">
			<h4>Some of our featured books</h4>
		</div>
	</div>
</body>
</html>