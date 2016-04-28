/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insurance.data;

import insurance.model.Customer;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Kristi
 */
public class CustomerDAO {
     public static boolean createCoverage(Customer customer)
        throws ClassNotFoundException {
        boolean succeeded = false;
         //All connections go through DBConnection.getConnection();
        Connection conn = null;
        
        try {
            conn = DBConnection.getConnection();
            String queryString = "sp_insertCustomer(?,?,?,?,?,?,?);"; //question mark is a placeholder
            CallableStatement callableStatement = conn.prepareCall(queryString);
            callableStatement.setString(1, customer.getUsername());
            callableStatement.setString(2, customer.getFirstname());
            callableStatement.setString(3, customer.getLastname());
            callableStatement.setDate(4, (java.sql.Date) customer.getDOB());
            callableStatement.setString(5, customer.getAddress());
            callableStatement.setInt(6, customer.getPhone());
            callableStatement.setString(7, customer.getEmail());
            callableStatement.setString(8, customer.getSs());
            
            succeeded = callableStatement.execute();
            
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
