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
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("com.yiibai.URLConverter")
public class URLConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component,
            String value) {

        String HTTP = "http://";
        StringBuilder url = new StringBuilder();

        if (!value.startsWith(HTTP, 0)) {
            url.append(HTTP);
        }
        url.append(value);

        if (url.toString().length() > 30) {
            FacesMessage msg
                    = new FacesMessage("URL Conversion error.",
                            "Invalid URL format.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(msg);
        }
        return url.toString();
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component,
            Object value) {

        return value.toString();

    }

}
