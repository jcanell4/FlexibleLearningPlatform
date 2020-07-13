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
    /*
    Se li podria passar un String com indentificador del tipus per reduir la complexitat de classes 
    Altra possibilitat és passar-li un tipu Enumerate que contingui tots el tipus de vistes existents.
    La primera opció és més versatil, tot i que és menys feble perquè no detecte els error 
    en temps de compilació. Ara bé pot resultar molt útil perquè es podria usar el nom de la classe 
    com identificador del responseVieComposer de manera que la seva instanciació fos molt senzilla. 
    Altres alternatives en format String seria un identificador associat a la classe a instanciar a 
    través d'un fitxer de configuració.
    Si es fa mitjançant un Enumerate, cada cop que afegim un tipus caldrà tocar el codi.
    La meva opinió és que amb un String n'hi ha prou. Es podria implementar un sistema que primer 
    intenti fer instancia suposant que és una classe i si això dona error de classe inexistent, 
    aleshores faci consulta en una property del fitxer de configuració principal (application.properties) 
    o en algun altre fitxer de configuració (altre fitxer properties o un xml, etc). 
    L'ús de les properties del fitxer principal (application.properties) és extremadament senzill des de Spring
    Consulta a internet i ja veuràs que hi ha anotacions per indicar la propietat a usar i en quina 
    variable o paràmetre d'un mètode es necessita. 
    */