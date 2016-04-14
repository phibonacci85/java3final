/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package klutsSales;

import java.util.Date;

/**
 *
 * @author nh228u27
 */
public class Violation {
    ViolationType type = null;
    Date dateOccured = null;
    Date convictionDate = null;
    
    public double ViolationSurchargePoints(ViolationType type){
        switch(type){
            case SPEEDING:

                break;
            case FOLLOWING_TO_CLOSE:

                break;
            case CELL_PHONE:

                break;
            case TRAFFIC_DEVICE:

                break;
            case DUI:

                break;
            case RECKLESS_DRIVING:

                break;
            case CARELESS_DRIVING:

                break;
            default: //LISENCE_INVALID
                
        }
        return 0.0;
    }
}
