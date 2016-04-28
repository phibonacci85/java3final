<%-- 
    Document   : browse_policies
    Created on : Apr 27, 2016, 7:13:03 PM
    Author     : John
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="/includes/head.html" />
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
        <h1>Browse Policies</h1>
    </body>
</html>
