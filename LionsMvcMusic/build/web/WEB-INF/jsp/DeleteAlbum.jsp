<%-- 
    Document   : DeleteAlbum
    Created on : 14.Tem.2016, 21:05:59
    Author     : Asus
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Edit Album</title>
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
<h1>Delete</h1>
<h2>Silmek istedigine emin misin?</h2>
<form:form modelAttribute="deleteAlbum" method="POST" commandName="deleteAlbum" action="/LionsMvcMusic/StoreManager/DeleteAlbum?deletealbumid=${deleteAlbum.albumid}">
    <fieldset style="width: 300px">
        <legend>Album</legend>
        <c:out value="Genre :${albumdeleted.genreid.name}"/><br/><br>
        <c:out value="Artist: ${albumdeleted.artistid.name}"/><br/><br>
        <c:out value="Title: ${albumdeleted.title}"/><br/><br>
        <c:out value="Price: ${albumdeleted.price}"/><br/><br>
        <c:out value="AlbumArtUrl: ${albumdeleted.albumarturl}"/><br/><br>  
    </fieldset>
    <input type="submit" value="Delete"/> | <a href="/LionsMvcMusic/StoreManager/" id="current">Back To List</a>
    
</form:form>
</body>
</html>
