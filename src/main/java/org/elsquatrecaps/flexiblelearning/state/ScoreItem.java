/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.elsquatrecaps.flexiblelearning.state;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author professor
 */
public class ScoreItem {
    
    private String name; // name and identifier of score item (inside a ScoreScheme)
    private String description;
    private Class clasz=null; // class of values of the ScoreItem
    private List<ScoreItem> members=Collections.synchronizedList(new ArrayList<>());

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
     * Get members
     * @return value of members
     */
    
    public List<ScoreItem> getMembers() {
        return members;
    }

    /**
     * set members. <b>Don't use.</b> Only compatibility purpose.
     * @param members value of members
     */
    
    public void setMembers(List<ScoreItem> members) {
        this.members = members;
    }

    /**
     * get value of clasz
     * @return value of clasz
     */
    
    public Class getClasz() {
        return clasz;
    }

    /**
     * set value of clasz
     * @param clasz new value of clasz
     */
    public void setClasz(Class clasz) {
        this.clasz = clasz;
    }
    
    
    
    
}
