/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.elsquatrecaps.flexiblelearning.infolearningstructure;

/**
 *
 * @author professor
 */
public interface ResponseViewComposer {
    public Object getResponseView(Student s, Attempt a, Task t);
    public Object doSubmitAction(Student s, Attempt a, Task t);
    public Object doMiddleAction(Student s, Attempt a, Task t);
    

}
