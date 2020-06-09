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
public class SimpleTask {
    
    private List<SimpleTaskElement> members=Collections.synchronizedList(new ArrayList<>());

    /**
     * Get members
     * @return value of members
     */
    
    public List<SimpleTaskElement> getMembers() {
        return members;
    }

    /**
     * set members. <b>Don't use.</b> Only compatibility purpose.
     * @param members value of members
     */
    
    public void setMembers(List<SimpleTaskElement> members) {
        this.members = members;
    }
    
    
    
}
