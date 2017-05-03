package gob.senado.ppf.sed.controlador.sesion;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Principal;

public interface SesionControlador {

	ModelAndView vistaInicioSesion(String error, String logout);

	ModelAndView vistaMenuPrincipal(HttpSession sesion, HttpServletResponse response, HttpServletRequest request,
			Principal principal);

	ModelAndView vistaPasswordOlvidado();

	ModelAndView vistaConcretaPasswordOlvidado(HttpSession sesion, HttpServletResponse response, HttpServletRequest request, Principal principal);
}
