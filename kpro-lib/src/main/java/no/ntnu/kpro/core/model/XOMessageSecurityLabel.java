/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package no.ntnu.kpro.core.model;

/**
 *
 * @author Aleksander
 * Note. There also exists separate enums for each of the grading classes.
 * Unsure of which to keep as of now.
 */
public enum XOMessageSecurityLabel {
    CHOOSE_ONE("Choose Security Label", "I SHOULD NOT SHOW, BECAUSE I CANNOT BE CHOSEN", null),
    UGRADERT("UGRADERT", "ug", "marking=\"UGRADERT\"; fgcolor=black; bgcolor=white; type=\":ess\"; label=\"MQ8CAQEGCmCEQgECARyEQgE=\""),
    BEGRENSET("BEGRENSET", "b", "marking=\"BEGRENSET\"; fgcolor=red; bgcolor=white; type=\":ess\"; label=\"MQ8CAQIGCmCEQgECARyEQgE=\""),
    KONFIDENSIELT("KONFIDENSIELT", "k", "marking=\"KONFIDENSIELT\"; fgcolor=red; bgcolor=white; type=\":ess\"; label=\"MQ8CAQMGCmCEQgECARyEQgE=\""),
    UNCLASSIFIED("UNCLASSIFIED", "uc", "marking=\"UNCLASSIFIED\"; fgcolor=black; bgcolor=white; type=\":ess\"; label=\"MQ4CAQEGCWCEQgECARwAAQ==\""),
    RESTRICTED("RESTRICTED", "r", "marking=\"RESTRICTED\"; fgcolor=red; bgcolor=white; type=\":ess\"; label=\"MQ4CAQIGCWCEQgECARwAAQ==\""), 
    CONFIDENTIAL("CONFIDENTIAL", "c", "marking=\"CONFIDENTIAL\"; fgcolor=red; bgcolor=white; type=\":ess\"; label=\"MQ4CAQMGCWCEQgECARwAAQ==\""),
    NATO_UNCLASSIFIED("NATO_UNCLASSIFIED", "nu", "marking=\"NATO UNCLASSIFIED\"; fgcolor=black; bgcolor=white; type=\":ess\"; label=\"MQ0CAQEGCCsaAKI2AAUB\""),
    NATO_RESTRICTED("NATO_RESTRICTED", "nr", "marking=\"NATO RESTRICTED\"; fgcolor=red; bgcolor=white; type=\":ess\"; label=\"MQ0CAQIGCCsaAKI2AAUB\""),
    NATO_CONFIDENTIAL("NATO_CONFIDENTIAL", "nc", "marking=\"NATO CONFIDENTIAL\"; fgcolor=red; bgcolor=white; type=\":ess\"; label=\"MQ0CAQMGCCsaAKI2AAUB\"");
    
    private String val;
    private String shortVal;
    private String headerValue;
    
    private XOMessageSecurityLabel(String value, String shortValue, String headerValue){
        this.val = value;
        this.shortVal = shortValue;
        this.headerValue = headerValue;
    }
    
    @Override
    public String toString(){
        return this.val;
    }

    public String getShortValue(){
        return this.shortVal;
    }
    
    public String getHeaderValue() {
        return this.headerValue;
    }
}
