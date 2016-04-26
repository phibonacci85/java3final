/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package insurance.model;

import java.util.ArrayList;
import java.util.List;
import static oracle.jrockit.jfr.tools.ConCatRepository.usage;

/**
 *
 * @author nh228u27
 */
public class Driver {
    private String licenseNumber;
    private String firstName;
    private String lastName;
    private VehicleUsage usage;
    
    private List<Accident> accidents = new ArrayList<>();
    private List<Vehicle> vehicles = new ArrayList<>();
    private List<Violation> violations = new ArrayList<>();
    private List<Suspension> suspensions = new ArrayList<>();
    
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
    public List<Violation> getViolations() {
        return violations;
    }

    /**
     * @param violations the violations to set
     */
    public void setViolations(List<Violation> violations) {
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
    public List<Accident> getAccidents() {
        return accidents;
    }

    /**
     * @param accidents the accidents to set
     */
    public void setAccidents(List<Accident> accidents) {
        this.setAccidents(accidents);
    }

    /**
     * @return the vehicles
     */
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    /**
     * @param vehicles the vehicles to set
     */
    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    /**
     * @return the suspensions
     */
    public List<Suspension> getSuspensions() {
        return suspensions;
    }

    /**
     * @param suspensions the suspensions to set
     */
    public void setSuspensions(List<Suspension> suspensions) {
        this.suspensions = suspensions;
    }
}
