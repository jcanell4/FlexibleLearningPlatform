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
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author professor
 */
public class Status <T>{
    
    private LocalDateTime time;
   
    private Map<String,Object> studentInputs = Collections.synchronizedMap(new HashMap<>());
    private ActivityConfiguration activityConfiguration = new ActivityConfiguration();
    private Map<String, Object> additionalData = Collections.synchronizedMap(new HashMap<>());
    

    
    /**
     * Get the value of an Item
     *
     * @param itemName name of the item wich state will be returned
     * @return the state of the item
     */
    public Object getState(String itemName) {
        return studentInputs.get(itemName);
    }

    /**
     * Set the state corresponding to the item identified by itemName
     *
     * @param itemName name and identification (inside the scoreScheme) of an item
     * @param state new state of the item identified by itemName
     */
    public void setState(String itemName,Object state) {
        studentInputs.put(itemName, state);
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
    
    /**
     * Get the value of additionalData
     *
     * @return the value of additionalData
     */
    public Map<String, Object> getAdditionalData() {
        return additionalData;
    }

    /**
     * Set the value of additionalData
     *
     * @param additionalData new value of additionalData
     */
    public void setAdditionalData(Map<String, Object> additionalData) {
        this.additionalData = additionalData;
    }
    
    

    /**
     * Get the value of activityConfiguration
     *
     * @return the value of activityConfiguration
     */
    public ActivityConfiguration getActivityConfiguration() {
        return activityConfiguration;
    }

    /**
     * Set the value of activityConfiguration
     *
     * @param activityConfiguration new value of activityConfiguration
     */
    public void setActivityConfiguration(ActivityConfiguration activityConfiguration) {
        this.activityConfiguration = activityConfiguration;
    }

    public void studentInputsToStatus(ModelMap mp){
        studentInputs.clear();
        studentInputs.putAll(mp);
    }
    
    public void studentInputsToModel(ModelAndView mv){
        mv.getModel().putAll(studentInputs);
    }
    
}
