/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.elsquatrecaps.flexiblelearning.activity;

import org.elsquatrecaps.flexiblelearning.activity.Activity;

/**
 *
 * @author professor
 */
public class ActivityConfiguration {

        private NamedObjectsConcurrentSet objects = new NamedObjectsConcurrentSet();
        
        public void copyConfigurationToActivity(Activity activity){
            if(!objects.isEmpty()){
                activity.setObjects((NamedObjectsConcurrentSet) objects.clone());
            }
        }
        
        public void saveConfigurationFromActivity(Activity activity){
            this.objects=(NamedObjectsConcurrentSet)activity.getObjects().clone();
        }

    
   
    
    
}
