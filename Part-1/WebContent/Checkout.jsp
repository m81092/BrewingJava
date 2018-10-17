<!-- Reference:w3Schools.com -->
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="css/checkout.css" rel="stylesheet" type="text/css"/>

</head>
<body>

<h2>Please checkout here</h2>
<div class="row">
  <div class="col-75">
    <div class="container">
      <form action="/action">
      
        <div class="row">
          <div class="col-50">
            <h3>Please checkout here</h3>
            <label for="fname"><i class="fa fa-user"></i> Full Name</label>
            <input type="text" id="fname" name="firstname" placeholder="Enter Name here">
            
            <label for="adr"><i class="fa fa-address-card-o"></i> Billing Address</label>
            <input type="text" id="adr" name="address" placeholder="Enter Billing Address here">
            <label for="city"><i class="fa fa-institution"></i> Shipping Address</label>
            <input type="text" id="city" name="city" placeholder="Enter Shipping Address">
			<label>
          	<input type="checkbox" checked="checked" name="sameadr"> Shipping address same as billing
        	</label>
            <div class="row">
              <div class="col-50"> </div>
              <div class="col-50"></div>
           </div>
          </div>

          <div class="col-50">
            <h3>Payment</h3>
            <label for="fname">Accepted Cards</label>
            <div class="icon-container">
              <i class="fa fa-cc-visa" style="color:navy;"></i>
              <i class="fa fa-cc-amex" style="color:blue;"></i>
              <i class="fa fa-cc-mastercard" style="color:red;"></i>
              <i class="fa fa-cc-discover" style="color:orange;"></i>
            </div>
            <label for="cname">Name on Card</label>
            <input type="text" id="cname" name="cardname" placeholder="Enter Name on Card">
            <label for="ccnum">Credit card number</label>
            <input type="text" id="ccnum" name="cardnumber" placeholder="Enter Credit card number ">
            <label for="expmonth">Exp Month</label>
            <input type="text" id="expmonth" name="expmonth" placeholder="Enter Exp Month">
            <div class="row">
              <div class="col-50">
                <label for="expyear">Exp Year</label>
                <input type="text" id="expyear" name="expyear" placeholder="Enter Exp Year">
              </div>
              <div class="col-50">
                <label for="cvv">CVV</label>
                <input type="text" id="cvv" name="cvv" placeholder="Enter Three Digit CVV Number ">
              </div>
            </div>
          </div>
          
        </div>
        
        
      </form>
    </div>
  </div>
  <div class="col-25">
    <div class="container">
      <h4>Cart <span class="price" style="color:black"><i class="fa fa-shopping-cart"></i> <b></b></span></h4>
      <p><a href="#"></a> <span class="price"></span></p>
      <p><a href="#"></a> <span class="price"></span></p>
      <p><a href="#"></a> <span class="price"></span></p>
      <p><a href="#"></a> <span class="price"></span></p>
      <hr>
      <p>Total <span class="price" style="color:black"><b></b></span></p>
    </div>
    <input type="submit" value="Continue to checkout" class="btn">
  </div>
</div>

</body>
</html>
