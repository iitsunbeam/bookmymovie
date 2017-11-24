<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
 <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<style>
body.body
{
padding-top:100px;
background-image:url("https://in.bmscdn.com/showcaseimage/eventimage/pvr7thjuly.jpg");
background-repeat:no-repeat;
background-position:top; 
background-color:yellow; 
}


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
div.iemail
{
width:300px;
height:55px;
margin-top:50px;
margin-left:90px;  

}
input.email
{
width:350px;
height:50px; 
font-size:20px;
text-align:center;
color:black;   
}
div.ipass
{
width:300px;
height:55px;
margin-top:30px;
margin-left:90px; 

}
input.pass
{
width:350px;
height:50px; 
font-size:20px;
text-align:center;
color:black;   
}
div.isubmit
{
width:300px;
height:55px;
margin-top:30px;
margin-left:90px; 
}


input.submits
{
width:350px;
height:50px; 
font-size:20px;
text-align:center;
background-color:#97222D;
color:white;  
}

div.signup
{
margin-top:20px;
text-align:center;
color:black;
font-size:20px;  
  
}
a.signup
{
color:#C02C39 
}

</style>


<script >
function ValidateMyForm()
{
console.log("inside validate");
var email=document.getElementById("email").value;
var pass=document.getElementById("pass").value;
if ((email==null||(email==""))) 
{
	alert("Enter Valid Email Id!!!")
	return false;
}
else if (( pass==null||( pass==""))) 
{
    alert('Please Enter Valid Password');
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
    <h1>Sign in</h1>
   </div>
</div>
<sf:form modelAttribute="basic" action="login" onsubmit="return ValidateMyForm()">
<div class="iemail">
<input  type="text" id="email" name="email" placeholder="Enter Your  Email ID" class="email"/><br/><br/>
</div>
<div class="ipass">
<input type="password" id="pass" name="pass" placeholder="Enter Your  Password" class="pass"/><br/><br/>
</div>
<div class="isubmit">
<input type="hidden" name="navid" value="${requestScope.ids}">
<input type="submit" value="SIGN IN" class="submits"  onclick="JavaScript:validateMyForm()"/>
</div>
</sf:form>


<div class="signup">Still not connected?<a href="signup" class="signup">Sign Up</a></div>




</div> 
</body>
</html>