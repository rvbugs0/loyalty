<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>Loyalty Application - Manage Vendors</title>

<link rel="stylesheet" href='/loyalty.com/css/custom.min.css'>
<link rel="stylesheet" href='/loyalty.com/css/bootstrap.min.css'>
<script src='/loyalty.com/jquery/jquery-2.1.3.min.js'></script>
<script src='/loyalty.com/jquery/jquery.validate.min.js'></script>
<script src='/loyalty.com/jquery/jquery-ui.js'></script>
<link rel="stylesheet" href="/loyalty.com/jquery/jquery-ui.css">
<script src="/loyalty.com/js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
<div class="container">
        <div class="row">
          <div class="col-lg-12">
            <div class="page-header" style="margin-top:-50px;">
              <h1 id="forms">Manage Vendors</h1>
            </div>
          </div>
        </div>
    <section id="vendortablesection" style="margin-top:40px;">
            <button class="btn btn-md btn-success" id="AddVendorButton"  >Add Vendor</button>
                    <br><br/>
                    
                    <table class="table table-striped table-hover" id="vendorTable">
                <thead>
                    <tr>
                    <td>S.No.</td>
                    <td>Name of Firm</td>
                    <td>Username</td>
                    <td>Address</td>
                    <td>City</td>
                    <td>Phone Number</td>
                    <td>Email</td>
                    
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
                
                <form role="form">
                  <div class="form-group">
                    <label for="AddVendorNameOfFirm">Name Of Firm</label>
                      <input type="text" class="form-control"
                      id="AddVendorNameOfFirm" />
                  </div>
                  <div class="form-group">
                    <label for="AddVendorEmail">Email</label>
                      <input type="email" class="form-control"
                      id="AddVendorEmail" />
                  </div>
                  <div class="form-group">
                    <label for="AddVendorPhone">Phone Number</label>
                      <input type="text" class="form-control"
                      id="AddVendorPhone" />
                  </div>
                 <div class="form-group">
                    <label for="AddVendorAddress">Address</label>
                      <input type="text" class="form-control"
                      id="AddVendorAddress" />
                  </div>

                 <div class="form-group">
                    <label for="AddVendorUsername">Username</label>
                      <input type="text" class="form-control"
                      id="AddVendorUsername" />
                  </div>

                  <div class="form-group">
                    <label for="AddVendorPassword">Password</label>
                      <input type="text" class="form-control"
                      id="AddVendorPassword" />
                  </div>


                  <div class="form-group">
                    <label for="AddVendorCity">City : </label>
                      <select id="AddVendorCity" >
			<option value="-1">&lt;select&gt;</option>
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
    <div class="modal-dialog modal-md">
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
                
                    
                <form role="form">
                  <div class="form-group">
                    <label for="EditVendorNameOfFirm">Name</label>
                      <input type="text" class="form-control"
                      id="EditVendorNameOfFirm" placeholder="Enter Title"/>
                  </div>
                  <div class="form-group">
                    <label for="EditVendorEmail">Email</label>
                      <input type="email" class="form-control"
                      id="EditVendorEmail" placeholder="Enter Title"/>
                  </div>
                  <div class="form-group">
                    <label for="EditVendorPhone">Phone Number</label>
                      <input type="text" class="form-control"
                      id="EditVendorPhone" placeholder="Enter Title"/>
                  </div>

                 <div class="form-group">
                    <label for="EditVendorAddress">Address</label>
                      <input type="text" class="form-control"
                      id="EditVendorAddress" />
                  </div>

                 <div class="form-group">
                    <label for="EditVendorUsername">Username</label>
                      <input type="text" class="form-control"
                      id="EditVendorUsername" />
                  </div>


                  <div class="form-group">
                    <label for="EditVendorCity">City : </label>
                      <select id="EditVendorCity" >
			<option value="-1">&lt;select&gt;</option>
                    <!--code to dynamically add cities	-->  </select>
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
<script src="/loyalty.com/js/manage-vendors.js" type="text/javascript"></script>
</body>
</html>