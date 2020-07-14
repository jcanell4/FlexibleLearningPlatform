package org.elsquatrecaps.flexiblelearning.state;

import org.elsquatrecaps.flexiblelearning.activity.LearningProposalActivity;
import org.elsquatrecaps.flexiblelearning.activity.Activity;

/**
 *              1.- Amb l'ID de l'estudiant hauria de recuperar el learningState de l'estudiant, corresponent a la learningProposal sol·licitada. El learning state hauria de contenir
         el currentAttempt i tots els FinishedAttempts de les activitats ja realitzades.
         El currentAttempt hauria de contenir com a mínim les següents dades:
            - Id de l'activitat (activity/task o com vulguis dir-li) en al que es troba l'estudiant en la proposta d'aprenentatge (learningProposal equivalent 
              al que anomenavem activitat nuclear) indicada. 
            - Dades de l'estat de l'activitat atribuibles a l'estudiant. Ésa  dir coses que l'estudiant ha fet a l'activitat:
                - Respostes escrites (aquest punt és la informació mínima nexessaria i obligatòria per a totes les activitats interactives com les que estem implementant)
                - Altres dades opcionals depenent del tipus d'activitat:
                    - Recursos consultats per l'estudiant fins el moment
                    - Enllaços a favorits si l'activitat ho suporta
                    - Anotacions de l'estudiant si l'activitat ho suporta
                    - Elements de feedback enviats a l'estudiant fins el moment, com per exemplee quantes i/o quines pistes se li han donat, quines 
                        preguntes o aclariments ha demanat l'estudiat amb les seves respostes si n'hi han (si l'activitat permet fer preguntes o aclariments), etc.
                    - etc.                    
                  (Jo de moment només hi posaria les pistes i més endavant ja veuríem)
         Els finishedAttempts haurien de ser accessibles per cada activitat associada (indexació per activitat), i en cas de guardar tots els intents que s'hi accedeixi en ordre invers (pila). Aquests 
         harien de contenir com a mínim les notes (score). però podriem decidir afegir-hi la informació dels currentAttempt total o parcialment.  Aquest procés (passar de currentAttempt a 
         finishedAttem es faria de forma automatitzada en acabar una activitat.

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
