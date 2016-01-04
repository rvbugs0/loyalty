function Customer()
{
	this.name="";
	this.email="";
	this.contactNumber="";
	this.username="";
	this.password="";
	this.passwordKey="";
	this.gender="";
	this.dateOfBirth="";
	this.student="";
	this.occupation="";
	this.currentAddress="";
	this.permanentAddress="";
	this.married="";
	this.cityCode="";
	this.stream="";
	this.courseDetails="";
	this.spouseName="";
	this.spouseOccupation="";
	this.spouseDateOfBirth="";
	this.anniversaryDate="";
	this.girlChild="";
	this.boyChild="";
}

function City()
{
	this.code="";
	this.name="";
}

function State()
{
	this.name="";
	this.cities=[];
	this.cityCount=0;
}

var globalStates=[];

$(document).ready(function(){

$.ajax({
	"url": "GetAllCities",
	"type": "GET",
"success":function(data){

var txt="<option value='-1'>&lt; Select &gt; </option> ";
x=0;
while(x<data.length)
{
	txt=txt + "<option value='"+data[x].code+"'>"+data[x].name +"</option> ";
	x++;
}
$("#city").html(txt);

},
"error":function(){
alert("error getting cities!!");
}
});
});




function printDistinctStates(arr)
{
 var stateCount=0;

	n=sizeof(arr);
    // Pick all elements one by one
    for (i=0; i<n; i++)
    {
        // Check if the picked element is already printed
        var j;
        for (j=0; j<i; j++)
           if (arr[i].state == arr[j].state)
               {
               break;
               }
 
        // If not printed earlier, then print it
        if (i == j)
        {
        	var state =new State();
        	state.name=arr[i].state;
        	globalStates[stateCount]=state;
        	stateCount++;
        }

    }
}


$("#sameAddress").change(function() {
    if(this.checked) {
        //Do stuff
     address= $("#currentAddress").val();   
    $("#permanentAddress").val(address);
    $("#permanentAddressBlock").hide();
    }
});

$("#currentAddress").on("change",function() {
    address= $("#currentAddress").val();   
    if($("#sameAddress").prop("checked")==true)
    {$("#permanentAddress").val(address);
    
    $("#permanentAddressBlock").hide();
    }
});


