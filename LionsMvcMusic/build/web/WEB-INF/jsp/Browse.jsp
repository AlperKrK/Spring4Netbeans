<%-- 
    Document   : Browse
    Created on : 14.Tem.2016, 21:05:26
    Author     : Asus
--%>
<%-- 
    Document   : Browse
    Created on : 14.Tem.2016, 21:05:26
    Author     : Asus
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1 " pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
    <title>Store Browse</title>
    <link href="resources/css/site.css" media="screen" rel="stylesheet" type="text/css"/>
</head>
<body>
   
    
<div id="header">
    
    <h1>SPRING MVC MUSIC STORE </h1>
    <ul id="navlist">
        
        <li class="first"><a href="/LionsMvcMusic/" id="current">HOME</a></li>
        <li><a href="/LionsMvcMusic/Store">STORE</a></li>
        <li id="cart"><a>Cart(${itemNumbers})</a></li>
        
    </ul>
</div>
<div id="categories">
<c:forEach items="${genreList}" var="myGenre">
    <c:url var="albumUrl" value="Store/Browse?genre=${myGenre.name}"/>
    <h3 style="color: red"><li><a href="${albumUrl}"><c:out value="${myGenre.name}"></c:out></a></li></h3>
</c:forEach>
</div>

<h1>Browse Genres : ${genre}</h1>

<div>
<c:forEach items="${foundAlbum}" var="myAlbum">
    <div style="float: left;width: 150px">
    <c:url var="albumUrl" value="Details?albumid=${myAlbum.albumid}"/>
    <img alt="Album Art of album :${detailedAlbum.title}" src="resources/css/image/placeholder.gif"></img><br/><br/>
    <p><a href="${albumUrl}"><c:out value="${myAlbum.title}"/></a></p>
    </div>
</c:forEach>
</div>
    <div id="footer"><h3>Spring 4.0 Jpa(EclipseLink) </h3></div>
</body>
</html>
