<html>
<head>
<title>Loyalty Application - Setup new Admin</title>
<script type="text/javascript" charset="utf-8"></script> 

<link rel="stylesheet" href='css/bootstrap/css/bootstrap.min.css'>
<link rel="stylesheet" href='css/custom.min.css'>
<script src='jquery/jquery-2.1.3.min.js'></script>
<script src='jquery/jquery.validate.min.js'></script>
<script>
function authenticate(){
$("#signupForm").validate({
rules:{
name:{
required:true
},
username:{
required:true
},
password:{
required:true
},
confirmPassword:{
required:true,
equalTo: '#password'
},
contactNumber:{
required:true
},
emailId:{
required:true
}},
messages:{
name:{
required:"Please enter name"
},
username:{
required:"Please enter username"
},
password:{
required:"Please enter password"
},
confirmPassword:{
required:"Please enter confirmPassword"
},
contactNumber:{
required:"Please enter contactNumber"
},
emailId:{
required:"Please enter emailId"
}
}
});
var form=$('#signupForm');
if($('#signupForm').valid())
{
$.ajax({
"url": "AdminFormCreation",
"data":{name:$("#name").val(),username:$("#username").val(),
password:$("#password").val(),confirmPassword:$("#confirmPassword").val(),contactNumber:$("#contactNumber").val(),emailId:$("#emailId").val()
},
"type": "POST",
"success":function(){
$('#validForm').submit();
},
"error":function(){
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
              <h1 id="forms">Admin Signup Form</h1>
            </div>
          </div>
        </div>

        <div class="row">
          <div class="col-lg-6">
            <div class="well bs-component">
              <form class="form-horizontal" id='signupForm' action='AdminFormCreation'>
                <fieldset>
                  <legend>Admin Details</legend>
                  <div class="form-group">
                    <label for="name" class="col-lg-2 control-label">Name</label>
                    <div class="col-lg-10">
                      <input type="text" class="form-control" id="name" placeholder="Name" name="name">
                    </div>
                  </div>
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
                    <label for="confirmPassword" class="col-lg-2 control-label">Confirm Password</label>
                    <div class="col-lg-10">
                      <input type="password" class="form-control" id="confirmPassword" placeholder="Repeat Password">
                    </div>
                  </div>
                  <div class="form-group">
                   <label for="contactNumber" class="col-lg-2 control-label">Contact Number</label>
                    <div class="col-lg-10">
                		<input type='text' class="form-control" placeholder='Contact Number' name='contactNumber' id='contactNumber'>
                    </div>
                  </div>
                  <div class="form-group">
                   <label for="emailId" class="col-lg-2 control-label">Email Id</label>
                    <div class="col-lg-10">
                		<input type='email' class="form-control" placeholder='EmailId' name='emailId' id='emailId'>
                    </div>
                  </div>

                  <div class="form-group">
                    <div class="col-lg-10 col-lg-offset-2">
                      <button type="button" class="btn btn-primary" onclick='authenticate()'>Signup</button>
                    </div>
                  </div>
                </fieldset>
              </form>
            </div>
          </div>
        </div>
      </div>
</div> <!-- container-->

<form id='validForm' action='AdminLoginForm.jsp'></form>
</body>
</html>