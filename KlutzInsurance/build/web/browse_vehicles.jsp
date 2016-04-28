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
                <label>VIN: </label><span>${vehicle.vin}</span>
                <hr>
                <label>License Number: </label><span>${vehicle.licenseNumber}</span>
                <hr>
                <label>Make: </label><span>${vehicle.make}</span>
                <hr>
                <label>Model: </label><span>${vehicle.model}</span>
                <hr>
                <label>Year: </label><span>${vehicle.year}</span>
                <hr>
                <label>Total Mileage: </label><span>${vehicle.totalMileage}</span>
                <hr>
                <label>Annual Mileage: </label><span>${vehicle.annualMileage}</span>
            </div>
        </div>
    </body>
</html>
