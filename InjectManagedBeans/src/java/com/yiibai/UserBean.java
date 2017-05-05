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
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class UserBean implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @ManagedProperty(value="#{message}")
  private MessageBean messageBean;

  public void setMessageBean(MessageBean messageBean) {
    this.messageBean = messageBean;
  }

  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  
  public String getSayWelcome(){
    //check if null?
    if("".equals(name) || name ==null){
      return "";
    }else{
      return messageBean.getSayWelcome() + name;
    }
  }
  
}