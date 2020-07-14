package org.elsquatrecaps.flexiblelearning.responses;

import org.elsquatrecaps.flexiblelearning.activity.LearningProposalActivity;
import org.elsquatrecaps.flexiblelearning.activity.Activity;
import java.time.LocalDateTime;
import java.util.List;
import org.elsquatrecaps.flexiblelearning.state.Attempt;
import org.elsquatrecaps.flexiblelearning.state.Attempts;
import org.elsquatrecaps.flexiblelearning.state.DBConnection;
import org.elsquatrecaps.flexiblelearning.state.LearningState;
import org.elsquatrecaps.flexiblelearning.state.Status;
import org.elsquatrecaps.flexiblelearning.state.Student;
import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.common.LearningProposal;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * NOTA[JOSEP]: D'acord amb el que diu el document https://docs.google.com/document/d/1NrOOKxvgJ5-mqJWI9-OARRgRI0MqspLp5fVrz0yQ3E0, aquesta classe
 * és un Action que serà instanciat i cridat pel controller. Jo crec que només hauria de tenir un únic mètode i el seu paper consisteix
 * En crear un ResponseViewComposer usant el ResponseViewComposerFactory a fi d'aconseguir la resposta (ModelAndView per exemple, o Objecte amb dades, etc)
 * A fi de passar la resposta al controller i que aquesta arribi al client. Crec que només té un mètode perquè actua com a gestor de la petició 
 * que  el controller li passa ("Obtenir la vista de tal activitat per a tal estudiant") i això és seqüencial. Cal que a partir de la tasca obtingui les 
 * dades de configuració de l'activitat des de la base de dades d'activitats i també les dades de configuració de l'activitat associades a l'estudiant

 * 
 *  INCÍS ABANS DE CONTINUAR: Jo no havia pensat en els intents, però em sembla bé tenir-los en compte i són una manera d'independitzar l'activitat própiament 
    dita de les "activitats realitzades per l'usuari". En tot cas, jo distingiria entre dos tipus d'intents: intents que s'estant duent a terme (CurrentAttemps) i 
    intents acabats (FinishedAttemps). La raó és que la informació guardada en un intent no acabat pot ser molt més gran que la informació guardada en un intent 
    ja acabat. Donant-li voltes, crec que a l'intent no acabat hauria de contenir tota la informació relativa a l'estat de l'activitat, En canvi la informació dels 
    estats acabats podria reduir-se per no fer créixer infinitament la base de dades. En una cas extrem, potser només ens interessaria guardar la nota, però poden haver 
    casos intermedis interessant (guardar les respostes, guardar els feedbacks, etc). De moment si et sembla guardaríem només la nota. També caldria valorar si cal guardar 
    tots els intents o només el darrer convinat amb la dada que indiqui quants intents s'han realitzat abans. En cas que decidim guardar tots els intents, jo usaria una pila associada a cada activitat per tal de disposar sempre del darrer 
    intent sense perdre l'accés als altres. Es pot implementar com una cadena de nodes o usar una de les implementacions de pila de java.

 * 
 * @author professor
 */



public class Starter {
  
