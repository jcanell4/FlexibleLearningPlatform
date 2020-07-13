package org.elsquatrecaps.flexiblelearning.test;

import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.nav.NavComponents;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController{
    
    public TestController() {
    }
    
    @RequestMapping("/")
    public String startAct(){
        return "redirect:/base";
    }
    
    @RequestMapping("/base")
    public ModelAndView startBaseAct(){
        NavComponents navComponents = CommonTest.getNavComponents();
        ModelAndView ret = new ModelAndView("pl_base_act");
        ret.addObject("navComponents", navComponents);
        return ret;
    }
    
    @RequestMapping("/writing")
    public ModelAndView startWritingAct(){
        return TestWriting.startAct();
    }
    
    @RequestMapping("/code")
    public ModelAndView startCodeAct(){
        return TestCode.startAct();
    }
    
    @RequestMapping("/nextClue")
    public ModelAndView nextClue(@RequestParam int nextClue, @RequestParam String lp_id){
        ModelAndView ret;
        switch(lp_id){
            case "writing":
                ret = TestWriting.nextClue(nextClue);
                break;
            case "code":
                ret = TestCode.nextClue(nextClue);
                break;
            default:
                throw new RuntimeException("No es reconeix l'identificador de la proposta d'aprenentatge");
        }
        return ret;
    }
    
    @RequestMapping("/sendActivity")
    public ModelAndView sendActivity(@RequestParam String editor, @RequestParam String lp_id){
        ModelAndView ret;
        switch(lp_id){
            case "writing":
                ret = TestWriting.sendActivity(editor);
                break;
            case "code":
                ret = TestCode.sendActivity(editor);
                break;
            default:
                throw new RuntimeException("No es reconeix l'identificador de la proposta d'aprenentatge");
        }
        return ret;
    }
}
