$.validator.addMethod("valueNotEquals", function(value, element, arg){
  return arg != value;
 }, "Value must not equal arg.");

$("#AddVendorForm").validate({
rules:{
AddVendorUsername:{
required:true,
maxlength:50,
minlength:8
},
AddVendorPassword:{
required:true,
maxlength:20,
minlength:8
},
AddVendorAddress:{
required:true,
maxlength:500,
minlength:10
},
AddVendorNameOfFirm:{
required:true,
maxlength:50,
minlength:1
},
AddVendorPhone:{
required:true,
maxlength:20,
minlength:10
},
AddVendorEmail:{
required:true,
maxlength:100,
minlength:7
},
AddVendorCity:{
valueNotEquals: "-1"
}

},
messages:{
AddVendorUsername:{
required:"Username length 8-50"
},
AddVendorAddress:{
required:"Address length  < 500"
},
AddVendorNameOfFirm:{
required:"Name length length < 50"
},
AddVendorPassword:{
required:"Password length 8-20"
},
AddVendorPhone:{
required:"Contact Number  length < 20"	
},
AddVendorEmail:{
required:"Email id  length < 100"	
},
AddVendorCity: 
{ valueNotEquals: "Please select an item!" 
}
},errorClass: "my-error-class",
   validClass: "my-valid-class"
});