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
public class LearningState {

    private String idStudent;
    private List<Attempts> attemptList=new ArrayList<>();
    private Attempt lastAttempt=null;

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

    public List<Attempts> getAttemptList() {
        return attemptList;
    }

    public void setAttemptList(List<Attempts> attemptList) {
        this.attemptList = attemptList;
    }

    public Attempt getLastAttempt() {
        return lastAttempt;
    }

    public void setLastAttempt(Attempt lastAttempt) {
        this.lastAttempt = lastAttempt;
    }



    
}
