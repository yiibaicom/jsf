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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

@ManagedBean(name = "user")
@SessionScoped
public class UserBean {

    public String nickname;

    public void attrListener(ActionEvent event) {
        nickname = (String) event.getComponent().getAttributes().get("username");
    }

    public String outcome() {
        return "result";
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

}
