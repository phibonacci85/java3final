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
public class Coverage {
    private int coverageId;
    private String username;
    private CoverageType type;
    private String biStateMinimum;
    private int pdStateMinimum;
    private DeductibleOption deductibleOption;
    private int medPay;
    
    private int [] medPayOptions;
    
    public Coverage(){}
    
    public String BIStateMinimum(StateCode code) {
        String minimum = "";
        switch(code){
            case IA:
            case KS:
            case TX:
                minimum = "25/50";
                break;
            case CO:
            case NM:
            case NE:
                minimum = "30/60";
                break;
            default:
                minimum = "";
        }
        return minimum;
    }

    /**
     * @return the type
     */
    public CoverageType getType() {
        if(type == type.MEDICAL_PAYMENT_COVERAGE) {
            medPayOptions = new int [] {1000,2000,3000,5000,10000};
        }
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(CoverageType type) {
        this.type = type;
    }

    /**
     * @return the biStateMinimum
     */
    public String getBiStateMinimum() {
        return biStateMinimum;
    }

    /**
     * @param biStateMinimum the biStateMinimum to set
     */
    public void setBiStateMinimum(String biStateMinimum) {
        this.biStateMinimum = biStateMinimum;
    }

    /**
     * @return the pdStateMinimum
     */
    public int getPdStateMinimum() {
        return pdStateMinimum;
    }

    /**
     * @param pdStateMinimum the pdStateMinimum to set
     */
    public void setPdStateMinimum(int pdStateMinimum) {
        this.pdStateMinimum = pdStateMinimum;
    }

    /**
     * @return the medPayOptions
     */
    public int[] getMedPayOptions() {
        return medPayOptions;
    }

    /**
     * @param medPayOptions the medPayOptions to set
     */
    public void setMedPayOptions(int[] medPayOptions) {
        this.medPayOptions = medPayOptions;
    }

    /**
     * @return the deductibleOptions
     */
    public DeductibleOption getDeductibleOption() {
        return deductibleOption;
    }

    /**
     * @param deductibleOptions the deductibleOptions to set
     */
    public void setDeductibleOption(DeductibleOption deductibleOptions) {
        this.deductibleOption = deductibleOption;
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

    /**
     * @return the coverageId
     */
    public int getCoverageId() {
        return coverageId;
    }

    /**
     * @param coverageId the coverageId to set
     */
    public void setCoverageId(int coverageId) {
        this.coverageId = coverageId;
    }

    /**
     * @return the medPay
     */
    public int getMedPay() {
        return medPay;
    }

    /**
     * @param medPay the medPay to set
     */
    public void setMedPay(int medPay) {
        this.medPay = medPay;
    }
}
