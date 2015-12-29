var objects=[];
$(document).ready(function(){
outletTBL=$('#outletTable').dataTable({
 "sAjaxSource": "GetAllVendorOutletsByVendorCode?code=20",
    "sAjaxDataProp": "VendorOutlets",
    "fnRowCallback" : function(nRow, aData, iDisplayIndex){

                $("td:first", nRow).html(iDisplayIndex +1);
                $("td:last",nRow).html("<a class='btn btn-warning btn-sm deleteButton optionButton' id='deleteButtonCode"+aData.code+"'>Delete</a>"+"<a class='btn btn-warning btn-sm editButton optionButton' id='editButtonCode"+aData.code+"'>Edit</a>");
               return nRow;
            },
    "aoColumns": [
        { "mDataProp": null },        
        { "mDataProp": "address" },
        { "mDataProp": "contactNumber" },
        { "mDataProp": "cityCode" },
        { "mDataProp": "latitude" },
        { "mDataProp": "longitude" },
        { "mDataProp": null }
    ]});


$('#outletTableSearchTextField').keyup(function(){
      outletTBL.fnFilter(this.value); ;
});

$("select[name=outletTable_length]").addClass("form-control");

});



function refreshTable () {
  var outletTBL=$('#outletTable').DataTable();
   outletTBL.ajax.reload();  
   
}

$("#AddOutletButton").on("click",function(){
	$("#AddOutletModal").modal("show");
});


$('#outletTable tbody').on( 'click', 'tr .editButton', function () {
  code=$(this).attr("id").replace("editButtonCode","");
  
     $row=$(this).closest("tr");
      $tds = $row.find("td");



			address=$tds.get(1).innerHTML;
      contactNumber=$tds.get(2).innerHTML;
      cityCode=$tds.get(3).innerHTML;
      latitude=$tds.get(4).innerHTML;
      longitude=$tds.get(5).innerHTML;
      

  $("#EditOutletAddress").val(address);
  $("#EditOutletPhone").val(contactNumber);
  $("#EditOutletCity").val(cityCode);
  $("#EditOutletLatitude").val(latitude);
  $("#EditOutletLongitude").val(longitude); 
  $("#EditOutletCode").val(code);
  
	$("#EditOutletModal").modal("show");

});


$("#EditOutletFormSubmitButton").on("click",function(){
	
	if($("#EditOutletForm").valid())
  {
  var code=$("#EditOutletCode").val();
  var address=$("#EditOutletAddress").val();
  var contactNumber=$("#EditOutletPhone").val();
  var cityCode=$("#EditOutletCity").val();
  var longitude=$("#EditOutletLongitude").val();
  var latitude=$("#EditOutletLatitude").val();

//testing
var vendorCode=20;
  

  var urlFormed="UpdateVendorOutlet?contactNumber="+encodeURI(contactNumber)+
  "&cityCode="+encodeURI(cityCode)+"&address="+encodeURI(address)
  +"&latitude="+encodeURI(latitude)+"&longitude="+encodeURI(longitude)
  +"&code="+encodeURI(code)+"&vendorCode="+vendorCode;
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
    $("#EditOutletModal").modal('hide');  
    $("#notificationMessage").html("Outlet Updated");
    $("#notificationModal").modal('show');
    $("#outletsTableBody").html("");
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

$("#AddOutletFormSubmitButton").on("click",function(){

if($("#AddOutletForm").valid())
{
var contactNumber=$("#AddOutletPhone").val();
var longitude=$("#AddOutletLongitude").val();
var latitude=$("#AddOutletLatitude").val();
var address=$("#AddOutletAddress").val();
var cityCode=$("#AddOutletCity").val();
//just for testing
var vendorCode=20;

var urlFormed="AddVendorOutlet?contactNumber="+encodeURI(contactNumber)
+"&cityCode="+encodeURI(cityCode)+"&address="+encodeURI(address)+
"&latitude="+encodeURI(latitude)+"&longitude="+encodeURI(longitude)
+"&vendorCode="+vendorCode;
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
    $("#AddOutletModal").modal('hide');
    $("#notificationMessage").html("Outlet Added");
    $("#notificationModal").modal('show');
    $("#outletsTableBody").html("");
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
var urlFormed="RemoveVendorOutlet?code="+code;
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
    $("#notificationMessage").html("Outlet Deleted");
    $("#notificationModal").modal('show');      
    $("#outletsTableBody").html("");
refreshTable();
    }else
    {
    $("#notificationMessage").html(data.errorMessage);
    $("#notificationModal").modal('show');
    }


  }
});
});


