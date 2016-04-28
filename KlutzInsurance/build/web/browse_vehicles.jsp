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
        <jsp:include page="/includes/top_bar.jsp" />
        <h1 class="text-center">Vehicle Details</h1>
        <div class="row">
            <div class="large-10 large-centered">
                <hr>
                <div class="large-6 columns">
                    <h4>VIN: </h4>
                </div>
                <div class="large-6 columns text-right">
                    <h5>${vehicle.vin}</h5>
                </div>
                <hr>
                <div class="large-6 columns">
                    <h4>License Number: </h4>
                </div>
                <div class="large-6 columns text-right">
                    <h5>${vehicle.licenseNumber}</h5>
                </div>
                <hr>
                <div class="large-6 columns">
                    <h4>Make: </h4>
                </div>
                <div class="large-6 columns text-right">
                    <h5>${vehicle.make}</h5>
                </div>
                <hr>
                <div class="large-6 columns">
                    <h4>Model: </h4>
                </div>
                <div class="large-6 columns text-right">
                    <h5>${vehicle.model}</h5>
                </div>
                <hr>
                <div class="large-6 columns">
                    <h4>Year: </h4>
                </div>
                <div class="large-6 columns text-right">
                    <h5>${vehicle.year}</h5>
                </div>
                <hr>
                <div class="large-6 columns">
                    <h4>Total Mileage: </h4>
                </div>
                <div class="large-6 columns text-right">
                    <h5>${vehicle.totalMileage}</h5>
                </div>
                <hr>
                <div class="large-6 columns">
                    <h4>Annual Mileage: </h4>
                </div>
                <div class="large-6 columns text-right">
                    <h5>${vehicle.annualMileage}</h5>
                </div>
                <hr>
            </div>
        </div>
    </body>
</html>
