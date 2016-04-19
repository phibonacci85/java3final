/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package insurance.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nh228u27
 */
public class User {
    private String username = null;
    private String password = null;
    private List<Accident> accidents = new ArrayList<>();
    private List<Coverage> coverages = new ArrayList<>();
    private List<Policy> policies = new ArrayList<>();
    private List<Suspension> suspensions = new ArrayList<>();
    private List<Vehicle> vehicles = new ArrayList<>();
    private List<Violation> violations = new ArrayList<>();
    

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
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
        this.accidents = accidents;
    }

    /**
     * @return the coverages
     */
    public List<Coverage> getCoverages() {
        return coverages;
    }

    /**
     * @param coverages the coverages to set
     */
    public void setCoverages(List<Coverage> coverages) {
        this.coverages = coverages;
    }

    /**
     * @return the policies
     */
    public List<Policy> getPolicies() {
        return policies;
    }

    /**
     * @param policies the policies to set
     */
    public void setPolicies(List<Policy> policies) {
        this.policies = policies;
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
     * @return the violations
     */
    public List<Violation> getViolations() {
        return violations;
    }

    /**
     * @param violations the violations to set
     */
    public void setViolations(List<Violation> violations) {
        this.violations = violations;
    }
}
