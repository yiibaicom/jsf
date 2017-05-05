package com.yiibai;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Administrator
 */
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "user")
@SessionScoped
public class UserBean {

    public String text = "Hello {0}";
    public String htmlInput = "<a href='http://www.yiibai.com'>{0}</a>";

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHtmlInput() {
        return htmlInput;
    }

    public void setHtmlInput(String htmlInput) {
        this.htmlInput = htmlInput;
    }

}
