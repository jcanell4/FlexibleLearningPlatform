/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.elsquatrecaps.flexiblelearning.infolearningstructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author professor
 */
public class ActivityCategory extends Activity{

    protected List<Activity> members=Collections.synchronizedList(new ArrayList<>());

    /**
     * Get the value of members
     *
     * @return the value of members
     */
    public List<Activity> getMembers() {
        return members;
    }

    /**
     * Set the value of members     <b>Don't use.</b>. written by compatibility reasons.
     *
     * @param members new value of members
     */
    public void setMembers(ArrayList<Activity> members) {
        this.members = members;
    }
// end of accessors
    /**
     * Cleans members list (called members)
     */

    public void clearMembers(){
        members.clear();
    }
    
    
    
    // Cal cridar-la un cop children ja te els seus objectes
    public boolean addChildrenBeforeOf(Activity next, Activity children){
        int position=members.indexOf(next);
        
        if(position==-1){
            return addChildrenAtTheEnd(children);
        }
        else{
            return addChildrenAt(position,children);
        }
    }
    
    // Cal cridar-la un cop children ja te els seus objectes
    public boolean addChildrenAtTheEnd(Activity children){
        copyObjectsTo(children);
        children.parentActivity=this;
        return members.add(children);
    }

    // Cal cridar-la un cop children ja te els seus objectes
    public boolean addChildrenAt(int position, Activity children){
        copyObjectsTo(children);
        children.parentActivity=this;        
        members.add(position,children);
        return true;
    }
    
    public boolean canGoNext(Attempt attempt,Activity activity){
        return attempt.getEndLocalDateTime()!=null;
    }
    

    public boolean canGoPrev(Attempt attempt,Activity activity){
        return true;
    }
    
    protected void copyObjectsTo(Activity children){
        for(NamedObject no:objects){
            children.objects.add(no);
        }
    }

    
}
