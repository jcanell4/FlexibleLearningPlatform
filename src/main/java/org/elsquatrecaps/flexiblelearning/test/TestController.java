package org.elsquatrecaps.flexiblelearning.test;

import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.activity.Activity;
import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.nav.NavComponents;
import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.nav.ItemResource;
import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.nav.ProgressBarNode;
import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.nav.ProgressBarState;
import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.nav.VideoResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController{
    
    public TestController() {
    }
    
    private NavComponents getNavComponents(){
        NavComponents navComponents = new NavComponents();
        
        navComponents.setInfoText(
"                <h3>infoooooo</h3> \n" +
"                <p>Lorem ipsum dolor sit amet. Et minus minima sit voluptatibus repudiandae sed ipsam voluptatem sed similique ratione quaerat vero qui quis molestiae vel corrupti internos! Eos quia ipsam quo reprehenderit impedit quo praesentium odit ex debitis galisum est deserunt ipsa est quibusdam dignissimos eum consequuntur dignissimos. Et repellendus voluptatem sed dolorem facere et omnis rerum aut exercitationem quia ut facilis beatae.</p>\n" +
"                <p>Ut quod porro sed optio rem culpa voluptatum in distinctio sunt et quae praesentium. Et dolor rerum ab nobis iure est quas minus At pariatur nihil non accusamus nisi 33 ipsam earum et fuga quam? Aut sequi velit aut suscipit consequatur id ipsa enim quo quis sequi.</p>\n" +
"                <p>Et quia eaque ea ipsa voluptas ut commodi nemo in culpa reprehenderit nam dolor omnis eum veniam voluptatem. Sed vitae quia et laborum obcaecati sit voluptatum illum et nobis officiis.</p>\n" +
"                <p>Ut perspiciatis iste aut laborum iste est autem recusandae. Et fuga molestiae quo eveniet blanditiis qui harum reiciendis ut nostrum corrupti ut magnam reiciendis ut omnis exercitationem est nostrum sapiente. Ut quae aperiam sed distinctio quaerat ut fuga excepturi qui autem pariatur hic porro voluptatem sed tempora pariatur aut exercitationem laborum. Aut totam illum id harum iste vel quia harum et provident vitae.</p>\n" +
"                <p>Aut ipsa perferendis et saepe sint non quia voluptates nam vero quas. Ad perferendis adipisci qui eius velit aut enim sint ea veritatis alias sit vitae ratione aut sint sunt et omnis rerum? Qui vero quibusdam aut quae quod est omnis autem sed praesentium soluta et magni animi.</p>\n" +
"                <p>Ea illum pariatur ut odio praesentium qui corrupti magnam non aperiam earum. In galisum consequatur et quibusdam odio aut debitis possimus 33 cupiditate praesentium est nihil consequatur. A earum perferendis qui voluptatem atque quo sequi unde id cumque perferendis. Ab magni exercitationem officiis accusantium sit consequatur saepe.</p>\n" +
"");
        navComponents.setSummary("<div class=\"d-flex flex-column w-100\">\n" +
"                    <div class=\"d-flex\">\n" +
"                        <div class=\"border flex-fill container containerCell\" style=\"width:16%;\">\n" +
"                            <ul>\n" +
"                                <li>Bla bla bla</li>\n" +
"                                <li>Bla bla blablabla</li>\n" +
"                                <li>Bla blabla blabla</li>\n" +
"                                <li>Blablabla bla blabla blabla</li>\n" +
"                                <li>Blabla blablabla blabla</li>\n" +
"                            </ul>\n" +
"                        </div>\n" +
"                        <div class=\"d-flex flex-column flex-fill\" style=\"width:32%;\">\n" +
"                            <div class=\"border container containerCell\">\n" +
"                                <img src=\"http://evc-cit.info/cit042/examples/formulas.png\" width=\"100%\">\n" +
"                            </div>\n" +
"                            <div class=\"border container containerCell\">\n" +
"                                <img src=\"http://cs.wellesley.edu/~rds/rds05/projects/grendel/head.jpg\" width=\"100%\">\n" +
"                            </div>  \n" +
"                        </div>\n" +
"                        <div class=\"border d-flex flex-column flex-fill\" style=\"width:52%;\">\n" +
"                            <div class=\"border flex-fill container containerCell\">\n" +
"                                <img src=\"https://collaboration.cmc.ec.gc.ca/science/rpn/gem/gem-climate/Version_3.2.1/Flux_diagram.png\" width=\"100%\">\n" +
"                            </div>\n" +
"                            <div class=\"border flex-fill container containerCell\">\n" +
"                                <h2> Aaa  a a a</h2>\n" +
"                                <p>hdjkh dh jhjkh kdhask dhsk hsajkhd jksahdjkashk hjakh djksah dsahkj hsdajkhjaskh jsak.</p>\n" +
"\n" +
"                            \n" +
"                            </div>\n" +
"                        </div>\n" +
"                    </div>\n" +
"                    <div class=\"d-flex h-100\"> \n" +
"                        <div class=\"border flex-fill container containerCell\" style=\"width:50%;\">Flex item 2</div>\n" +
"                        <div class=\"border flex-fill container containerCell\" style=\"width:50%;\">Flex item 3</div>\n" +
"                    </div>\n" +
"                </div>  ");
        navComponents.setVideo(new VideoResource("https://www.youtube.com/embed/u79dkQxuSv4", "thymeleaf"));
        navComponents.addRelatedResource(new ItemResource("url/recurs.1", "Recurs 1"));
        navComponents.addRelatedResource(new ItemResource("url/recurs.2", "Recurs 2"));
        navComponents.addRelatedResource(new ItemResource("url/recurs.3", "Recurs 3"));
        for(int i=1; i<=4; i++){
            navComponents.addProgressBarNode(new ProgressBarNode(i, String.format("Exercici %1d", i), ProgressBarState.DONE));
        }
        navComponents.addProgressBarNode(new ProgressBarNode(5, "Exercici 5", ProgressBarState.ACTIVE));
        for(int i=6; i<=10; i++){
            navComponents.addProgressBarNode(new ProgressBarNode(i, String.format("Exercici %1d", i), ProgressBarState.TODO));
        }
        navComponents.setLearningProposalName("Mira el món! Sents la vida?");
        
        return navComponents;
    }
    
    
    /*COMENTARI DE PROVA*/
    @RequestMapping("/")
    public String startAct(){
        return "redirect:/base";
    }
    
    @RequestMapping("/base")
    public ModelAndView startBaseAct(){
        NavComponents navComponents = this.getNavComponents();
        ModelAndView ret = new ModelAndView("pl_base_act");
        ret.addObject("navComponents", navComponents);
        return ret;
    }
    
    @RequestMapping("/writing")
    public ModelAndView startWritingAct(){
        ModelAndView ret = new ModelAndView("pl_writing_act");
        NavComponents navComponents = this.getNavComponents();
        Activity activity = new Activity();

        navComponents.setLearningProposalName("LLegeix el món, escriu contes!");
        ret.addObject("navComponents", navComponents);
        
        activity.setStatement("Un cop fets els exercicis pervia, ha arribat el moment de fer la teva pròpia creació. Un conte brea a l'estil Calderessià. En primer lloc ...");
        activity.getEditor().setFontsize(24);
        
        ret.addObject("activity", activity);
        return ret;
    }
    
    @RequestMapping("/nextClue")
    public ModelAndView nextClue(@RequestParam int nextClue){
        String[] pistes = {
                "En primer lloc hauries d'escriure el títol relacionat amb el tema que vulgus tractar. Escriu el títol si us plau.", 
                "Un cop has pensat el títol haries d'escriure un primer paràgraf amb la intenció de presentar el relat de foma general posant el focus... ",
                "Ara cadrà que ....",
                "Finalment haràs d'escriure el desenllaç. Intenta que sigui inesperat. Busca de nou en tot l'argument... "
        };
        ModelAndView ret = new ModelAndView("pl_writing_act :: clueDataGroup");
        Activity activity = new Activity();
        if(nextClue<pistes.length){
            activity.getCurrentClue().setContent(String.format("<h3>Pista %d</h3><p>%s</p>", nextClue, pistes[nextClue]));
        }else{
            activity.getCurrentClue().setContent(String.format("<h3>Ho sentim</h3><p>%s</p>",
                    "Però ja no tenim més pistes. Si ho necessites pots posar-te en contan¡cte amb el teu professor"));
        }
        nextClue++;
        
        activity.getCurrentClue().setId(nextClue);
        
        ret.addObject("activity", activity);
        return ret;
    }
}
