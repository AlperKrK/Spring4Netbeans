<%-- 
    Document   : CheckOut
    Created on : 14.Tem.2016, 21:05:39
    Author     : Asus
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Check Out</title>
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
<h2>CheckOut Tamamlandi</h2>
<h3>Siparisiniz icin tesekkurler siraniz:${myCartid}</h3>
<h3>Daha fazla siparis vermek icin ister misiniz: <a href="/LionsMvcMusic/Store">Store</a>?</h3>
</body>
</html>
