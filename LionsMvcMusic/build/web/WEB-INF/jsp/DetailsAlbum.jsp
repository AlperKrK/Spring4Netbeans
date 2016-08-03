<%-- 
    Document   : DetailsAlbum
    Created on : 14.Tem.2016, 21:06:15
    Author     : Asus
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        
    <title>Album Details</title>
    <link href="resources/css/site.css" media="screen" rel="stylesheet" type="text/css"/>
    
</head>
<body>
<div id="header">
    <h1>Spring MVC MUSIC STORE</h1>
    <ul id="navlist">
         <li class="first"><a href="/LionsMvcMusic/" id="current">HOME</a></li>
        <li><a href="/LionsMvcMusic/Store">STORE</a></li>
    </ul>
</div>
<h2>Details</h2>

<fieldset style="width: 300px">

    <legend>Album</legend>
    
    <c:out value="Genre : ${detailAlbum.genreid.name}"></c:out><br/><br>
    <c:out value="Artist: ${detailAlbum.artistid.name}"></c:out><br/><br>
    <c:out value="Title:  ${detailAlbum.title}"></c:out><br/><br> 
    <c:out value="Price: ${detailAlbum.price}"></c:out><br/><br>
    <c:out value="AlbumArtUrl: ${detailAlbum.albumarturl}"></c:out><br/><br>
    
</fieldset>
    
        <a href="EditAlbum?editalbumid=${detailsalbumid}">Edit</a> | <a href="/LionsMvcMusic/StoreManager/" id="current">Back StoreManager</a>

</body>
</html>
