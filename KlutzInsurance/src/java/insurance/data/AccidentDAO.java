/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package insurance.data;

import insurance.model.Accident;
import insurance.model.AccidentType;
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
public class AccidentDAO {
    
    private static List<Accident> accidents = new ArrayList<>();
    private static Accident accident = new Accident();
    
    /**
     * gets an accident from an accidentId
     * @param accidentId
     * @return
     * @throws ClassNotFoundException 
     */
    public static Accident getAccidentByAccidentId(int accidentId)
        throws ClassNotFoundException{
        accidents = new ArrayList<>();
         //All connections go through DBConnection.getConnection();
        Connection conn = null;
        
        try {
            conn = DBConnection.getConnection();
            String queryString = "call sp_selectAccidentsByAccidentId(?);"; //question mark is a placeholder
            CallableStatement callableStatement = conn.prepareCall(queryString);
            int id = accidentId;
            
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
                    
            //set employee object to the result set from the query
            while(resultSet.next()) {
                accident.setAccidentId(resultSet.getInt(1));
                accident.setLiscenseNumber(resultSet.getString(2));
                accident.setVin(resultSet.getString(3));
                accident.setType(AccidentType.valueOf(resultSet.getString(4)));
                accident.setDate(resultSet.getDate(1));
                accident.setAtFault(resultSet.getBoolean(2));
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
        return accident;
    }
    
    /**
     * gets all accidents
     * @return
     * @throws ClassNotFoundException 
     */
    public static List<Accident> getAccidents()
        throws ClassNotFoundException{
        accidents = new ArrayList<>();
         //All connections go through DBConnection.getConnection();
        Connection conn = null;
        
        try {
            conn = DBConnection.getConnection();
            String queryString = "call sp_selectAccidents();"; //question mark is a placeholder
            CallableStatement callableStatement = conn.prepareCall(queryString);
            
            ResultSet resultSet = callableStatement.executeQuery();
                    
            //set employee object to the result set from the query
            while(resultSet.next()) {
                Accident accident = new Accident();
                accident.setAccidentId(resultSet.getInt(1));
                accident.setLiscenseNumber(resultSet.getString(2));
                accident.setVin(resultSet.getString(3));
                accident.setType(AccidentType.valueOf(resultSet.getString(4)));
                accident.setDate(resultSet.getDate(1));
                accident.setAtFault(resultSet.getBoolean(2));
                accidents.add(accident);
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
        return accidents;
    }
    
    /**
     * gets all of a drivers accidents
     * @param driverId
     * @return
     * @throws ClassNotFoundException 
     */
    public static List<Accident> getAccidentsByDriverId(int driverId)
        throws ClassNotFoundException{
        accidents = new ArrayList<>();
         //All connections go through DBConnection.getConnection();
        Connection conn = null;
        
        try {
            conn = DBConnection.getConnection();
            String queryString = "call sp_selectAccidentsByDriverId(?);"; //question mark is a placeholder
            CallableStatement callableStatement = conn.prepareCall(queryString);
            int id = driverId;
            
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
                    
            //set employee object to the result set from the query
            while(resultSet.next()) {
                Accident accident = new Accident();
                accident.setAccidentId(resultSet.getInt(1));
                accident.setLiscenseNumber(resultSet.getString(2));
                accident.setVin(resultSet.getString(3));
                accident.setType(AccidentType.valueOf(resultSet.getString(4)));
                accident.setDate(resultSet.getDate(1));
                accident.setAtFault(resultSet.getBoolean(2));
                accidents.add(accident);
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
        return accidents;
    }
    
    /**
     * creates a new accident record
     * @param accident
     * @return
     * @throws ClassNotFoundException 
     */
    public static boolean createAccident(Accident accident)
        throws ClassNotFoundException {
        boolean succeeded = false;
         //All connections go through DBConnection.getConnection();
        Connection conn = null;
        
        try {
            conn = DBConnection.getConnection();
            String queryString = "call sp_insertAccident(?,?,?,?,?);"; //question mark is a placeholder
            CallableStatement callableStatement = conn.prepareCall(queryString);
            
            callableStatement.setString(1, accident.getLiscenseNumber());
            callableStatement.setString(2, accident.getVin());
            callableStatement.setString(3, accident.getType().toString());
            callableStatement.setDate(4, (java.sql.Date) accident.getDate());
            callableStatement.setBoolean(5, accident.isAtFault());
            
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
