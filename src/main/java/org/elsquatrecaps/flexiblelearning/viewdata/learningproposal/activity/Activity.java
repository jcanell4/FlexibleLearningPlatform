/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.activity;

/**
 *
 * @author josep
 */
public class Activity {
    private String statement;
    private Editor editor = new Editor();
    private Clue currentClue= new Clue();

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
    public Editor getEditor() {
        return editor;
    }

    /**
     * @return the currentClueId
     */
    public Clue getCurrentClue() {
        return currentClue;
    }
}
