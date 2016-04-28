/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package insurance.data;

import insurance.model.Vehicle;
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
public class VehicleDAO {
    private static List<Vehicle> vehicles = new ArrayList<>();
    private static Vehicle vehicle;
    
    public static Vehicle getVehicleByVin(String vin)
        throws ClassNotFoundException{
        vehicles = new ArrayList<>();
         //All connections go through DBConnection.getConnection();
        Connection conn = null;
        
        try {
            conn = DBConnection.getConnection();
            String queryString = "call sp_selectVehicleByVin(?);"; //question mark is a placeholder
            CallableStatement callableStatement = conn.prepareCall(queryString);
            String id = vin;
            
            callableStatement.setString(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
                    
            //set employee object to the result set from the query
            while(resultSet.next()) {
                vehicle.setVin(resultSet.getString(1));
                vehicle.setLicenseNumber(resultSet.getString(2));
                vehicle.setYear(resultSet.getInt(3));
                vehicle.setMake(resultSet.getString(4));
                vehicle.setModel(resultSet.getString(5));
                vehicle.setTotalMileage(resultSet.getInt(6));
                vehicle.setAnnualMileage(resultSet.getInt(7));
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
        
        return vehicle;
    }
    
    public static List<Vehicle> getVehicles()
        throws ClassNotFoundException{
        vehicles = new ArrayList<>();
         //All connections go through DBConnection.getConnection();
        Connection conn = null;
        
        try {
            conn = DBConnection.getConnection();
            String queryString = "call sp_selectVehicles();"; //question mark is a placeholder
            CallableStatement callableStatement = conn.prepareCall(queryString);
            
            ResultSet resultSet = callableStatement.executeQuery();
                    
            //set employee object to the result set from the query
            while(resultSet.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setVin(resultSet.getString(1));
                vehicle.setLicenseNumber(resultSet.getString(2));
                vehicle.setYear(resultSet.getInt(3));
                vehicle.setMake(resultSet.getString(4));
                vehicle.setModel(resultSet.getString(5));
                vehicle.setTotalMileage(resultSet.getInt(6));
                vehicle.setAnnualMileage(resultSet.getInt(7));
                vehicles.add(vehicle);
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
        
        return vehicles;
    }
    
    public static List<Vehicle> getUserVehicles(String username)
        throws ClassNotFoundException{
        vehicles = new ArrayList<>();
         //All connections go through DBConnection.getConnection();
        Connection conn = null;
        
        try {
            conn = DBConnection.getConnection();
            String queryString = "call sp_selectVehiclesByUsername(?);"; //question mark is a placeholder
            CallableStatement callableStatement = conn.prepareCall(queryString);
            String id = username;
            
            callableStatement.setString(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
                    
            //set employee object to the result set from the query
            while(resultSet.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setVin(resultSet.getString(1));
                vehicle.setLicenseNumber(resultSet.getString(2));
                vehicle.setYear(resultSet.getInt(3));
                vehicle.setMake(resultSet.getString(4));
                vehicle.setModel(resultSet.getString(5));
                vehicle.setTotalMileage(resultSet.getInt(6));
                vehicle.setAnnualMileage(resultSet.getInt(7));
                vehicles.add(vehicle);
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
        
        return vehicles;
    }
    
    public static boolean createVehicle(Vehicle vehicle)
        throws ClassNotFoundException {
        boolean succeeded = false;
         //All connections go through DBConnection.getConnection();
        Connection conn = null;
        
        try {
            conn = DBConnection.getConnection();
            String queryString = "call sp_insertVehicle(?,?,?,?,?,?,?);"; //question mark is a placeholder
            CallableStatement callableStatement = conn.prepareCall(queryString);
            
            callableStatement.setString(1, vehicle.getVin());
            callableStatement.setString(2, vehicle.getLicenseNumber());
            callableStatement.setInt(3, vehicle.getYear());
            callableStatement.setString(4, vehicle.getMake());
            callableStatement.setString(5, vehicle.getModel());
            callableStatement.setInt(6, vehicle.getTotalMileage());
            callableStatement.setInt(7, vehicle.getAnnualMileage());
            
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
