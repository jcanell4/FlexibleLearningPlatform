/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.common;

/**
 *
 * @author josep
 */
public class ActionDialogButton {
    private String action;
    private String text;
    private String id;
    private boolean closeDialogOnClick=false;

    public ActionDialogButton() {
    }

    public ActionDialogButton(String action, String text, String id, boolean closeDialogOnClick) {
        this.closeDialogOnClick = closeDialogOnClick;
        this.action = action;
        this.text = text;
        this.id = id;
    }

    public ActionDialogButton(String action, String text, String id) {
        this.action = action;
        this.text = text;
        this.id = id;
    }
    
    public ActionDialogButton(String action, String text, boolean closeDialogOnClick) {
        this.action = action;
        this.text = text;
        this.closeDialogOnClick = closeDialogOnClick;
    }

    public ActionDialogButton(String action, String text) {
        this.action = action;
        this.text = text;
    }

    /**
     * @return the action
     */
    public String getAction() {
        return action;
    }

    /**
     * @param action the action to set
     */
    public void setAction(String action) {
        this.action = action;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the closeDialogOnClick
     */
    public boolean isCloseDialogOnClick() {
        return closeDialogOnClick;
    }

    /**
     * @param closeDialogOnClick the closeDialogOnClick to set
     */
    public void setCloseDialogOnClick(boolean closeDialogOnClick) {
        this.closeDialogOnClick = closeDialogOnClick;
    }
}
