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
    private CoverageType type = null;
    private String biStateMinimum = null;
    private int pdStateMinimum = 25;
    private int [] medPayOptions = null;
    private DeductibleOptions deductibleOptions = null;
    
    Coverage(){
        if(type == type.MEDICAL_PAYMENT_COVERAGE) {
            medPayOptions = new int [] {1000,2000,3000,5000,10000};
        }
        
    }
    
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
    public DeductibleOptions getDeductibleOptions() {
        return deductibleOptions;
    }

    /**
     * @param deductibleOptions the deductibleOptions to set
     */
    public void setDeductibleOptions(DeductibleOptions deductibleOptions) {
        this.deductibleOptions = deductibleOptions;
    }
}
