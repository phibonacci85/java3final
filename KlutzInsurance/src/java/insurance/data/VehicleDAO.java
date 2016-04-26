/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package insurance.data;

import insurance.model.Suspension;
import insurance.model.SuspensionType;
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
    
    public static List<Vehicle> getUserVehicles(String username)
        throws ClassNotFoundException{
        vehicles = new ArrayList<>();
         //All connections go through DBConnection.getConnection();
        Connection conn = null;
        
        try {
            conn = DBConnection.getConnection();
            String queryString = "sp_selectVehiclesByUsername(?);"; //question mark is a placeholder
            CallableStatement callableStatement = conn.prepareCall(queryString);
            String id = username;
            
            callableStatement.setString(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
                    
            //set employee object to the result set from the query
            while(resultSet.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setVin(resultSet.getString(1));
                vehicle.setLiscenseNumber(resultSet.getString(2));
                vehicle.setModel(resultSet.getString(3));
                vehicle.setYear(resultSet.getInt(4));
                vehicle.setTotalMileage(resultSet.getInt(5));
                vehicle.setAnnualMileage(resultSet.getInt(6));
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
    
    public static Vehicle getVehicle(String vin){
        return vehicle;
    }
}
