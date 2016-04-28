/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package insurance.data;

import insurance.model.Suspension;
import insurance.model.SuspensionType;
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
public class SuspensionDAO {
    private static List<Suspension> suspensions = new ArrayList<Suspension>();
    private static Suspension suspension = new Suspension();
    
    public static Suspension getSuspensionsBySuspensionId(int suspensionId)
        throws ClassNotFoundException{
        suspensions = new ArrayList<>();
         //All connections go through DBConnection.getConnection();
        Connection conn = null;
        
        try {
            conn = DBConnection.getConnection();
            String queryString = "call sp_selectSuspensionBySuspensionId(?);"; //question mark is a placeholder
            CallableStatement callableStatement = conn.prepareCall(queryString);
            int id = suspensionId;
            
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
                    
            //set employee object to the result set from the query
            while(resultSet.next()) {
                suspension.setSuspensionId(resultSet.getInt(1));
                suspension.setLiscenseNumber(resultSet.getString(2));
                suspension.setType(SuspensionType.valueOf(resultSet.getString(3)));
                suspension.setDateStart(resultSet.getDate(4));
                suspension.setDateEnd(resultSet.getDate(5));
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
        return suspension;
    }
    
    public static List<Suspension> getSuspensions()
        throws ClassNotFoundException{
        suspensions = new ArrayList<>();
         //All connections go through DBConnection.getConnection();
        Connection conn = null;
        
        try {
            conn = DBConnection.getConnection();
            String queryString = "call sp_selectSuspensions();"; //question mark is a placeholder
            CallableStatement callableStatement = conn.prepareCall(queryString);
            
            ResultSet resultSet = callableStatement.executeQuery();
                    
            //set employee object to the result set from the query
            while(resultSet.next()) {
                Suspension suspension = new Suspension();
                suspension.setSuspensionId(resultSet.getInt(1));
                suspension.setLiscenseNumber(resultSet.getString(2));
                suspension.setType(SuspensionType.valueOf(resultSet.getString(3)));
                suspension.setDateStart(resultSet.getDate(4));
                suspension.setDateEnd(resultSet.getDate(5));
                suspensions.add(suspension);
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
        return suspensions;
    }
    
    public static List<Suspension> getUserSuspensions(String username)
        throws ClassNotFoundException{
        suspensions = new ArrayList<>();
         //All connections go through DBConnection.getConnection();
        Connection conn = null;
        
        try {
            conn = DBConnection.getConnection();
            String queryString = "call sp_selectSuspensionsByUsername(?);"; //question mark is a placeholder
            CallableStatement callableStatement = conn.prepareCall(queryString);
            String id = username;
            
            callableStatement.setString(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
                    
            //set employee object to the result set from the query
            while(resultSet.next()) {
                Suspension suspension = new Suspension();
                suspension.setSuspensionId(resultSet.getInt(1));
                suspension.setLiscenseNumber(resultSet.getString(2));
                suspension.setType(SuspensionType.valueOf(resultSet.getString(3)));
                suspension.setDateStart(resultSet.getDate(4));
                suspension.setDateEnd(resultSet.getDate(5));
                suspensions.add(suspension);
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
        return suspensions;
    }
    
    public static boolean createSuspension(Suspension suspension)
        throws ClassNotFoundException {
        boolean succeeded = false;
         //All connections go through DBConnection.getConnection();
        Connection conn = null;
        
        try {
            conn = DBConnection.getConnection();
            String queryString = "call sp_insertSuspension(?,?,?,?);"; //question mark is a placeholder
            CallableStatement callableStatement = conn.prepareCall(queryString);
            
            callableStatement.setString(1, suspension.getLiscenseNumber());
            callableStatement.setString(2, suspension.getType().toString());
            callableStatement.setDate(3, (java.sql.Date) suspension.getDateStart());
            callableStatement.setDate(4, (java.sql.Date) suspension.getDateEnd());
            
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
