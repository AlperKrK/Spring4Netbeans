<%-- 
    Document   : Deneme
    Created on : 17.Tem.2016, 15:15:20
    Author     : Asus
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
    <title>Store Index Lions</title>
    <link href="resources/css/site.css" media="screen" rel="stylesheet" type="text/css"/>
</head>
<body>
    <div id="header">
    <h1>SPRING MVC MUSIC STORE </h1>
    <ul id="navlist">        
        <li class="first"><a href="/LionsMvcMusic/" id="current">HOME</a></li>
        <li><a href="/LionsMvcMusic/Store">STORE</a></li>  
    </ul>
</div>
<h1>Browse Genres</h1>
<h2>Select from  genres:${genreCount}</h2>
    
    <c:forEach items="${Lionshere}" var="atribute">
                <h3 style="color: red"><li><a href="${albumUrl}"><c:out value="${atribute.name}"></c:out></a></li></h3>
                   
            </c:forEach>
    
</body>
</html>
