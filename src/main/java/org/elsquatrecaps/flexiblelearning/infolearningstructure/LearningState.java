package org.elsquatrecaps.flexiblelearning.infolearningstructure;

/**
 * State of a LearningProposal
 * @author professor
 */
public class LearningState {


    private Student student;
    private LearningProposalActivity learningProposalActivity = null;  
    
    //attempts information of learningProposalActivity and its subactivities;
    //key is the <i>Attempts</i> identificator
//    private Map<String,Attempts> attemptsMap= Collections.synchronizedMap(new HashMap<>()); 
    private Activity currentActivity=null;






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

////    /**
////     * Get the value of attemptsMap
////     * @return the value of attemptsMap
////     */
////    
////    public Map<String,Attempts> getAttemptsMap() {
////        return attemptsMap;
////    }
////
////    /**
////     * Set the value of attemptsMap. <b>Dont't use.</b> Only for compatibility purposes.
////     * @param attemptsMap new value of attemptsMap
////     */
////    
////    public void setAttemptsMap(Map<String,Attempts> attemptsMap) {
////        this.attemptsMap = attemptsMap;
////    }
    
////    /**
////     * get the attempts of activity
////     * @param activity the Activity of wich the attempts are got
////     * @return attempts corresponding to activity
//// if there's no attempt of activity, returns an attempts object with no attempt
////     */
////    
////    public Attempts getActivityAttempts(Activity activity){
////        Attempts res=attemptsMap.get(activity.getName());
////        if(res==null){
////            res=new Attempts();
////            res.setActivity(activity);
////        }
////        return res;
////    }

   /**
     * Get the value of learningProposalActivity
     *
     * @return the value of learningProposalActivity
     */
    public LearningProposalActivity getLearningProposalActivity() {
        return learningProposalActivity;
    }

    /**
     * Set the value of learningProposalActivity
     *
     * @param learningProposalActivity new value of learningProposalActivity
     */
    public void setLearningProposalActivity(LearningProposalActivity learningProposalActivity) {
        this.learningProposalActivity = learningProposalActivity;
    }


    /**
     * get currentActivity
     * @return value of currentActivity
     */
    public Activity getCurrentActivity() {
        return currentActivity;
    }

    /**
     * set lastAttmpt. <b>Don't use.</b> Only for compatibility purposes.
     * @param currentActivity  new value of currentActivity
     */
    public void setCurrentActivity(Activity currentActivity) {
        this.currentActivity = currentActivity;
    }

    

///////////// end of accessors
    
////    /**
////     * adds an attempt corresponding to activity
////     * @param activity to wich attempt belongs
////     * @param attempt of activity to be added
////     */
////    public void addActivityAttempt(Activity activity,Attempt attempt){
////        
////        if(activity.rootActivity()!=learningProposalActivity){
////            throw new LearningStructureError(Messages.BAD_HIERARCHY);
////        }
////        
////        String activityName=activity.getName();
////        
////        Attempts attempts=attemptsMap.get(activityName);
////        
////        if(attempts==null){
////            attempts=new Attempts();
////            attempts.setActivity(activity);
////        }
////        attempts.addAttempt(attempt);
////        attemptsMap.put(activityName, attempts);
////        currentActivity=attempts;
////        
////    }
////
////    public boolean isRootActivityFinished(){
////        return isActivityFinished(learningProposalActivity);
////    }
////
////    public boolean isActivityFinished(Activity t){
////
////        if(t.rootActivity()!=learningProposalActivity){
////            throw new LearningStructureError(Messages.BAD_HIERARCHY);
////        }
////
////        Attempts a=attemptsMap.get(t.getName());
////        
////        if(a==null) return false;
////        else{
////            return a.finishedAttemptsList().size()>= t.getMaxAttempts();
////        }
////        
////    }



    
}
