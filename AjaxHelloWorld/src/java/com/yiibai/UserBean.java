
/**
 *
 * @author Administrator
 */
package com.yiibai;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.io.Serializable;



@ManagedBean
@SessionScoped
public class UserBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSayWelcome() {
        if ("".equals(name) || name == null) {
            return "Null Message";
        } else {
            return "Ajax message : Welcome " + name;
        }
    }

}
