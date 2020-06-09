/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.elsquatrecaps.flexiblelearning.infolearningstructure;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * State of a LearningProposal
 * @author professor
 */
public class LearningState {

    private String idStudent;
    private Map<String,Attempts> attemptsMap= Collections.synchronizedMap(new HashMap<>()); //attempts information of rootTask and its subtasks
    private Attempts lastAttempts=null;
    private Task rootTask = null;  //this task is associated with a LearningProposal

 


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
     * Get the value of attemptsMap
     * @return the value of attemptsMap
     */
    
    public Map<String,Attempts> getAttemptsMap() {
        return attemptsMap;
    }

    /**
     * Set the value of attemptsMap. <b>Dont't use.</b> Only for compatibility purposes.
     * @param attemptsMap new value of attemptsMap
     */
    
    public void setAttemptsMap(Map<String,Attempts> attemptsMap) {
        this.attemptsMap = attemptsMap;
    }
    
    /**
     * get the attempts of task
     * @param task the Task of wich the attempts are got
     * @return attempts corresponding to task
 if there's no attempt of task, returns an attempts object with no attempt
     */
    
    public Attempts getTaskAttempts(Task task){
        Attempts res=attemptsMap.get(task.getName());
        if(res==null){
            res=new Attempts();
            res.setTask(task);
        }
        return res;
    }

   /**
     * Get the value of rootTask
     *
     * @return the value of rootTask
     */
    public Task getRootTask() {
        return rootTask;
    }

    /**
     * Set the value of rootTask
     *
     * @param rootTask new value of rootTask
     */
    public void setRootTask(Task rootTask) {
        this.rootTask = rootTask;
    }


    /**
     * get lastAttempts
     * @return value of lastAttempts
     */
    public Attempts getLastAttempts() {
        return lastAttempts;
    }

    /**
     * set lastAttmpt. <b>Don't use.</b> Only for compatibility purposes.
     * @param lastAttempts  new value of lastAttempts
     */
    public void setLastAttempts(Attempts lastAttempts) {
        this.lastAttempts = lastAttempts;
    }


///////////// end of accessors
    
    /**
     * adds an attempt corresponding to task
     * @param task to wich attempt belongs
     * @param attempt of task to be added
     */
    public void addTaskAttempt(Task task,Attempt attempt){
        
        if(task.rootTask()!=rootTask){
            throw new LearningStructureError(Messages.BAD_HIERARCHY);
        }
        
        String taskName=task.getName();
        
        Attempts attempts=attemptsMap.get(taskName);
        
        if(attempts==null){
            attempts=new Attempts();
            attempts.setTask(task);
        }
        attempts.addAttempt(attempt);
        attemptsMap.put(taskName, attempts);
        lastAttempts=attempts;
        
    }

    public boolean isRootTaskFinished(){
        return isTaskFinished(rootTask);
    }

    public boolean isTaskFinished(Task t){

        if(t.rootTask()!=rootTask){
            throw new LearningStructureError(Messages.BAD_HIERARCHY);
        }

        Attempts a=attemptsMap.get(t.getName());
        
        if(a==null) return false;
        else{
            return a.finishedAttemptsList().size()>= t.getMaxAttempts();
        }
        
    }



    
}
