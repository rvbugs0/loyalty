<html>
<head>
<h2>Login</h2>
<script type="text/javascript" charset="utf-8"></script> 
<script src='/loyalty.com/jquery-2.1.3.min.js'></script>
<script src='/loyalty.com/jquery.validate.min.js'></script>
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
"url":"/loyalty.com/AdminLogin",
"data":{username:$('#username').val(),
password:$("#password").val()
},
"type": "GET",
"dataType":"json",
"success":function(response)
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
<form id='loginForm' action='/loyalty.com/AdminLogin'>
Username
<input type='text' name='username' id='username'> 
<br><br>
Password
<input type='text' name='password' id='password'><br><br>
<button id='login' value='login' onclick='authenticate()'>Login</button> 
</form>
<form id='validForm' action='/loyalty.com/AdminHomepage.jsp'></form>
<form id='invalidForm' action='/loyalty.com/AdminLoginForm.jsp'></form>
</body>
</html>