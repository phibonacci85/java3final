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
                    <label>License Number
                        <input name="createDriverLicenseNumber" type="text" />
                    </label>
                    <label>First Name
                        <input name="createDriverFirstName" type="text" />
                    </label>
                    <label>Last Name
                        <input name="createDriverLastName" type="text" />
                    </label>
                    <label>
                        <select name="createDriverUsage">
                            <option val="WORK">Work</option>
                            <option val="SCHOOL">School</option>
                            <option val="BUSINESS">Business</option>
                            <option val="PLEASURE">Pleasure</option>
                        </select>
                    </label>
                    <input type="submit" class="button large" value="Create Driver" />
                </form>
            </div>
        </div>
        <hr>
        <div class="row">
            <c:choose>
                <c:when test="${drivers != null}">
                    <div class="large-6 columns">
                        <form action="RequestHandler?task=create_vehicle" method="post">
                            <label>Driver
                                <select name="createVehicleLicenseNumber">
                                    <c:forEach items="${drivers}" var="driver" >
                                        <option val="${driver.licenseNumber}">${driver.firstName} ${driver.lastName}</option>
                                    </c:forEach>
                                </select>
                            </label>
                            <label>VIN
                                <input name="createVehicleVin" type="text" />
                            </label>
                            <label>Make
                                <input name="createVehicleMake" type="text" />
                            </label>
                            <label>Model
                                <input name="createVehicleModel" type="text" />
                            </label>
                            <label>Year
                                <input name="createVehicleYear" type="number" />
                            </label>
                            <label>Total Mileage
                                <input name="createVehicleTotalMileage" type="number" />
                            </label>
                            <label>Annual Mileage
                                <input name="createVehicleAnnualMileage" type="number" />
                            </label>
                            <input type="submit" class="button large" value="Create Vehicle" />
                        </form>
                    </div>
                </c:when>
                <c:otherwise>
                    
                </c:otherwise>
            </c:choose>
        </div>
        <hr>
        <div class="row">
        <c:choose>
            <c:when test="${vehicles != null}">
                <div class="large-6 columns">
                    <form action="RequestHandler?task=create_policy" method="post">
                        <label>Vehicles
                            <select name="createVehicleVin">
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
