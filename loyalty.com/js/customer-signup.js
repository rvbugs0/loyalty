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
			customer.email=$("#email").val();
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

	function createAccount()
	{
	$("#accountCreationSection").show();		
	console.log(globalCustomer);	
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
		globalCustomer.spouseDateOfBirth=$("#spouseDateOfBirth").val();
		globalCustomer.anniversaryDate=$("#anniversaryDate").val();
		globalCustomer.girlChild=$("#girlChild").val();
		globalCustomer.boyChild=$("#boyChild").val();	
		$( "#marriageInfoForm" ).slideUp( "slow", function() {
    	$("#progressBar").css("width","100%");

        });			
		}

	 
	}	
