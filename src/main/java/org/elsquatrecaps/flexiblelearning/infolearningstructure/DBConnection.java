/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.elsquatrecaps.flexiblelearning.infolearningstructure;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.activity.EditorActivity;
import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.activity.WritingActivity;
import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.activity.interactivetools.CodeEditor;
import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.common.LearningProposal;
import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.nav.ItemResource;
import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.nav.NavComponents;
import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.nav.ProgressBarNode;
import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.nav.ProgressBarState;
import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.nav.VideoResource;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

/**
 * Mock database server connection
 * @author professor
 */
public class DBConnection {

    private static LearningProposal lp= new LearningProposal();
    private static ResponseAction sendResponse= new ResponseAction(){
        @Override
        public void action(ModelMap modelMap, Student student, LearningProposal learningProposal, LearningProposalActivity lpActivity, Attempt attempt, Activity activity) {
            attempt.setEndLocalDateTime(LocalDateTime.now());
        }
        
    };
    
    private static class DoubleKey<F,S>{
        
        private F first;

        private S second;

        public DoubleKey() {
        }

        public DoubleKey(F first, S second) {
            this.first = first;
            this.second = second;
        }

        /**
         * Get the value of second
         *
         * @return the value of second
         */
        public S getSecond() {
            return second;
        }

        /**
         * Set the value of second
         *
         * @param second new value of second
         */
        public void setSecond(S second) {
            this.second = second;
        }

        /**
         * Get the value of first
         *
         * @return the value of first
         */
        public F getFirst() {
            return first;
        }

        /**
         * Set the value of first
         *
         * @param first new value of first
         */
        public void setFirst(F first) {
            this.first = first;
        }

        @Override
        public boolean equals(Object obj) {
            DoubleKey a=this, b;
            b=(DoubleKey)obj;
            
            return (a.getFirst().equals(b.getFirst()) && a.getSecond().equals(b.getSecond()));
        }

    }
    
    private static Map<String,Student> students =Collections.synchronizedMap(new HashMap<>());
    private static Map<String,Activity> activities =Collections.synchronizedMap(new HashMap<>());
    private static Map<String,LearningState> states=Collections.synchronizedMap(new HashMap<>());
    private static Map<String,Attempts> attemptsSet=Collections.synchronizedMap(new HashMap<>());

/// Nomes per debug v
    public static Map<String, Student> getStudents() {
        return students;
    }

    public static Map<String, Activity> getActivities() {
        return activities;
    }

    public static Map<String, LearningState> getStates() {
        return states;
    }

    public static Map<String, Attempts> getAttemptsSet() {
        return attemptsSet;
    }
    
/// Només per debug ^
    
    static {
        
        
        
        
        lp.setId("LP1");
        lp.setDescription("LP 1");
        
        Student s1= new Student(), s2=new Student();
        s1.setId("ST1"); s2.setId("ST2");
        s1.setName("Primer"); s2.setName("Segon");
 
        LearningProposalActivity lpa=new LearningProposalActivity(){
            @Override
            public void loadAction(Student student, LearningProposal learningProposal, LearningProposalActivity lpActivity, Attempt attempt, Activity activity) {
                updateProgressBarState(student, activity); 
            }
        };
        
        lpa.setName("ProvaLearningProposal");
        lpa.setDescription("Activitat arrel");
        lpa.setType("base");   // falta afegir-li els objectes i startAction
        lpa.setLearningProposal(lp);
        
        
        Activity sa1=new SimpleActivity(){
            @Override
            public void loadAction(Student student, LearningProposal learningProposal, LearningProposalActivity lpActivity, Attempt attempt, Activity activity) {
                updateProgressBarState(student, activity); 
            }
        };
        
        Activity sa2=new SimpleActivity(){
            @Override
            public void loadAction(Student student, LearningProposal learningProposal, LearningProposalActivity lpActivity, Attempt attempt, Activity activity) {
                updateProgressBarState(student, activity); 
            }
        };
       
        fillFirstActivity(sa1);
        fillSecondActivity(sa2);
        fillThirdActivity(lpa);
        
        sa1.setName("PrimeraFilla"); sa1.setDescription("Primera filla"); lpa.addChildrenAtTheEnd(sa1);
        
        sa2.setName("SegonaFilla"); sa2.setDescription("Segona filla"); lpa.addChildrenAtTheEnd(sa2);

        LearningState ls=new LearningState();
        
        ls.setCurrentActivity(sa1);
        ls.setLearningProposalActivity(lpa);
        ls.setStudent(s1);
        
        Attempts atts= new Attempts();
          
        atts.setActivity(sa1);
        atts.setStudent(s1);
 
        Attempt at = new Attempt();

        Status stat = new Status();
        stat.setTime(LocalDateTime.now().minusDays(2));
        at.setStartLocalDateTime(stat.getTime());
        at.setStatus(stat);
        atts.getAttempts().add(at);
        

        add(s1);
        add(s2);
        add(lpa);
        add(sa1);
        add(sa2);
        add(ls);
        add(atts);

        
//        lpa.setDescription(description);
//        lpa.setLearningProposal(learningProposal);
//        lpa.setMaxAttempts(0);
//        lpa.setMembers(members);
//        lpa.setMiddleAction(middleAction);
//        lpa.setName(name);
//        lpa.setObjects(objects);
//        lpa.setParentActivity(lpa);
//        lpa.setScoreScheme(scoreScheme);
//        lpa.setStartAction(startAction);
//        lpa.setSubmitAction(submitAction);
//        lpa.setType(type);
        
        
        
    }
    
