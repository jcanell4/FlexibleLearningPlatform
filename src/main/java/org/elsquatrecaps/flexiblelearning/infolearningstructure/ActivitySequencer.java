/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.elsquatrecaps.flexiblelearning.infolearningstructure;

import java.util.List;

/**
 * Interface that provides a method to get next activities to be done by the student
 * @author professor
 */
public interface ActivitySequencer {
    /**
     * Method that provides a list with the activities to be done after act has been finished
     * @param na parent activity to the last completed activity
     * @param act last completed activity
     * @return list of the activities that can be done after act activity is completed
     */
    public List<Activity> nextActivities(NuclearActivity na, Activity act);
}
