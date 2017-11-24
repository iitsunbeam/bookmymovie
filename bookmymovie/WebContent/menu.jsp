<%@page import="dac.movie.pojos.Login"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
 <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BookMyShow</title>

<link rel="stylesheet" href="http://localhost:8080/bookmymovie/css/bootstrap.css">
<script src="http://localhost:8080/bookmymovie/js/jquerymin.js"></script>
<script src="http://localhost:8080/bookmymovie/js/bootstrapmin.js"></script>


<!-- <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"> -->
<%-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> --%>
<%-- <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> --%>



<script src="js/jquery-1.12.3.js"></script>
<style>


.carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 80%;
      margin: auto;
  }





div.header
{
width:100%;
height:105px; 
background-color:transparent; 
}
div.headerimg
{
background-color:transparent;
margin-left:1px;
position: absolute;    
}
div.imgrotator
{
width:100%;
height:300px; 
}

div.signin
{
color:white;
margin-left:830px;
font-size:30px;   

}
a.signin
{
text-decoration:none;
color:white;
width:30px;
 
}
a.signin:HOVER
{
color:gold;
text-shadow:buttonface;   
}

body.body
{ 
background-image:url("menu_background_image");
background-repeat:no-repeat; 
background-color:#002540; 
}

div#slider { 
                overflow: hidden;
                margin-top:10px;
                margin:-50px;  
            }
            
            div#slider > ul.slides {
               border:solid blue 2px; 
                list-style: none;
                display: block;
                height: 300px;
                width: 4000px;
                margin-top:50px;
                 
            }
            
            #slider > ul.slides > li.slide {
            border:solid red 2px;
                float: left;
                width:1300px%;
                height: 300px;
                overflow: hidden;
            }
            
            #slider > ul.slides > li.slide > img {
                border:solid yellow 2px;
                width:1300px;
                height: 300px;
               overflow:hidden; 
                  
            }
div.wrappertype
{
border: solid black 2px; 
width:770px;
height: 300px;
position: absolute;
margin-top:550px; /*  450px initially */ 
margin-left:280px;
text-align:center;
top:0;bottom: 0;left: 0;right: 0;
<!--background-color:#11719A-->; 
border-radius:10px;
font-style: italic;
font-size:40px;
text-decoration: none;
text-align:center;
list-style-type:none; 
}

div.type
{
/* border: solid black 2px  */
text-align:  center;
width: 500px;
height:200px;
margin-left:120px;
margin-top:80px;  
text-decoration: none; 
list-style-type:none;

}


div.cat
{
/* border:solid blue 2px; */
width: 500px;
height:200px;
color:black;
/* margin-bottom:50px; */ 
margin-top: -220px;
margin-left:110px; 
}
a.type:HOVER
{
color:gold; 
}





</style>
</head>
<body class="body">
<div class="wrapper">
<div class="header">
<div class="headerimg">
<img src="images/bookmyshowlogo.jpg" class="logo"/>
</div>
<div class="signin">
Welcome User:${sessionScope.user.user} 

<c:choose>
<c:when test="${sessionScope.user.user=='annonymous'}"  >
<a href="index"  data-toggle="tooltip" title="Sign In"  class="signin">Sign In</a>
</c:when>
<c:otherwise>
<a href="logout" class="signin">Sign Out</a>
</c:otherwise> 
</c:choose>
</div>
</div>

<!-- <div class="imgrotator">

<div class="header_slider ">
  <div id="slider">
  <ul class="slides">
  <li class="slide"><img src="images/slide3.jpg"/></li>
  <li class="slide"><img src="images/slide2.jpg"/></li>
  <li class="slide"><img src="images/slide1.jpg"/></li>
 
  
  </ul>
  </div>
</div>
</div> -->





<div class="container">
  <br>
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img src="images/slide2.jpg" alt="slide1" width="460" height="345">
      </div>

      <div class="item">
        <img src="images/slide1.jpg" alt="slide2" width="460" height="345">
      </div>
    
      <div class="item">
        <img src="images/slide3.jpg" alt="slide3" width="460" height="345">
      </div>
      
      <div class="item">
        <img src="images/slide4.jpg" alt="slide4" width="460" height="345">
      </div>
      
   
      
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
</div>













<div class="wrappertype">
 <div class="type">
 
<c:forEach var="item" items="${requestScope.types}">

 
<a class="type"   data-toggle="tooltip" title="Choose Movie Catrgory You Want To See"  style="color:white ; font-weight:bolder;  " href="menu1?type=${item}" name="${item}">${item}<br/></a>

 </c:forEach>
 </div>
 
<div class="cat" id="cat">
<c:forEach var="cat" items="${requestScope.categories}">
<a style="color:white; font-weight:bolder; " href="menu2?type=${param.type}&category=${cat}" name="${cat}">${cat}<br/></a>
</c:forEach> 
</div>
<div class="cat" id="cat">
<c:forEach var="movie" items="${requestScope.movies}">
<a style="color: white; font-weight:bolder; "  href="showmovie?id=${movie.id}" name="${movie.id}">${movie.name}<br/></a>
</c:forEach> 
</div>
 
 


</div>
</div>
<script>
var animationSpeed = 4000;
var sliderWidth = 1200;
var slideCount = 3;
var slideIndex = 1;

setInterval(function() {
    $('#slider > .slides').animate({"margin-left":"-=" + sliderWidth + "px"}, 100, function() {                
        console.log("slideIndex = " + slideIndex);
        if (slideIndex === slideCount) {
            slideIndex = 1;
            $('#slider > .slides').css("margin-left", "0px");
        }
        
        slideIndex++;                    
    });
    
}, animationSpeed);




</script>
</body>
</html>