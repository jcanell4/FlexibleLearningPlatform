/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.elsquatrecaps.flexiblelearning.test;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.activity.Activity;
import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.common.ActionDialogButton;
import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.common.Dialog;
import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.timerdata.CallableJavascript;
import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.timerdata.ResponseTimer;
import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.timerdata.Timer;
import org.elsquatrecaps.thymeleaf.ThymeLeafTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.TemplateEngine;

/**
 *
 * @author josep
 */
public class TestWriting {
    public static ModelAndView nextClue(int nextClue){
        String[] pistes = {
                "En primer lloc hauries d'escriure el títol relacionat amb el tema que vulgus tractar. Escriu el títol si us plau.", 
                "Un cop has pensat el títol haries d'escriure un primer paràgraf amb la intenció de presentar el relat de foma general posant el focus... ",
                "Ara caldrà que ....",
                "Finalment haràs d'escriure el desenllaç. Intenta que sigui inesperat. Busca de nou en tot l'argument... "
        };
        ModelAndView ret = new ModelAndView("pl_writing_act :: clueDataGroup");
        Activity activity = new Activity();
        if(nextClue<pistes.length){
            activity.getCurrentClue().setContent(String.format("<h3>Pista %d</h3><p>%s</p>", nextClue+1, pistes[nextClue]));
            nextClue++;
        }else{
            activity.getCurrentClue().setContent(String.format("<h3>Ho sentim</h3><p>%s</p>",
                    "Però ja no tenim més pistes. Si ho necessites pots posar-te en contan¡cte amb el teu professor"));
            nextClue=pistes.length+1;
        }
       
        
        activity.getCurrentClue().setId(nextClue);
        
        ret.addObject("activity", activity);
        ret.addObject("infoMessage", String.format("Heu obtingut la pista n. %d", nextClue));
        return ret;
    }
    

    public static ModelAndView sendWriting(String editor){
        ModelAndView ret = new ModelAndView("pl_dialogs_act :: dialogBaseCenter");
        ret.addObject("onclick", "mainObject.runActionButton");
        Dialog dialog = new Dialog("LLiurament enviat amb èxit", false);
        dialog.getMessage().add("Enhorabona! El teu escrit ha estat enviat amb èxit. Quan estigui corregit rebràs una "
                + "notificació i podràs consultar la retroacció i la qualificació.");
        dialog.getMessage().add("Escull una opció per continuar.");
        dialog.getButtons().add(new ActionDialogButton("nextActivity", "Començar una nova activitat", true));
        dialog.getButtons().add(new ActionDialogButton("toHomePage", "Sortir i tornar a l'aula", true));
        ret.addObject("dialog", dialog);
        return ret;
    }
    
    public static ResponseTimer autoFeedback(String editor, int counter, int timeLapsed, String lp_id, TemplateEngine templateEngine){
        String[] pistes = {
                "En primer lloc hauries d'escriure el títol relacionat amb el tema que vulgus tractar. Escriu el títol si us plau.", 
                "Molt bé, ja has posat el títol. Ara hauries d'escriure un primer paràgraf amb la intenció de presentar el relat de foma general posant el focus... ",
                "Ara caldrà que ....",
                "Finalment haràs d'escriure el desenllaç. Intenta que sigui inesperat. Busca de nou en tot l'argument... "
        };
        ResponseTimer ret = null;        
        int nextClue=0;
        ThymeLeafTemplate thymeLeafTemplate = new ThymeLeafTemplate("pl_writing_act", "clueDataGroup", templateEngine);
        Activity activity = new Activity();
        CallableJavascript c = new CallableJavascript();

        if(editor.isEmpty()){
            nextClue = 0;
        }else{
            Pattern pattern = Pattern.compile("([^\n]*)\n");
            Matcher matcher = pattern.matcher(editor);
            while (matcher.find()) {
                if(!matcher.group(1).isEmpty()){
                    nextClue++;
                }
            }
        }
        if(nextClue>=pistes.length){
            nextClue=pistes.length;
        }

        activity.getCurrentClue().setContent(String.format("<h3>Pista %d</h3><p>%s</p>", nextClue+1, pistes[nextClue]));
        activity.getCurrentClue().setId(nextClue+1);
        thymeLeafTemplate.addObject("activity", activity);

        c.setName("showTimerClue");
        c.setParams(new HashMap<>());


        c.getParams().put("fragment", thymeLeafTemplate.buildContent());
        c.getParams().put("nextId", nextClue+1);
        if(nextClue<pistes.length){
            ret = new ResponseTimer(c, new Timer(timeLapsed, "autoTimerFeedback"));
        }else{
            ret = new ResponseTimer(c);
        }
        
        return ret;
    }    
}
