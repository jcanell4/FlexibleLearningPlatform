/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.elsquatrecaps.flexiblelearning.infolearningstructure;

/**
 *
 * @author professor
 */
public abstract class TaskActivity extends Activity {
    
    private String statement;  // HTML code with statements to do the exercise
    private String workZone;   // HTML code with workzone
    private boolean continousTip; //  Should tips be updated after each keystroke?
    private boolean onDemandTip; // Should tips be updated on demand?

    
    
    /**
     * Get the value of statement
     *
     * @return the value of statement
     */
    public String getStatement() {
        return statement;
    }

    /**
     * Set the value of statement
     *
     * @param statement new value of statement
     */
    public void setStatement(String statement) {
        this.statement = statement;
    }    
    
    
    /**
     * Get the value of workZone
     *
     * @return the value of workZone
     */
    public String getWorkZone() {
        return workZone;
    }

    /**
     * Set the value of workZone
     *
     * @param workZone new value of workZone
     */
    public void setWorkZone(String workZone) {
        this.workZone = workZone;
    }

    /**
     * Get the value of continousTip
     *
     * @return the value of continousTip
     */
    public boolean getContinousTip() {
        return continousTip;
    }

    /**
     * Set the value of continousTip
     *
     * @param continousTip new value of continousTip
     */
    public void setContinousTip(boolean continousTip) {
        this.continousTip = continousTip;
    }

    /**
     * Get the value of onDemandTip
     *
     * @return the value of onDemandTip
     */
    public boolean getOnDemandTip() {
        return onDemandTip;
    }

    /**
     * Set the value of onDemandTip
     *
     * @param onDemandTip new value of onDemandTip
     */
    public void setOnDemandTip(boolean onDemandTip) {
        this.onDemandTip = onDemandTip;
    }

    
    
    
}
