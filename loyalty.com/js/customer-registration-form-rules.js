$("#basicInfoForm").validate({
rules:{
name:{
required:true,
maxlength:50,
minlength:3
},
username:{
required:true,
maxlength:20,
minlength:8
},
password:{
required:true,
maxlength:20,
minlength:1
},
email:{
required:true,
maxlength:100,
minlength:8
},
contactNumber:{
required:true,
maxlength:20,
minlength:10
},
dob:{
required:true,
},
gender:{
required:true
}
,
permanentAddress:{
required:true,
maxlength:500,
minlength:10
},
currentAddress:{
required:true,
maxlength:500,
minlength:10
},
married:{
required:true
},
student:{
required:true
}},errorClass: "my-error-class",
   validClass: "my-valid-class"
});




$("#studentInfoForm").validate({
rules:{
stream:{
required:true,
maxlength:50,
minlength:1
},
courseDetails:{
required:true,
maxlength:100,
minlength:1
}},errorClass: "my-error-class",
   validClass: "my-valid-class"
});



$("#marriageInfoForm").validate({
rules:{
spouseName:{
required:true,
maxlength:50,
minlength:1
},
spouseOccupation:{
required:true,
maxlength:50,
minlength:1
},
girlChild:{
required:true,
},
boyChild:{
required:true,
},
anniversaryDate:{
required:true,
},
spouseDob:{
required:true,
}},errorClass: "my-error-class",
   validClass: "my-valid-class"
});