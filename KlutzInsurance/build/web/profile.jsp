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
    </head>
    <body>
        <jsp:include page="/includes/top_bar.jsp" />
        <div class="row">
            <div class="center-text">
                <h1>Profile</h1>
            </div>
        </div>
        <div class="row small-10 columns">
            <div class="small-6 columns">
                <h5>First Name</h5>
            </div>
            <div class="small-6 columns" style="text-align:right;">
                <h5>${user.username}</h5>
            </div>
            <hr>
            <div class="small-6 columns">
                <h5>Last Name</h5>
            </div>
            <div class="small-6 columns" style="text-align:right;">
                <h5>${user.password}</h5>
            </div>
        </div>
        
        <script src="js/jquery.js" type="text/javascript"></script>
        <script src="js/foundation.min.js" type="text/javascript"></script>
    </body>
</html>
