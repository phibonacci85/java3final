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
        <jsp:include page="/includes/head.html" />
        <link href="css/index.css" rel="stylesheet" type="text/css"/>
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
                    <c:choose>
                        <c:when test="${user != null}">
                            <li><a href="RequestHandler?task=logout">Logout</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="RequestHandler?task=login">Login</a></li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </div>
        <div class="callout large">
            <div class="row column text-center">
                <h1>Welcome to Klutz Insurance!</h1>
                <c:choose>
                    <c:when test="${user != null}">
                        <p>Let us help you with the best insurance out there</p>
                        <a href="RequestHandler?task=start_policy" class="button large">Start a Policy</a>
                        <a href="RequestHandler?task=browse_policies" class="button large">Browse your Policies</a>
                    </c:when>
                    <c:otherwise>
                        <p>Please Login or Create a new User</p>
                        <div class="row">
                            <div class="large-4 columns large-centered">
                                <form action="RequestHandler?task=create_user" method="post">
                                    <input type="text" name="createUsername" />
                                    <input type="password" name="createPassword" />
                                    <input type="submit" class="button large" value="Create User" />
                                </form>
                            </div>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
        <div class="row">
            <div class="medium-6 columns medium-push-6">
                <img class="thumbnail" src="http://placehold.it/750x350">
            </div>
            <div class="medium-6 columns medium-pull-6">
                <h2>Our Agency</h2>
                <p>Vivamus luctus urna sed urna ultricies ac tempor dui sagittis. In condimentum facilisis porta. Sed nec diam eu diam mattis viverra. Nulla fringilla, orci ac euismod semper, magna diam porttitor mauris, quis sollicitudin sapien justo in libero. Vestibulum mollis mauris enim. Morbi euismod magna ac lorem rutrum elementum. Donec viverra auctor.</p>
            </div>
        </div>
        <div class="row">
            <div class="medium-4 columns">
                <h3>Photoshop</h3>
                <p>Vivamus luctus urna sed urna ultricies ac tempor dui sagittis. In condimentum facilisis porta. Sed nec diam eu diam mattis viverra. Nulla fringilla, orci ac euismod semper, magna.</p>
            </div>
            <div class="medium-4 columns">
                <h3>Javascript</h3>
                <p>Vivamus luctus urna sed urna ultricies ac tempor dui sagittis. In condimentum facilisis porta. Sed nec diam eu diam mattis viverra. Nulla fringilla, orci ac euismod semper, magna.</p>
            </div>
            <div class="medium-4 columns">
                <h3>Marketing</h3>
                <p>Vivamus luctus urna sed urna ultricies ac tempor dui sagittis. In condimentum facilisis porta. Sed nec diam eu diam mattis viverra. Nulla fringilla, orci ac euismod semper, magna.</p>
            </div>
        </div>
        
        <script src="js/jquery.js" type="text/javascript"></script>
        <script src="js/foundation.min.js" type="text/javascript"></script>
    </body>
</html>
