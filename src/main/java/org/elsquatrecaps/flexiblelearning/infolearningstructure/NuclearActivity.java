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
public abstract class NuclearActivity extends LearningActivity{

    protected List<LearningActivity> members=new ArrayList<>();
    protected ActivitySequencer activitySequencer=null; // LearningActivity sequencer associated to this LearningActivity
    /**
     * Get the value of members
     *
     * @return the value of members
     */
    public List<LearningActivity> getMembers() {
        return members;
    }

    /**
     * Set the value of members     <b>Don't use.</b>. written by compatibility reasons.
     *
     * @param members new value of members
     */
    public void setMembers(ArrayList<LearningActivity> members) {
        this.members = members;
    }
    
    /**
     * Cleans members list (called members)
     */

    public void clearMembers(){
        members.clear();
    }
    
    
    /** Get the value of activitySequencer
     * 
     * @return the value of activitySequencer
     */
    public ActivitySequencer getActivitySequencer() {
        return activitySequencer;
    }

    /** Set the value of activitySequencer
     * 
     * @param activitySequencer new value of activitySequencer
     */
    public void setActivitySequencer(ActivitySequencer activitySequencer) {
        this.activitySequencer = activitySequencer;
    }

}
