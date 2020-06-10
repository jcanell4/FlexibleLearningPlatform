/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.elsquatrecaps.flexiblelearning.infolearningstructure;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Just for testing
 * @author professor
 */
@Controller
public class ControllerSelect {

    
    @RequestMapping(value="/select/{idStudent}", method=RequestMethod.GET)
    public ModelAndView startBaseAct(@PathVariable String idStudent){
        
        
        LearningState[] states=Starter.getFinishedLearningStates(idStudent);

        ModelAndView ret = new ModelAndView("pl_select");

        ret.addObject("states", states);

        return ret;
    }
    
    
}
