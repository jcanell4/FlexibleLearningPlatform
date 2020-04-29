/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.activity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josep
 * @param <T>
 */
public class Activity<T extends Editor> {
    private String statement;
    private List<String> instructions = new ArrayList<>();
    private T editor = null;
    private Clue currentClue= new Clue();

    public Activity() {
        this.editor = (T) new Editor();
    }

    public Activity(T editor) {
        this.editor = editor;
    }   

    public Activity(String editorClass) {
        try {
            this.editor = (T) Class.forName(editorClass).newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException ex) {
           throw new RuntimeException(String.format("%s class not found", editorClass));
        }
    }   

    /**
     * @return the statement
     */
    public String getStatement() {
        return statement;
    }

    /**
     * @param statement the statement to set
     */
    public void setStatement(String statement) {
        this.statement = statement;
    }

    /**
     * @return the editor
     */
    public T getEditor() {
        return editor;
    }

    /**
     * @return the currentClueId
     */
    public Clue getCurrentClue() {
        return currentClue;
    } 

    /**
     * @return the instructions
     */
    public List<String> getInstructions() {
        return instructions;
    }
}
