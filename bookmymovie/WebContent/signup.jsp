<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
 <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Signup</title>
<style >
div.wrapper
{
border: solid black 2px;
width: 500px;
height: 450px;
position: absolute;
margin:auto;
text-align:center;
top:0;bottom: 0;left: 0;right: 0;
}

div.signinheading
{
height:80px;
background-color:#1F2533 

}
div.header
{
font-size: 20px;
text-align: center;
color: #49BA8E;
letter-spacing: 3px;
text-transform: uppercase;
position: relative;
padding-top:1px; 

}

input.name
{
margin-top:30px;
width:350px;
height:30px; 
font-size:20px;
text-align:center;
color:black;   
}
input.pass
{
margin-top:-10px;
width:350px;
height:30px; 
font-size:20px;
text-align:center;
color:black;   
}
input.mobile
{
margin-top:-10px;
width:350px;
height:30px; 
font-size:20px;
text-align:center;
color:black;   
}
input.address
{
margin-top:-10px;
width:350px;
height:30px; 
font-size:20px;
text-align:center;
color:black;   
}
input.email
{
margin-top:-10px;
width:350px;
height:30px; 
font-size:20px;
text-align:center;
color:black;   
}

input.submit
{
width:350px;
height:50px; 
font-size:20px;
text-align:center;
background-color:#97222D;
color:white;  
}

div.signin
{
margin-top:20px;
text-align:center;
color:black;
font-size:20px;  
  
}
a.signin
{
color:#C02C39 
}
body.body
{
background-image:url("signup_background_image");

}
</style>

<script>

function  ValidateForm() 
{
console.log("inside validate form");
var name=document.getElementById("name").value;
var password=document.getElementById("password").value;
var mobile=document.getElementById("mobile").value;
var address=document.getElementById("address").value;
var email=document.getElementById("email").value;

if((name==null||(name=="")))
{
	alert("Please Enter  Name");
    return false;
}

else if((password==null||(password=="")))
{
	  alert("Please Enter Password");
	  return false;
}

else if((mobile==null||(mobile=="")))
{
	  alert("Please Enter Mobile Number");
	  return false;
}

else if((address==null||(address=="")))
{
	  alert("Please Enter Address");
	  return false;
}



else if((email==null||(email=="")))
{
	  alert("Please Enter Email");
	  return false;
}
return true;
}

</script>


</head>
<body class="body">
<div class="wrapper">
<div class="signinheading">
  <div class="header">
    <h1>Sign Up</h1>
   </div>
</div>
<sf:form modelAttribute="basic" action="register" onsubmit="return ValidateForm()">
<input type="text"     id="name"  name="name" placeholder="Enter Your Name" class="name"/><br/><br/>
<input type="password" id="password" name="password" placeholder="Enter Your Password" class="pass"/><br/><br/>
<input type="text"     id="mobile" name="mobile" placeholder="Enter Your Mobile Number" class="mobile"/><br/><br/>
<input type="text"     id="address" name="address" placeholder="Enter Your Address" class="address"/><br/><br/>
<input  type="text"    id="email" name="email" placeholder="Enter Your  Email ID" class="email"/><br/><br/>
<input type="submit" value="SIGN UP" class="submit"/>
</sf:form>
<div class="signin">Already connected?<a href="index" class="signin">Sign Up</a></div>
</div>
</body>
</html>