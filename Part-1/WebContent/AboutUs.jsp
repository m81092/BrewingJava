<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<title>BookWorm</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-teal.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"><style>
body {font-family: "Roboto", sans-serif}
.w3-bar-block .w3-bar-item{padding:16px;font-weight:bold}
</style>
<body>

<nav class="w3-sidebar w3-bar-block w3-collapse w3-animate-left w3-card" style="z-index:3;width:250px;" id="mySidebar">
  <a class="w3-bar-item w3-button w3-border-bottom w3-large" href="#"><img src="https://www.w3schools.com/images/w3schools.png" style="width:80%;"></a>
  <a class="w3-bar-item w3-button w3-hide-large w3-large" href="javascript:void(0)" onclick="w3_close()">Close <i class="fa fa-remove"></i></a>
  <a class="w3-bar-item w3-button w3-teal" href="Welcome.jsp">Home</a>
  <a class="w3-bar-item w3-button" href="AboutUs.jsp">About Us</a>
  <a class="w3-bar-item w3-button" href="Team.jsp">Team</a>
  <a class="w3-bar-item w3-button" href="#">Contact US</a>
  <a class="w3-bar-item w3-button" href="${pageContext.request.contextPath}/ShowBooks?category=All">View All Books</a>
  <a class="w3-bar-item w3-button" href="${pageContext.request.contextPath}/ShowBooks?category=featured">Featured Books</a>
  <a class="w3-bar-item w3-button" href="Register.jsp">Sign Up</a>
  
  <div>
    <a class="w3-bar-item w3-button" onclick="myAccordion('demo')" href="javascript:void(0)">Categories <i class="fa fa-caret-down"></i></a>
    <div id="demo" class="w3-hide">
      <a class="w3-bar-item w3-button" href="${pageContext.request.contextPath}/ShowBooks?category=Business and Finance">Business and Finance</a>
      <a class="w3-bar-item w3-button" href="${pageContext.request.contextPath}/ShowBooks?category=Biography and Memoir">Biography and Memoir</a>
      <a class="w3-bar-item w3-button" href="${pageContext.request.contextPath}/ShowBooks?category=Computers">Computers</a>
	  <a class="w3-bar-item w3-button" href="${pageContext.request.contextPath}/ShowBooks?category=Entertainment">Entertainment</a>
	  <a class="w3-bar-item w3-button" href="${pageContext.request.contextPath}/ShowBooks?category=History">History</a>
	  <a class="w3-bar-item w3-button" href="${pageContext.request.contextPath}/ShowBooks?category=Fiction">Fiction</a>
	  <a class="w3-bar-item w3-button" href="${pageContext.request.contextPath}/ShowBooks?category=Science Fiction">Science Fiction</a>
	  <a class="w3-bar-item w3-button" href="${pageContext.request.contextPath}/ShowBooks?category=Self-Help">Self-Help</a>
	  <a class="w3-bar-item w3-button" href="${pageContext.request.contextPath}/ShowBooks?category=Health">Health</a>
	  <a class="w3-bar-item w3-button" href="${pageContext.request.contextPath}/ShowBooks?category=Science and Nature">Science and Nature</a>
	  <a class="w3-bar-item w3-button" href="${pageContext.request.contextPath}/ShowBooks?category=Poetry">Science and Nature</a>
    </div>
  </div>
</nav>

<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" id="myOverlay"></div>

<div class="w3-main" style="margin-left:250px;">

<div id="myTop" class="w3-container w3-top w3-theme w3-large">
  <p><i class="fa fa-bars w3-button w3-teal w3-hide-large w3-xlarge" onclick="w3_open()"></i>
  <span id="myIntro" class="w3-hide">Welcome to Bookworm, place where Canada shop</span></p>

</div>


<header class="w3-container w3-theme" style="padding:64px 32px">
  <h1 class="w3-xxxlarge">About us</h1>
</header>
<% String username = (String)session.getAttribute("userName"); 
if (username == null) { %>
<h4>&nbsp;&nbsp;&nbsp;&nbsp;Welcome:<b>Guest</b></h4>
<% } else { %>
<h4>&nbsp;&nbsp;&nbsp;&nbsp;Welcome: <b><%=username%></b></h4>
<%} %>
<div class="w3-container" style="padding:32px">

<h3>Welcome to Bookworm- an Online Bookstore</h3>
<ul class="w3-leftbar w3-theme-border" style="list-style:none">
 <li>Bookworm offers a carefully curated selection of Science fiction, Computers, Entertainment, History, Health and many more.</li>
 <li> There is special selection of featured books selected by our passionate bibliophiles which are our top best sellers.</li>
 <br>
 <li> Here at Bookworm you can view all books at once or select from our featured books or go categorically </li>
 <li> Once you have chosen your books you can add them to cart (at this point if you haven't logged or registered you can do so now) </li>
 <li> Proceed to checkout. Voila! You are done!</li>
</ul>
<br>

</div>

<script>
// Open and close the sidebar on medium and small screens
function w3_open() {
    document.getElementById("mySidebar").style.display = "block";
    document.getElementById("myOverlay").style.display = "block";
}
function w3_close() {
    document.getElementById("mySidebar").style.display = "none";
    document.getElementById("myOverlay").style.display = "none";
}

// Change style of top container on scroll
window.onscroll = function() {myFunction()};
function myFunction() {
    if (document.body.scrollTop > 80 || document.documentElement.scrollTop > 80) {
        document.getElementById("myTop").classList.add("w3-card-4", "w3-animate-opacity");
        document.getElementById("myIntro").classList.add("w3-show-inline-block");
    } else {
        document.getElementById("myIntro").classList.remove("w3-show-inline-block");
        document.getElementById("myTop").classList.remove("w3-card-4", "w3-animate-opacity");
    }
}

// Accordions
function myAccordion(id) {
    var x = document.getElementById(id);
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
        x.previousElementSibling.className += " w3-theme";
    } else { 
        x.className = x.className.replace("w3-show", "");
        x.previousElementSibling.className = 
        x.previousElementSibling.className.replace(" w3-theme", "");
    }
}
</script>
     
</body>
</html> 
