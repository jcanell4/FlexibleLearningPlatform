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
 *
 * @author professor
 */
public class DBConnection {
    private static Map<String,Student> students =Collections.synchronizedMap(new HashMap<>());
    private static Map<String,LearningState> states=Collections.synchronizedMap(new HashMap<>());
    
    static {
        Student s= new Student();
        s.setId("1");
        s.setName("Primer");
        
        SimpleTask t=new SimpleTask();
        
        t.setName("primeratasca");
        
        t.setDescription("Primera tasca");
        
        
        s.subscribeTask(t);
        
        t=new SimpleTask();
        
        t.setName("segonatasca");
        
        t.setDescription("Segona tasca");

        s.subscribeTask(t);        
        
        
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
    

}
