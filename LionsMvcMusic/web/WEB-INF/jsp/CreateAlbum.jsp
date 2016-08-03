<%-- 
    Document   : CreateAlbum
    Created on : 14.Tem.2016, 21:05:49
    Author     : Asus
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<h1>Create</h1>

<form:form modelAttribute="createAlbum" method="POST" commandName="createAlbum" action="/LionsMvcMusic/StoreManager/CreateAlbum">
    <fieldset style="width: 300px">
        <h3>Genre</h3>
        <select name="genreSelected">
            <c:forEach items="${genres}" var="myGenre">
                <option value="${myGenre.genreid}">${myGenre.name}</option>
            </c:forEach>
        </select>
        <br />
        <h3>Artist</h3>
        <select name="artistSelected">
            <c:forEach items="${artists}" var="myArtist">
                 <option value="${myArtist.artistid}">${myArtist.name}</option>
            </c:forEach>
           
        </select>
        <br /><br/>
        <h3>Title</h3>
        <td><form:input path="title"/></td>
        <br /><br />
        <h3>Price</h3>
        <td><form:input path="price"/></td>
        <br /><br />
        <h3>AlbumArtUrl</h3>
        <td><form:input path="albumarturl"/></td>
        <br /><br />
        <input type="submit" value="Save"/>
        <br/><br/>
    </fieldset>
    
</form:form>
<a href="/LionsMvcMusic/StoreManager/"id="current">Back To List</a>
</body>
</html>
