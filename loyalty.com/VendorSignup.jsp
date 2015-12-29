<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>Loyalty - Vendor Registration</title>
<link rel="stylesheet" href='/loyalty.com/css/styles.css'>
<link rel="stylesheet" href='/loyalty.com/css/custom.min.css'>
<link rel="stylesheet" href='/loyalty.com/css/bootstrap/css/bootstrap.min.css'>
<script src='/loyalty.com/jquery/jquery-2.1.3.min.js'></script>
<script src='/loyalty.com/jquery/jquery.validate.min.js'></script>
<script src='/loyalty.com/jquery/jquery-ui.js'></script>

<script src='/loyalty.com/jquery/jquery.dataTables.min.js'></script>
<link rel="stylesheet" href="/loyalty.com/jquery/jquery-ui.css">
<script src="/loyalty.com/js/bootstrap.min.js" type="text/javascript"></script>
<style type="text/css">
	  #form-group
    {
    	width: 300px;
         margin-right: 50px; 
        display: inline-block;
    }
</style>
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
      <a class="navbar-brand" href="/loyalty.com/AdminHomepage.jsp">Home</a>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      
<div class="dropdown pull-right">

  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
    &nbsp;Login/Signup
    <span class="caret"></span>
  </button>
  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
    <li><a href="/loyalty.com/Customer.jsp">Customer</a></li>
    <li><a href="/loyalty.com/Vendor.jsp">Vendor</a></li>
    <li><a href="/loyalty.com/Admin">Admin</a></li>
    <li role="separator" class="divider"></li>
    <li><a href="#">Separated link</a></li>
  </ul>
</div>
    </div>
  </div>
</nav><!-- Nav-->

<div class="container">

<div class="row">
          <div class="col-lg-12">
            <div class="page-header" >
              <h1 id="forms">Vendor Sign-up</h1>
            </div>
          </div>
        </div>

<div class="row">
<div class="col-lg-12">
	<div class="progress progress-striped active">
  <div class="progress-bar" id="progressBar" style="width: 5%"></div>
</div>
</div>
</div>




<div class="row">
<div class="col-lg-12">
<form class="form-horizontal" id="vendorRegistrationForm">
  <fieldset>
    <legend>Basic Info</legend>
    <div class="form-group">
      <label for="name" class="col-lg-2 control-label">Name Of Firm</label>
      <div class="col-lg-10">
        <input type="text" class="form-control" id="name" name="name" placeholder="Full Name">
      </div>
    </div>
    <div class="form-group">
      <label for="email" class="col-lg-2 control-label">Email</label>
      <div class="col-lg-10">
        <input type="text" class="form-control" id="email" name="email" placeholder="Email">
      </div>
    </div>
     <div class="form-group">
      <label for="contactNumber" class="col-lg-2 control-label">Contact Number</label>
      <div class="col-lg-10">
        <input type="text" class="form-control" id="contactNumber" name="contactNumber" placeholder="Contact Number">
      </div>
    </div>
    <div class="form-group">
      <label for="username" class="col-lg-2 control-label">Username</label>
      <div class="col-lg-10">
        <input type="text" class="form-control" id="username" name="username" placeholder="Username">
      </div>
    </div>
    <div class="form-group">
      <label for="password" class="col-lg-2 control-label">Password</label>
      <div class="col-lg-10">
        <input type="password" class="form-control" name="password" id="password" placeholder="Password">
      </div>
    </div>
    
    <div class="form-group">
      <label for="address" class="col-lg-2 control-label">Address</label>
      <div class="col-lg-10">
        <textarea class="form-control" rows="3" id="address" name="address"></textarea>
        <!--
        <span class="help-block">A longer block of help text that breaks onto a new line and may extend beyond one line.</span>
      	-->
     
      </div>

    </div>
     

    <div class="form-group">
      <label for="state" class="col-lg-2 control-label">State</label>
      <div class="col-lg-10">
        <select class="form-control" id="state">
          <option>Andhra Pradesh</option>
          <option>Maharashtra</option>
          <option>Madhya Pradesh</option>
          
        </select>
      </div>
    </div>
    
    <div class="form-group">
      <label for="city" class="col-lg-2 control-label">City</label>
      <div class="col-lg-10">
        <select class="form-control" id="city">
          <option value="703">Indore</option>
          <option value="777">Ujjain</option>
          <option value="748">Ratlam</option>
          
        </select>
      </div>
    </div>
    <div class="form-group">
      <div class="col-lg-10 col-lg-offset-2">
        
        <button type="button" onclick="checkNameAvailability()" class="btn btn-primary">Proceed</button>
      </div>
    </div>
  </fieldset>
</form>




</div>
</div>

<div class="row" id="accountCreationSection">
<div class="col-lg-offset-1 col-lg-10">
<div class="well bs-component">
<legend>Validating Information and creating Account,</legend>
<p id="accountStatusMessage">please wait for a moment</p>
<div class="progress progress-striped active">
  <div class="progress-bar progress-bar-success" id="accountProgress" style="width: 40%"></div>
</div>
</div>
</div>
</div>

<div class="modal fade" id="notificationModal" role="dialog">
    <div class="modal-dialog modal-md">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Notification</h4>
        </div>
        <div class="modal-body">
          <p id="notificationMessage"></p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default btn-primary" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>

</div><!--container-->
<script src='/loyalty.com/js/vendor-registration-form-rules.js'></script>
<script type="text/javascript" src="/loyalty.com/js/vendor-signup.js"></script>



</body>
</html>


