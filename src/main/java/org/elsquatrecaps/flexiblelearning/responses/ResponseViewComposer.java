package org.elsquatrecaps.flexiblelearning.responses;

import org.elsquatrecaps.flexiblelearning.activity.LearningProposalActivity;
import org.elsquatrecaps.flexiblelearning.activity.Activity;
import org.elsquatrecaps.flexiblelearning.state.Attempt;
import org.elsquatrecaps.flexiblelearning.state.Student;
import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.common.LearningProposal;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author professor
 */
/*
NOTA[JOSEP]: Jo crearia un paquet anomenat viewcomposer on hi posaria totes les classes i 
interfícies relacionades amb la construcció de vistas, Inclos aquest interfície

NOTA[JOSEP]: L'he creat jo per afegir-hi una exempleque et serveixi de model. L'exemple instanciarà 
una vista per mostrar una activitat de tipus CodeActivity
*/

/*
NOTA[JOSEP]: Aquesta classe té connexió amb la base de dades de propostes d'aprenentatge (LearningProposal o activitat nuclear) 
i d'activitats/exercicis. Ha de configurar-se amb un paràmetre de tipus ResponseViewId el qual és un identificador compost 
de tots els IDs necessaris per obtenir les dades de la base de dades i configurar la vista. D'entrada només faran falta l'ID 
de la proposta d'aprenentatge (activitat nuclear) i el de l'activitat/tasca/exercici específic

    
    /*
    NOTA[JOSEP]: Com diu el document "https://docs.google.com/document/d/1NrOOKxvgJ5-mqJWI9-OARRgRI0MqspLp5fVrz0yQ3E0/edit#" 
    al punt 2, en el darrer paràgraf, l'objetiu del responseViewComposer és obtenir el
    ModelAndView i omplir-lo amb les dades corresponents per passar-li al controlador. 
    D'altra banda, com que només necessitem crear la vista amb l'estat on es va quedar l'usuair la darrera vegada, Potser, per reduir el grau d'acoblament, es podria
    optar per pasar només un paràmetre de tipus ResponseViewConfigData (un tipus molt genèric que ho colés tot de manera a que cada responseViewComposer 
    li arribessin objectes amb les dades especifiques necessaries per cada tipologia). Això redueix l'acoblament. Pensa que si es passa  l'estudiant, l'Attemp i 
    l'Activity, s'incrementen molt el nombre de classes usades.i amb aquestes l'acoblament. En canvi si usem els objectes de tipus ResponseViewConfigData com a transmisors de la 
    informació des de la instància del Starter cap el responseViewComposer, es reduiex l'acoblament

    En una primera versió podem fer que el ResponseViewConfigData rebi només 3 tipus de dades:
        1) Dades de l'activitat (en el mateix format en que es guarden en el leraning state s'haurien d'emmagatzemar en el ResponseViewConfigData. 
        2) Dades de l'estudiant (opcional) com ara el nom, etc. 
        3)Llista d'activitats de la proposta d'aprenentatge que ja han estat completades. 

.   Són sempre dades provinents del LearningState, però poden ser només un subconjunt i poden estar estructurades de diferent manera. La part de dades de l'activitat (respostes de l'usuari) 
    es guardarien a la base de dades de LearningStates com un JSON o PlainObject (idoni per MongoDB) i es recuperaria igual de manera que l'Starter recuperés 
    les dades de MongoDB les encapsulés en un únic objecte de tipus   ResponseViewConfigData. Les dades de l'estudiant també tindríen un format JSON. Funalemnt la llista de 
    activitats ja finalitzades es passaria com un mapa de keys (IDs) i estas (realitzada/superada/no superada)
     
    El mètode getResponseView usant els IDs de ResponseViewId obté la plantilla i les dades de configuració d'aquesta consultant la base de dades i seguidament 
    hi afegeix també les dades de tipus ResponseViewConfigData, les incorpora totes a la plantilla i la retorna (tipus ModelAndView). Si es desitja lesa dades 
    com la plantilla i la configuració estàtica de l'activitat i la learningProposal, es potden obtenir en el moment de la inicialització.

    Amb les dades rebudes han d'instanciar i d'omplir els objectes usats per la plantilla (del paquet viewdata) per pal de poder configurar la palntilla correctament.
    */ 

public interface ResponseViewComposer {
    /*
    NOTA[JOSEP]: Es necessitaria un mètode per configurar les instancies d'aquesta classe. Potser un mètode anomenat
    init o start o config que rebi un únic paràmetre de tipus ResponseViewId amb els IDs necessaris per obtenir les dades (per defecte)
    d'inicialització de l'activitat. És preferible usar un mètode de configuració que no pas configurar des del constructor
    perquè podem forçar des de la interfície a que el mètode existeixi en totes les implementacions de la interfície    
    */

    //JOSEP: Per què hi ha dos mètodes que reben ela mateixos paràmetres i retornen el mateix tipus d'objecte?
    public ModelAndView getResponseView(Student student, LearningProposal learningProposal, LearningProposalActivity lpActivity, Attempt attempt, Activity activity);
    public ModelAndView startAct(Student student, LearningProposal learningProposal, LearningProposalActivity lpActivity, Attempt attempt, Activity activity);

}
