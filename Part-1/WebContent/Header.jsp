<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Date, java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<link href="css/style.css" rel="stylesheet" type="text/css"/>
<meta charset="ISO-8859-1">
</head>
<body>
<div class="header">
<h4 align="left">
<% 	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	String time = sdf.format(date);
	out.print("Timestamp: " + time);%></h4>
<h3 id="title" align="center">BOOKWORM</h3>
<h4 class="desc" align="center">Welcome to Bookworm, place where Canada shops!</h4>
<h4 class="options" align="right">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="">Sign In</a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="">Cart</a>&nbsp;&nbsp;</h4>
</div>
</body>
</html>