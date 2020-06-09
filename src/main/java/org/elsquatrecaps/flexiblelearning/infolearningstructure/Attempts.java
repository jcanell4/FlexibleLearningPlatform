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
 * List of attempts corresponding to a Task
 * @author professor
 */
public class Attempts {

    private Task task;

    List<Attempt> attempts= Collections.synchronizedList(new ArrayList<>()); //attempts of task
    
    
    /**
     * Get the value of task
     *
     * @return the value of task
     */
    public Task getTask() {
        return task;
    }

    /**
     * Set the value of task
     *
     * @param task new value of task
     */
    public void setTask(Task task) {
        this.task = task;
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
