<%-- 
    Document   : ShoppingCart
    Created on : 14.Tem.2016, 21:07:00
    Author     : Asus
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Customer Cart</title>
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
<form:form modelAttribute="myCart" method="POST" commandName="myCart" action="/LionsMvcMusicStore/ShoppingCart">
    <h2>Review your cart</h2>
    <input type="submit" value="CheckOut >>"/>
    <div style="height: 20px"></div>
    <table>
        <thead>
            <tr>
                <th>Album Name</th>
                <th>Price (each)</th>
                <th>Quantity</th>
                <th>/</th>
            </tr>
        </thead>
        <tbody>
            <c:out value="${removedAlbuminfo}"></c:out>
            <c:forEach items="${albumList}" var="myAlbum">
                <tr>
                    <td><a href="/LionsMvcMusic/Store/Details?albumid=${myAlbum.albumid}"><c:out value="${myAlbum.title}"/></a></td>
                    <td><c:out value="${myAlbum.price}"/></td>
                    <td><c:out value="1"/></td>
                    <td><a href="/LionsMvcsMusic/ShoppingCart?deletedAlbumid=${myAlbum.albumid}"><c:out value="Remove From Cart "/></a></td>
                    
                </tr>
            </c:forEach>
                <tr>
                    <td>Total</td>
                    <td></td>
                    <td></td>
                    <td>${totalPrice}</td>
                </tr>
        </tbody>
    </table>
</form:form>
    
</body>
</html>
