<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your Booked Movie</title>
<style>
body.body
{
background-image:url("Booked_movie_background_image");

}
</style>
</head>
<body class="body">

<%-- <c:forEach var="pricedetails" items="${requestScope.listPricing}">
<h1>
${pricedetails.movie.type}<br/>
${pricedetails.movie.name}<br/>
${pricedetails.pricingtype}<br/>
${pricedetails.price}<br/>
</h1>
</c:forEach> --%>


<c:forEach var="pricedetails" items="${sessionScope.listPricing.cartmp}">
<h1>
${pricedetails.movie.type}<br/>
${pricedetails.movie.name}<br/>
${pricedetails.pricingtype}<br/>
${pricedetails.price}<br/>
</h1>
</c:forEach>


<%-- 
<h2>User Is By Scriplet<%=session.getAttribute("user") %></h2>

 <h3>User Is By EL:${sessionScope.user.user}</h3>  --%>

<c:choose>
<c:when test="${sessionScope.user.user=='annonymous'}"  >
<h2>Total Payment :${sessionScope.listPricing.total} <a href="indexp?id=p">purchase</a></h2>
</c:when>
<c:otherwise>
<h2>Total Payment :${sessionScope.listPricing.total}<a href="purchase">purchase</a></h2>
</c:otherwise> 
</c:choose>


</body>
</html>