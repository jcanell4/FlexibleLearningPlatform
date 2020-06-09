/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.elsquatrecaps.flexiblelearning.infolearningstructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

/**
 * Learning task
 * @author professor
 */
public class Task {

    private String name; // name and identifier of Task
    private String description;
    protected CompositeTask parentTask=null;
    private int maxAttempts=1;
    private ScoreScheme scoreScheme = null;
    private TaskType type = TaskType.UNIQUE;
    private List <NamedObject> objects = Collections.synchronizedList(new ArrayList<>());
    private Function submitAction = null;
    private Function middleAction = null;

 
    
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
     * Get the value of maxAttempts
     *
     * @return the value of maxAttempts
     */
    public int getMaxAttempts() {
        return maxAttempts;
    }

    /**
     * Set the value of maxAttempts
     *
     * @param maxAttempts new value of maxAttempts
     */
    public void setMaxAttempts(int maxAttempts) {
        this.maxAttempts = maxAttempts;
    }

    /**  
     * Get the value of parentTask
     *
     * @return the value of parentTask
     */
    public CompositeTask getParentTask() {
        return parentTask;
    }

    /**
     * Set the value of parentTask
     *
     * @param parentTask new value of parentTask
     */
    public void setParentTask(CompositeTask parentTask) {
        this.parentTask = parentTask;
    }


    /**
     * Get the value of scoreScheme
     *
     * @return the value of scoreScheme
     */
    public ScoreScheme getScoreScheme() {
        return scoreScheme;
    }

    /**
     * Set the value of scoreScheme
     *
     * @param scoreScheme new value of scoreScheme
     */
    public void setScoreScheme(ScoreScheme scoreScheme) {
        this.scoreScheme = scoreScheme;
    }

/// end of accessors

    /**
     * 
     * Get next task
     * @return next task; null, if there is no next task
     */
    public Task nextTask (){
        Task result=null;
        List<Task> siblings=this.parentTask.getMembers();
        if(this.parentTask!=null){
            int position=siblings.indexOf(this)+1; //postition of next task
            if(position==0){                       // this was not found - error
                throw new LearningStructureError(Messages.INTERNAL_ERROR);
            }else if(position<siblings.size()){    // this is not the last task
               result=siblings.get(position);
            }
        }
        return result;
    }
    
    /**
     * 
     * Get previous task
     * @return previous task; null, if there is no previous task
     */
    public Task prevTask (){
        Task result=null;
        List<Task> siblings=this.parentTask.getMembers();
        if(this.parentTask!=null){
            int position=siblings.indexOf(this)-1; //postition of previous task
            if(position==-2){                      // this was not found - error
                throw new LearningStructureError(Messages.INTERNAL_ERROR);
            }else if(position!=-1){    // this is not the first task
               result=siblings.get(position);
            }
        }
        return result;
    }
    
    
    /**
     * Get the root task of the hierarchy where this is
     * @return root task
     */
    
    public Task rootTask(){
        Task t=this;
        while(t.parentTask!=null){
            t=t.parentTask;
        }
        return t;
        
    }

    /**
     * Get the value of type
     *
     * @return the value of type
     */
    public TaskType getType() {
        return type;
    }

    /**
     * Set the value of type
     *
     * @param type new value of type
     */
    public void setType(TaskType type) {
        this.type = type;
    }



    /**
     * Get the value of objects
     *
     * @return the value of objects
     */
    public List <NamedObject> getObjects() {
        return objects;
    }

    /**
     * Set the value of objects
     *
     * @param objects new value of objects
     */
    public void setObjects(List <NamedObject> objects) {
        this.objects = objects;
    }

    /**
     * Get the value of submitAction
     *
     * @return the value of submitAction
     */
    public Function getSubmitAction() {
        return submitAction;
    }

    /**
     * Set the value of submitAction
     *
     * @param submitAction new value of submitAction
     */
    public void setSubmitAction(Function submitAction) {
        this.submitAction = submitAction;
    }
    
    /**
     * Get the value of middleAction
     *
     * @return the value of middleAction
     */
    public Function getMiddleAction() {
        return middleAction;
    }

    /**
     * Set the value of middleAction
     *
     * @param middleAction new value of middleAction
     */
    public void setMiddleAction(Function middleAction) {
        this.middleAction = middleAction;
    }

    
}
