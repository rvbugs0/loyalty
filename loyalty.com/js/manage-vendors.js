var objects=[];
var vendorTBL="";
$(document).ready(function(){
	$("#AddVendorForm").valid();
  $("#EditVendorForm").valid();

//  $('#vendorTable').DataTable();
vendorTBL=$('#vendorTable').dataTable({
 "sAjaxSource": "GetAllVendors",
    "sAjaxDataProp": "Vendors",
    "fnRowCallback" : function(nRow, aData, iDisplayIndex){

                $("td:first", nRow).html(iDisplayIndex +1);
                $("td:last",nRow).html("<a class='btn btn-warning btn-sm deleteButton optionButton' id='deleteButtonCode"+aData.code+"'>Delete</a>"+"<a class='btn btn-warning btn-sm editButton optionButton' id='editButtonCode"+aData.code+"'>Edit</a>");
               return nRow;
            },
    "aoColumns": [
        { "mDataProp": "code" },        
        { "mDataProp": "name" },
        { "mDataProp": "username" },
        { "mDataProp": "contactNumber" },
        { "mDataProp": "cityCode" },
        { "mDataProp": "emailId" },
        { "mDataProp": "address" },
        { "mDataProp": "password" },
        { "mDataProp": "code" }

    ]});


$('#vendorTableSearchTextField').keyup(function(){
      vendorTBL.fnFilter(this.value); ;
});

$("select[name=vendorTable_length]").addClass("form-control");


});

function refreshTable () {
   var vendorTBL=$('#vendorTable').DataTable();
   vendorTBL.ajax.reload();  
}

$("#AddVendorButton").on("click",function(){
	$("#AddVendorModal").modal("show");
});


$('#vendorTable tbody').on( 'click', 'tr .editButton', function () {
  code=$(this).attr("id").replace("editButtonCode","");
  
     $row=$(this).closest("tr");
      $tds = $row.find("td");



			name=$tds.get(1).innerHTML;
      username=$tds.get(2).innerHTML;
			contactNumber=$tds.get(3).innerHTML;
      cityCode=$tds.get(4).innerHTML;
      emailId=$tds.get(5).innerHTML;
      address=$tds.get(6).innerHTML;
      password=$tds.get(7).innerHTML;

  $("#EditVendorNameOfFirm").val(name);
  $("#EditVendorPhone").val(contactNumber);
  $("#EditVendorPassword").val(password);
  $("#EditVendorEmail").val(emailId); 
  $("#EditVendorAddress").val(address); 
	$("#EditVendorUsername").val(username);	
	$("#EditVendorCode").val(code);
  $("#EditVendorCity").val(cityCode);

	$("#EditVendorModal").modal("show");

});


$("#EditVendorFormSubmitButton").on("click",function(){
	
  //$("#EditVendorModal").modal("hide");	
	if($("#EditVendorForm").valid())
  {
  var name=$("#EditVendorNameOfFirm").val();
  var code=$("#EditVendorCode").val();
  var emailId=$("#EditVendorEmail").val();
  var contactNumber=$("#EditVendorPhone").val();
  var address=$("#EditVendorAddress").val();
  var username=$("#EditVendorUsername").val();
  var password=$("#EditVendorPassword").val();
  var cityCode=$("#EditVendorCity").val();
  var urlFormed="UpdateVendor?name="+encodeURI(name)+"&emailId="+encodeURI(emailId)
  +"&contactNumber="+encodeURI(contactNumber)+"&cityCode="+encodeURI(cityCode)
  +"&address="+encodeURI(address)+"&username="+encodeURI(username)
  +"&password="+encodeURI(password)+"&code="+encodeURI(code);
$.ajax({

  url: urlFormed,
  error : function (jqXHR,textStatus,errorThrown )
  {
    $("#notificationMessage").html(errorThrown);
    $("#notificationModal").modal('show');
  },success : function(data,textStatus,jqXHR)
  {
    if(data.success)
    {
    $("#EditVendorModal").modal('hide');  
    $("#notificationMessage").html("Vendor Updated");
    $("#notificationModal").modal('show');
    $("#vendorsTableBody").html("");
    refreshTable();     
    }
    else
    {
    $("#notificationMessage").html(data.errorMessage);
    $("#notificationModal").modal('show');
    }

  }
});
  }



});

$("#AddVendorFormSubmitButton").on("click",function(){


	//$("#AddVendorModal").modal("hide");	
if($("#AddVendorForm").valid())
{
var username=$("#AddVendorUsername").val();
var name=$("#AddVendorNameOfFirm").val();
var email=$("#AddVendorEmail").val();
var contactNumber=$("#AddVendorPhone").val();
var password=$("#AddVendorPassword").val();
var address=$("#AddVendorAddress").val();
var cityCode=$("#AddVendorCity").val();
var urlFormed="AddVendor?name="+encodeURI(name)+"&username="+encodeURI(username)+"&emailId="+encodeURI(email)+"&contactNumber="+encodeURI(contactNumber)+"&cityCode="+encodeURI(cityCode)+"&address="+encodeURI(address)+"&password="+encodeURI(password);
$.ajax({

  url: urlFormed,
  error : function (jqXHR,textStatus,errorThrown )
  {
    $("#notificationMessage").html(errorThrown);
    $("#notificationModal").modal('show');
  },success : function(data,textStatus,jqXHR)
  {
    if(data.success)
    {
    $("#AddVendorModal").modal('hide');
    $("#notificationMessage").html("Vendor Added");
    $("#notificationModal").modal('show');
    $("#vendorsTableBody").html("");
    refreshTable();
    }
    else
    {
      $("#notificationMessage").html(data.errorMessage);
    $("#notificationModal").modal('show');
    }

  }
});
}


});



$(document).on("click",".deleteButton",function(){
var code=$(this).attr("id").replace("deleteButtonCode","");
var urlFormed="RemoveVendor?code="+code;
$.ajax({

  url: urlFormed,
  error : function (jqXHR,textStatus,errorThrown )
  {
  	$("#notificationMessage").html(errorThrown);
  	$("#notificationModal").modal('show');
  },success : function(data,textStatus,jqXHR)
  {
    if(data.success)
    {
    $("#notificationMessage").html("Vendor Deleted");
    $("#notificationModal").modal('show');      
    $("#vendorsTableBody").html("");
refreshTable();
    }else
    {
    $("#notificationMessage").html(data.errorMessage);
    $("#notificationModal").modal('show');
    }


  }
});
});


