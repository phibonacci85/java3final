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
public class Accident {
    private AccidentType type = null;
    private Date date = null;
    private boolean atFault = false;

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
}
