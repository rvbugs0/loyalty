var customer = "";

	$("#studentInfoForm").hide();
	$("#marriageInfoForm").hide();
	$("#accountCreationSection").hide();



	function submitBasicInfo()
	{
		if($("#basicInfoForm").valid())
		{
			customer.name=$("#name").val();
			customer.email=$("#email").val();
			customer.contactNumber=$("#contactNumber").val();
			customer.username=$("#username").val();
			customer.password=$("#password").val();


	$( "#basicInfoForm" ).slideUp( "slow", function() {
    	$("#progressBar").css("width","50%");
      $("#studentInfoForm").show();
        });



		}
}

	function submitStudentInfo()
	{
		$( "#studentInfoForm" ).slideUp( "slow", function() {
    	$("#progressBar").css("width","75%");
      $("#marriageInfoForm").show();
        });
	 
	}

	function submitMarriageInfo()
	{	 $( "#marriageInfoForm" ).slideUp( "slow", function() {
    	$("#progressBar").css("width","100%");
$("#accountCreationSection").show();
        });
	 
	}	