function checkContactNumberAvailability()
{
	if($("#basicInfoForm").valid())
{
	vContactNumber=$("#contactNumber").val();
$.ajax({
	"url": "GetCustomerByContactNumber",
	"data":{
	contactNumber:vContactNumber
	},
"type": "GET",
"success":function(data){
if(!data.success)
{
checkUsernameAvailability();
}
else
{
$("#notificationMessage").html("Contact Number "
	+ vContactNumber+" Not available");	
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
	"url": "GetCustomerByUsername",
	"data":{
	username:vUsername
	},
"type": "GET",
"success":function(data){
if(!data.success)
{
checkEmailIdAvailability();
}
else
{
$("#notificationMessage").html("Username "
	+ vUsername+" not available");	
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
	"url": "GetCustomerByEmailId",
	"data":{
	emailId:vEmailId
	},
"type": "GET",
"success":function(data){
if(!data.success)
{
submitBasicInfo();
}
else
{
$("#notificationMessage").html("Email ID "
	+ vEmailId+" not available");	
$("#notificationModal").modal("show");
}
},
"error":function(){
alert("error!!");
}
});
}


var globalCustomer="";


	$("#studentInfoForm").hide();
	$("#marriageInfoForm").hide();
	$("#accountCreationSection").hide();



	function submitBasicInfo()
	{
		var customer=new Customer();
		globalCustomer=customer;
		if($("#basicInfoForm").valid())
		{
			customer.name=$("#name").val();
			customer.emailId=$("#email").val();
			customer.contactNumber=$("#contactNumber").val();
			customer.username=$("#username").val();
			customer.password=$("#password").val();
			customer.passwordKey=customer.password;

			if($("#genderMaleChecked").prop("checked")==true)
			{
				customer.gender="M";
			}
			else
			{
				customer.gender="F";
			}
			customer.dateOfBirth=$("#dob").val();
			
			if($("#studentYesOption").prop("checked")==true)
			{
			customer.student=true;				
			}else
			{
			customer.student=false;
			}

			customer.occupation=$("#occupation").val();

			customer.currentAddress=$("#currentAddress").val();
			if($("#sameAddress").prop("checked")==true)
			{
				customer.permanentAddress=customer.currentAddress;
			}
			else
			{
				customer.permanentAddress=$("#permanentAddress").val();
			}
			
			customer.cityCode=$("#city").val();
			
			if($("#noMarriedOption").prop("checked")==true)
			{
					customer.married=false;
			}
			else
			{
				customer.married=true;
			}			


    	if(customer.married==false && customer.student==true)
    	{
    	$("#basicInfoForm" ).slideUp( "slow", function() {	
    	$("#studentInfoForm").show();
    	$("#progressBar").css("width","75%");
    	});
    	}
    	if(customer.married==true && !customer.student==true)
    	{
    	$( "#basicInfoForm" ).slideUp( "slow", function() {	
    	$("#marriageInfoForm").show();
    	$("#progressBar").css("width","75%");
    	});
    	}    	
    	if(customer.student==true && customer.married==true)
    	{
		$( "#basicInfoForm" ).slideUp( "slow", function() {
    	$("#studentInfoForm").show();		
    	$("#progressBar").css("width","50%");
    	});
    	}

    	if(!customer.married==true && !customer.student==true)
    	{
    	$( "#basicInfoForm" ).slideUp( "slow", function() {	
    	$("#progressBar").css("width","100%");
    	createAccount();	
    	});
    	}

		}/* if valid*/
}



	function submitStudentInfo()
	{

		if($("#studentInfoForm").valid())
		{
			globalCustomer.stream=$("#stream").val();
			globalCustomer.courseDetails=$("#courseDetails").val();

		if(globalCustomer.married)
		{
		$( "#studentInfoForm" ).slideUp( "slow", function() {
    	$("#progressBar").css("width","75%");
      $("#marriageInfoForm").show();
        });			
	}else
	{
				$( "#studentInfoForm" ).slideUp( "slow", function() {
    	$("#progressBar").css("width","100%");
      createAccount();
        });
	}			
		}
	}

	function submitMarriageInfo()
	{	 
		if($("#marriageInfoForm").valid())
		{
	
		globalCustomer.spouseName=$("#spouseName").val();
		globalCustomer.spouseOccupation=$("#spouseOccupation").val();
		globalCustomer.spouseDateOfBirth=$("#spouseDob").val();
		globalCustomer.anniversaryDate=$("#anniversaryDate").val();
		globalCustomer.girlChild=$("#girlChild").val();
		globalCustomer.boyChild=$("#boyChild").val();	
		$( "#marriageInfoForm" ).slideUp( "slow", function() {
    	$("#progressBar").css("width","100%");
        createAccount();			
        });

		}

	 
	}


	function createAccount()
	{
	
	

	$("#accountCreationSection").show();		
	//console.log(globalCustomer);	
	$.ajax({
	"url": "AddCustomer",
	"data":{
	name:globalCustomer.name,
	username:globalCustomer.username,
	password:globalCustomer.password,
	passwordKey:globalCustomer.password,
	emailId:globalCustomer.emailId,
	contactNumber:globalCustomer.contactNumber,
	cityCode:globalCustomer.cityCode,
	gender:globalCustomer.gender,
	dateOfBirth:globalCustomer.dateOfBirth,
	isStudent:globalCustomer.student,
	occupation:globalCustomer.occupation,
	currentAddress:globalCustomer.currentAddress,
	permanentAddress:globalCustomer.permanentAddress,
	isMarried:globalCustomer.married,
	stream:globalCustomer.stream,
	courseDetails:globalCustomer.courseDetails,
	spouseName:globalCustomer.spouseName,
	spouseOccupation:globalCustomer.occupation,
	spouseDateOfBirth:globalCustomer.spouseDateOfBirth,
	anniversaryDate:globalCustomer.anniversaryDate,
	numberOfGirlChild:globalCustomer.girlChild,
	numberOfBoyChild:globalCustomer.boyChild
	},
"type": "GET",
"success":function(data){
if(data.success)
{
$("#accountStatusMessage").html("Account created successfully ,Click <a href='Customer.jsp'> here </a>to login to your account.");
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
