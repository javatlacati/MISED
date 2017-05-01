package gob.senado.ppf.sed.configuracion;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Javatlacati
 */
public class FiltroXSS implements Filter {

    private FilterConfig filtroXss;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filtroXss = filterConfig;
    }

    @Override
    public void destroy() {
        this.filtroXss = null;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        chain.doFilter(new XSSWrapper((HttpServletRequest) request), response);
    }
}