    //JOSEP: Què és la learningProposalActivityName? El que hauria de venir és només un identificador d'una LearningProposal (String). Jo canviaria el nom del 
    // paràmetre per constatar que es trcata d'un identificador.
    public static ModelAndView startAct(String idStudent, String learningProposalActivityName ){
        LearningProposalActivity lpa=(LearningProposalActivity) DBConnection.getActivity(learningProposalActivityName); //L'estarter no és l'encarregar de recuperat la learningProposal, ho és el responseViewComposer específic.
        Activity activity;
        Student student;

        LearningState ls=DBConnection.getLearningState(idStudent, learningProposalActivityName);
        activity=null;
        if(ls==null){
            //JOSEP:[TODO] D'acord amb els casos 1 i 2  del document https://docs.google.com/document/d/1NrOOKxvgJ5-mqJWI9-OARRgRI0MqspLp5fVrz0yQ3E0/edit#heading=h.yr2sbnlwhi2c, si no hi 
            // ha LS, cal llançar un error indicant que l'estudiant no pot fer la leraning proposal demanada perquè no la té assignada. Caldria canviar
            //el codi següent per un llançament d'una excepció tipificada. Aquest codi, en realitat hauria d'anar al procés de selecció i assignació 
            // d'una learningProposal (cas d'us 1 i classes 21, 21.1,...21.3).
            student = DBConnection.getStudent(idStudent);
            ls=new LearningState();
            ls.setLearningProposalActivity(lpa);
            ls.setStudent(student);
            DBConnection.add(ls);
        }else{       
            //JOSEP: jo crec que el LS només ha de contenir identificadors per referenciar tant la learningProposal com la learningActivity, com qualsevol 
            //altre referencia a recursos didàctics que siguin necessaris. De moment només tindrem en compte el la LearningPorpossal i la LearningActivity.
            //Amb aquest dos identificadors obtinguts des del client (learningProposalId) i des del learningState (learningActivityId) cal constuir  el 
            //ResponseViewId: un identificador compost de tots els identioficadors necessaris per crear la vista (Mira't la classe StarterAction (número 2) del document
            // https://docs.google.com/document/d/1NrOOKxvgJ5-mqJWI9-OARRgRI0MqspLp5fVrz0yQ3E0/edit#heading=h.yr2sbnlwhi2c
            //El ResponseViewId ha de servir per passar-li al ResponseViewComposerFactory per tal que pugui identificar el responseviewComposer corresponent a l'activitat.
            //El responseviewComposerFactory usarà els identificadors per consultar una base de dades i obtenir la classe del ResponseViewComposer a instanciar i un cop trobada crearà una 
            //instancioa i li passarà els identificadors (ResponseViewId) per tal que el ResponseViewComposer quedi inicialitzat i el retornarà al starter.
            //[NOTA]: No cal que hi hagi un ResponseViewComposer per cada activitat, sinó més aviat per cada tipus. La funció del ResponseViewComposer és la de crear la vista si dues 
            //vistes es generen de forma semblant però amb paràmetres diferents; per exemple l'activitat de codi i la d'escripture que possiblement s'assemblen molt i probablement poden 
            //compartir la classe que les genera.
            //El ResponseViewComposer tindrà un mètode per generar la vista. Crec que tu li has dit, getResponseView que només hauria de rebre un únic paràmetre amb les dades 
            //del LearninState, perquè les de l'activitat i les de la proposta d'aprenentatge, les buscarà el propi composer amb els identificadors amb els que ha estat inicialitzat. 
            //Per tal d'assegurar la compatibilitat de les dades i degut a que hi oden haver molts tipus de learningState, proposo que les dades del leranint state es passin mitjançant 
            //una classe anomenada ResponseViewConfigData, la qual contindrà una forma estandarditzada d'obtenir les dades emmagatzemades al learninState. [ALERTA]! En el learning State només 
            //hi hauria d'haver les dades que hagin estat conseqüencia de les accions de l'estudiant, no les dades pròpies de l'activitat com el títol, el tema, etc.
            //Caldria convenir quines dades són les que ha de contenir el ResponseViewConfigData, però de moment, jo crec que com a mínim n'hi haurien d'haver de varis tipus:            
            //1) Dades de l'activitat (en el mateix format en que es guarden en el leraning state s'haurien d'emmagatzemar en el ResponseViewConfigData. 2) Dades de l'estudiant (opcional) com ara 
            // el nom , etc. 3)Llista d'activitats de la proposta d'aprennetatge que ja ha estat completades. Aquesta llista s'obte de l'estuctura de dades que emmagatzema 
            // els múltiples intents realitzats per les diferents activitats, però de tots ells ens interessa només una llista amb els IDs de cada activitat realitzada i 
            // un valor indicant un estat (realitzada/no realitzada o superada/no superada/no realitzada).Sigui com sigui, la llista contionguda només haurà d'informar 
            //de les activitats conegudes pel learningState, és a dir, les realitzades (les no realitzades les deduirà el ResponseViewComposser fent la diferencia amb les 
            //activitats contingudes al LearnigProposal).
            activity=ls.getCurrentActivity();
        }

        //JOSEP: Jo crec que en aquest sistema la classe Activity com a tal no té gaire sentit. De moemt es pot mantenir i ja l'eleiminarem si es constanta que no té sentit.
        //Ara bé tingui o no sentit, l'Starter no és l'encarregat de crear la instància. Jo eliminaria aquestes línies de codi
        if(activity==null){
               activity=DBConnection.getActivity(learningProposalActivityName);
        }
        
        //JOSEP: Veig que aquest codi està comentat però per si un cas, Igual que passa mb l'activity, no li correspon a l'estarter fer la instància
        //LearningProposal lp=ls.getLearningProposalActivity().getLearningProposal();
        
        //Els intents estan continguts en el learningState, no? Perquè els recuperes aquí?
        Attempts attempts=DBConnection.getAttempts(activity.getName(), idStudent);
        
        //No correspon al Stater crear intents. Els intents els hauria de crear i emmagatzemar la ActivityEventAction de tipus SolutionSubmitting (mira la 
        //classe 13 (ActivityEventAction del document: https://docs.google.com/document/d/1NrOOKxvgJ5-mqJWI9-OARRgRI0MqspLp5fVrz0yQ3E0/edit#).
        if(attempts==null){
            attempts=new Attempts();
            attempts.setActivity(activity);
            attempts.setStudent(ls.getStudent());
            Attempt at = new Attempt();

            Status stat = new Status();
            stat.setTime(LocalDateTime.now());
            at.setStartLocalDateTime(stat.getTime());
            at.setStatus(stat);
            attempts.getAttempts().add(at);
            DBConnection.add(attempts);
        }
        
        
        //JOSEP: El factory instancia el ResponseViewComposer a partir dels ID passats en un paràmetre de tipus ResponseViewId. El tipus d'activity l'ha de 
        //trobar la factory a partir dels ID. Sinò què fa la factory?
        ResponseViewComposer rvc=ResponseViewComposerFactory.createResponseViewComposer(activity.getType());
        
        //JOSEP: No crec que calgui passar tota la llista d'intents al responseViewComposer sinó només la llista de activitats de la proposata d'aprenentatge realitzades (amb o sense èxit)
        List<Attempt> attemptsList=attempts.getAttempts();
        

        //JOSEP: Jo crec que el ResponseViewComposerfactory ha d'inicialitzar la instancia de ResponseViewComposer amb  les dades que calgui. De moment a mi només se 
        //m'acudeix que per la inicializació només són necessaris els ID del responseViewID.
        //Desd'aquí el rvc només hauria de rebre un paràmetre el ResponseViewConfigData contenint els tres tipus de dades (dades de l'activitat, dades de l'estudiant i dades de la leraningProposal=llista d'activitat ja realitzades)
        return rvc.startAct(ls.getStudent(), ls.getLearningProposalActivity().getLearningProposal(),ls.getLearningProposalActivity(), attemptsList.get(attemptsList.size()-1), activity);
        
        //NOTA JOSEP: Per saber que fa el ResponseViewComposer consulta la classe.
    }

}     

