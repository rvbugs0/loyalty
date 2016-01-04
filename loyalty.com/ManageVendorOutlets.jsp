<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>Loyalty Application - Manage Outlets</title>
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
      <a class="navbar-brand" href="VendorHomepage.jsp">Home</a>
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
              <h1 id="forms">Manage Outlets</h1>
            </div>
          </div>
        </div>
    <section id="outletTableSection" style="margin-top:40px;">
            <div class="row">
            <div class="col-lg-4">
            <button class="btn btn-md btn-success" style="display:insline-block;" id="AddOutletButton"  >Add Outlet</button>
            </div>

            <div class="col-lg-offset-4 col-lg-4">
                    Search :   <input type="text" class="form-control"
                      id="outletTableSearchTextField" />
     
            </div>
            </div>


                    <table class="table table-striped table-hover" id="outletTable">
                <thead>
                    <tr>
                    <td>S.No.</td>
                    <td>Address</td>
                    <td>Contact Number</td>
                    <td>City Code</td>
                    <td>Latitude</td>
                    <td>Longitude</td>
                       
                   <td>Options</td>

                    </tr>
                </thead>
                <tbody id="outletTableBody">

                </tbody>
                </table>
            </section>


<div class="modal fade" id="AddOutletModal" tabindex="-1" role="dialog" 
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
                    Add Outlet
                </h4>
            </div>
            
            <!-- Modal Body -->
            <div class="modal-body">
                
                <form role="form" id="AddOutletForm">
                  <div class="form-group">
                    <label for="AddOutletPhone">Phone Number</label>
                      <input type="text" class="form-control"
                      id="AddOutletPhone" name="AddOutletPhone" />
                  </div>
                 <div class="form-group">
                    <label for="AddOutletAddress">Address</label>
                      <input type="text" class="form-control"
                      id="AddOutletAddress" name="AddOutletAddress" />
                  </div>
<br/>
                 <div class="form-group">
                    <label for="AddOutletLatitude">Latitude</label>
                      <input type="text" class="form-control"
                      id="AddOutletLatitude" name="AddOutletLatitude" />
                  </div>

                  <div class="form-group">
                    <label for="AddOutletLongitude">Longitude</label>
                      <input type="text" class="form-control"
                      id="AddOutletLongitude" name="AddOutletLongitude" />
                  </div>

<br/>

                  <div class="form-group">
                    <label for="AddOutletCity">City : </label>
                      <select id="AddOutletCity" class="form-control" name="AddOutletCity" >
			<option value="-1" selected>&lt;select&gt;</option>
      <option value="1" >Indore</option>
      <option value="2" >Ujjain</option>
                    <!--code to dynamically add cities	-->  </select>
                  </div>
                    


                               </form>
                
                
            </div>
            
            <!-- Modal Footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="AddOutletFormSubmitButton">
                    Add Outlet
                </button>

                <button type="button" class="btn btn-default"
                        data-dismiss="modal">
                            Close
                </button>
            </div>
        </div>
    </div>
</div>



<div class="modal fade " id="EditOutletModal" tabindex="-1" role="dialog" 
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
                    Edit Outlet
                </h4>
            </div>
            
            <!-- Modal Body -->
            <div class="modal-body">
                
                    
                <form role="form" id="EditOutletForm">
                     <div class="form-group">
                    <label for="EditOutletPhone">Phone Number</label>
                      <input type="text" class="form-control"
                      id="EditOutletPhone" name="EditOutletPhone" placeholder="Enter Title"/>
                  </div>

                 <div class="form-group">
                    <label for="EditOutletAddress">Address</label>
                      <input type="text" class="form-control"
                      id="EditOutletAddress" name="EditOutletAddress" />
                  </div>
                  <br>
                  <div class="form-group">
                    <label for="EditOutletLatitude">Latitude</label>
                      <input type="text" class="form-control"
                      id="EditOutletLatitude" name="EditOutletLatitude" />
                  </div>
                  <div class="form-group">
                    <label for="EditOutletLongitude">Longitude</label>
                      <input type="text"  class="form-control"
                      id="EditOutletLongitude" name="EditOutletLongitude" />
                  </div>
                
                  <br/>
                  <div class="form-group">
                    <label for="EditOutletCity">City : </label>
                      <select id="EditOutletCity" name="EditOutletCity" class="form-control">
      <option value="-1" selected>&lt;select&gt;</option>
      <option value="1" >Indore</option>
      <option value="2" >Ujjain</option>
                    <!--code to dynamically add cities	-->  </select>
                  </div>
                 <br>
                 <div class="form-group">
                      <input type="hidden" class="form-control"
                      id="EditOutletCode" />
                  </div>                       
                </form>
                
                
            </div>
            
            <!-- Modal Footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="EditOutletFormSubmitButton">
                    Update Outlet
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
<script src="js/manage-vendor-outlets.js" type="text/javascript"></script>
</body>
</html>
