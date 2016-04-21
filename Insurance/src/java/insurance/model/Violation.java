/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package insurance.model;

import java.util.Date;

/**
 *
 * @author nh228u27
 */
public class Violation {
    private int violationId;
    private String liscenseNumber;
    private ViolationType type;
    private Date dateOccured;
    private Date convictionDate;
    
    
    public double ViolationSurchargePoints(){
        double surchargePoints = 0.0;
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
        return surchargePoints;
    }

    /**
     * @return the type
     */
    public ViolationType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(ViolationType type) {
        this.type = type;
    }

    /**
     * @return the dateOccured
     */
    public Date getDateOccured() {
        return dateOccured;
    }

    /**
     * @param dateOccured the dateOccured to set
     */
    public void setDateOccured(Date dateOccured) {
        this.dateOccured = dateOccured;
    }

    /**
     * @return the convictionDate
     */
    public Date getConvictionDate() {
        return convictionDate;
    }

    /**
     * @param convictionDate the convictionDate to set
     */
    public void setConvictionDate(Date convictionDate) {
        this.convictionDate = convictionDate;
    }

    /**
     * @return the violationId
     */
    public int getViolationId() {
        return violationId;
    }

    /**
     * @param violationId the violationId to set
     */
    public void setViolationId(int violationId) {
        this.violationId = violationId;
    }

    /**
     * @return the liscenseNumber
     */
    public String getLiscenseNumber() {
        return liscenseNumber;
    }

    /**
     * @param liscenseNumber the liscenseNumber to set
     */
    public void setLiscenseNumber(String liscenseNumber) {
        this.liscenseNumber = liscenseNumber;
    }
}
