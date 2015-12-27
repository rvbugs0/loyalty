<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>Loyalty - Customer Registration</title>
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
<script type="text/javascript">
	function submitBasicInfo()
	{
		/*
		$("#basicInfoForm").hide();
		$("#progressBar").css("width","50%");
	*/
	 $( "#basicInfoForm" ).slideUp( "slow", function() {
    	$("#progressBar").css("width","50%");  });
	 $("#studentInfoForm").show();
	}

	function submitStudentInfo()
	{
	/*	$("#studentInfoForm").hide();
		$("#progressBar").css("width","75%");	
	*/
		 $( "#studentInfoForm" ).slideUp( "slow", function() {
    	$("#progressBar").css("width","75%");  });
	 $("#marriageInfoForm").show();
	}

	function submitMarriageInfo()
	{/*
		$("#marriageInfoForm").hide();
		$("#progressBar").css("width","100%");	
	*/
		 $( "#marriageInfoForm" ).slideUp( "slow", function() {
    	$("#progressBar").css("width","100%");  });
	 $("#accountCreationSection").show();
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
    <li><a href="#">Vendor</a></li>
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
              <h1 id="forms">Customer Sign-up</h1>
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
<form class="form-horizontal" id="basicInfoForm">
  <fieldset>
    <legend>Basic Info</legend>
    <div class="form-group">
      <label for="name" class="col-lg-2 control-label">Name</label>
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
        <input type="password" class="form-control" id="password" placeholder="Password">
      </div>
    </div>
    <div class="form-group">
      <label class="col-lg-2 control-label">Gender</label>
      <div class="col-lg-10">
        <div class="radio">
          <label>
            <input type="radio" name="gender" id="maleOption" value="M" checked="true">
            Male
          </label>
        </div>
        <div class="radio">
          <label>
            <input type="radio" name="gender" id="femaleOption" value="F">
            Female
          </label>
        </div>
      </div>
    </div>
    
        <div class="form-group">
      <label for="dob" class="col-lg-2 control-label">Date Of Birth</label>
      <div class="col-lg-3">
        <input type="date" class="form-control" id="dob" name="dob" placeholder="Date Of Birth">
      </div>
    </div>
    <br/>
        <div class="form-group">
      <label class="col-lg-2 control-label">Student</label>
      <div class="col-lg-10">
        <div class="radio">
          <label>
            <input type="radio" name="student" id="yesOption" value="Y" checked="true">
            Yes
          </label>
        </div>
        <div class="radio">
          <label>
            <input type="radio" name="student" id="noOption" value="N" >
            No
          </label>
        </div>

      </div>
    </div>
    <div class="form-group">
      <label for="occupation" class="col-lg-2 control-label">Occupation</label>
      <div class="col-lg-10">
        <input type="text" class="form-control" id="occupation" name="occupation" placeholder="Occupation">
      </div>
    </div>
    <div class="form-group">
      <label for="currentAddress" class="col-lg-2 control-label">Current Address</label>
      <div class="col-lg-10">
        <textarea class="form-control" rows="3" id="currentAddress" name="currentAddress"></textarea>
        <!--
        <span class="help-block">A longer block of help text that breaks onto a new line and may extend beyond one line.</span>
      	-->
       	 <div class="checkbox" >
          <label>
            <input type="checkbox"> Is this Current Address your Permanent Address ? 
          </label>
        </div>
     
      </div>

    </div>
     
    <div class="form-group">
      <label for="permanentAddress" class="col-lg-2 control-label">Permanent Address</label>
      <div class="col-lg-10">
        <textarea class="form-control" rows="3" id="permanentAddress" name="permanentAddress"></textarea>
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
          <option>Indore</option>
          <option>Ujjain</option>
          <option>Ratlam</option>
          
        </select>
      </div>
    </div>
        <div class="form-group">
      <label class="col-lg-2 control-label">Married</label>
      <div class="col-lg-10">
        <div class="radio">
          <label>
            <input type="radio" name="married" id="noOption" value="N" checked="true">
            No
          </label>
        </div>
        <div class="radio">
          <label>
            <input type="radio" name="married" id="yesOption" value="Y">
            Yes
          </label>
        </div>
      </div>
    </div>
    <div class="form-group">
      <div class="col-lg-10 col-lg-offset-2">
        
        <button type="button" onclick="submitBasicInfo()" class="btn btn-primary">Proceed</button>
      </div>
    </div>
  </fieldset>
</form>



<form class="form-horizontal" id="studentInfoForm">
  <fieldset>
    <legend>Student Details</legend>
    
        <div class="form-group">
      <label for="stream" class="col-lg-2 control-label">Stream of Studies</label>
      <div class="col-lg-5">
        <input type="text" class="form-control" id="stream" name="stream" placeholder="">
      </div>
    </div>
        <div class="form-group">
      <label for="courseDetails" class="col-lg-2 control-label">Course Details</label>
      <div class="col-lg-5">
        <input type="text" class="form-control" id="courseDetails" name="courseDetails" placeholder="">
      </div>
    </div>

    <br/>
        
    <div class="form-group">
      <div class="col-lg-10 col-lg-offset-2">
        
        <button type="button" onclick="submitStudentInfo()" class="btn btn-primary">Proceed</button>
      </div>
    </div>
  </fieldset>
</form>


<form class="form-horizontal" id="marriageInfoForm">
  <fieldset>
    <legend>Marriage Details</legend>
    
        <div class="form-group">
      <label for="spouseName" class="col-lg-2 control-label">Spouse Name</label>
      <div class="col-lg-6">
        <input type="text" class="form-control" id="spouseName" name="spouseName" placeholder="">
      </div>
    </div>

        <div class="form-group">
      <label for="spouseOccupation" class="col-lg-2 control-label">Spouse Occupation</label>
      <div class="col-lg-6">
        <input type="text" class="form-control" id="spouseOccupation" name="spouseOccupation" placeholder="">
      </div>
    </div>
            <div class="form-group">
      <label for="spouseDob" class="col-lg-2 control-label">Spouse's Date Of Birth</label>
      <div class="col-lg-3">
        <input type="date" class="form-control" id="spouseDob" name="spouseDob" placeholder="Spouse's Date Of Birth">
      </div>
    </div>
            <div class="form-group">
      <label for="anniversaryDate" class="col-lg-2 control-label">Anniversary Date</label>
      <div class="col-lg-3">
        <input type="date" class="form-control" id="anniversaryDate" name="anniversaryDate" placeholder="Anniversary Date">
      </div>
    </div>
            <div class="form-group">
      <label for="girlChild" class="col-lg-2 control-label">Number Of Girl Child</label>
      <div class="col-lg-6">
        <input type="number" value="0" class="form-control" id="girlChild" name="girlChild" placeholder="">
      </div>
    </div>
                      <div class="form-group">
      <label for="boyChild" class="col-lg-2 control-label">Number Of Boy Child</label>
      <div class="col-lg-6">
        <input type="number" value="0" class="form-control" id="boyChild" name="boyChild" placeholder="">
      </div>
    </div>
    <br/>
        
    <div class="form-group">
      <div class="col-lg-10 col-lg-offset-2">
        
        <button type="button" onclick="submitMarriageInfo()" class="btn btn-primary">Proceed</button>
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
<p>please wait for a moment</p>
<div class="progress progress-striped active">
  <div class="progress-bar progress-bar-success" style="width: 40%"></div>
</div>
</div>
</div>
</div>

</div><!--container-->

<script type="text/javascript">
	$("#studentInfoForm").hide();
	$("#marriageInfoForm").hide();
	$("#accountCreationSection").hide();


</script>
</body>
</html>


