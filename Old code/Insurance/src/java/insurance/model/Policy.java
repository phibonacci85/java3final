/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package insurance.model;

import insurance.data.VehicleDAO;
import java.util.List;

/**
 *
 * @author nh228u27
 */
public class Policy {
    private int policyId;
    private String username;
    private String vin;
    private String name;
    private Double rate;
    
    
    
    public Vehicle vehicle = VehicleDAO.getVehicle(vin);
    private List<Driver> drivers;
    
    public Policy() { }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the rate
     */
    public Double getRate() {
        return rate;
    }

    /**
     * @param rate the rate to set
     */
    public void setRate(Double rate) {
        this.rate = rate;
    }

    /**
     * @return the drivers
     */
    public List<Driver> getDrivers() {
        return drivers;
    }

    /**
     * @param drivers the drivers to set
     */
    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    /**
     * @return the policyId
     */
    public int getPolicyId() {
        return policyId;
    }

    /**
     * @param policyId the policyId to set
     */
    public void setPolicyId(int policyId) {
        this.policyId = policyId;
    }

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
    
}
