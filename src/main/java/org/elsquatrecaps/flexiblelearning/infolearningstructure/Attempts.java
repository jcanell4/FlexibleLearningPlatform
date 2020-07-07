/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.elsquatrecaps.flexiblelearning.infolearningstructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * List of attempts corresponding to a Activity
 * @author professor
 */
public class Attempts {

    private Activity activity;
    private Student student;

    List<Attempt> attempts= Collections.synchronizedList(new ArrayList<>()); //attempts of activity
    
    
    /**
     * Get the value of activity
     *
     * @return the value of activity
     */
    public Activity getActivity() {
        return activity;
    }

    /**
     * Set the value of activity
     *
     * @param activity new value of activity
     */
    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    /**
     * get attempts
     * @return value of attempts
     */
    public List<Attempt> getAttempts() {
        return attempts;
    }

    /**
     * set attempts. <b>Don't use.</b> Only for compatibility purposes.
     * @param attempts 
     */


    public void setAttempts(List<Attempt> attempts) {
        this.attempts = attempts;
    }

    

    /**
     * Get the value of student
     *
     * @return the value of student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Set the value of student
     *
     * @param student new value of student
     */
    public void setStudent(Student student) {
        this.student = student;
    }
   
///////////// end of accessors    
    
    /**
     * get list of finished attempts
     * @return list of finished attempts
     */
    public List<Attempt> finishedAttemptsList(){
       List<Attempt> result= Collections.synchronizedList(new ArrayList<>());
       for(Attempt a:attempts){
           if(a.getEndLocalDateTime()!=null)  result.add(a);
       }
       return result;
    }
    
    /**
     * get list of unfinished attempts
     * @return list of unfinished attempts
     */
    public List<Attempt> unFinishedAttemptsList(){
       List<Attempt> result= Collections.synchronizedList(new ArrayList<>());
       for(Attempt a:attempts){
           if(a.getEndLocalDateTime()==null)  result.add(a);
       }
       return result;
    }
    
    /**
     * Adds an attempt. 
     * @param attempt attempt to be added
     */
    
    protected void addAttempt(Attempt attempt){
        this.attempts.add(attempt);
    }
    
  
    
}
