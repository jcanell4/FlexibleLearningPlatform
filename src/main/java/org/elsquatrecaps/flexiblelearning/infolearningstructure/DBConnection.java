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
