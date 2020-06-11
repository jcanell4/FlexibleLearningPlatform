package org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.activity;

import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.activity.feedbackelements.Clue;
import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.activity.interactivetools.Editor;
import java.util.ArrayList;
import java.util.List;

/**
 * Learning activity containing an editor as interactive tool
 * An activity can be an exercise, a question, a task, and so on. In this case 
 * it is a task that involves writing in an editor
 * @author josep
 * @param <T> Some class extends Editor
 */
public class EditorActivity<T extends Editor> {
    private String statement;
    private List<String> instructions = new ArrayList<>();
    private T editor = null;
    private Clue currentClue= new Clue();

    public EditorActivity() {
        this.editor = (T) new Editor();
    }

    public EditorActivity(T editor) {
        this.editor = editor;
    }   

    public EditorActivity(String editorClass) {
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
