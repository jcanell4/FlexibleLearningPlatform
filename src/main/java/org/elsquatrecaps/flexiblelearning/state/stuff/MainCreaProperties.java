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


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;



public class MainCreaProperties {

    public static void main(String[] args) {

        try (OutputStream output = new FileOutputStream("activity_tipes.properties")) {

            Properties prop = new Properties();

            // set the properties value
            prop.setProperty("base", "pl_base_act");
            prop.setProperty("writing", "pl_writing_act");
            prop.setProperty("code", "pl_code_act");

            // save properties to project root folder
            prop.store(output, null);

            System.out.println(prop);

        } catch (IOException io) {
            io.printStackTrace();
        }
        
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@22");

    }
}
