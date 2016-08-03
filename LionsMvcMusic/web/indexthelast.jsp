<%-- 
    Document   : indexthelast
    Created on : 15.Tem.2016, 10:21:16
    Author     : Asus
--%>

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
        <li><a href="/LionsMvcMusic/Deneme">Deneme</a></li>
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
<img alt="Home ShowCase" src="resources/css/image/home-showcase.png"></img><br/><br/>
<div id="footer"><h3>Spring 4.0 Jpa(EclipseLink) </h3></div>
    
</body>
</html>