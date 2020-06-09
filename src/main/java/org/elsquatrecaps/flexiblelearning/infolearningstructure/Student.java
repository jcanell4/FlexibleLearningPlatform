/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.elsquatrecaps.flexiblelearning.infolearningstructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author professor
 */
public class Student {

    private String id;
    private String name;
    private SortedMap<String,LearningState> learningStatesMap= Collections.synchronizedSortedMap((SortedMap<String, LearningState>) new TreeMap<String, LearningState>());

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public String getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(String id) {
        this.id = id;
    }
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
     * Get the value of learningStatesMap
     * @return the value of learningStatesMap
     */
    
    public Map<String,LearningState> getLearningStatesMap() {
        return learningStatesMap;
    }

    /**
     * Set the value of attemptsMap. <b>Dont't use.</b> Only for compatibility purposes.
     * @param learningStatesMap new value of learningStatesMap
     */
    
    public void setLearningStatesMap(SortedMap<String,LearningState> learningStatesMap) {
        this.learningStatesMap = learningStatesMap;
    }  
    
///////////// end of accessors

    /**
     * Subscribes Student to a task
     * @param task task to be subscribed
     */
    
    public void subscribeTask(Task task){
        if(task.getParentTask()!=null){
            throw new LearningStructureError(Messages.NOT_A_ROOT_TASK);
        }
        if(learningStatesMap.get(task.getName())!=null){
            throw new LearningStructureError(Messages.DUPLICATED_ITEM);
        }

        LearningState ls=new LearningState();

        ls.setIdStudent(id);
        ls.setRootTask(task);

        learningStatesMap.put(task.getName(), ls);

    }
    
    
    /**
     * get array of learningStates with its main task finished
     * @return array of learningStates with its main task finished
     */
    public LearningState[] finishedLearningStatesArray(){
       ArrayList <LearningState> resultList=new ArrayList<>();
       LearningState[] result = null;
       
       for(LearningState ls:learningStatesMap.values()){
           if(ls.isRootTaskFinished())  resultList.add(ls);
       }
       result=resultList.toArray(result);
       return result;

    }
    
    /**
     * get array of learningStates with its main task unfinished
     * @return array of learningStates with its main task unfinished
     */
    public LearningState[] unFinishedLearningStatesArray(){
       
       ArrayList <LearningState> resultList=new ArrayList<>();
       LearningState[] result = null;
       
       for(LearningState ls:learningStatesMap.values()){
           if(!ls.isRootTaskFinished())  resultList.add(ls);
       }
       result=resultList.toArray(result);
       return result;
    }
    
    public LearningState[] getLearningStatesArray(){
        LearningState[] result = null;
        result=learningStatesMap.values().toArray(result);
        return result;
    }
    
    
    

}
