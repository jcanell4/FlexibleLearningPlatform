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
public class Status <T>{
    StatusType statusType;
    private LocalDateTime time;
    private T value;
 
    
    /**
     * Get the value of value
     *
     * @return the value of value
     */
    public T getValue() {
        return value;
    }

    /**
     * Set the value of value
     *
     * @param value new value of value
     */
    public void setValue(T value) {
        this.value = value;
    }

    
    
    /**
     * Get the value of statusType
     *
     * @return the value of statusType
     */
    public StatusType getStatusType() {
        return statusType;
    }

    /**
     * Set the value of statusType
     *
     * @param statusType new value of statusType
     */
    public void setStatusType(StatusType statusType) {
        this.statusType = statusType;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
