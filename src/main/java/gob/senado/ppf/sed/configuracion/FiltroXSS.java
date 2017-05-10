/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.senado.ppf.sed.configuracion;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Filtro para prevenir ataques de inyecci&oacute;n de c&oacute;digo javascript
 *
 * @author Javatlacati
 */
public class FiltroXSS implements Filter {

//    private FilterConfig filterConfig;

    /**
     * {@inheritDoc}
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        this.filterConfig = filterConfig;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void destroy() {
//        this.filterConfig = null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        chain.doFilter(new XSSWrapper((HttpServletRequest) request), response);
    }
}
