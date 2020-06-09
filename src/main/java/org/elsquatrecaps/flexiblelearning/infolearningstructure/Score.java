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
public class Score{
    
    ScoreScheme scoreScheme;
    private LocalDateTime time;
    private Map<String,Object> values = Collections.synchronizedMap(new HashMap<>());
 
    
    /**
     * Get the value of an Item
     *
     * @param itemName name of the item wich value will be returned
     * @return the value of the item
     */
    public Object getValue(String itemName) {
        return values.get(itemName);
    }

    /**
     * Set the value of value corresponding to the item identified by itemName
     *
     * @param itemName namne and identification (inside the scoreScheme) of an item
     * @param value new value of the item
     */
    public void setValue(String itemName,Object value) {
        values.put(itemName, value);
    }
    
    /**
     * Get the value of scoreScheme
     *
     * @return the value of scoreScheme
     */
    public ScoreScheme getScoreScheme() {
        return scoreScheme;
    }

    /**
     * Set the value of scoreScheme
     *
     * @param scoreScheme new value of scoreScheme
     */
    public void setScoreScheme(ScoreScheme scoreScheme) {
        this.scoreScheme = scoreScheme;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

}
