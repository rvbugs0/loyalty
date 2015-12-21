<html>
<head>
<h2>Sign up</h2>
<script type="text/javascript" charset="utf-8"></script> 
<script src='/loyalty.com/jquery-2.1.3.min.js'></script>
<script src='/loyalty.com/jquery.validate.min.js'></script>
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
"url": "/loyalty.com/AdminFormCreation",
"data":{name:$("name").val(),username:$("username").val(),
password:$("password").val(),confirmPassword:$("confirmPassword").val(),contactNumber:$("contactNumber").val(),emailId:$("emailId").val()
},
"type": "GET",
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
<form id='signupForm' action='/loyalty.com/AdminFormCreation'>
Name
<input type='text' name='name' id='name'> 
<br><br>
Username
<input type='text' name='username' id='username'> 
<br><br>
Password
<input type='text' name='password' id='password'><br><br>
ConfirmPassword
<input type='text' name='confirmPassword' id='confirmPassword'><br><br>
ContactNumber
<input type='text' name='contactNumber' id='contactNumber'><br><br>
EmailId
<input type='text' name='emailId' id='emailId'><br><br>
<button id='submit' value='submit' onclick='authenticate()'>Signup</button>
</form>
<form id='validForm' action='/loyalty.com/AdminLoginForm.jsp'></form>
</body>
</html>