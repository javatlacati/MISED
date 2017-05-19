package gob.senado.ppf.sed.controlador.usuario;

import org.springframework.web.servlet.ModelAndView;

public interface UsuarioControlador {
    ModelAndView vistaMiPerfil();

    ModelAndView vistaActualizarUsuarios();

    ModelAndView vistaBajaUsuarios();

    ModelAndView vistaBusquedaUsuarios();

    ModelAndView vistaCapturaUsuarios();

    ModelAndView vistaPermisosUsuarios();

    ModelAndView vistaCredencialesUsuarios();
}
