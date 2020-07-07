/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.elsquatrecaps.flexiblelearning.infolearningstructure;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.common.LearningProposal;

/**
 * Learning Activity
 * @author professor
 */
public class Activity {

    private String name; // name and identifier of Activity
    private String description;
    protected ActivityCategory parentActivity=null;
    private int maxAttempts=1;
    private ScoreScheme scoreScheme = null;
    private String type="";
    protected NamedObjectsConcurrentSet objects = new NamedObjectsConcurrentSet();
    private Map<String, ResponseAction> actions =Collections.synchronizedMap(new HashMap<>());

 
    
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
     * Get the value of parentActivity
     *
     * @return the value of parentActivity
     */
    public ActivityCategory getParentActivity() {
        return parentActivity;
    }

    /**
     * Set the value of parentActivity
     *
     * @param parentActivity new value of parentActivity
     */
    public void setParentActivity(ActivityCategory parentActivity) {
        this.parentActivity = parentActivity;
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
    
        /**
     * Get the value of type
     *
     * @return the value of type
     */
    public String getType() {
        return type;
    }

    /**
     * Set the value of type
     *
     * @param type new value of type
     */
    public void setType(String type) {
        this.type = type;
    }



    /**
     * Get the value of objects
     *
     * @return the value of objects
     */
    public NamedObjectsConcurrentSet getObjects() {
        return objects;
    }

    /**
     * Set the value of objects
     *
     * @param objects new value of objects
     */
    public void setObjects(NamedObjectsConcurrentSet objects) {
        this.objects = objects;
    }

    /**
     * Get the value of actions
     * @return  value of actions
     */
    public Map<String, ResponseAction> getActions() {
        return actions;
    }

    /**
     * Set the value of actions
     * @param actions new value of actions
     */
    
    public void setActions(Map<String, ResponseAction> actions) {
        this.actions = actions;
    }




/// end of accessors

    /**
     * 
     * Get next SimpleActivity - next is the next simpleActivity in pre-oder
     * @return next activity; null, if there is no next activity
     */
    public Activity nextActivity (){
        Activity result=null;
        if(this.parentActivity!=null){
            List<Activity> siblings=this.parentActivity.getMembers();
            int position=siblings.indexOf(this)+1; //postition of next Activity
            if(position==0){                       // this was not found - error
                throw new LearningStructureError(Messages.INTERNAL_ERROR);
            }else if(position<siblings.size()){    // has sibling afterwards
               result=siblings.get(position);
               while (result instanceof ActivityCategory){
                   ActivityCategory aux=(ActivityCategory) result;
                   result=aux.getMembers().get(0);
               }
            } else{ //is the last sibling
                return this.parentActivity.nextActivity();
            }
        }
        return result;
    }
    
    /**
     * 
     * Get previous SimpleActivity - next is the previous simpleActivity in pre-oder
     * @return next activity; null, if there is no next activity
     */
    public Activity prevActivity (){
        Activity result=null;
        if(this.parentActivity!=null){
            List<Activity> siblings=this.parentActivity.getMembers();
            int position=siblings.indexOf(this)-1; //postition of previous Activity
            if(position==-2){                       // this was not found - error
                throw new LearningStructureError(Messages.INTERNAL_ERROR);
            }else if(position>-1){    // has any sibling before
               result=siblings.get(position);
               while (result instanceof ActivityCategory){
                   ActivityCategory aux=(ActivityCategory) result;
                   List<Activity> members=aux.getMembers();
                   result=members.get(members.size()-1);
               }
            } else { //is the firs sibling
                return this.parentActivity.prevActivity();
            }
        }
        return result;
    }    
    
    /**
     * Get the root activity of the hierarchy where this is
     * @return root activity
     */
    
    public LearningProposalActivity rootActivity(){
        Activity t=this;

        while(t.parentActivity!=null){
            t=t.parentActivity;
        }
        return (LearningProposalActivity)t;
        
    }
    
    
    // Action to do when action is used in a view; must use run time data
    // If there is something to do, it must be overwritten
    public void loadAction(Student student, LearningProposal learningProposal,LearningProposalActivity lpActivity,Attempt attempt,Activity activity){
        
    }

    
}
