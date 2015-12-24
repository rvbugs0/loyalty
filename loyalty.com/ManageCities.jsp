<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<title>Loyalty Application - Manage Cities</title>

<link rel="stylesheet" href='/loyalty.com/css/custom.min.css'>
<link rel="stylesheet" href='/loyalty.com/css/bootstrap.min.css'>
<script src='/loyalty.com/jquery/jquery-2.1.3.min.js'></script>
<script src='/loyalty.com/jquery/jquery.validate.min.js'></script>
<script src='/loyalty.com/jquery/jquery-ui.js'></script>
<script src='/loyalty.com/jquery/jquery.dataTables.min.js'></script>

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
<link rel="stylesheet" href="/loyalty.com/jquery/jquery-ui.css">
<script src="/loyalty.com/js/bootstrap.min.js" type="text/javascript"></script>
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
              <h1 id="forms">Manage Cities</h1>
            </div>
          </div>
        </div>
    <section id="citytablesection" style="margin-top:40px;">
            <div class="row">
            <div class="col-lg-4">
            <button class="btn btn-md btn-success" style="display:insline-block;" id="AddCityButton"  >Add City</button>
            </div>

            <div class="col-lg-offset-4 col-lg-4">
                    Search :   <input type="text" class="form-control"
                      id="cityTableSearchTextField" />
     
            </div>
            </div>

                    <table class="table table-striped table-hover" id="cityTable">
                <thead>
                    <tr>
                    <td>S.No.</td>
                    <td>City</td>
                    <td>State</td>
                    <td>Country</td>
                    <td>Options</td>

                    </tr>
                </thead>
                <tbody id="cityTableBody">

                </tbody>
                </table>
            </section>


<div class="modal fade" id="AddCityModal" tabindex="-1" role="dialog" 
     aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- Modal Header -->
            <div class="modal-header">
                <button type="button" class="close" 
                   data-dismiss="modal">
                       <span aria-hidden="true">&times;</span>
                       <span class="sr-only">Close</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    Add City
                </h4>
            </div>
            
            <!-- Modal Body -->
            <div class="modal-body">
                
                <form role="form" id="AddCityForm">
                  <div class="form-group">
                    <label for="AddCityName">City Name</label>
                      <input type="text" class="form-control"
                      id="AddCityName" name="AddCityName" />
     
                  </div>
                  <div class="form-group">
                    <label for="AddStateName">State</label>
                      <input type="text" class="form-control"
                      id="AddStateName" name="AddStateName" />
     
                  </div>                    
                 <div class="form-group">
                    <label for="AddCountryName">Country</label>
                      <input type="text" class="form-control"
                      id="AddCountryName" name="AddCountryName" />
     
                  </div>                    


                               </form>
                
                
            </div>
            
            <!-- Modal Footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="AddCityFormSubmitButton">
                    Add City
                </button>

                <button type="button" class="btn btn-default"
                        data-dismiss="modal">
                            Close
                </button>
            </div>
        </div>
    </div>
</div>



<div class="modal fade " id="EditCityModal" tabindex="-1" role="dialog" 
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
                    Edit City
                </h4>
            </div>
            
            <!-- Modal Body -->
            <div class="modal-body">
                
                    
                <form role="form" id="EditCityForm">
                  <div class="form-group">
                    <label for="EditCityName">Name</label>
                      <input type="text" class="form-control"
                      id="EditCityName" name="EditCityName" placeholder="Name"/>
                  </div>
                  <div class="form-group">
                    <label for="EditStateName">State</label>
                      <input type="text" class="form-control"
                      id="EditStateName" name="EditStateName" placeholder="State"/>
                  </div>
                  <br/>
                  <div class="form-group">
                    <label for="EditCountryName">Country</label>
                      <input type="text" class="form-control"
                      id="EditCountryName" name="EditCountryName" placeholder="Country"/>
                  </div>

                      <input type="hidden" class="form-control"
                      id="EditCityCode" />
                  </div>                       
                </form>
                
                
            </div>
            
            <!-- Modal Footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-primary" id="EditCityFormSubmitButton">
                    Update City
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
<script src='/loyalty.com/js/form-rules.js'></script>
<script src="/loyalty.com/js/manage-cities.js" type="text/javascript"></script>
</body>
</html>