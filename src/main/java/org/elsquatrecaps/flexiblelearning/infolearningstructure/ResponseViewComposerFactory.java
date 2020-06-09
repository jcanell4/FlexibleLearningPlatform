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
    public static ResponseViewComposer createResponseViewComposer(TaskType t){
        return (ResponseViewComposer) new SpringThymeLeafResponseViewComposer();
    }
   
}
