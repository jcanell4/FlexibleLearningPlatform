/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.elsquatrecaps.flexiblelearning.responses;

import org.elsquatrecaps.flexiblelearning.activity.NamedObject;
import org.elsquatrecaps.flexiblelearning.activity.LearningProposalActivity;
import org.elsquatrecaps.flexiblelearning.activity.Activity;
import org.elsquatrecaps.flexiblelearning.state.Attempt;
import org.elsquatrecaps.flexiblelearning.state.Student;
import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.common.LearningProposal;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author professor
 */

public class SpringThymeLeafResponseViewComposer implements ResponseViewComposer{

    private String template;

    public SpringThymeLeafResponseViewComposer(String template) {
        this.template = template;
    }

    /**
     * Get the value of template
     *
     * @return the value of template
     */
    public String getTemplate() {
        return template;
    }

    /**
     * Set the value of template
     *
     * @param template new value of template
     */
    public void setTemplate(String template) {
        this.template = template;
    }


    
    
    
    
    /**
     *
     * @param student
     * @param learningProposal
     * @param lpActivity
     * @param attempt
     * @param activity
     * @return
     */
    @Override
    public ModelAndView startAct(Student student, LearningProposal learningProposal, LearningProposalActivity lpActivity, Attempt attempt, Activity activity) {

       ModelAndView ret = new ModelAndView(template);
       attempt.getStatus().studentInputsToModel(ret);
       attempt.getStatus().getActivityConfiguration().copyConfigurationToActivity(activity);
       

       activity.loadAction(student, learningProposal,lpActivity,attempt,activity);
       

       for(NamedObject no:activity.getObjects()){
           ret.addObject(no.getName(),no.getObject());
       }
       
       
       return ret;
    }


    /* De moment es igual que l'anterior
    */
    @Override
    public ModelAndView getResponseView(Student student, LearningProposal learningProposal, LearningProposalActivity lpActivity, Attempt attempt, Activity activity) {
       ModelAndView ret = new ModelAndView(template);
       attempt.getStatus().studentInputsToModel(ret);
       attempt.getStatus().getActivityConfiguration().copyConfigurationToActivity(activity);
       
       activity.loadAction(student, learningProposal,lpActivity,attempt,activity);
       
       for(NamedObject no:activity.getObjects()){
           ret.addObject(no.getName(),no.getObject());
       }
       
       
       return ret;
        
    }

    
}
/*
Com exemple està bé, però no és útil per la implemetació. Jo el passaria a un paquest dins del viewComposer
anomenat, per exemple, proves i que en un futur es pugui eliminar.
*/