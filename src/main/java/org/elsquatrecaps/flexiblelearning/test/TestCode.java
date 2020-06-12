/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.elsquatrecaps.flexiblelearning.test;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.activity.CodeActivity;
import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.activity.EditorActivity;
import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.activity.interactivetools.CodeEditor;
import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.common.ActionDialogButton;
import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.common.Dialog;
import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.common.LearningProposal;
import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.nav.NavComponents;
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
public class TestCode extends CommonTest{
    
     public static ModelAndView startAct(){
        ModelAndView ret = new ModelAndView("pl_code_act");
        NavComponents navComponents = getNavComponents();
        LearningProposal learningProposal = new LearningProposal("code");
        EditorActivity<CodeEditor> activity = new EditorActivity(new CodeEditor());

        navComponents.setLearningProposalName("Mira el món, tot ès codi!");
        ret.addObject("navComponents", navComponents);
        
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
        
        ret.addObject("activity", activity);
        ret.addObject("learningProposal", learningProposal);
        return ret;
    }
     
    public static ModelAndView nextClue(int nextClue){
        String[] pistes = {"No sé què dir-te ..."};
        ModelAndView ret = new ModelAndView("pl_code_act :: clueDataGroup");
        CodeActivity activity = new CodeActivity();
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
    

    public static ModelAndView sendActivity(String editor){
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
        String[] pistes = {"No sé què dir-te...."};
        ResponseTimer ret = null;        
        int nextClue=0;
        ThymeLeafTemplate thymeLeafTemplate = new ThymeLeafTemplate("pl_code_act", "clueDataGroup", templateEngine);
        CodeActivity activity = new CodeActivity();
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
            nextClue=pistes.length-1;
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
