/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.elsquatrecaps.flexiblelearning.state;

import java.time.LocalDateTime;

/**
 * Information about an attempt of one Activity
 * @author professor
 */
public class Attempt {
  

    private Score score;
    private Status status;
    private LocalDateTime endLocalDateTime;
    private LocalDateTime startLocalDateTime;


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
     * Get the value of status
     *
     * @return the value of status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Set the value of status
     *
     * @param status new value of status
     */
    public void setStatus(Status status) {
        this.status = status;
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

    

}
