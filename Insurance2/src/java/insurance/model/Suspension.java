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
public class Suspension {
    private int suspensionId;
    private String liscenseNumber;
    private SuspensionType type;
    private Date dateStart;
    private Date dateEnd;
    
    public Suspension() { }
    
    /**
     * @return the type
     */
    public SuspensionType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(SuspensionType type) {
        this.type = type;
    }

    /**
     * @return the dateStart
     */
    public Date getDateStart() {
        return dateStart;
    }

    /**
     * @param dateStart the dateStart to set
     */
    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    /**
     * @return the dateEnd
     */
    public Date getDateEnd() {
        return dateEnd;
    }

    /**
     * @param dateEnd the dateEnd to set
     */
    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    /**
     * @return the username
     */
    public String getLiscenseNumber() {
        return liscenseNumber;
    }

    /**
     * @param username the username to set
     */
    public void setLiscenseNumber(String liscenseNumber) {
        this.liscenseNumber = liscenseNumber;
    }

    /**
     * @return the suspensionId
     */
    public int getSuspensionId() {
        return suspensionId;
    }

    /**
     * @param suspensionId the suspensionId to set
     */
    public void setSuspensionId(int suspensionId) {
        this.suspensionId = suspensionId;
    }
}
