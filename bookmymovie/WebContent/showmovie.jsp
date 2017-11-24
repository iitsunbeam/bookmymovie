<%@page import="dac.movie.pojos.Login"%>
<%@page import="dac.movie.pojos.MoviePricing"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movies</title>
<style>
div.price
{
float:left;
width:90px;
height:90px;
background-color: #FFC0CB;
margin-right: 5px;
text-align: center;
}

div.submit
{
padding-top:20px;
clear:both;
margin-top:20px;
margin-bottom:20px;
}


input.submit
{
background-color:#11719A;
height:30px;
border:none;
color:white;
font-weight:bold;
}

body.body
{
background-image:url("movie_background_image");
background-repeat:no-repeat; 

}
</style>
</head>
<body class="body">
<h2>welcome user: ${sessionScope.user.user}</h2>
<h1>
${requestScope.movie.id}<br/>
${requestScope.movie.name}<br/>
${requestScope.movie.type}<br/> 
${requestScope.movie.category}<br/>
${requestScope.movie.description}<br/>
</h1>
<sf:form modelAttribute="basic" action="bookedmovie">
<c:forEach var="movieprice" items="${requestScope.movie.listprizing}">
<div class="price">
<input type="checkbox" name="moviepriceid" value="${movieprice.id}" /><br/>
${movieprice.pricingtype}<br/>
${movieprice.price}<br/>
</div>
</c:forEach>

<div class="submit">
<input type="submit" class="submit"  value="Book Movie">
</div>
</sf:form>
<%-- <h3>request id is :<%=request.getParameter("id")%></h3> --%>


</body>
</html>