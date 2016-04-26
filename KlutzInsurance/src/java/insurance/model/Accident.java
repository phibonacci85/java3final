/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package insurance.model;

import insurance.data.AccidentDAO;
import insurance.data.DriverDAO;
import insurance.data.VehicleDAO;
import java.util.Date;

/**
 *
 * @author nh228u27
 */
public class Accident {
    private String accidentId;
    private String liscenseNumber;
    private String vin;
    private AccidentType type;
    private Date date;
    private boolean atFault;
    
    public Driver driver = DriverDAO.getDriver(liscenseNumber);
    public Vehicle vehicle = VehicleDAO.getVehicle(vin);

    public Accident() {}
    
    public Accident(String accidentId){
    }
    
    /**
     * @return the type
     */
    public AccidentType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(AccidentType type) {
        this.type = type;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the atFault
     */
    public boolean isAtFault() {
        return atFault;
    }

    /**
     * @param atFault the atFault to set
     */
    public void setAtFault(boolean atFault) {
        this.atFault = atFault;
    }

    /**
     * @return the accidentId
     */
    public String getAccidentId() {
        return accidentId;
    }

    /**
     * @param accidentId the accidentId to set
     */
    public void setAccidentId(String accidentId) {
        this.accidentId = accidentId;
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

    /**
     * @return the vin
     */
    public String getVin() {
        return vin;
    }

    /**
     * @param vin the vin to set
     */
    public void setVin(String vin) {
        this.vin = vin;
    }
}
