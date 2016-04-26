/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package insurance.data;

import insurance.model.Coverage;
import insurance.model.CoverageType;
import insurance.model.DeductibleOption;
import insurance.model.User;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NH228U27
 */
public class UserDAO {
    private static User user = null;
    private static List<User> users = new ArrayList<>();
    
    public static List<User> getUsers()
        throws ClassNotFoundException {
        users = new ArrayList<>();
         //All connections go through DBConnection.getConnection();
        Connection conn = null;
        
        try {
            conn = DBConnection.getConnection();
            String queryString = "get_Coverages(?);"; //question mark is a placeholder
            CallableStatement callableStatement = conn.prepareCall(queryString);
            
            ResultSet resultSet = callableStatement.executeQuery();
                    
            //set employee object to the result set from the query
            while(resultSet.next()) {
                User user = new User();
                user.setUsername(resultSet.getString(1));
                user.setPassword(resultSet.getString(2));
                users.add(user);
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
        return users;
    }
        
    public static User getUserByUsername(String username)
            throws ClassNotFoundException {
        
        Connection conn = null;
        User user = new User();
        
        try {
            conn = DBConnection.getConnection();
            String queryString = "get_User(?);"; //question mark is a placeholder
            CallableStatement callableStatement = conn.prepareCall(queryString);
            
            ResultSet resultSet = callableStatement.executeQuery();
                    
            //set employee object to the result set from the query
            while(resultSet.next()) {
                user.setUsername(resultSet.getString(1));
                user.setPassword(resultSet.getString(2));
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
        return user;
    }
    
    public static String getUserFirstName() {
        String lastname = "FIRSTNAME";
        return lastname;
    }
    
    public static String getUserLastName() {
        String lastname = "LASTNAME";
        return lastname;
    }
}
