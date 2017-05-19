package gob.senado.ppf.sed.controlador.usuario;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

public interface UsuarioControlador {
    @GetMapping(value = "/usuario/mi-perfil.htm")
    ModelAndView vistaMiPerfil();

    @GetMapping(value = "/administrador/usuario/actualizar-usuarios.htm")
    ModelAndView vistaActualizarUsuarios();

    @GetMapping(value = "/administrador/usuario/baja-usuarios.htm")
    ModelAndView vistaBajaUsuarios();

    @GetMapping(value = "/administrador/usuario/busqueda-usuarios.htm")
    ModelAndView vistaBusquedaUsuarios();

    @GetMapping(value = "/administrador/usuario/captura-usuarios.htm")
    ModelAndView vistaCapturaUsuarios();

    @GetMapping(value = "/administrador/usuario/permisos-usuarios.htm")
    ModelAndView vistaPermisosUsuarios();

    @GetMapping(value = "/administrador/usuario/restablecer-cedenciales-usuarios.htm")
    ModelAndView vistaCredencialesUsuarios();
}
