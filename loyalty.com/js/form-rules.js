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



$("#EditVendorForm").validate({
rules:{
EditVendorUsername:{
required:true,
maxlength:50,
minlength:8
},
EditVendorPassword:{
required:true,
maxlength:20,
minlength:8
},
EditVendorAddress:{
required:true,
maxlength:500,
minlength:10
},
EditVendorNameOfFirm:{
required:true,
maxlength:50,
minlength:1
},
EditVendorPhone:{
required:true,
maxlength:20,
minlength:10
},
EditVendorEmail:{
required:true,
maxlength:100,
minlength:7
},
EditVendorCity:{
valueNotEquals: "-1"
}

},
messages:{
EditVendorUsername:{
required:"Username length 8-50"
},
EditVendorAddress:{
required:"Address length  < 500"
},
EditVendorNameOfFirm:{
required:"Name length length < 50"
},
EditVendorPassword:{
required:"Password length 8-20"
},
EditVendorPhone:{
required:"Contact Number  length < 20"	
},
EditVendorEmail:{
required:"Email id  length < 100"	
},
EditVendorCity: 
{ valueNotEquals: "Please select an item!" 
}
},errorClass: "my-error-class",
   validClass: "my-valid-class"
});



$("#AddCityForm").validate({
rules:{
AddCityName:{
required:true,
maxlength:30,
minlength:1
},
AddStateName:{
required:true,
maxlength:30,
minlength:1
},
AddCountryName:{
required:true,
maxlength:30,
minlength:1
}},
messages:{
AddCityName:{
required:"City Name length < 30"
},
AddStateName:{
required:"State Name length  < 30"
},
AddCountryName:{
required:"Country Name length length < 30"
}
},errorClass: "my-error-class",
   validClass: "my-valid-class"
});




$("#EditCityForm").validate({
rules:{
EditCityName:{
required:true,
maxlength:30,
minlength:1
},
EditStateName:{
required:true,
maxlength:30,
minlength:1
},
EditCountryName:{
required:true,
maxlength:30,
minlength:1
}},
messages:{
EditCityName:{
required:"City Name length < 30"
},
EditStateName:{
required:"State Name length  < 30"
},
EditCountryName:{
required:"Country Name length length < 30"
}
},errorClass: "my-error-class",
   validClass: "my-valid-class"
});