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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ReferencedBean;

@ManagedBean
@ReferencedBean
public class User {

    String userName;
    String email;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean save() {
        int result = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "123456");
            PreparedStatement stmt = con.prepareStatement("insert into user(name,email) values(?,?)");
            stmt.setString(1, this.getUserName());
            stmt.setString(2, this.getEmail());
            result = stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }

    public String submit() {
        if (this.save()) {
            return "result.xhtml";
        } else {
            return "index.xhtml";
        }
    }
}
