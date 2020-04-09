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
public abstract class Activity {

    private String name; // name and identifier of activity
    private String description;
    private Activity parentActivity=null;
    private int maxAttempts=1;


    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the value of description
     *
     * @return the value of description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the value of description
     *
     * @param description new value of description
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * Returns the appropiate Score
     * 
     * @return Score appropiate to this Activity
     */

    /**
     * Get the value of maxAttempts
     *
     * @return the value of maxAttempts
     */
    public int getMaxAttempts() {
        return maxAttempts;
    }

    /**
     * Set the value of maxAttempts
     *
     * @param maxAttempts new value of maxAttempts
     */
    public void setMaxAttempts(int maxAttempts) {
        this.maxAttempts = maxAttempts;
    }

    /**  
     * Get the value of parentActivity
     *
     * @return the value of parentActivity
     */
    public Activity getParentActivity() {
        return parentActivity;
    }

    /**
     * Set the value of parentActivity
     *
     * @param parentActivity new value of parentActivity
     */
    public void setParentActivity(Activity parentActivity) {
        this.parentActivity = parentActivity;
    }



    
    /** 
     * Returns appropiate Score
     *
     */

    public abstract Score ScoreFactory();

    
    /**
     * Updates an attempt associate to this activity
     * @param attempt attempt to be filled
     * @param isSend indicates if the Activity has been submitted by the student (true value) or not
     * @return false if the attempt doesn't bellong to this activity or an error occurs
     *         true if the update can be done
     */
    
    public abstract boolean updateAttempt (Attempt attempt, boolean isSend);

    /**
     * Update the clues on a edited work zone
     * @param currentWorkZone activity's work zone edited by student
     * @param visible indicates if the clues must be shown (true) or not
     * @return current work zone with the clues updated
     */

    public abstract String updateClues (String currentWorkZone, boolean visible);

    
    
    
}
