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
    
    @RequestMapping("/autoTimerFeedback")
    public ResponseTimer autoFeedback(@RequestParam String editor, @RequestParam int counter, @RequestParam int timeLapsed, @RequestParam String lp_id){
        ResponseTimer ret = null;        
        switch(lp_id){
            case "writing":
                ret = TestWriting.autoFeedback(editor, counter, timeLapsed, lp_id, templateEngine);
                break;
            case "code":
                ret = TestCode.autoFeedback(editor, counter, timeLapsed, lp_id, templateEngine);
                break;
            default:
                throw new RuntimeException("No es reconeix l'identificador de la proposta d'aprenentatge");
        }
        
        return ret;
    }    
}
