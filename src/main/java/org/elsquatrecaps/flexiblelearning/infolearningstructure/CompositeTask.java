/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.elsquatrecaps.flexiblelearning.infolearningstructure;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author professor
 */
public class CompositeTask extends Task{

    protected List<Task> members=new ArrayList<>();

    /**
     * Get the value of members
     *
     * @return the value of members
     */
    public List<Task> getMembers() {
        return members;
    }

    /**
     * Set the value of members     <b>Don't use.</b>. written by compatibility reasons.
     *
     * @param members new value of members
     */
    public void setMembers(ArrayList<Task> members) {
        this.members = members;
    }
    
    /**
     * Cleans members list (called members)
     */

    public void clearMembers(){
        members.clear();
    }
    

}
