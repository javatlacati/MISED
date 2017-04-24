package gob.senado.ppf.sed.controlador.sesion;

import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;

public interface SesionControlador {

	public abstract ModelAndView vistaInicioSesion(String error, String logout);

	public abstract ModelAndView vistaMenuPrincipal(HttpSession sesion, HttpServletResponse response,
			HttpServletRequest request, Principal principal);
	
}
