/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package insurance.model;

/**
 *
 * @author nh228u27
 */
public class Driver {
    private String firstName = null;
    private String lastName = null;
    private String licenseNumber = null;
    private Violation [] violations = null;
    private VehicleUsage usage = null;
    private Accident [] accidents = null;
    
    
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

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the licenseNumber
     */
    public String getLicenseNumber() {
        return licenseNumber;
    }

    /**
     * @param licenseNumber the licenseNumber to set
     */
    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    /**
     * @return the violations
     */
    public Violation[] getViolations() {
        return violations;
    }

    /**
     * @param violations the violations to set
     */
    public void setViolations(Violation[] violations) {
        this.setViolations(violations);
    }

    /**
     * @return the usage
     */
    public VehicleUsage getUsage() {
        return usage;
    }

    /**
     * @param usage the usage to set
     */
    public void setUsage(VehicleUsage usage) {
        this.usage = usage;
    }

    /**
     * @return the accidents
     */
    public Accident[] getAccidents() {
        return accidents;
    }

    /**
     * @param accidents the accidents to set
     */
    public void setAccidents(Accident[] accidents) {
        this.setAccidents(accidents);
    }
}
