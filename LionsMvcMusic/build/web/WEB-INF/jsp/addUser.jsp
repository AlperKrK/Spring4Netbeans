<%-- 
    Document   : addUser
    Created on : 14.Tem.2016, 21:05:15
    Author     : Asus
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.lions.controller.*"%>
<%@page import="java.util.List" %>
<jsp:useBean id="userModel" class="com.lions.controller.deneme.UsersModel" scope="request"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Create user</title>
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
<div id="Login-error">${error}</div>
<form method="POST" action="addUser" id="addUserForm"></form>
<fieldset>
    <legend>Login information</legend>
    
    <label for="username">Username :</label><br/>
    <input type="text" name="txtUsername" id="username"><br/><br>
        
        <label for="password">Password: </label><br/>
        <input type="text" name="txtPassword" id="password"><br/><br>
            
            <label for="passwordconfirm">Confirm: </label><br/><br>
            <input type="password" name="txtPasswordConfirm" id="passwordconfirm"><br/><br>
                
</fieldset>
<fieldset>
    <legend>Shipping information</legend>
    <label for="firstname">Firstname: </label><br/>
    <input type="text" name="txtFirstname" id="firstname"><br/><br>
        
        <label for="lastname">Lastname: </label><br/>
        <input type="text" name="txtLastanme" id="lastname"><br/><br>
            
            <label for="adress">Adress: </label><br/>
            <input type="text" name="txtAdress" id="adress"><br/><br>
                
                <label for="city">City: </label><br/>
                <input type="text" name="txtCity" id="city"><br/><br>
                    
                    <label for="state">State: </label><br/>
                    <input type="text" name="txtState" id="state"><br/><br>
                        
                        <label for="postalcode">PostalCode: </label><br/>
                        <input type="text" name="txtPostalCode" id="postalcode"><br/><br>
                            
                            <label for="phone">Phone: </label><br/>
                            <input type="text" name="txtPhone" id="phone"><br/><br>
                                
                                <label for="email">Email: </label><br/>
                                <input type="text" name="txtEmail" id="email"><br/><br>
                                    
            
</fieldset>

<fieldset>
    <legend>Payment</legend>
    <p>Promo kodu ucretsiz olarak alabilirsiniz:</p>
    <label for="promocode">Promo Code: </label><br/>
    <input type="text" name="txtPromoCode"><br/><br>
</fieldset>
<input type="submit"  id="submit" value="Create">
</body>
</html>
