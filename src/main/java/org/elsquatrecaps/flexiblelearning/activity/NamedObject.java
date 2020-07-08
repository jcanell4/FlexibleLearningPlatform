/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.elsquatrecaps.flexiblelearning.activity;

/**
 *
 * @author professor
 */
public class NamedObject implements Comparable<NamedObject>{

    private String name = null;
    private Object object = null;

    public NamedObject() {
    }
    
    public NamedObject(String name, Object object){
        this.name=name;
        this.object=object;
    }
    
    
    
    
    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the value of object
     *
     * @return the value of object
     */
    public Object getObject() {
        return object;
    }

    /**
     * Set the value of object
     *
     * @param object new value of object
     */
    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public int compareTo(NamedObject o) {
        return this.getName().compareTo(o.getName());
    }

}
