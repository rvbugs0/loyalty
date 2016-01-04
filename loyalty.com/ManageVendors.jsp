<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>Loyalty Application - Manage Vendors</title>
<link rel="stylesheet" href='css/styles.css'>
<link rel="stylesheet" href='css/custom.min.css'>
<link rel="stylesheet" href='css/bootstrap/css/bootstrap.min.css'>
<script src='jquery/jquery-2.1.3.min.js'></script>
<script src='jquery/jquery.validate.min.js'></script>
<script src='jquery/jquery-ui.js'></script>
<script src='jquery/jquery.dataTables.min.js'></script>

<link rel="stylesheet" href="jquery/jquery-ui.css">
<script src="js/bootstrap.min.js" type="text/javascript"></script>

<style>
  .form-group
    {
        width: 300px;
        margin-right: 20px; 
        display: inline-block;
    }

    .dataTables_filter {
   display: none;
}

</style>
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
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">Link</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="container">
        <div class="row">
          <div class="col-lg-12">
            <div class="page-header" >
              <h1 id="forms">Manage Vendors</h1>
            </div>
          </div>
        </div>
    <section id="vendortablesection" style="margin-top:40px;">
            <div class="row">
            <div class="col-lg-4">
            <button class="btn btn-md btn-success" style="display:insline-block;" id="AddVendorButton"  >Add Vendor</button>
            </div>

            <div class="col-lg-offset-4 col-lg-4">
                    Search :   <input type="text" class="form-control"
                      id="vendorTableSearchTextField" />
     
            </div>
            </div>

                    <table class="table table-striped table-hover" id="vendorTable">
                <thead>
                    <tr>
                    <td>S.No.</td>
                    <td>Firm Name</td>
                    <td>Username</td>
                    <td>Phone</td>
                    <td>City</td>
                    <td>Email</td>
                    <td>Address</td>
                    <td>Password</td>   
                   <td>Options</td>

                    </tr>
                </thead>
                <tbody id="vendorsTableBody">

                </tbody>
                </table>
            </section>


<div class="modal fade" id="AddVendorModal" tabindex="-1" role="dialog" 
     aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
                <button type="button" class="close" 
                   data-dismiss="modal">
                       <span aria-hidden="true">&times;</span>
                       <span class="sr-only">Close</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    Add Vendor
                </h4>
            </div>
            
            <!-- Modal Body -->
            <div class="modal-body">
                
                <form role="form" id="AddVendorForm">
                  <div class="form-group">
                    <label for="AddVendorNameOfFirm">Name Of Firm</label>
                      <input type="text" class="form-control"
                      id="AddVendorNameOfFirm" name="AddVendorNameOfFirm" />
     
                  </div>
                  <div class="form-group">
                      <label for="AddVendorEmail">Email</label>
                      <input type="email" class="form-control"
                      id="AddVendorEmail" name="AddVendorEmail" />               
                  </div>
                  <br/>
                  <div class="form-group">
                    <label for="AddVendorPhone">Phone Number</label>
                      <input type="text" class="form-control"
                      id="AddVendorPhone" name="AddVendorPhone" />
                  </div>
                 <div class="form-group">
                    <label for="AddVendorAddress">Address</label>
                      <input type="text" class="form-control"
                      id="AddVendorAddress" name="AddVendorAddress" />
                  </div>
<br/>
                 <div class="form-group">
                    <label for="AddVendorUsername">Username</label>
                      <input type="text" class="form-control"
                      id="AddVendorUsername" name="AddVendorUsername" />
                  </div>

                  <div class="form-group">
                    <label for="AddVendorPassword">Password</label>
                      <input type="password" class="form-control"
                      id="AddVendorPassword" name="AddVendorPassword" />
                  </div>

<br/>

                  <div class="form-group">
                    <label for="AddVendorCity">City : </label>
                      <select id="AddVendorCity" class="form-control" name="AddVendorCity" >
			<option value="-1" selected>&lt;select&gt;</option>
      <option value="1" >Indore</option>
      <option value="2" >Ujjain</option>
                    <!--code to dynamically add cities	-->  </select>
                  </div>
                    


                               </form>
                
                
            </div>
            
            <!-- Modal Footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="AddVendorFormSubmitButton">
                    Add Vendor
                </button>

                <button type="button" class="btn btn-default"
                        data-dismiss="modal">
                            Close
                </button>
            </div>
        </div>
    </div>
</div>



<div class="modal fade " id="EditVendorModal" tabindex="-1" role="dialog" 
     aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
                <button type="button" class="close" 
                   data-dismiss="modal">
                       <span aria-hidden="true">&times;</span>
                       <span class="sr-only">Close</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    Edit Vendor
                </h4>
            </div>
            
            <!-- Modal Body -->
            <div class="modal-body">
                
                    
                <form role="form" id="EditVendorForm">
                  <div class="form-group">
                    <label for="EditVendorNameOfFirm">Name</label>
                      <input type="text" class="form-control"
                      id="EditVendorNameOfFirm" name="EditVendorNameOfFirm" placeholder="Enter Title"/>
                  </div>
                  <div class="form-group">
                    <label for="EditVendorEmail">Email</label>
                      <input type="email" class="form-control"
                      id="EditVendorEmail" name="EditVendorEmail" placeholder="Enter Title"/>
                  </div>
                  <br/>
                  <div class="form-group">
                    <label for="EditVendorPhone">Phone Number</label>
                      <input type="text" class="form-control"
                      id="EditVendorPhone" name="EditVendorPhone" placeholder="Enter Title"/>
                  </div>

                 <div class="form-group">
                    <label for="EditVendorAddress">Address</label>
                      <input type="text" class="form-control"
                      id="EditVendorAddress" name="EditVendorAddress" />
                  </div>
                  <br>
                                   <div class="form-group">
                    <label for="EditVendorUsername">Username</label>
                      <input type="text" disabled class="form-control"
                      id="EditVendorUsername" name="EditVendorUsername" />
                  </div>
                  <div class="form-group">
                    <label for="EditVendorPassword">Password</label>
                      <input type="text"  class="form-control"
                      id="EditVendorPassword" name="EditVendorPassword" />
                  </div>
                
                  <br/>
                  <div class="form-group">
                    <label for="EditVendorCity">City : </label>
                      <select id="EditVendorCity" name="EditVendorCity" class="form-control">
      <option value="-1" selected>&lt;select&gt;</option>
      <option value="1" >Indore</option>
      <option value="2" >Ujjain</option>
                    <!--code to dynamically add cities	-->  </select>
                  </div>
                 <br>
                 <div class="form-group">
                      <input type="hidden" class="form-control"
                      id="EditVendorCode" />
                  </div>                       
                </form>
                
                
            </div>
            
            <!-- Modal Footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="EditVendorFormSubmitButton">
                    Update Vendor
                </button>

                <button type="button" class="btn btn-default"
                        data-dismiss="modal">
                            Close
                </button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="notificationModal" role="dialog">
    <div class="modal-dialog modal-sm">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Notification</h4>
        </div>
        <div class="modal-body">
          <p id="notificationMessage"></p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default btn-primary" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
</div>
</div><!-- container-->
<script src='js/form-rules.js'></script>
<script src="js/manage-vendors.js" type="text/javascript"></script>
</body>
</html>