// JavaScript Document




function showcate1(){
document.getElementById('company').style.display = "none"; 
document.getElementById('author').style.display = "none";
document.getElementById('judge').style.display = "none";      
}
function showcate2(){
document.getElementById('company').style.display = "block"; 
document.getElementById('author').style.display = "none";
document.getElementById('judge').style.display = "none";      
}
function showcate3(){
document.getElementById('company').style.display = "none"; 
document.getElementById('author').style.display = "block";
document.getElementById('judge').style.display = "none";      
}
function showcate4(){
document.getElementById('company').style.display = "none"; 
document.getElementById('author').style.display = "none";
document.getElementById('judge').style.display = "block";      
}

function checktipUser(){
	$.post("registercheck.jsp",
		   {name:$('input[name="userId"]').attr("value")},
		   function(data){
				  if(data == "username available")
				  $('#okUser').css("display","");
				  else
				  $('#warnUserExists').css("display","");
	       }
	);

}

function showtipUser(){

$('#tipUser').fadeIn("slow");
}
function showtipPassword(){
$('#tipPassword').fadeIn("slow");
}
function showtipPasswordCheck(){
$('#tipPasswordCheck').fadeIn("slow");
}
function showtipMail(){
$('#tipMail').fadeIn("slow");
}
function showtipContact(){
$('.tipContact').fadeIn("slow");
}






function checkPasswordCheck(){
	var name = document.userForm.name;
	var password1 = document.userForm.passwd;
	var password2 = document.userForm.PasswordCheck;
	var email=document.userForm.mail;
	
	if( password2.value==""){
		document.getElementById('warnPasswordCheck').style.display="";
		document.getElementById('okPasswordCheck').style.display="none";
	}
	else if( password1.value!=password2.value ){
		document.getElementById('warnPasswordCheck').style.display="";
		document.getElementById('okPasswordCheck').style.display="none";
		
	}
	else if( password1.value==password2.value ){
		document.getElementById('warnPasswordCheck').style.display="none";
		document.getElementById('okPasswordCheck').style.display="";
		
	}
		
}

function checkPassword(){
	var password1 = document.userForm.passwd;
	if(password1.value.length<6||password1.value.length>16){
		document.getElementById('warnPassword').style.display="";
		document.getElementById('okPassword').style.display="none";
		
	}
	else{
		document.getElementById('warnPassword').style.display="none";
		document.getElementById('okPassword').style.display="";
		
	}
}