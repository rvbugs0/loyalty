<html>
<head>
<meta charset="utf-8">
<script src='/loyalty.com/jquery-2.1.3.min.js'></script>
<script src='/loyalty.com/jquery-ui.js'></script>
<link rel="stylesheet" href="/loyalty.com/jquery-ui.css">
<script>
$(function() {
$("#button1,#button2,#button3,#button4").button()
      
  });
  </script>
<h1>Admin Home</h1>
</head>
<body>
<a id='button1' href='/loyalty.com/UpdateAdminDetails.jsp'>Change Username/Password</a><br/>
<a id='button2' href='/loyalty.com/VendorUI.jsp'>Manage Vendors</a><br/>
<a id='button3' href='/loyalty.com/CityUI.jsp'>Manage Cities</a><br/>
<a id='button4' href='/loyalty.com/Logout.jsp'>Logout</a><br/>
</body>
</html>