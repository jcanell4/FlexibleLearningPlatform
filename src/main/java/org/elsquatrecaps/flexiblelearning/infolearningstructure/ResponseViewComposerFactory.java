/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.elsquatrecaps.flexiblelearning.infolearningstructure;

/**
 *
 * @author professor
 */
public class ResponseViewComposerFactory {
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
    public static ResponseViewComposer createResponseViewComposer(TaskType t){
        return (ResponseViewComposer) new SpringThymeLeafResponseViewComposer();
    }
   
}
