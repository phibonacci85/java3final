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
    
    public static List<Accident> getAccidents()
        throws ClassNotFoundException{
        accidents = new ArrayList<>();
         //All connections go through DBConnection.getConnection();
        Connection conn = null;
        
        try {
            conn = DBConnection.getConnection();
            String queryString = "sp_selectAccidents();"; //question mark is a placeholder
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
    
    public static List<Accident> getAccidentsByDriverId(int driverId)
        throws ClassNotFoundException{
        accidents = new ArrayList<>();
         //All connections go through DBConnection.getConnection();
        Connection conn = null;
        
        try {
            conn = DBConnection.getConnection();
            String queryString = "sp_selectAccidentsByDriverId(?);"; //question mark is a placeholder
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
    
    public static boolean createAccident(Accident accident)
        throws ClassNotFoundException {
        boolean succeeded = false;
         //All connections go through DBConnection.getConnection();
        Connection conn = null;
        
        try {
            conn = DBConnection.getConnection();
            String queryString = "sp_insertAccident(?,?,?,?,?);"; //question mark is a placeholder
            CallableStatement callableStatement = conn.prepareCall(queryString);
            
            callableStatement.setString(1, accident.getLiscenseNumber());
            callableStatement.setString(2, accident.getVin());
            callableStatement.setString(3, accident.getType().toString());
            callableStatement.setDate(4, (java.sql.Date) accident.getDate());
            callableStatement.setBoolean(5, accident.isAtFault());
            
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
