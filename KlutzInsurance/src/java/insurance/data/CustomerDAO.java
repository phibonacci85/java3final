/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insurance.data;

import insurance.model.Customer;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kristi
 */
public class CustomerDAO {
    private static List<Customer> customers = new ArrayList<>();
    
    /**
     * gets the customer from the username
     * @param username
     * @return
     * @throws ClassNotFoundException 
     */
    public Customer getUserCustomer(String username)
        throws ClassNotFoundException{
         //All connections go through DBConnection.getConnection();
        Connection conn = null;
        Customer customer = new Customer();
        
        try {
            conn = DBConnection.getConnection();
            String queryString = "call sp_selectCustomerByUsername(?);"; //question mark is a placeholder
            CallableStatement callableStatement = conn.prepareCall(queryString);
            String id = username;
            
            callableStatement.setString(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
                    
            //set employee object to the result set from the query
            while(resultSet.next()) {
                customer.setUsername(resultSet.getString(1));
                customer.setFirstname(resultSet.getString(2));
                customer.setLastname(resultSet.getString(3));
                customer.setDOB(resultSet.getDate(4));
                customer.setAddress(resultSet.getString(5));
                customer.setPhone(resultSet.getInt(6));
                customer.setEmail(resultSet.getString(7));
                customer.setSs(resultSet.getString(8));
            } 
        } catch (SQLException ex) {
            System.out.println("Technical Difficulties... ");
            System.err.println(ex.getMessage());
        }finally {
            try {
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println("Technical Difficulties");
                System.err.println(ex.getMessage());
            }
        }
        return customer;
    }
    
    /**
     * gets all customers
     * @return
     * @throws ClassNotFoundException 
     */
    public static List<Customer> getCustomers()
        throws ClassNotFoundException {
        customers = new ArrayList<>();
         //All connections go through DBConnection.getConnection();
        Connection conn = null;
        
        try {
            conn = DBConnection.getConnection();
            String queryString = "call sp_selectCustomers();"; //question mark is a placeholder
            CallableStatement callableStatement = conn.prepareCall(queryString);
            
            ResultSet resultSet = callableStatement.executeQuery();
                    
            //set employee object to the result set from the query
            while(resultSet.next()) {
                Customer customer = new Customer();
                customer.setUsername(resultSet.getString(1));
                customer.setFirstname(resultSet.getString(2));
                customer.setLastname(resultSet.getString(3));
                customer.setDOB(resultSet.getDate(4));
                customer.setAddress(resultSet.getString(5));
                customer.setPhone(resultSet.getInt(6));
                customer.setEmail(resultSet.getString(7));
                customer.setSs(resultSet.getString(8));
                customers.add(customer);
            } 
        } catch (SQLException ex) {
            System.out.println("Technical Difficulties... ");
            System.err.println(ex.getMessage());
        }finally {
            try {
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println("Technical Difficulties");
                System.err.println(ex.getMessage());
            }
        }
        return customers;
    }
    
    /**
     * creates a new customer record
     * @param customer
     * @return
     * @throws ClassNotFoundException 
     */
     public static boolean createCustomer(Customer customer)
        throws ClassNotFoundException {
        boolean succeeded = false;
         //All connections go through DBConnection.getConnection();
        Connection conn = null;
        
        try {
            conn = DBConnection.getConnection();
            String queryString = "call sp_insertCustomer(?,?,?,?,?,?,?,?);"; //question mark is a placeholder
            CallableStatement callableStatement = conn.prepareCall(queryString);
            callableStatement.setString(1, customer.getUsername());
            callableStatement.setString(2, customer.getFirstname());
            callableStatement.setString(3, customer.getLastname());
            callableStatement.setDate(4, (java.sql.Date) customer.getDOB());
            callableStatement.setString(5, customer.getAddress());
            callableStatement.setInt(6, customer.getPhone());
            callableStatement.setString(7, customer.getEmail());
            callableStatement.setString(8, customer.getSs());
            
            if(!callableStatement.execute()) {
                int updateCount = callableStatement.getUpdateCount();
                if(updateCount == 1) {
                    succeeded = true;
                }
            }
            
        } catch (SQLException ex) {
            System.out.println("Technical Difficulties... ");
            System.err.println(ex.getMessage());
        }finally {
            try {
                if(conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println("Technical Difficulties");
                System.err.println(ex.getMessage());
            }
        }
        return succeeded;
    }
}
