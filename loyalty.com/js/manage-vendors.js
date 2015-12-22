var objects="";

$(document).ready(function(){
	loadVendors();
});

$("#AddVendorButton").on("click",function(){
	$("#AddVendorModal").modal("show");
});

$(document).on("click",".editButton",function(){
	code=$(this).attr("id").replace("editButtonCode","");
	//alert(code);
	for(i=0;i<objects.length;i++)
	{
		if(objects[i].code==code)
		{

			name=objects[i].name;
      username=objects[i].username;
			address=objects[i].address;
      contactNumber=objects[i].contactNumber;
      cityCode=objects[i].cityCode;
      emailId=objects[i].emailId;


      //alert(name);
			break;
		}

	}
  $("#EditVendorNameOfFirm").val(name);
  $("#EditVendorPhone").val(contactNumber);
  $("#EditVendorEmail").val(emailId); 
  $("#EditVendorAddress").val(address); 
	$("#EditVendorUsername").val(username);	
	$("#EditVendorCode").val(code);
  $("#EditVendorCity").val(cityCode);
	$("#EditVendorModal").modal("show");
});


$("#EditVendorFormSubmitButton").on("click",function(){
	$("#EditVendorModal").modal("hide");	
	
	var name=$("#EditVendorNameOfFirm").val();
	if(name.trim().length==0)
	{
  	$("#notificationMessage").html("Please provide some input");
  	$("#notificationModal").modal('show');		
	return;
	}
	var code=$("#EditVendorCode").val();
	var email=$("#EditVendorEmail").val();
  if(email.trim().length==0)
  {

    $("#notificationMessage").html("Please provide an Email");
    $("#notificationModal").modal('show');    
  return;
  }
  var phone=$("#EditVendorPhone").val();
  if(phone.trim().length==0)
  {

    $("#notificationMessage").html("Please provide a phone number");
    $("#notificationModal").modal('show');    
  return;
  }
  var dob=$("#EditVendorDOB").val();
  if(dob.trim().length==0)
  {

    $("#notificationMessage").html("Please provide Birth Date");
    $("#notificationModal").modal('show');    
  return;
  }

  var address=$("#EditVendorAddress").val();
  if(address.trim().length==0)
  {

    $("#notificationMessage").html("Please provide an address");
    $("#notificationModal").modal('show');    
  return;
  }
var role=$("#EditVendorRole").val();
  if(role.trim().length==0)
  {

    $("#notificationMessage").html("Please Select a role");
    $("#notificationModal").modal('show');    
  return;
  }
var gender=$("#EditVendorGender").val();
  if(gender.trim().length==0)
  {

    $("#notificationMessage").html("Please select a gender");
    $("#notificationModal").modal('show');    
  return;
  }
  var department=$("#EditVendorDepartment").val();
  if(department.trim().length==0)
  {

    $("#notificationMessage").html("Please select a department");
    $("#notificationModal").modal('show');    
  return;
  }
    var institution=$("#EditVendorInstitution").val();
  if(institution.trim().length==0)
  {

    $("#notificationMessage").html("Please provide institution name");
    $("#notificationModal").modal('show');    
  return;
  }


var urlFormed="UpdateVendor.php?name="+encodeURI(name)+"&institution="+encodeURI(institution)+"&email="+encodeURI(email)+"&phone="+encodeURI(phone)+"&dob="+encodeURI(dob)+"&address="+encodeURI(address)+"&role="+encodeURI(role)+"&gender="+encodeURI(gender)+"&department="+encodeURI(department)+"&code="+encodeURI(code);
$.ajax({

  url: urlFormed,
  error : function (jqXHR,textStatus,errorThrown )
  {
  	$("#notificationMessage").html(errorThrown);
  	$("#notificationModal").modal('show');
  },success : function(data,textStatus,jqXHR)
  {
  	$("#notificationMessage").html(data);
  	$("#notificationModal").modal('show');
  	$("#vendorsTableBody").html("");
  	loadVendors();
  }
});

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
    loadVendors();
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
    loadVendors();
    }else
    {
    $("#notificationMessage").html(data.errorMessage);
    $("#notificationModal").modal('show');
    }


  }
});
});




function insertRows(objects)
{
var tableRef = document.getElementById('vendorsTableBody');

var x=0;
while(x<objects.length)
{
object = objects[x];	
// Insert a row in the table at the last row
var newRow   = tableRef.insertRow(tableRef.rows.length);

// Insert a cell in the row at index 0
var newCell  = newRow.insertCell(0);
var newText  = document.createTextNode(""+(x+1));
newCell.appendChild(newText);

var newCell  = newRow.insertCell(1);
var newText  = document.createTextNode(object.name);
newCell.appendChild(newText);

var newCell  = newRow.insertCell(2);
var newText  = document.createTextNode(object.username);
newCell.appendChild(newText);

var newCell  = newRow.insertCell(3);
var newText  = document.createTextNode(object.address);
newCell.appendChild(newText);

var newCell  = newRow.insertCell(4);
var newText  = document.createTextNode(object.cityCode);
newCell.appendChild(newText);

var newCell  = newRow.insertCell(5);
var newText  = document.createTextNode(object.contactNumber);
newCell.appendChild(newText);

var newCell  = newRow.insertCell(6);
var newText  = document.createTextNode(object.emailId);
newCell.appendChild(newText);


var newCell  = newRow.insertCell(7);
//deleteButton
var a = document.createElement('a');
var linkText = document.createTextNode("Delete");
a.appendChild(linkText);
a.className ="btn btn-warning btn-sm deleteButton optionButton";
a.id = "deleteButtonCode"+object.code;
newCell.appendChild(a);


//editButton
var a = document.createElement('a');
var linkText = document.createTextNode("Edit");
a.appendChild(linkText);
a.className ="btn btn-warning btn-sm editButton optionButton";
a.id = "editButtonCode"+object.code;

newCell.appendChild(a);

x++;
}
}



function loadVendors()
{
var vendors;

$.ajax(
	{
		url:"GetAllVendors",
		  error : function (jqXHR,textStatus,errorThrown )
  {
   	$("#notificationMessage").html(errorThrown);
  	$("#notificationModal").modal('show'); 
  },
  	success : function(data,textStatus,jqXHR)
  {
    if(data.success)
    {

    objects=data.Vendors;
    insertRows(objects);  
    }

  	
  } 
	});

}



