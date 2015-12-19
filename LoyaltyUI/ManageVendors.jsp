<!DOCTYPE html>
<html lang="en" >

<head >

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Loyalty App- Manage Vendors</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">

  
    <link href="css/freelancer.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<style type="text/css">
    .deleteButton{
        margin-right:5px;
    }

    .form-group
    {
        display: inline-block;
    }
</style>

</head>
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
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
    </div>
  </div>
</div>

<body id="page-top" class="index">

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
          
            <div class="navbar-header">
                <a class="navbar-brand" href="index.jsp">Loyalty App</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
        <!-- /.container-fluid -->
    </nav>



<div class="modal fade" id="AddVendorModal" tabindex="-1" role="dialog" 
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


    <!-- Portfolio Grid Section -->
   
    <section id="portfolio" class="portfolio" style="margin-top:70px;">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h2>Manage Vendors</h2>
                   </div>
            </div>
            <div class="row">

                <div class="col-lg-12">
            <button class="btn btn-md btn-success" id="AddVendorButton">Add Vendor</button>
                    <br><br/>
                    
                    <table class="table table-bordered">
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
                </div> 
            </div>
         </div>
    </section>


    <!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
    <div class="scroll-top page-scroll visible-xs visible-sm">
        <a class="btn btn-primary" href="#page-top">
            <i class="fa fa-chevron-up"></i>
        </a>
    </div>


      
    <!-- jQuery -->
    <script src="js/jquery.js"></script>
 <script src="site-js/manage-vendors.js" type="text/javascript"></script>
 
    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
    <script src="js/classie.js"></script>
    <script src="js/cbpAnimatedHeader.js"></script>

    <!-- Contact Form JavaScript -->
    <script src="js/jqBootstrapValidation.js"></script>
    <script src="js/contact_me.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="js/freelancer.js"></script>

</body>

</html>
