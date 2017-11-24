<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
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
input.type
{
margin-top:-10px;
width:350px;
height:30px; 
font-size:20px;
text-align:center;
color:black;   
}
input.category
{
margin-top:-10px;
width:350px;
height:30px; 
font-size:20px;
text-align:center;
color:black;   
}
input.description
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


body.body
{
background-image:url("admin_background_image");
}


span.namemsg
{
color:red;
}




</style>





<script>

function AddMovie()
{

console.log("inside  add movie")
var name=document.getElementById("name").value;
var type=document.getElementById("type").value;
var cat=document.getElementById("category").value;
var desc=document.getElementById("desc").value;
if((name==null||(name=="")))
{
	 /* document.getElementById("namemsg").innerHTML="Enter Movie Name" */
	    alert("Please Enter Movie Name");
		return false;
}
else if((type==null||(type=="")))
{
	  alert("Please Enter Movie Type");
	  return false;
}

else if((cat==null||(cat=="")))
{
	  alert("Please Enter Movie Category");
	  return false;
}

else if((desc==null||(desc=="")))
{
	  alert("Please Enter Movie Description");
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
    <h1>Insert Movie</h1>
   </div>
</div>


 

<form  method="post" action="insertmovie"   onsubmit=" return AddMovie()" >
<input type="text" id="name" placeholder="Insert Movie Name" class="name" name="name"/> <span id="namemsg" class="namemsg"></span> <br/><br/>
<input type="text" id="type" placeholder="Insert Movie Type" class="type" name="type"/><br/><br/>
<input type="text" id="category" placeholder="Insert Movie Category" class="category"  name="category"/><br/><br/>
<input type="textarea" id="desc" placeholder="Insert Movie Description" class="description" name="description"/><br/><br/>
<input type="submit" value="Add Movie" class="submit" /><br/><br/>
 </form> 

</div>
 
<c:choose>
<c:when test="${requestScope.stat=='success'}"  >
<h1>${requestScope.message}</h1>
</c:when>
<c:otherwise>
</c:otherwise> 
</c:choose>







</body>
</html>