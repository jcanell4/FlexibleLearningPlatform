/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.elsquatrecaps.flexiblelearning.responses;

import org.elsquatrecaps.flexiblelearning.responses.Actor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Just for testing
 * @author professor
 */
@Controller
public class FlexibleController {

    
    @RequestMapping(value="/start", method=RequestMethod.GET)
    public ModelAndView startAction(@RequestParam(value = "idStudent") String idStudent, @RequestParam(value = "idActivity") String idLearningProposalActivity) {
        return Starter.startAct(idStudent, idLearningProposalActivity);
    }
    
    @RequestMapping(value="/next")
    public ModelAndView nextAction(@RequestParam(value = "idStudent") String idStudent, @RequestParam(value = "idActivity") String idActivity) {
        return Navigator.nextAct(idStudent, idActivity);
    }
    
    @RequestMapping(value="/prev")
    public ModelAndView prevAction(@RequestParam(value = "idStudent") String idStudent, @RequestParam(value = "idActivity") String idActivity) {
        return Navigator.prevAct(idStudent, idActivity);
    }

    @RequestMapping(value="/refresh")
    public ModelAndView refreshAction(@RequestParam(value = "idStudent") String idStudent, @RequestParam(value = "idActivity") String idActivity) {
        return Navigator.refreshAct(idStudent, idActivity);
    }
    
    @RequestMapping(value="/do")
    public ModelAndView doAction(ModelMap modelMap, @RequestParam(value = "idStudent") String idStudent, @RequestParam(value = "idActivity") String idActivity, @RequestParam(value="action") String action) {
        return Actor.doAct(modelMap,idStudent, idActivity, action);
    }

    
    
}
