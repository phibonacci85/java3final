/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package insurance.data;

import insurance.model.Vehicle;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NH228U27
 */
public class VehicleDAO {
    private static List<Vehicle> vehicles = new ArrayList<>();
    private static Vehicle vehicle;
    
    public static List<Vehicle> getUserVehicles(String username){
        
        return vehicles;
    }
    
    public static Vehicle getVehicle(String vin){
        return vehicle;
    }
}
