/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.elsquatrecaps.flexiblelearning.responses;

import org.elsquatrecaps.flexiblelearning.activity.LearningProposalActivity;
import org.elsquatrecaps.flexiblelearning.activity.Activity;
import org.elsquatrecaps.flexiblelearning.state.Attempt;
import org.elsquatrecaps.flexiblelearning.state.Student;
import org.elsquatrecaps.flexiblelearning.viewdata.learningproposal.common.LearningProposal;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author professor
 */
public interface ResponseAction {
    public void action(ModelMap modelMap, Student student, LearningProposal learningProposal, LearningProposalActivity lpActivity, Attempt attempt, Activity activity);
}
