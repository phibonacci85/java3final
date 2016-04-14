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
public class Coverage {
    CoverageType type = null;
    String biStateMinimum = null;
    final int pdStateMinimum = 25;
    int [] medPayOptions = null;
    DeductibleOptions deductibleOptions = null;
    
    Coverage(){
        if(type == type.MEDICAL_PAYMENT_COVERAGE) {
            medPayOptions = new int [] {1000,2000,3000,5000,10000};
        }
        
    }
    
    public String BIStateMinimum(StateCode code) {
        String minimum = "";
        switch(code){
            case IA:
            case KS:
            case TX:
                minimum = "25/50";
                break;
            case CO:
            case NM:
            case NE:
                minimum = "30/60";
                break;
            default:
                minimum = "";
        }
        return minimum;
    }
}
