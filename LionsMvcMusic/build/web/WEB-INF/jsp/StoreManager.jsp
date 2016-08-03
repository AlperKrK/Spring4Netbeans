<%-- 
    Document   : StoreManager
    Created on : 14.Tem.2016, 21:07:23
    Author     : Asus
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1 " pageEncoding="ISO-8859-1"%>
<%@page import="com.lions.controller.*"%>
<%@page import="com.lions.controller.model.*"%>

<jsp:useBean id="albumModel" class="com.lions.controller.deneme.AlbumModel" scope="request" />


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
    <title>Store Browse</title>
    <link href="resources/css/site.css" media="screen" rel="stylesheet" type="text/css"/>
    
<body>
    <div id="header">
    
    <h1>SPRING MVC MUSIC STORE </h1>
    <ul id="navlist">
        
        <li class="first"><a href="/LionsMvcMusic/" id="current">HOME</a></li>
        <li><a href="/LionsMvcMusic/Store">STORE</a></li>
        
    </ul>
</div>

<h1>Index</h1>
<h2 style="color: red"><a href="/LionsMvcMusic/StoreManager/CreateAlbum">Create New</a> </h2>

<table>
    
    <thead>
        <tr>
            <th>Genre</th>
            <th>Artist</th>
            <th>Title</th>
            <th>Price</th>
            <th></th>
            <th></th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <%for(Album myAlbum : albumModel.findAllAlbum())
        {
            %>
            <tr>
                <%int tempGenreid =myAlbum.getGenreid().getGenreid().intValueExact(); %>
                <%int tempArtistid =myAlbum.getArtistid().getArtistid().intValueExact(); %>
                <td> <%=albumModel.findGenreIdFromAlbum(tempGenreid).getName() %> </td>
                <td> <%=albumModel.findArtistIdFromAlbum(tempArtistid).getName() %> </td>
                <td> <%=myAlbum.getTitle()%></td>
                <td> <%=myAlbum.getPrice()%></td>
                <td> <a href="EditAlbum?editalbumid=<%=myAlbum.getAlbumid()%>">Edit</a></td>
                <td> <a href="DetailsAlbum?detailsalbumid=<%=myAlbum.getAlbumid()%>">Details</a></td>
                <td> <a href="DeleteAlbum?deletealbumid=<%=myAlbum.getAlbumid()%>">Delete</a></td>
               
            </tr>
            
            <%} %>
    </tbody>
    
</table>
    <div id="footer"><h3>Spring 4.0 Jpa(EclipseLink) </h3>
</body>

</html>
