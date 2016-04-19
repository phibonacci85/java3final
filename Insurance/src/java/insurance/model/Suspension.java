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
    private SuspensionType type = null;
    private Date dateStart = null;
    private Date dateEnd = null;

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
}
