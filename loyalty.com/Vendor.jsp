<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>Loyalty</title>
<link rel="stylesheet" href='css/styles.css'>
<link rel="stylesheet" href='css/custom.min.css'>

<link rel="stylesheet" href='css/bootstrap/css/bootstrap.min.css'>
<script src='jquery/jquery-2.1.3.min.js'></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>

<script src='jquery/jquery.validate.min.js'></script>
<script type="text/javascript">
  
  
function authenticate()
{
  $("#loginForm").validate({
rules:{
username:{
required:true
},
password:{
required:true
}},
messages:{
username:{
required:"Please enter username"
},
password:{
required:"Please enter password"
}
}
});
if($('#loginForm').valid())
{
return true;
}
return false;
}

</script>
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
      <a class="navbar-brand" href="AdminHomepage.jsp">Home</a>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      
<div class="dropdown pull-right">

  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
    &nbsp;Login/Signup
    <span class="caret"></span>
  </button>
  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
    <li><a href="#">Customer</a></li>
    <li><a href="#">Vendor</a></li>
    <li><a href="Admin">Admin</a></li>
    <li role="separator" class="divider"></li>
    <li><a href="#">Separated link</a></li>
  </ul>
</div>
    </div>
  </div>
</nav>


<div class="container">

<div >
        <div class="row">

          <div class="col-lg-12">
            <div class="page-header" >
              <h1 id="forms">Vendor Sign-in</h1>
            </div>
          </div>
        </div>

        <div class="row">
          <div class="col-lg-6">
            <div class="well bs-component">
              <form class="form-horizontal" id='loginForm' action='VendorHomepage.jsp' method="POST" onsubmit="return authenticate()">
                <fieldset>
                  <legend>Vendor Details</legend>
                  <div class="form-group">
                   <label for="username" class="col-lg-2 control-label">Username</label>
                    <div class="col-lg-10">
                    <input type='text' placeholder='Username' class="form-control" name='username' id='username'>
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="password" class="col-lg-2 control-label">Password</label>
                    <div class="col-lg-10">
                      <input type="password" class="form-control" id="password" placeholder="Password" name="password">
                    </div>
                  </div>
                  
                  <div class="form-group">
                    <div class="col-lg-10 col-lg-offset-2">
                      <button type="submit" class="btn btn-primary" id='login' value='login' >Login</button>
<br/>
                    <a style="color:white;margin-right:20px;" class="pull-right" href="#">forgot password?</a>

                    </div>
                  </div>
              
                </fieldset>
              
              </form>
            </div>
          </div><!-- col-lg-6-->
          <div class="col-lg-6">
            <div class="well bs-component">
                 <legend>Haven't Registered yet? </legend>
               <a class="btn btn-default btn-primary" href="VendorSignup.jsp">Register now</a>
               <br/><br/>
            </div>
          </div><!-- col-lg-6-->
        </div>
      </div>

</div><!--container-->
</body>
</html>