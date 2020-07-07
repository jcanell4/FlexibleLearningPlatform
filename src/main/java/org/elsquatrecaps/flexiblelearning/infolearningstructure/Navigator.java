package org.elsquatrecaps.flexiblelearning.infolearningstructure;

import java.time.LocalDateTime;
import java.util.List;
import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.common.LearningProposal;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author professor
 */



public class Navigator {
  
    public static ModelAndView nextAct(String idStudent, String activityName){

        Activity activity, nextActivity;
        String nextActivityName=activityName;
        Attempts attempts;
        Student student=DBConnection.getStudent(idStudent);
        
        if(student==null){// parameter control
            return new ModelAndView(Messages.STUDENT_DOESNT_EXIST);            
        }        
        
        activity=DBConnection.getActivity(activityName);
        
        
        attempts=DBConnection.getAttempts(activityName, idStudent);

        if(activity!=null && attempts!=null && activity.getParentActivity()!=null){
            nextActivity=activity.nextActivity();
            if(nextActivity!=null && activity.getParentActivity().canGoNext(attempts.getAttempts().get(attempts.getAttempts().size()-1), activity)){
                        nextActivityName=nextActivity.getName();
            }
        }
        
        return new ModelAndView(new RedirectView("/refresh?idStudent="+idStudent+"&idActivity="+nextActivityName, true));
        
    }

    public static ModelAndView prevAct(String idStudent, String activityName){

        Activity activity, prevActivity;
        String prevActivityName=activityName;
        Attempts attempts;
        Student student=DBConnection.getStudent(idStudent);
        
        if(student==null){// parameter control
            return new ModelAndView(Messages.STUDENT_DOESNT_EXIST);            
        }        
        
        activity=DBConnection.getActivity(activityName);
        
        
        attempts=DBConnection.getAttempts(activityName, idStudent);
        
        if(activity!=null && attempts!=null && activity.getParentActivity()!=null){
            prevActivity=activity.prevActivity();

            if(prevActivity!=null && activity.getParentActivity().canGoPrev(attempts.getAttempts().get(attempts.getAttempts().size()-1), activity)){
                        prevActivityName=prevActivity.getName();
            }
        }
        
        return new ModelAndView(new RedirectView("/refresh?idStudent="+idStudent+"&idActivity="+prevActivityName, true));
        
    }
    
    public static ModelAndView refreshAct(String idStudent, String activityName){    
    

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
        
        
        
        ResponseViewComposer rvc=ResponseViewComposerFactory.createResponseViewComposer(activity.getType());
        
        List<Attempt> attemptsList=attempts.getAttempts();
        
        return rvc.getResponseView(student, ls,lpa, attemptsList.get(attemptsList.size()-1), activity);   
        
        
        
        
    }

}

