var objects=[];
var cityTBL="";
$(document).ready(function(){
	$("#AddCityForm").valid();
  //$("#EditCityForm").valid();
  cityTBL=$('#cityTable').dataTable({
 "sAjaxSource": "GetAllCities",
 "sAjaxDataProp": "",  
    "fnRowCallback" : function(nRow, aData, iDisplayIndex){
                $("td:first", nRow).html(iDisplayIndex +1);
                $("td:last",nRow).html("<a class='btn btn-warning btn-sm deleteButton optionButton' id='deleteButtonCode"+aData.code+"'>Delete</a>"+"<a class='btn btn-warning btn-sm editButton optionButton' id='editButtonCode"+aData.code+"'>Edit</a>");
               return nRow;
            },
    "aoColumns": [
        { "mDataProp": "code" },        
        { "mDataProp": "name" },
        { "mDataProp": "state" },
        { "mDataProp": "country"},
        { "mDataProp": "code" }]});


$('#cityTableSearchTextField').keyup(function(){
      cityTBL.fnFilter(this.value); ;
});

$("select[name=cityTable_length]").addClass("form-control");


});

function refreshTable () {
   var cityTBL=$('#cityTable').DataTable();
   cityTBL.ajax.reload();  
}

$("#AddCityButton").on("click",function(){
	$("#AddCityModal").modal("show");
});



$(document).on("click",".editButton",function(){
	code=$(this).attr("id").replace("editButtonCode","");
	  tbl = $("#cityTable").dataTable();
  
  var rowCount = $('#cityTable tr').length;
  alert(rowCount);
  x=0;
  while(x<rowCount)
  {
  rowData = tbl.fnGetData(x);
  if(rowData.code==code)
  {
    alert("found");
    break;
  }    
  x++;
  }
  name=rowData.name;
  alert(name);
  state=rowData.state;
  country=rowData.country;


  $("#EditCityName").val(name);
  $("#EditStateName").val(state);
  $("#EditCountryName").val(country);
  $("#EditCityCode").val(code); 
	$("#EditCityModal").modal("show");
});


$("#EditCityFormSubmitButton").on("click",function(){
	
  //$("#EditCityModal").modal("hide");	
	if($("#EditCityForm").valid())
  {
  var name=$("#EditCityNameOfFirm").val();
  var code=$("#EditCityCode").val();
  var emailId=$("#EditCityEmail").val();
  var contactNumber=$("#EditCityPhone").val();
  var address=$("#EditCityAddress").val();
  var username=$("#EditCityUsername").val();
  var password=$("#EditCityPassword").val();
  var cityCode=$("#EditCityCity").val();
  var urlFormed="UpdateCity?name="+encodeURI(name)+"&emailId="+encodeURI(emailId)
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
    $("#EditCityModal").modal('hide');  
    $("#notificationMessage").html("City Updated");
    $("#notificationModal").modal('show');
    $("#citysTableBody").html("");
    loadCitys();      
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


$("#AddCityFormSubmitButton").on("click",function(){


if($("#AddCityForm").valid())
{
var name=$("#AddCityName").val();
var state=$("#AddStateName").val();
var country=$("#AddCountryName").val();
var urlFormed="AddCity?name="+encodeURI(name)+"&state="+encodeURI(state)+"&country="+encodeURI(country);
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
    $("#AddCityModal").modal('hide');
    $("#notificationMessage").html("City Added");
    $("#notificationModal").modal('show');
    $("#cityTableBody").html("");
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
var urlFormed="RemoveCity?code="+code;
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
    $("#notificationMessage").html("City Deleted");
    $("#notificationModal").modal('show');      
    $("#citysTableBody").html("");
   refreshTable();
     }else
    {
    $("#notificationMessage").html(data.errorMessage);
    $("#notificationModal").modal('show');
    }


  }
});
});


