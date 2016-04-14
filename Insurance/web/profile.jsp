<%-- 
    Document   : home
    Created on : Apr 12, 2016, 8:59:44 PM
    Author     : John
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insurance Profile</title>
        <link href="css/foundation.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <link href="css/home.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="top-bar">
            <div class="top-bar-left">
                <ul class="menu">
                    <li><a href="#">Welcome: ${profile.firstName} ${profile.lastName}</a></li>
                </ul>
            </div>
            <div class="top-bar-right">
                <ul class="menu">
                    <li><a href="LoginHandler">Home</a></li>
                    <li><a href="ProfileHandler">Profile</a></li>
                    <li><a href="LogoutHandler">Logout</a></li>
                </ul>
            </div>
        </div>

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
                <h5>${profile.firstName}</h5>
            </div>
            <hr>
            <div class="small-6 columns">
                <h5>Last Name</h5>
            </div>
            <div class="small-6 columns" style="text-align:right;">
                <h5>${profile.lastName}</h5>
            </div>
        </div>
        
        <script src="js/jquery.js" type="text/javascript"></script>
        <script src="js/foundation.min.js" type="text/javascript"></script>
    </body>
</html>
