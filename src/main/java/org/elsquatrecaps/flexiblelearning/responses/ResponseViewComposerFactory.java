/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.elsquatrecaps.flexiblelearning.responses;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.elsquatrecaps.flexiblelearning.state.stuff.TaskType;

/**
 *    
    Crec que la millor solució és que rebi un ResponseViewId, es qual conté tots els identificadors necessaris per reconeixer 
    * quin tipus de ResponseViewComposer cal instanciar i tots aquells necessaris per inicalitzar-lo. D'entrada només hi ememagatzemarem 
    * l'id de la LearningProposal i l'Id de l'activity 
    * 
    * Amb els identificadors el factory buscarà a una base de dades quin tipus de Composer necessita i l'inicialitzarà passant-li els identificadors (LP i LA)
    * necessaris perquè el composer obtingui les dades estàtiqes de la vista.
    *     
 * @author professor
 */
public class ResponseViewComposerFactory {

    public static ResponseViewComposer createResponseViewComposer(String type){
        
////        try (InputStream input = new FileInputStream("activity_types.properties")) {   // TODO parametritzar l'adreça
////
////            Properties prop = new Properties();
////
////            // load a properties file
////            prop.load(input);

                return (ResponseViewComposer) new SpringThymeLeafResponseViewComposer("pl_"+type+"_act");  

////            return (ResponseViewComposer) new SpringThymeLeafResponseViewComposer(prop.getProperty(type));  //TODO considerar més classes
            
////        } catch (IOException ex) {
////            throw new LearningStructureError(ex.getMessage());
////        }              
    }

}
