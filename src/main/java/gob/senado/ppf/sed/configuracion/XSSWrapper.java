/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.senado.ppf.sed.configuracion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * @author Javatlacati
 */
public class XSSWrapper extends HttpServletRequestWrapper {
    /**
     * {@inheritDoc}
     */

    XSSWrapper(HttpServletRequest httpServletRequest) {
        super(httpServletRequest);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String[] getParameterValues(String parameter) {
        String[] values = super.getParameterValues(parameter);
        if (values == null) {
            return null;
        }
        int count = values.length;
        String[] encodedValues = new String[count];
        int i = 0;
        while (i < values.length) {
            encodedValues[i] = cleanXSS(values[i]);
            i++;
        }
        return encodedValues;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getParameter(String parameter) {
        String value = super.getParameter(parameter);
        return value == null ? null : cleanXSS(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getHeader(String name) {
        String value = super.getHeader(name);
        return value == null ? null : cleanXSS(value);
    }

    /**
     * Remplaza entidades html en una cadena especificada.
     *
     * @param value string to fe filtered
     * @return filtered string
     */
    private String cleanXSS(String value) {
        //You'll need to remove the spaces from the html entities below
        value = value.replaceAll("<", "&lt;").replaceAll(">", "&gt;")
                .replaceAll("\\(", "&#40;").replaceAll("\\)", "&#41;")
                .replaceAll("'", "&#39;")
                .replaceAll("eval\\((.*)\\)", "")
                .replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"']", "\"\"")
                .replaceAll("script", "");
        return value;
    }

}
