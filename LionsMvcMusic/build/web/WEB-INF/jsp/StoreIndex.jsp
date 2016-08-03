<%-- 
    Document   : StoreIndex
    Created on : 14.Tem.2016, 21:07:14
    Author     : Asus
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
    <title>Store Index</title>
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
    <h3 style="color: red"><li><a href="${albumUrl}"><c:out value="${myGenre.name}"></c:out></a></li></h3>
</c:forEach>
 </div>
<h1>Browse Genres</h1>
<h2>Select from  genres:${genreCount}</h2>
<div id="footer"><h3>Spring 4.0 Jpa(EclipseLink) </h3>
      
</body>
</html>
