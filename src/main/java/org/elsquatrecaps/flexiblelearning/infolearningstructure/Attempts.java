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
public class Attempts {

    private LearningActivity activity;
    
    List<Attempt> attempts=new ArrayList<>();
    
    
    /**
     * Get the value of activity
     *
     * @return the value of activity
     */
    public LearningActivity getActivity() {
        return activity;
    }

    /**
     * Set the value of activity
     *
     * @param activity new value of activity
     */
    public void setActivity(LearningActivity activity) {
        this.activity = activity;
    }

    public List<Attempt> getAttempts() {
        return attempts;
    }

    public void setAttempts(List<Attempt> attempts) {
        this.attempts = attempts;
    }
    
    
    
}
