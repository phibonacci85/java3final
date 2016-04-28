/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insurance.logic;

import insurance.data.*;
import insurance.model.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author John
 */
@WebServlet(name = "RequestHandler", urlPatterns = {"/RequestHandler"})
public class RequestHandler extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nextLocation = null;

        String nextLocationText = request.getParameter("task");
        HttpSession session = request.getSession();
        User curUser = (User)session.getAttribute("user");
        switch (nextLocationText) {
            case "login":
                nextLocation = "/login.jsp";
                break;
            case "home":
                nextLocation = "/index.jsp";
                break;
            case "profile":
                if(curUser == null) {
                    nextLocation = "/index.jsp";
                } else {
                    nextLocation = "/profile.jsp";
                }
                break;
            case "validate_login":
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                try {
                    curUser = UserDAO.getUserByUsername(username);
                    if(password.equals(curUser.getPassword())) {
                        session.setAttribute("user", curUser);
                    }
                } catch (ClassNotFoundException e) {
                    // Error logging in
                    session.invalidate();
                }
                nextLocation = "/index.jsp";
                break;
            case "logout":
                session.invalidate();
                nextLocation = "/index.jsp";
                break;
            case "create_user":
                String createUsername = request.getParameter("createUsername");
                String createPassword = request.getParameter("createPassword");
                try {
                    boolean created = UserDAO.createUser(createUsername, createPassword);
                    if(created) {
                        curUser = UserDAO.getUserByUsername(createUsername);
                        session.setAttribute("user", curUser);
                    }
                } catch (Exception e) {
                    // Couldn't create the user
                    session.invalidate();
                }
                nextLocation = "/index.jsp";
                break;
            case "browse_policies":
                if(curUser == null) {
                    nextLocation = "/index.jsp";
                } else {
                    try {
                        List<Driver> drivers = DriverDAO.getUserDrivers(curUser.getUsername());
                        List<Vehicle> vehicles = VehicleDAO.getUserVehicles(curUser.getUsername());
                        List<Policy> policies = PolicyDAO.getUserPolicies(curUser.getUsername());
                        if(null != drivers && drivers.size() > 0)
                            request.setAttribute("drivers", drivers);
                        if(null != vehicles && vehicles.size() > 0)
                            request.setAttribute("vehicles", vehicles);
                        if(null != policies && policies.size() > 0)
                            request.setAttribute("policies", policies);
                    } catch (ClassNotFoundException e) {
                        //
                    }
                    nextLocation = "/browse_policies.jsp";
                }
                break;
            case "browse_vehicles":
                if(curUser == null) {
                    nextLocation = "/index.jsp";
                } else {
                    try {
                        List<Driver> drivers = DriverDAO.getUserDrivers(curUser.getUsername());
                        List<Vehicle> vehicles = VehicleDAO.getUserVehicles(curUser.getUsername());
                        List<Policy> policies = PolicyDAO.getUserPolicies(curUser.getUsername());
                        if(null != drivers && drivers.size() > 0)
                            request.setAttribute("drivers", drivers);
                        if(null != vehicles && vehicles.size() > 0)
                            request.setAttribute("vehicles", vehicles);
                        if(null != policies && policies.size() > 0)
                            request.setAttribute("policies", policies);
                    } catch (ClassNotFoundException e) {
                        //
                    }
                    nextLocation = "/browse_vehicles.jsp";
                }
                break;
            case "browse_drivers":
                if(curUser == null) {
                    nextLocation = "/index.jsp";
                } else {
                    try {
                        List<Driver> drivers = DriverDAO.getUserDrivers(curUser.getUsername());
                        List<Vehicle> vehicles = VehicleDAO.getUserVehicles(curUser.getUsername());
                        List<Policy> policies = PolicyDAO.getUserPolicies(curUser.getUsername());
                        if(null != drivers && drivers.size() > 0)
                            request.setAttribute("drivers", drivers);
                        if(null != vehicles && vehicles.size() > 0)
                            request.setAttribute("vehicles", vehicles);
                        if(null != policies && policies.size() > 0)
                            request.setAttribute("policies", policies);
                    } catch (ClassNotFoundException e) {
                        //
                    }
                    nextLocation = "/browse_drivers.jsp";
                }
                break;
            case "start_policy":
                if(curUser == null) {
                    nextLocation = "/index.jsp";
                } else {
                    try{
                        List<Driver> drivers = DriverDAO.getUserDrivers(curUser.getUsername());
                        List<Vehicle> vehicles = VehicleDAO.getUserVehicles(curUser.getUsername());
                        if(null != drivers && drivers.size() > 0)
                            request.setAttribute("drivers", drivers);
                        if(null != vehicles && vehicles.size() > 0)
                            request.setAttribute("vehicles", vehicles);
                    } catch(ClassNotFoundException e) {
                        // failed to load resources
                    }
                    nextLocation = "/start_policy.jsp";
                }
                break;
            case "create_driver":
                if(curUser == null) {
                    nextLocation = "/index.jsp";
                } else {
                    String createDriverLicenseNumber = request.getParameter("createDriverLicenseNumber");
                    String createDriverFirstName = request.getParameter("createDriverFirstName");
                    String createDriverLastName = request.getParameter("createDriverLastName");
                    String createDriverUsage = request.getParameter("createDriverUsage");
                    
                    Driver driver = new Driver();
                    driver.setLicenseNumber(createDriverLicenseNumber);
                    driver.setFirstName(createDriverFirstName);
                    driver.setLastName(createDriverLastName);
                    driver.setUsername(curUser.getUsername());
                    
                    switch(createDriverUsage) {
                        case "WORK":
                            driver.setUsage(VehicleUsage.WORK);
                            break;
                        case "SCHOOL":
                            driver.setUsage(VehicleUsage.SCHOOL);
                            break;
                        case "BUSINESS":
                            driver.setUsage(VehicleUsage.BUSINESS);
                            break;
                        case "PLEASURE":
                            driver.setUsage(VehicleUsage.PLEASURE);
                            break;
                        default:
                            driver.setUsage(VehicleUsage.PLEASURE);
                    }
                    
                    try {
                        DriverDAO.createDriver(driver);
                        
                        List<Driver> drivers = DriverDAO.getUserDrivers(curUser.getUsername());
                        List<Vehicle> vehicles = VehicleDAO.getUserVehicles(curUser.getUsername());
                        if(null != drivers && drivers.size() > 0)
                            request.setAttribute("drivers", drivers);
                        if(null != vehicles && vehicles.size() > 0)
                            request.setAttribute("vehicles", vehicles);
                    } catch (ClassNotFoundException e) {
                        // couldn't create the policy
                    }
                    nextLocation = "/start_policy.jsp";
                }
                break;
            case "create_vehicle":
                if(curUser == null) {
                    nextLocation = "/index.jsp";
                } else {
                    String createVehicleLicenseNumber = request.getParameter("createVehicleLicenseNumber");
                    String createVehicleVin = request.getParameter("createVehicleVin");
                    String createVehicleMake = request.getParameter("createVehicleMake");
                    String createVehicleModel = request.getParameter("createVehicleModel");
                    int createVehicleYear = Integer.parseInt((String)request.getParameter("createVehicleYear"));
                    int createVehicleTotalMileage = Integer.parseInt((String)request.getParameter("createVehicleTotalMileage"));
                    int createVehicleAnnualMileage = Integer.parseInt((String)request.getParameter("createVehicleAnnualMileage"));
                    
                    Vehicle vehicle = new Vehicle();
                    vehicle.setVin(createVehicleVin);
                    vehicle.setLicenseNumber(createVehicleLicenseNumber);
                    vehicle.setMake(createVehicleMake);
                    vehicle.setModel(createVehicleModel);
                    vehicle.setYear(createVehicleYear);
                    vehicle.setTotalMileage(createVehicleTotalMileage);
                    vehicle.setAnnualMileage(createVehicleAnnualMileage);
                    vehicle.setUsername(curUser.getUsername());
                    try {
                        VehicleDAO.createVehicle(vehicle);
                        
                        List<Driver> drivers = DriverDAO.getUserDrivers(curUser.getUsername());
                        List<Vehicle> vehicles = VehicleDAO.getUserVehicles(curUser.getUsername());
                        if(null != drivers && drivers.size() > 0)
                            request.setAttribute("drivers", drivers);
                        if(null != vehicles && vehicles.size() > 0)
                            request.setAttribute("vehicles", vehicles);
                    } catch (ClassNotFoundException e) {
                        // couldn't create the policy
                    }
                    nextLocation = "/start_policy.jsp";
                }
                break;
            case "create_policy":
                if(curUser == null) {
                    nextLocation = "/index.jsp";
                } else {
                    Policy policy = new Policy();
                    String createPolicyVin = request.getParameter("createPolicyVin");
                    String createPolicyName = request.getParameter("createPolicyName");
                    double createPolicyRate = Double.parseDouble((String)request.getParameter("createPolicyRate"));
                    policy.setUsername(curUser.getUsername());
                    policy.setName(createPolicyName);
                    policy.setRate(createPolicyRate);
                    policy.setVin(createPolicyVin);
                    
                    try {
                        PolicyDAO.createPolicy(policy);
                    } catch (ClassNotFoundException e) {
                        // couldn't create the policy
                    }
                    nextLocation = "/index.jsp";
                }
                break;
            default:
                nextLocation = "/index.jsp";
        }
        
        //ExampleThing thing = new ExampleThing();
        //request.setAttribute("thing", thing);

        // Redirect things back to the JSP specified in the switch statement
        request.getRequestDispatcher(nextLocation).forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}