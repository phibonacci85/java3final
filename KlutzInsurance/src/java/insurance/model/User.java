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
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    
    public User() {
        
    }
    
    public User(String username){
        this.username = username;
    }
    
    private List<Coverage> coverages = new ArrayList<>();
    private List<Policy> policies = new ArrayList<>();
    private List<Suspension> suspensions = new ArrayList<>();
    
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
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}