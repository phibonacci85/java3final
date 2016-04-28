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
        <h1 class="text-center">Browse Drivers</h1>
        <table border="1" cellpadding="10">
            <thead>
                <th>License Number</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Vehicle Usage</th>
                <th>Date</th>
                <th>Username</th>
            </thead>
            <tbody>
                <c:forEach items="${drivers}" var="driver" >
                    <tr>
                        <td>${driver.licenseNumber}</td>
                        <td>${driver.firstName}</td>
                        <td>${driver.lastName}</td>
                        <td>${driver.usage}</td>
                        <td>${driver.DOB}</td>
                        <td>${driver.username}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
