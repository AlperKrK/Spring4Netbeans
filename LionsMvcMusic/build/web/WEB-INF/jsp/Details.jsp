<%-- 
    Document   : Details
    Created on : 14.Tem.2016, 21:06:08
    Author     : Asus
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1 " pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
    <title>Store Details</title>
    <link href="resources/css/site.css" media="screen" rel="stylesheet" type="text/css"/>
</head>
<body>
    
<div id="header">
    
    <h1>SPRING MVC MUSIC STORE </h1>
    <ul id="navlist">
        
        <li class="first"><a href="/LionsMvcMusic/" id="current">HOME</a></li>
        <li><a href="/LionsMvcMusic/Store">STORE</a></li>
        <li><a>Cart(${itemNumbers})</a></li>
        
    </ul>
</div>
<div id="categories">

<c:forEach items="${genreList}" var="myGenre">
    <c:url var="albumUrl" value="Store/Browse?genre=${myGenre.name}"/>
    <h3 style="color: red"><a href="${albumUrl}"><c:out value="${myGenre.name}"></c:out></a></h3>
</c:forEach>
 </div>

<form:form modelAttribute="addAlbum" method="POST" commandName="addAlbum" action="/LionsMvcMusic/Store/Details?albumid=${addAlbum.albumid}">
    <h1><c:out value="${detailedAlbum.title}"></c:out></h1>
    
    <img alt="Album art of album:${detailedAlbum.title}" src="../resources/css/image/placeholder.gif"></img><br/><br>
   
    <div style="height: 20px"></div>
    
    <h2><c:out value="Genre: ${detailedAlbum.genreid.name}"></c:out></h2>
    <h2><c:out value="Artist: ${detailedAlbum.artistid.name}"></c:out></h2>
    <h2><c:out value="Price: ${detailedAlbum.price}"></c:out></h2>
    <input type="submit" value="Add to Cart"></input>
    
</form:form>
<div id="footer"><h3>Spring 4.0 Jpa(EclipseLink) </h3></div>
</html>
