<%-- 
    Document   : start_policy
    Created on : Apr 27, 2016, 7:13:41 PM
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
        <h1 class="text-center">Start Policy</h1>
        <div class="row">
            <div class="large-6 columns">
                <form action="RequestHandler?task=create_driver" method="post">
                    <label>Name
                        <input name="policyName" type="text" />
                    </label>
                    <label>Rate
                        <input name="policyRate" type="number" min="0" value="0"/>
                    </label>
                    <label>Vin
                        <input name="policyVin" type="text" />
                    </label>
                    <input type="submit" class="button large" value="Create Driver" />
                </form>
            </div>
            <c:choose>
                <c:when test="${drivers != null}">
                    <div class="large-6 columns">
                        <form action="RequestHandler?task=create_vehicle" method="post">
                            <label>Driver
                                <select>
                                    <c:forEach items="${drivers}" var="driver" >
                                        <option val="${driver.licenseNumber}">${driver.firstName} ${driver.lastName}</option>
                                    </c:forEach>
                                </select>
                            </label>
                            <label>More Inputs
                                <input name="policyName" type="text" />
                            </label>
                            <input type="submit" class="button large" value="Create Vehicle" />
                        </form>
                    </div>
                </c:when>
                <c:otherwise>
                    
                </c:otherwise>
            </c:choose>
        </div>
        <div class="row">
        <c:choose>
            <c:when test="${drivers != null}">
                <div class="large-6 columns">
                    <form action="RequestHandler?task=create_policy" method="post">
                        <label>Vehicles
                            <select>
                                <c:forEach items="${vehicles}" var="vehicle" >
                                    <option val="${vehicle.vin}">${vehicle.make} ${vehicle.model}</option>
                                </c:forEach>
                            </select>
                        </label>
                        <label>More Inputs
                            <input name="policyName" type="text" />
                        </label>
                        <input type="submit" class="button large" value="Create Policy" />
                    </form>
                </div>
            </c:when>
            <c:otherwise>

            </c:otherwise>
        </c:choose>
        </div>
    </body>
</html>
