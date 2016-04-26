/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package insurance.data;

import insurance.model.Coverage;
import insurance.model.CoverageType;
import insurance.model.DeductibleOption;
import insurance.model.Driver;
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
public class DriverDAO {
    private static Driver driver;
    private static List<Driver> drivers = new ArrayList<>();
    
    public static Driver getDriver(String liscenseNumber){
        return driver;
    }
    
    public static List<Driver> getVehicleDrivers(int vehicleId)
        throws ClassNotFoundException{
        drivers = new ArrayList<>();
         //All connections go through DBConnection.getConnection();
        Connection conn = null;
        
        try {
            conn = DBConnection.getConnection();
            String queryString = "get_Drivers(?);"; //question mark is a placeholder
            CallableStatement callableStatement = conn.prepareCall(queryString);
            int id = vehicleId;
            
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
                    
            //set employee object to the result set from the query
            while(resultSet.next()) {
                Driver driver = new Driver();
                driver.setLicenseNumber(resultSet.getString(1));
                driver.setFirstName(resultSet.getString(2));
                driver.setLastName(resultSet.getString(3));
                //driver.setUsage(VehicleUsage.valueOf(resultSet.getString(4)));
                drivers.add(driver);
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
        return drivers;
    }
}
