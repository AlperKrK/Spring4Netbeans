<%-- 
    Document   : EditAlbum
    Created on : 14.Tem.2016, 21:06:27
    Author     : Asus
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>EDIT ALBUM</title>
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
<h1>Edit</h1>

<form:form modelAttribute="editAlbum" method="POST" commandName="editAlbum" actions="/LionsMvcMusic/StoreManager/EditAlbum?editalbumid=${editAlbum.albumid}">
    <fieldset style="width: 300px">
        <h3>Genre</h3>
        <select name="genreselected">
            <c:forEach items="${genres}" var="myGenre">
                
                <option value="${myGenre.genreid}" ${myGenre.name==selectgenre?'selected':''}>${myGenre.name}</option>
                
            </c:forEach>
        </select>
        <br/>
        <h3>Artist</h3>
        <select name="artistselected">
            <c:forEach items="${artists}" var="myArtist">
                <option value="${myArtist.artistid}" ${myArtist.name==selectartist?'selected':''}>${myArtist.name}</option>
                
            </c:forEach>
        </select>
        <br/><br>
        <h3>Title</h3>
        <form:input name="txtitle" path="title"></form:input>
        <br/><br>
        <h3>Price</h3>
        <form:input path="price"></form:input>
        <br/><br>
        <h3>AlbumArtUrl</h3>
        <form:input path="albumarturl"></form:input>
        <br/><br>
        
        <input type="submit" value="SAVE"></input>
        <br/><br>
    </fieldset> 
    
    
</form:form>
<a href="/LionsMvcMusic/StoreManager/" id="current">Back To StoreManager</a>
</body>
</html>
