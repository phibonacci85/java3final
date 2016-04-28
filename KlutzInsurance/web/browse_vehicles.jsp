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
        <h1 class="text-center">Browse Vehicles</h1>
        <table border="1" cellpadding="10">
            <thead>
                <th>VIN</th>
                <th>License Number</th>
                <th>Make</th>
                <th>Model</th>
                <th>Year</th>
                <th>Total Mileage</th>
                <th>Annual Mileage</th>
                <th>Username</th>
            </thead>
            <tbody>
                <c:forEach items="${vehicles}" var="vehicle" >
                    <tr>
                        <td>${vehicle.vin}</td>
                        <td>${vehicle.licenseNumber}</td>
                        <td>${vehicle.make}</td>
                        <td>${vehicle.model}</td>
                        <td>${vehicle.year}</td>
                        <td>${vehicle.totalMileage}</td>
                        <td>${vehicle.annualMileage}</td>
                        <td>${vehicle.username}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
