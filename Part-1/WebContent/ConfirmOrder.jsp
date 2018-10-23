<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>

<!-- All of the below code is referenced unless specified from https://www.w3schools.com/w3css/tryit.asp?filename=tryw3css_examples_material  -->
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

<!-- code referenced from https://stackoverflow.com/questions/24176684/how-to-show-alert-in-a-jsp-from-a-servlet-and-then-redirect-to-another-jsp -->
	<c:if test="${not empty error}">
		<script>
			window.addEventListener("load", function() {
				alert("This account name already exists. Try again!");
			});
		</script>
	</c:if>
<!-- code end -->

<nav class="w3-sidebar w3-bar-block w3-collapse w3-animate-left w3-card" style="z-index:3;width:250px;" ></nav>
<a class="w3-bar-item w3-button w3-hide-large w3-large" ></a>

<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" id="myOverlay"></div>

<div class="w3-main" style="margin-left:250px;">

<div id="myTop" class="w3-container w3-top w3-theme w3-large">
  <p><i class="fa fa-bars w3-button w3-teal w3-hide-large w3-xlarge" onclick="w3_open()"></i>
  <span id="myIntro" class="w3-hide">Welcome to Bookworm, place where Canada shop</span></p>

</div>

<header class="w3-container w3-theme" style="padding:64px 32px">
  <h1 class="w3-xxxlarge">BookWorm</h1>
</header>

<div class="w3-container" style="padding:70px">

<form action="" method="post" class="w3-container w3-card-4 w3-light-grey w3-text-blue w3-margin">
<h2 class="w3-center">Payment</h2>
 
 <div class="w3-row w3-section w3-text-black">
    <div class="w3-rest">
    <label for="nameOnCard">Name On Card</label>
      <input class="w3-input w3-border" id="nameOnCard" name="nameOnCard" type="text" placeholder="Enter Name on Credit Card" required>
    </div>
</div>

<div class="w3-row w3-section w3-text-black">
    <div class="w3-rest">
    <label for="expMonth"> Select Card Type</label><br>
                <select>
                    <option value="creditCard">Credit Card </option>
                    <option value="debitCard">Debit Card </option>
                </select>
	</div>
</div>
<div class="w3-row w3-section w3-text-black">
    <div class="w3-rest">
    <label for="cardNumber">Card Number</label>
      <input class="w3-input w3-border" id="cardNumber" name="cardNumber" type="text" value=""
            onkeypress="javascript:return isNumber(event)"placeholder="Enter card Number" required >
    </div>
</div>

<div class="w3-row w3-section w3-text-black">
    <div class="w3-rest">
    <label for="expMonth"> Expiration Date</label><br>
                
                <select>
                    <option value="01">January</option>
                    <option value="02">February </option>
                    <option value="03">March</option>
                    <option value="04">April</option>
                    <option value="05">May</option>
                    <option value="06">June</option>
                    <option value="07">July</option>
                    <option value="08">August</option>
                    <option value="09">September</option>
                    <option value="10">October</option>
                    <option value="11">November</option>
                    <option value="12">December</option>
                </select>
                <select>
                    <option value="16"> 2018</option>
                    <option value="17"> 2019</option>
                    <option value="18"> 2020</option>
                    <option value="19"> 2021</option>
                    <option value="20"> 2022</option>
                    <option value="21"> 2023</option>
                </select>
            </div>
</div>            

<div class="w3-row w3-section w3-text-black">
    <div class="w3-rest">
    <label for="cvvNum"> CVV</label>
      <input class="w3-input w3-border" id="cvvNum" name="cvvNum" value=""
            onkeypress="javascript:return isNumber(event)" placeholder="Enter Three digit CVV Number" required>
      
    </div>
</div>
   
</form>

 <p class="w3-center">
 <form action="${pageContext.request.contextPath}/ConfirmOrder" method="get">
 <%-- <%
 int orderID =  (Integer)request.getAttribute("purchaseOrderID");
 %> --%>
 <input type="hidden" class="purchaseOrderID" name="purchaseOrderID" value = "<%=request.getAttribute("purchaseOrderID") %>">
<button class="w3-button w3-section w3-blue w3-ripple" type="submit"> Confirm Order</button></form>
</p>


<h2>Beautiful Book Quotes...!!</h2>
<div class="w3-container w3-sand w3-leftbar">
<p><i>Make it as simple as possible, but not simpler.</i><br>
Albert Einstein</p>
</div>
</div>

<footer class="w3-container w3-theme" style="padding:22px">
  <p>Copyright © 2018 Brewing Java Corporation</p>
</footer>
     
</div>

<script>
 function isNumber(evt) {
    var iKeyCode = (evt.which) ? evt.which : evt.keyCode
    if (iKeyCode != 46 && iKeyCode > 31 && (iKeyCode < 48 || iKeyCode > 57))
        return false;

    return true;
}   
 
function validate() {
	var nameOnCard = document.getElementById("nameOnCard").value;
	var cardNumber = document.getElementById("cardNumber").value;
	var expMonth = document.getElementById("expMonth").value;
	var expYear = document.getElementById("expYear").value;
	var cvvNum = document.getElementById("cvvNum").value;
	if (nameOnCard === "" || cardNumber === "" || expMonth ===""||expYear ===""|| cvvNum === "" ) {
		alert("None of the fields should be left blank!");
		return false;
	}
	else {
		document.form.submit();
        return true;
	}
}

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