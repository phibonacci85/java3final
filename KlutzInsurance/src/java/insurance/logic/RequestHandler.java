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
                    ArrayList<Policy> policies = new ArrayList();
                    Policy policy1 = new Policy();
                    policy1.setPolicyId(1);
                    Policy policy2 = new Policy();
                    policy2.setPolicyId(2);
                    policies.add(policy1);
                    policies.add(policy2);
                    request.setAttribute("policies", policies);
                    nextLocation = "/browse_policies.jsp";
                }
                break;
            case "start_policy":
                nextLocation = "/start_policy.jsp";
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
