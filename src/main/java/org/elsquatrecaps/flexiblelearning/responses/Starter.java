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
 * @author professor
 */



public class Starter {
  
    public static ModelAndView startAct(String idStudent, String learningProposalActivityName){
        LearningProposalActivity lpa=(LearningProposalActivity) DBConnection.getActivity(learningProposalActivityName);
        Activity activity;
        Student student;
        
        LearningState ls=DBConnection.getLearningState(idStudent, learningProposalActivityName);
        activity=null;
        if(ls==null){
            student = DBConnection.getStudent(idStudent);
            ls=new LearningState();
            ls.setLearningProposalActivity(lpa);
            ls.setStudent(student);
            DBConnection.add(ls);
        }else{       
            activity=ls.getCurrentActivity();
        }

        if(activity==null){
               activity=DBConnection.getActivity(learningProposalActivityName);
        }
        
        //LearningProposal lp=ls.getLearningProposalActivity().getLearningProposal();
        
        Attempts attempts=DBConnection.getAttempts(activity.getName(), idStudent);
        
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
        
        
        
        ResponseViewComposer rvc=ResponseViewComposerFactory.createResponseViewComposer(activity.getType());
        
        List<Attempt> attemptsList=attempts.getAttempts();
        

        
        return rvc.startAct(ls.getStudent(), ls.getLearningProposalActivity().getLearningProposal(),ls.getLearningProposalActivity(), attemptsList.get(attemptsList.size()-1), activity);
        
        
        
        
    }

}


  /*
    NOTA[JOSEP]: Crec que, si cal aquest mètode hauria de ser privat o protected
    */


/*
NOTA[JOSEP]: D'acord amb el que diu el document https://docs.google.com/document/d/1NrOOKxvgJ5-mqJWI9-OARRgRI0MqspLp5fVrz0yQ3E0, aquesta classe
és un Action que serà instanciat i cridat pel controller. Jo crec que només hauria de tenir un únic mètode i el seu paper consisteix
En crear un ResponseViewComposer usant el ResponseViewComposerFactory a fi d'aconseguir la resposta (ModelAndView per exemple, o Objecte amb dades, etc)
A fi de passar la resposta al controller i que aquesta arribi al client. Crec que només té un mètode perquè actua com a gestor de la petició 
que  el controller li passa ("Obtenir la vista de tal activitat per a tal estudiant") i això és seqüencial. Cal que a partir de la tasca obtingui les 
dades de configuració de l'activitat des de la base de dades d'activitats i també les dades de configuració de l'activitat associades a l'estudiant


    /*
    NOTA[JOSEP]: Crec que, si cal aquest mètode hauria de ser privat o protected

    
    NOTA[JOSEP]: Faltaria el mètode process o run o start que executés tot el procediment per iniciar la vista i passar-la al client
    Aquest mètode rebria un id d'estudiant + l'identificador únic (String) de la learningProposal sol·licitada per l'usuari (per exemple
    des d'un enllaç de moodle). 
    
    INCÍS ABANS DE CONTINUAR: Jo no havia pensat en els intents, però em sembla bé tenir-los en compte i són una manera d'independitzar l'activitat própiament 
    dita de les "activitats realitzades per l'usuari". En tot cas, jo distingiria entre dos tipus d'intents: intents que s'estant duent a terme (CurrentAttemps) i 
    intents acabats (FinishedAttemps). La raó és que la informació guardada en un intent no acabat pot ser molt més gran que la informació guardada en un intent 
    ja acabat. Donant-li voltes, crec que a l'intent no acabat hauria de contenir tota la informació relativa a l'estat de l'activitat, En canvi la informació dels 
    estats acabats podria reduir-se per no fer créixer infinitament la base de dades. En una cas extrem, potser només ens interessaria guardar la nota, però poden haver 
    casos intermedis interessant (guardar les respostes, guardar els feedbacks, etc). De moment si et sembla guardaríem només la nota. També caldria valorar si cal guardar 
    tots els intents o només el darrer convinat amb la dada que indiqui quants intents s'han realitzat abans. En cas que decidim guardar tots els intents, jo usaria una pila associada a cada activitat per tal de disposar sempre del darrer 
    intent sense perdre l'accés als altres. Es pot implementar com una cadena de nodes o usar una de les implementacions de pila de java.
    
    Finalitzat l'incís, anem a veure què hauria de fer aquest mètode :
     1.- Amb l'ID de l'estudiant hauria de recuperar el learningState de l'estudiant, corresponent a la learningProposal sol·licitada. El learning state hauria de contenir
         el currentAttempt i tots els FinishedAttempts de les activitats ja realitzades.
         El currentAttempt hauria de contenir com a mínim les següents dades:
            - Id de l'activitat (activity/task o com vulguis dir-li) en al que es troba l'estudiant en la proposta d'aprenentatge (learningProposal equivalent 
              al que anomenavem activitat nuclear) indicada. 
            - Dades de l'estat de l'activitat atribuibles a l'estudiant. Ésa  dir coses que l'estudiant ha fet a l'activitat:
                - Respostes escrites (aquest punt és la informació mínima nexessaria i obligatòria per a totes les activitats interactives com les que estem implementant)
                - Altres dades opcionals depenent del tipus d'activitat:
                    - Recursos consultats per l'estudiant fins el moment
                    - Enllaços a favorits si l'activitat ho suporta
                    - Anotacions de l'estudiant si l'activitat ho suporta
                    - Elements de feedback enviats a l'estudiant fins el moment, com per exemplee quantes i/o quines pistes se li han donat, quines 
                        preguntes o aclariments ha demanat l'estudiat amb les seves respostes si n'hi han (si l'activitat permet fer preguntes o aclariments), etc.
                    - etc.                    
                  (Jo de moment només hi posaria les pistes i més endavant ja veuríem)
         Els finishedAttempts haurien de ser accessibles per cada activitat associada (indexació per activitat), i en cas de guardar tots els intents que s'hi accedeixi en ordre invers (pila)
            - Intents de les activitats ja realitzades haurien de contenir com a mínim . 
     2.- 
    */
        

