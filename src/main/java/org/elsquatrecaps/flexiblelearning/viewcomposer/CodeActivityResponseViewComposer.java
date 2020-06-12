/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.elsquatrecaps.flexiblelearning.viewcomposer;

import static org.elsquatrecaps.flexiblelearning.test.CommonTest.getNavComponents;
import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.activity.EditorActivity;
import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.activity.interactivetools.CodeEditor;
import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.common.LearningProposal;
import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.nav.NavComponents;
import org.springframework.web.servlet.ModelAndView;
import org.elsquatrecaps.flexiblelearning.viewcomposer.data.ResponseViewConfigData;

/**
 *
 * @author josep
 */
public class CodeActivityResponseViewComposer extends AbstractResponseViewComposer /*implements ResponseViewComposer*/{ //no implemento ResponseViewComposer per poder configurar els  mètodes i paràmteres tal com crec que ha d'anar

    public CodeActivityResponseViewComposer() {
        super("pl_code_act");
    }

    /*Si classe comparteix diverses plantilles
    public CodeActivityResponseViewComposer(String templatename) {
        this.templateName = templatename;
    }
    */
    
    /*
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
    */
    

    /*@Override*/
    public ModelAndView getResponseView(ResponseViewConfigData config) {
        //NOTA[JOSEP]: Valorar si el nom de la plantilla es pot recollir des de la base de dades
        //i passar-ho per paràmetre en el costructor (Hauria de passar-ho la Factory)
        //Això seria útil només si un mateix ResponseViewComposer pogués usar vàries plantilles.
        //Pot ser interessant per tal d'evitar multiplicitat de 
        ModelAndView ret = new ModelAndView(templateName);
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
}
