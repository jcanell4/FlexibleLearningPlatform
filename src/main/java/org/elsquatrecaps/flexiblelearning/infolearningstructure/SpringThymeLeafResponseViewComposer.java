/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.elsquatrecaps.flexiblelearning.infolearningstructure;

import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author professor
 */
public class SpringThymeLeafResponseViewComposer implements ResponseViewComposer{

    @Override
    public Object getResponseView(Student s, Attempt a, Task t) {
       ModelAndView ret = new ModelAndView("pl_"+t.getName().toLowerCase());
       
       ret.addObject("Student",s);
       ret.addObject("Attempt",a);
       for(NamedObject no:t.getObjects()){
           ret.addObject(no.getName(),no.getObject());
       }
       return ret;
    }

    @Override
    public Object doSubmitAction(Student s, Attempt a, Task t) {
        return t.getSubmitAction().apply(new Object[]{s,a,t});
    }

    @Override
    public Object doMiddleAction(Student s, Attempt a, Task t) {
        return t.getMiddleAction().apply(new Object[]{s,a,t});
    }
    
}
