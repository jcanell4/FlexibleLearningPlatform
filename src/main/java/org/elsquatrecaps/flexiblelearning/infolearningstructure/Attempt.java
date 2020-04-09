/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.elsquatrecaps.flexiblelearning.infolearningstructure;

import java.time.LocalDateTime;

/**
 *
 * @author professor
 */
public class Attempt {
  
    private Activity activity;
    private Score score;
    private LocalDateTime endLocalDateTime;
    private LocalDateTime startLocalDateTime;
    private String workZone;   // HTML code with last state of workzone

    /**
     * Get the value of activity
     *
     * @return the value of activity
     */
    public Activity getActivity() {
        return activity;
    }

    /**
     * Set the value of activity
     *
     * @param activity new value of activity
     */
    public void setActivity(Activity activity) {
        this.activity = activity;
    }



    /**
     * Get the value of score
     *
     * @return the value of score
     */
    public Score getScore() {
        return score;
    }

    /**
     * Set the value of score
     *
     * @param score new value of score
     */
    public void setScore(Score score) {
        this.score = score;
    }

    /**
     * Get the value of endLocalDateTime
     *
     * @return the value of score
     */
    
    public LocalDateTime getEndLocalDateTime() {
        return endLocalDateTime;
    }

    /**
     * Set the value of endLocalDateTime
     *
     * @param endLocalDateTime new value of endLocalDateTime
     */
   
    public void setEndLocalDateTime(LocalDateTime endLocalDateTime) {
        this.endLocalDateTime = endLocalDateTime;
    }

    /**
     * Get the value of startLocalDateTime
     *
     * @return the value of score
     */


    public LocalDateTime getStartLocalDateTime() {
        return startLocalDateTime;
    }

    /**
     * Set the value of startLocalDateTime
     *
     * @param startLocalDateTime new value of startLocalDateTime
     */
    
    public void setStartLocalDateTime(LocalDateTime startLocalDateTime) {
        this.startLocalDateTime = startLocalDateTime;
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

 

}
