/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.elsquatrecaps.flexiblelearning.infolearningstructure;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 *
 * @author professor
 */
public class LearningState {

    private String idStudent;
    private List<Attempt> attemptList=new ArrayList<>();
    
    //Redundant structure to find attempts of an Activity
    
    private ConcurrentSkipListSet <Attempt> attemptsByActivity=  
            new ConcurrentSkipListSet<>((Attempt a1, Attempt a2) -> a1.getActivity().getName().compareTo(a2.getActivity().getName()));


    /**
     * Get the value of idStudent
     *
     * @return the value of idStudent
     */
    public String getIdStudent() {
        return idStudent;
    }

    /**
     * Set the value of idStudent
     *
     * @param idStudent new value of idStudent
     */
    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }


    /**
     * Get the value of attemptList
     *
     * @return the value of attemptList
     */
    public List<Attempt> getAttemptList() {
        return attemptList;
    }

    /**
     * Set the value of attemptList <b> Do not use</b> Only for compatibility purposes.
     *
     * @param attemptList new value of attemptList
     */
    public void setAttemptList(List<Attempt> attemptList) {
        this.attemptList = attemptList;
    }    

    /**
     * Clear the contents of attemptList
     *
     */
    public void clearAttemptList() {
        this.attemptList.clear();
    }    

    public void addAttempt(Attempt a){
        this.attemptList.add(a);
        this.attemptsByActivity.add(a);
    }
    
    
}
