function Vendor()
{
	this.name="";
	this.email="";
	this.contactNumber="";
	this.username="";
	this.password="";
	this.address="";
	this.cityCode="";
	
}


$(document).ready(function(){

$.ajax({
	"url": "GetAllCities",
	"type": "GET",
"success":function(data){

var txt="<option value='-1'>&lt; Select &gt; </option> ";
x=0;
while(x<data.length)
{
	txt=txt + "<option value='"+data[x].code+"'>"+data[x].name+"</option> ";
	x++;
}
$("#city").html(txt);

},
"error":function(){
alert("error getting cities!!");
}
});
});


function checkNameAvailability()
{
	vName=$("#name").val();
$.ajax({
	"url": "VendorExistsByName",
	"data":{
	name:vName
	},
"type": "GET",
"success":function(data){
if(data.success)
{
if(!data.message)
{
checkEmailIdAvailability();
}
else
{
$("#notificationMessage").html("Name Of Firm : "+vName+" not available");	
$("#notificationModal").modal("show");	
}	

}
else
{
$("#notificationMessage").html(data.errorMessage);	
$("#notificationModal").modal("show");
}
},
"error":function(){
alert("error!!");
}
});
}



function checkContactNumberAvailability()
{
	if($("#vendorRegistrationForm").valid())
{
	vContactNumber=$("#contactNumber").val();
$.ajax({
	"url": "VendorExistsByContactNumber",
	"data":{
	contactNumber:vContactNumber
	},
"type": "GET",
"success":function(data){
if(data.success)
{
if(!data.message)
{
checkUsernameAvailability();
}
else
{
$("#notificationMessage").html("Contact Number "+vContactNumber+" not available");	
$("#notificationModal").modal("show");	
}	

}
else
{
$("#notificationMessage").html(data.errorMessage);	
$("#notificationModal").modal("show");
}
},
"error":function(){
alert("error!!");
}
});

}
}

function checkUsernameAvailability()
{
	vUsername=$("#username").val();
$.ajax({
	"url": "VendorExistsByUsername",
	"data":{
	username:vUsername
	},
"type": "GET",
"success":function(data){
if(data.success)
{
if(!data.message)
{
createAccount();
}
else
{
$("#notificationMessage").html("Username "+vUsername+" not available");	
$("#notificationModal").modal("show");	
}	

}
else
{
$("#notificationMessage").html(data.errorMessage);	
$("#notificationModal").modal("show");
}
},
"error":function(){
alert("error!!");
}
});
}





function checkEmailIdAvailability()
{
	vEmailId=$("#email").val();
$.ajax({
	"url": "VendorExistsByEmailId",
	"data":{
	emailId:vEmailId
	},
"type": "GET",
"success":function(data){
if(data.success)
{
if(!data.message)
{
checkContactNumberAvailability();
}
else
{
$("#notificationMessage").html("Email ID : "+vEmailId+" not available");	
$("#notificationModal").modal("show");	
}	

}
else
{
$("#notificationMessage").html(data.errorMessage);	
$("#notificationModal").modal("show");
}
},
"error":function(){
alert("error!!");
}
});
}





	$("#accountCreationSection").hide();



	function createAccount()
	{
	
	if($("#vendorRegistrationForm").valid())
	{
		$( "#vendorRegistrationForm" ).slideUp( "slow", function() {	
    		$("#progressBar").css("width","100%");
		$("#accountCreationSection").show();
    	});
		
	
		var vendor=new Vendor();
		vendor.name=$("#name").val();
		vendor.emailId=$("#email").val();
		vendor.contactNumber=$("#contactNumber").val();
		vendor.username=$("#username").val();
		vendor.password=$("#password").val();
		vendor.address=$("#address").val();
		vendor.cityCode=$("#city").val();
	}

		
	$.ajax({
	"url": "AddVendor",
	"data":{
	name:vendor.name,
	username:vendor.username,
	password:vendor.password,
	emailId:vendor.emailId,
	contactNumber:vendor.contactNumber,
	cityCode:vendor.cityCode,
	address:vendor.address,
	},
"type": "GET",
"success":function(data){
if(data.success)
{
$("#accountStatusMessage").html("Account created successfully ,Click <a href='Vendor.jsp'> here </a>to login to your account.");
$("#accountProgress").css("width","100%");
}
else
{
	$("#accountStatusMessage").html(data.errorMessage);
}

},
"error":function(){
alert("error!!");
}
});
	}	
