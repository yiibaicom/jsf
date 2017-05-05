/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yiibai;

/**
 *
 * @author Maxsu
 */
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

public class MyActionListener implements ActionListener {

    @Override
    public void processAction(ActionEvent event)
            throws AbortProcessingException {

        System.out.println("Any use case here?");

    }

}
