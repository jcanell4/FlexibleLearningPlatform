/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.elsquatrecaps.flexiblelearning.activity;

import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.common.LearningProposal;

/**
 *
 * @author professor
 */
public class LearningProposalActivity extends ActivityCategory{
    
    private LearningProposal learningProposal = null;

    /**
     * Get the value of learningProposal
     *
     * @return the value of learningProposal
     */
    public LearningProposal getLearningProposal() {
        return learningProposal;
    }

    /**
     * Set the value of learningProposal
     *
     * @param learningProposal new value of learningProposal
     */
    public void setLearningProposal(LearningProposal learningProposal) {
        this.learningProposal = learningProposal;
    }

    

}
