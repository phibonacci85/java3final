/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package insurance.data;

import insurance.model.Policy;
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
public class PolicyDAO {
    private static List<Policy> policies = new ArrayList<Policy>();
    private static Policy policy = new Policy();
    
    public static Policy getPolicyByPolicyId(int policyId)
        throws ClassNotFoundException{
        policies = new ArrayList<>();
         //All connections go through DBConnection.getConnection();
        Connection conn = null;
        
        try {
            conn = DBConnection.getConnection();
            String queryString = "sp_selectPoliciesByUsername(?);"; //question mark is a placeholder
            CallableStatement callableStatement = conn.prepareCall(queryString);
            int id = policyId;
            
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
                    
            //set employee object to the result set from the query
            while(resultSet.next()) {
                policy.setPolicyId(resultSet.getInt(1));
                policy.setVin(resultSet.getString(2));
                policy.setName(resultSet.getString(3));
                policy.setRate(resultSet.getDouble(4));
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
        return policy;
    }
    
    public static List<Policy> getPolicies()
        throws ClassNotFoundException{
        policies = new ArrayList<>();
         //All connections go through DBConnection.getConnection();
        Connection conn = null;
        
        try {
            conn = DBConnection.getConnection();
            String queryString = "sp_selectPolicies();"; //question mark is a placeholder
            CallableStatement callableStatement = conn.prepareCall(queryString);
            
            ResultSet resultSet = callableStatement.executeQuery();
                    
            //set employee object to the result set from the query
            while(resultSet.next()) {
                Policy policy = new Policy();
                policy.setPolicyId(resultSet.getInt(1));
                policy.setVin(resultSet.getString(2));
                policy.setName(resultSet.getString(3));
                policy.setRate(resultSet.getDouble(4));
                policies.add(policy);
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
        return policies;
    }
    
    public static List<Policy> getUserPolicies(String username)
        throws ClassNotFoundException{
        policies = new ArrayList<>();
         //All connections go through DBConnection.getConnection();
        Connection conn = null;
        
        try {
            conn = DBConnection.getConnection();
            String queryString = "sp_selectPoliciesByUsername(?);"; //question mark is a placeholder
            CallableStatement callableStatement = conn.prepareCall(queryString);
            String id = username;
            
            callableStatement.setString(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
                    
            //set employee object to the result set from the query
            while(resultSet.next()) {
                Policy policy = new Policy();
                policy.setPolicyId(resultSet.getInt(1));
                policy.setVin(resultSet.getString(2));
                policy.setName(resultSet.getString(3));
                policy.setRate(resultSet.getDouble(4));
                policies.add(policy);
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
        return policies;
    }
    
    public static boolean createPolicy(Policy policy)
        throws ClassNotFoundException {
        boolean succeeded = false;
         //All connections go through DBConnection.getConnection();
        Connection conn = null;
        
        try {
            conn = DBConnection.getConnection();
            String queryString = "sp_insertDriver(?,?,?,?);"; //question mark is a placeholder
            CallableStatement callableStatement = conn.prepareCall(queryString);
            
            callableStatement.setString(1, policy.getUsername());
            callableStatement.setString(2, policy.getVin());
            callableStatement.setString(3, policy.getName());
            callableStatement.setDouble(4, policy.getRate());
            
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
