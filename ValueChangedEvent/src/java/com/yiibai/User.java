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
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

@ManagedBean(name = "country")
@SessionScoped
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private static Map<String, String> countries;
    private String localeCode = "en"; //default value 

    static {
        countries = new LinkedHashMap<String, String>();
        countries.put("United Kingdom", "en"); //label, value
        countries.put("French", "fr");
        countries.put("German", "de");
    }

    public void countryLocaleCodeChanged(ValueChangeEvent e) {
        localeCode = e.getNewValue().toString();
    }

    public Map<String, String> getCountryInMap() {
        return this.countries;
    }

    public String getLocaleCode() {
        return localeCode;
    }

    public void setLocaleCode(String localeCode) {
        this.localeCode = localeCode;
    }
}
