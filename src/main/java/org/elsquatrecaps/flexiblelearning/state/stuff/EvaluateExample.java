/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.elsquatrecaps.flexiblelearning.state.stuff;

/**
 *
 * @author professor
 */
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class EvaluateExample {
  public static void main(String[] args) throws ScriptException {
    ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine engine = mgr.getEngineByName("JavaScript");
    //String foo = "40+2";
    String foo="'Hola que tal'.startsWith('H')";
    System.out.println(engine.eval(foo));
    
    String test="a=3;b=2;\na+b";
    System.out.println(engine.eval(test));
    
    
    } 
}