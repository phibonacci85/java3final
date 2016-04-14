/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package klutsSales;

/**
 *
 * @author nh228u27
 */
public class Driver {
    String firstName = null;
    String lastName = null;
    String licenseNumber = null;
    Violation [] violations = null;
    VehicleUsage usage = null;
    Accident [] accidents = null;
    
    
    public double UsageSurchargePoints(VehicleUsage usage){
        switch(usage){
            case WORK: 
                
                break;
            case SCHOOL:
                
                break;
            case BUISNESS:
                
                break;
            default: //PLEASURE
                
        }
        return 0.0;
    }
}
