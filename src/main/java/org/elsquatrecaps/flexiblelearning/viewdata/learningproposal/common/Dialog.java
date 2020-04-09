/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.common;

import java.util.ArrayList;
import java.util.List;

public class Dialog {
    private boolean canClose=true;
    private String id = "dialog";
    private String title;
    private List<String> message = new ArrayList<>();
    private List<ActionDialogButton> buttons = new ArrayList<>();

    public Dialog() {
    }

    public Dialog(String id, String title, String message, boolean canClose) {
        this.id = id;
        this.canClose = canClose;
        this.title = title;
        this.message.add(message);
    }
    
    public Dialog(String title, String message, boolean canClose) {
        this.canClose = canClose;
        this.title = title;
        this.message.add(message);
    }
    
    public Dialog(String title, boolean canClose) {
        this.canClose = canClose;
        this.title = title;
    }
    
    public Dialog(String id, String title, String message) {
        this.id = id;
        this.title = title;
        this.message.add(message);
    }

    public Dialog(String title, String message) {
        this.title = title;
        this.message.add(message);
    }

    public Dialog(String title) {
        this.title = title;
    }

    public boolean isCanClose() {
        return canClose;
    }

    public void setCanClose(boolean canClose) {
        this.canClose = canClose;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getMessage() {
        return message;
    }

    public List<ActionDialogButton> getButtons() {
        return buttons;
    }       

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
