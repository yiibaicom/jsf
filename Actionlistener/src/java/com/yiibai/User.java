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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "normal")
@SessionScoped
public class User implements java.io.Serializable {

    public String buttonId = "yiibai.com";

    public String getButtonId() {
        return buttonId;
    }

    public void setButtonId(String buttonId) {
        this.buttonId = buttonId;
    }

    public void printIt(ActionEvent event) {
        //Get submit button id
        buttonId = event.getComponent().getClientId();
    }

    public String outcome() {
        return "result";
    }
}
