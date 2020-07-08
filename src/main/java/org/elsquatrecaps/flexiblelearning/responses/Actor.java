/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.elsquatrecaps.flexiblelearning.responses;

import org.elsquatrecaps.flexiblelearning.activity.LearningProposalActivity;
import org.elsquatrecaps.flexiblelearning.activity.Activity;
import java.time.LocalDateTime;
import java.util.List;
import org.elsquatrecaps.flexiblelearning.state.Attempt;
import org.elsquatrecaps.flexiblelearning.state.Attempts;
import org.elsquatrecaps.flexiblelearning.state.DBConnection;
import org.elsquatrecaps.flexiblelearning.state.Messages;
import org.elsquatrecaps.flexiblelearning.state.Status;
import org.elsquatrecaps.flexiblelearning.state.Student;
import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.common.LearningProposal;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author professor
 */
public class Actor {

    public static ModelAndView doAct(ModelMap modelMap, String idStudent, String activityName, String action) {
       
        Activity activity;
        Attempts attempts;
        Student student=DBConnection.getStudent(idStudent);
        LearningProposal ls;
        LearningProposalActivity lpa;
        
        
        if(student==null){// parameter control
            return new ModelAndView(Messages.STUDENT_DOESNT_EXIST);            
        }
        
        activity=DBConnection.getActivity(activityName);
        if(activity==null){
            return new ModelAndView(Messages.ACTIVITY_DOESNT_EXIST);
        }
        
        lpa=(LearningProposalActivity)activity.rootActivity();
        ls=lpa.getLearningProposal();
        
        attempts=DBConnection.getAttempts(activityName, idStudent);

       
        if(attempts==null){
            attempts=new Attempts();
            attempts.setActivity(activity);
            attempts.setStudent(student);
            Attempt at = new Attempt();

            Status stat = new Status();
            stat.setTime(LocalDateTime.now());
            at.setStartLocalDateTime(stat.getTime());
            at.setStatus(stat);
            attempts.getAttempts().add(at);
            DBConnection.add(attempts);
        }
       
        List<Attempt> attemptsList=attempts.getAttempts();
        Attempt attempt=attemptsList.get(attemptsList.size()-1);
        
        attempt.getStatus().studentInputsToStatus(modelMap);
        
        ResponseAction doNow=activity.getActions().get(action);
        
        if(doNow!=null){
            doNow.action(modelMap, student, ls, lpa, attempt, activity);
        }
               
        attempt.getStatus().getActivityConfiguration().saveConfigurationFromActivity(activity);
        
        DBConnection.add(attempts);
        
        ResponseViewComposer rvc=ResponseViewComposerFactory.createResponseViewComposer(activity.getType());
      
        return rvc.getResponseView(student, ls,lpa, attempt, activity);   
    }

}
