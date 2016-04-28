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
        <h1 class="text-center">Browse Policies</h1>
        <table border="1" cellpadding="10">
            <thead>
                <th>Policy Id</th>
                <th>VIN</th>
                <th>Name</th>
                <th>Rate</th>
            </thead>
            <tbody>
                <c:forEach items="${policies}" var="policy" >
                    <tr>
                        <td>${policy.policyId}</td>
                        <td>${policy.vin}</td>
                        <td>${policy.name}</td>
                        <td>${policy.rate}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
