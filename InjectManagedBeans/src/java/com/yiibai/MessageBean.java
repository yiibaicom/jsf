/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yiibai;

/**
 *
 * @author Administrator
 */
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "message")
@SessionScoped
public class MessageBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String sayWelcome = "Welcome to JSF 2.0";

    public String getSayWelcome() {
        return sayWelcome;
    }

    public void setSayWelcome(String sayWelcome) {
        this.sayWelcome = sayWelcome;
    }

}
