<%-- 
    Document   : index.jsp
    Created on : Apr 12, 2016, 8:43:53 PM
    Author     : John
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insurance Login</title>
        <link href="css/foundation.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/default.css" rel="stylesheet" type="text/css"/>
        <link href="css/index.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="main" class="row">
            <div class="medium-4 medium-centered columns border">
                <form action="LoginHandler" method="post">
                    <div class="row">
                        <div class="medium-12 columns">
                            <h3 class="center text">Insurance Login</h3>
                        </div>
                    </div>
                    <div class="row">
                        <div class="medium-12 columns">
                            <label class="text" >Username</label>
                            <input type="text" name="username" id="username" />
                        </div>
                    </div>
                    <div class="row">
                        <div class="medium-12 columns">
                            <label class="text">Password</label>
                            <input type="password" name="password" id="password" />
                        </div>
                    </div>
                    <div class="row">
                        <div class="medium-12 columns">
                            <input class="button expanded" type="submit" name="login" id="login" value="Login" />
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <script src="js/jquery.js" type="text/javascript"></script>
        <script src="js/foundation.min.js" type="text/javascript"></script>
        <script>
            $(document).foundation();
        </script>
    </body>
</html>
