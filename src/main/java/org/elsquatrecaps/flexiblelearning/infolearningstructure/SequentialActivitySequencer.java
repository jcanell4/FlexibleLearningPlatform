/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.elsquatrecaps.flexiblelearning.infolearningstructure;

import java.util.ArrayList;
import java.util.List;

/**
 * ActivitySequencer that defines next activity as the next one in the list of members
 * @author professor
 */
public class SequentialActivitySequencer implements ActivitySequencer {

    @Override
    public List<Activity> nextActivities(NuclearActivity na, Activity act) {
        List <Activity> result=new ArrayList<>();
        
        int position=na.members.indexOf(act);
        if(position==-1 || position==(na.members.size()-1)){ //there's no more elements
            result.addAll(na.nextActivities()); //if act was the last activity of na, next activities of 
        } else {
            result.add(na.members.get(position+1));
        }
        return result;
    }
}