    public static void add(Student s){
        students.put(s.getId(), s);
    }
    
//    public static void add(LearningState ls){
//        states.put(ls.getIdStudent(), ls);
//    }
    
    public static Student getStudent(String id){
        return students.get(id);
    }
    
//    public static LearningState getLearningState(String idStudent){
//        return states.get(idStudent);
//    }
    
    public static void add(Activity a){
        activities.put(a.getName(), a);
    }
    
    public static Activity getActivity(String name){
        return activities.get(name);
    }
    
    
    public static void add(Attempts a){
        attemptsSet.put(a.getActivity().getName()+"\0"+a.getStudent().getId(),a);
    }
    
    public static Attempts getAttempts(String activityName, String idStudent){
        return attemptsSet.get(activityName+"\0"+idStudent);
    }
    
    
    public static void add(LearningState ls){
        states.put(ls.getStudent().getId()+"\0"+ls.getLearningProposalActivity().getName(),ls);
    }
    
    public static LearningState getLearningState(String idStudent, String activityName){
        return states.get(idStudent+"\0"+activityName);
    }
    

    
    ////// initialization methods:
    private static void fillFirstActivity(Activity sa) {

        

        
        sa.setType("writing");
        
        

        
        EditorActivity activity = new WritingActivity();

       
        activity.setStatement("Un cop fets els exercicis pervia, ha arribat el moment de fer la teva pròpia creació. Un conte brea a l'estil Calderessià. En primer lloc ...");
        activity.getEditor().setFontsize(24);
        
        sa.getObjects().add(new NamedObject("activity",activity));
        sa.getActions().put("send",sendResponse );

    }

    private static void fillSecondActivity(Activity sa) {

        sa.setType("code");
        
        
        EditorActivity<CodeEditor> activity = new EditorActivity(new CodeEditor());

        
        activity.setStatement("Volem fer un algoritme que cerqui si una llista de valors enters conté el valor 19");
        activity.getInstructions().add("Assigna a la variable <i>a_trobar</i> el valor 19, que desitgem cercar.");
        activity.getInstructions().add("Inicialitza la variable <i>pos</i> tenint en compte que indicarà la posició de lectura de la llista durant la cerca.");
        activity.getInstructions().add("Inicialitza la resta de variables que necessitaràs per fer la cerca.");
        activity.getInstructions().add("Posa la condició de sortida del bucle.");
        activity.getInstructions().add("Marca la variable <i>trobat</i> en funció de si hi ha algun element de l'array que coincideix amb el valor de la variable <i>a_trobar</i>.");
        activity.getInstructions().add("Mostra per pantalla el resultat de la cerca.");        
        activity.getEditor().setFontsize(14);
        activity.getEditor().setMode("python");
        activity.getEditor().setDefaultText("values=[10, 20, 4, 7, 2, 19, 26, 1, 17, 0, 3, 21]\n\n"
                + "a_trobar = ____\n"
                + "pos = ____\n"
                + "____ =  ____\n"
                + "____ =  ____\n"
                + "while _______:\n"
                + "   trobat = values[pos]==a_trobar\n"
                + "   pos = pos + 1\n\n"
                + "_____"
                + "");
        

        sa.getObjects().add(new NamedObject("activity",activity));
        
        sa.getActions().put("send",sendResponse );
        
    }

    private static void fillThirdActivity(LearningProposalActivity lpa) {
        lpa.setType("base");
        NavComponents navComponents = new NavComponents();
        
        navComponents.setInfoText(lpa.getName());
	navComponents.setSummary(lpa.getDescription()); 
        
	navComponents.setVideo(new VideoResource("https://www.youtube.com/embed/u79dkQxuSv4", "thymeleaf"));

        navComponents.addRelatedResource(new ItemResource("url/recurs.1", "Recurs 1"));
        navComponents.addRelatedResource(new ItemResource("url/recurs.2", "Recurs 2"));
        navComponents.addRelatedResource(new ItemResource("url/recurs.3", "Recurs 3"));

        navComponents.setLearningProposalName(lpa.getLearningProposal().getDescription());
        
        lpa.getObjects().add(new NamedObject("navComponents",navComponents));
        lpa.getObjects().add(new NamedObject("learningProposal",lpa.getLearningProposal()));
        lpa.getActions().put("send",sendResponse );
    }
    
    private static void updateProgressBarState(Student student, Activity activity) {
        
        NavComponents nav =(NavComponents) activity.objects.floor(new NamedObject("navComponents",null)).getObject();
        
        
        if(nav==null) return;

        ActivityCategory ac;
        
        if(activity instanceof ActivityCategory) {
            ac=(ActivityCategory) activity;
        }
        else {
            ac=activity.parentActivity;
        }
        
        List<Activity> members=ac.getMembers();
        List<ProgressBarNode> nodesList=nav.getProgressBarNodes();
        
        for(int i=0; i<members.size();i++){
            Attempts atts=getAttempts(ac.getName(),student.getId());
            if(nodesList.size()-1<i){
                    nodesList.add(new ProgressBarNode(members.get(i).getName(),members.get(i).getDescription()));
            }
            if(atts==null || atts.getAttempts().isEmpty()){
                nodesList.get(i).setState(ProgressBarState.TODO);
            }else{
                Attempt att=atts.getAttempts().get(atts.getAttempts().size()-1);
                if(att.getEndLocalDateTime()!=null){
                    nodesList.get(i).setState(ProgressBarState.DONE);
                } else{
                    nodesList.get(i).setState(ProgressBarState.ACTIVE);
                }
            }    
                    
        }
     
    }
    
}
