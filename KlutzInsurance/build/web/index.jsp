<%-- 
    Document   : home
    Created on : Apr 12, 2016, 8:59:44 PM
    Author     : John
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insurance Home</title>
        <link href="css/foundation.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <link href="css/home.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="top-bar">
            <div class="top-bar-left">
                <ul class="menu">
                    <li><a href="#">Welcome: 
                            <c:choose>
                                <c:when test="${user != null}">
                                    ${user.username}
                                </c:when>
                                <c:otherwise>
                                    Guest
                                </c:otherwise>
                            </c:choose>
                        </a></li>
                </ul>
            </div>
            <div class="top-bar-right">
                <ul class="menu">
                    <li><a href="RequestHandler?task=home">Home</a></li>
                    <li><a href="RequestHandler?task=profile">Profile</a></li>
                    <li><a href="RequestHandler?task=login">Login</a></li>
                    <li><a href="RequestHandler?task=logout">Logout</a></li>
                </ul>
            </div>
        </div>

        <div class="row">
            <div class="center-text">
                <h1>Home</h1>
            </div>
        </div>
        
        <script src="js/jquery.js" type="text/javascript"></script>
        <script src="js/foundation.min.js" type="text/javascript"></script>
    </body>
</html>
