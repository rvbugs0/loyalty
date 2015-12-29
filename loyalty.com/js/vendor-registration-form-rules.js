$("#vendorRegistrationForm").validate({
rules:{
name:{
required:true,
maxlength:50,
minlength:3
},
username:{
required:true,
maxlength:50,
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
address:{
required:true,
maxlength:500,
minlength:10
},
city:
{
required:true
}},errorClass: "my-error-class",
   validClass: "my-valid-class"
});


