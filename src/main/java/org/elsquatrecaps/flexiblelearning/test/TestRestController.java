package org.elsquatrecaps.flexiblelearning.test;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.activity.Activity;
import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.timerdata.CallableJavascript;
import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.timerdata.ResponseTimer;
import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.timerdata.Timer;
import org.elsquatrecaps.thymeleaf.ThymeLeafTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;

/**
 *
 * @author josep
 */
@RestController
public class TestRestController {
    @Autowired
    private TemplateEngine templateEngine;
    
//    @RequestMapping("/autoFeedback")
//    public ResponseTimer autoFeedback(@RequestParam String editor, @RequestParam int counter){
//        ResponseTimer ret = null;
//        if(counter<10){
//            ret = new ResponseTimer(new Timer(5000, "autoFeedback"));
//        }else if(counter==10){
//            CallableJavascript c = new CallableJavascript();
//            c.setName("showTimerClue");
//            c.setParams(new HashMap<>());
//            c.getParams().put("editor", editor);
//            ret = new ResponseTimer(c, new Timer(5000, "autoFeedback"));
//        }else if(counter<20){
//            ret = new ResponseTimer(new Timer(1000, "autoFeedback"));
//        }else{
//            CallableJavascript c = new CallableJavascript();
//            c.setName("showTimerClue");
//            c.setParams(new HashMap<>());
//            c.getParams().put("editor", editor);
//            c.getParams().put("id", counter);
//            ret = new ResponseTimer(c);
//        }
//        return ret;
//    }    
    
    @RequestMapping("/autoTimerFeedback")
    public ResponseTimer autoFeedback(@RequestParam String editor, @RequestParam int counter, @RequestParam int timeLapsed){
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
