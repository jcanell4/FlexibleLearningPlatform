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
public class LearningProposal {
    public String id;
    public String description;
    public String keywords;
    public String authors;

    public LearningProposal() {
    }

    public LearningProposal(String id, String description, String keywords, String authors) {
        this.id = id;
        this.description = description;
        this.keywords = keywords;
        this.authors = authors;
    }
    
    public LearningProposal(String id) {
        this.id = id;
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the keywords
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     * @param keywords the keywords to set
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    /**
     * @return the authors
     */
    public String getAuthors() {
        return authors;
    }

    /**
     * @param authors the authors to set
     */
    public void setAuthors(String authors) {
        this.authors = authors;
    }
    

}
