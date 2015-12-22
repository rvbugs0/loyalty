<html>
<head>
<title>Loyalty Application - Admin Login</title>
<link rel="stylesheet" href='/loyalty.com/css/custom.min.css'>
<link rel="stylesheet" href='/loyalty.com/css/bootstrap.min.css'>
<script src='/loyalty.com/jquery/jquery-2.1.3.min.js'></script>
<script src='/loyalty.com/jquery/jquery.validate.min.js'></script>
<script>
function authenticate(){
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
$.ajax({
url:"/loyalty.com/AdminLogin",
data:{username:$('#username').val(),
password:$("#password").val()
},
type: "POST",
dataType:"json",
success:function(response)
{
var resp=response.success;
if(resp===true)
{
$("#validForm").submit();
}
else{
$("#invalidForm").submit();
}
},
error:function(){
alert("error!!");
}
});
}
}
</script>
</head>
<body>
<div class="container">
<div class="">
        <div class="row">
          <div class="col-lg-12">
            <div class="page-header" style="margin-top:-50px;">
              <h1 id="forms">Admin Sign-in</h1>
            </div>
          </div>
        </div>

        <div class="row">
          <div class="col-lg-6">
            <div class="well bs-component">
              <form class="form-horizontal" id='loginForm' action='/loyalty.com/AdminLogin'>
                <fieldset>
                  <legend>Admin Details</legend>
                  <div class="form-group">
                   <label for="username" class="col-lg-2 control-label">Username</label>
                    <div class="col-lg-10">
                		<input type='text' placeholder='Username' class="form-control" name='username' id='username'>
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="password" class="col-lg-2 control-label">Password</label>
                    <div class="col-lg-10">
                      <input type="password" class="form-control" id="password" placeholder="Password">
                    </div>
                  </div>
                  
                  <div class="form-group">
                    <div class="col-lg-10 col-lg-offset-2">
                      <button type="button" class="btn btn-primary" id='login' value='login' onclick='authenticate()'>Login</button>
                    </div>
                  </div>
                </fieldset>
              </form>
            </div>
          </div>
        </div>
      </div>
</div> <!-- container-->
<form id='validForm' action='/loyalty.com/AdminHomepage.jsp'></form>
<form id='invalidForm' action='/loyalty.com/AdminLoginForm.jsp'></form>
</body>
</html>