<html>
<head>

<link rel="stylesheet" href='css/custom.min.css'>
<link rel="stylesheet" href='css/styles.css'>
<link rel="stylesheet" href='css/bootstrap/css/bootstrap.min.css'>
<script src='jquery/jquery-2.1.3.min.js'></script>
<script src='jquery/jquery.validate.min.js'></script>
<script src='jquery/jquery-ui.js'></script>
<link rel="stylesheet" href="jquery/jquery-ui.css">
<title>Loyalty - Vendor Home</title>
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="">Home</a>
    </div>
 <div class="navbar-collapse collapse" id="navbar-main">
          <ul class="nav navbar-nav">
            <li>
              <a href="VendorHomepage.jsp">Vendor-Home</a>
            </li>
          </ul>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">Link</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="container">
        <div class="row">
          <div class="col-lg-12">
            <div class="page-header" >
              <h1 id="forms">Vendor Home</h1>
            </div>
          </div>
        </div>

<a class="btn btn-default btn-danger" id='button1' href='UpdateAdminDetails.jsp'>Change Username/Password</a>
<br/><br/>
<a class="btn btn-default btn-primary" id='button2' href='ManageVendorOutlets.jsp'>Manage Outlets</a><br/><br/>

<a class="btn btn-default btn-info" id='button4' href='Logout.jsp'>Logout</a><br/>
</div>
</body>
</html>