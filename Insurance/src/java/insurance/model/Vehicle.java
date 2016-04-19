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
public class Vehicle {
    private int year = 0;
    private String make = null;
    private String model = null;
    private String vin = null;
    private int totalMileage = 0;
    private int annualMileage = 0;
    
    public Vehicle() {
        
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the make
     */
    public String getMake() {
        return make;
    }

    /**
     * @param make the make to set
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
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

    /**
     * @return the totalMileage
     */
    public int getTotalMileage() {
        return totalMileage;
    }

    /**
     * @param totalMileage the totalMileage to set
     */
    public void setTotalMileage(int totalMileage) {
        this.totalMileage = totalMileage;
    }

    /**
     * @return the annualMileage
     */
    public int getAnnualMileage() {
        return annualMileage;
    }

    /**
     * @param annualMileage the annualMileage to set
     */
    public void setAnnualMileage(int annualMileage) {
        this.annualMileage = annualMileage;
    }
}
