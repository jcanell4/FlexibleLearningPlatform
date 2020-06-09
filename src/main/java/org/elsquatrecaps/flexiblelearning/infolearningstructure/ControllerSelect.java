/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.elsquatrecaps.flexiblelearning.infolearningstructure;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author professor
 */
@Controller
public class ControllerSelect {

    
    @RequestMapping("/select")
    public ModelAndView startBaseAct(){
        String[] continents = {
          "Africa", "Antarctica", "Asia", "Australia", 
          "Europe", "North America", "Sourth America"
        };
        
        ModelAndView ret = new ModelAndView("pl_select");

        
        ret.addObject("continents", continents);
        return ret;
    }
    
    
}
