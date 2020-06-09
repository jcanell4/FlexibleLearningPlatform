/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.elsquatrecaps.flexiblelearning.infolearningstructure;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author professor
 */
public class Status <T>{
    
    private LocalDateTime time;
   
    private Map<String,Object> states = Collections.synchronizedMap(new HashMap<>()); 

    
    /**
     * Get the value of an Item
     *
     * @param itemName name of the item wich state will be returned
     * @return the state of the item
     */
    public Object getState(String itemName) {
        return states.get(itemName);
    }

    /**
     * Set the state corresponding to the item identified by itemName
     *
     * @param itemName name and identification (inside the scoreScheme) of an item
     * @param state new state of the item identified by itemName
     */
    public void setState(String itemName,Object state) {
        states.put(itemName, state);
    }

    
    


    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
