package gob.senado.ppf.sed.controlador.usuario.impl;

import gob.senado.ppf.sed.controlador.usuario.UsuarioControlador;
import gob.senado.ppf.sed.servicio.usuario.UsuarioServicio;
import gob.senado.ppf.sed.utilidades.Suppliers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrador on 18/05/2017.
 */
@Controller(value = "usuarioControlador")
public class UsuarioControladorImpl implements UsuarioControlador {

    private final UsuarioServicio usuarioServicio;

    @Autowired
    public UsuarioControladorImpl(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @Override
    @GetMapping(value = "/usuario/mi-perfil.htm")
    public ModelAndView vistaMiPerfil() {
        return new ModelAndView("usuario/mi-perfil",
                "usuario", Suppliers.USUARIO.get());
    }

    @Override
    @GetMapping(value = "/administrador/usuarios/actualizar-usuarios.htm")
    public ModelAndView vistaActualizarUsuarios() {
        return new ModelAndView("administrador/usuarios/actualizar-usuarios",
                "usuario", Suppliers.USUARIO.get());
    }

    @Override
    @GetMapping(value = "/administrador/usuarios/baja-usuarios.htm")
    public ModelAndView vistaBajaUsuarios() {
        return new ModelAndView("administrador/usuarios/baja-usuarios",
                "usuario", Suppliers.USUARIO.get());
    }

    @Override
    @GetMapping(value = "/administrador/usuarios/busqueda-usuarios.htm")
    public ModelAndView vistaBusquedaUsuarios() {
        return new ModelAndView("administrador/usuarios/busqueda-usuarios",
                "usuario", Suppliers.USUARIO.get());
    }

    @Override
    @GetMapping(value = "/administrador/usuarios/captura-usuarios.htm")
    public ModelAndView vistaCapturaUsuarios() {
        return new ModelAndView("administrador/usuarios/captura-usuarios",
                "usuario", Suppliers.USUARIO.get());
    }

    @Override
    @GetMapping(value = "/administrador/usuarios/permisos-usuarios.htm")
    public ModelAndView vistaPermisosUsuarios() {
        return new ModelAndView("administrador/usuarios/permisos-usuarios",
                "usuario", Suppliers.USUARIO.get());
    }

    @Override
    @GetMapping(value = "/administrador/usuarios/reestablecer-cedenciales-usuarios.htm")
    public ModelAndView vistaCredencialesUsuarios() {
        return new ModelAndView("administrador/usuarios/reestablecer-cedenciales-usuarios",
                "usuario", Suppliers.USUARIO.get());
    }

//    @Override
//    @GetMapping(value = "/administrador/usuario/administracion-usuario.htm")
//    public ModelAndView vistaAdministracionUnidadesApoyo() {
//        return new ModelAndView("administrador/usuario/administracion-usuario",
//                "usuario", Suppliers.USUARIO.get());
//    }

//    @Override
//    @PostMapping(value = "/administrador/usuario/registro-usuario")
//    public ResponseEntity<Usuario> registroUsuario(@ModelAttribute("usuario") Usuario usuario) {
//        if (usuarioServicio.altaUsuario(usuario)) {
//            return new ResponseEntity<>(usuario, HttpStatus.CREATED);
//        } else {
//            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
//        }
//    }
//
//    @Override
//    @PostMapping(value = "/administrador/usuario/baja-usuario/{idUsuario}")
//    public ResponseEntity<Usuario> bajaUsuario(@PathVariable("idUsuario") String idUsuario) {
//        try {
//            long identificadorUsuario = Long.parseLong(idUsuario);
//            final Usuario usuario = usuarioServicio.buscarUsuario(identificadorUsuario);
//            if (usuario != null) {
//                if (usuarioServicio.bajaUsuario(identificadorUsuario)) {
//                    return new ResponseEntity<>(usuario, HttpStatus.OK);
//                } else {
//                    return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
//                }
//            } else {
//                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            }
//        } catch (NumberFormatException nfe) {
//            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
//        }
//    }
//
//    @Override
//    @PostMapping(value = "/administrador/usuario/buscar-usuario/{idUsuario}")
//    public HttpEntity<Usuario> buscarUnidadApoyo(@PathVariable("idUsuario") String idUsuario) {
//        try {
//            long identificadorUsuario = Long.parseLong(idUsuario);
//            final Usuario usuario = usuarioServicio
//                    .buscarUsuario(identificadorUsuario);
//            if (usuario != null) {
//                return new ResponseEntity<>(usuario, HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            }
//        } catch (NumberFormatException nfe) {
//            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
//        }
//    }
//
//    @Override
//    @PostMapping(value = "/administrador/usuario/actualizar-usuario")
//    public ResponseEntity<Usuario> actualizarUnidadApoyo(@ModelAttribute("usuario") Usuario usuario, BindingResult result) {
//        final Usuario usuarioRegistrado = usuarioServicio
//                .buscarUsuario(usuario.getIdUnidadApoyo());
//        if (usuarioRegistrado != null) {
//            if (usuarioServicio.actualizarUsuario(usuario)) {
//                return new ResponseEntity<>(usuario, HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
//            }
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
}
