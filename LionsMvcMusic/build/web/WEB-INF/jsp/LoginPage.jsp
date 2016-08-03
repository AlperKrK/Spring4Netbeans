<%-- 
    Document   : LoginPage
    Created on : 14.Tem.2016, 21:06:48
    Author     : Asus
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login Page</title>
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
<div id="Login-error">${error}</div>
<form:form modelAttribute="login" method="POST" commandName="login" action="/LionsMvcMusic/Account/Login">
    <h2>Log on</h2>
    <h3>Please enter username and password.<a href="/LionsMvcMusic/addUser">Register</a>Hesabin yoksa kayit ol</h3>
    <fieldset>
        <legend>Account information</legend>
        <h3>Username</h3>
        <form:input path="username"></form:input>
        <br /><br>
        <h3>Password</h3>
        <form:input path="password"></form:input>
        <br /><br>
        <input type="submit" value="Log on"/>
        <br />
        
    </fieldset>
    
</form:form>
</body>
</html>
