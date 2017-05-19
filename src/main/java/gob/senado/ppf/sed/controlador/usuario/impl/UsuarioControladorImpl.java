package gob.senado.ppf.sed.controlador.usuario.impl;

import gob.senado.ppf.sed.controlador.usuario.UsuarioControlador;
import gob.senado.ppf.sed.servicio.usuario.UsuarioServicio;
import gob.senado.ppf.sed.utilidades.Suppliers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrador on 18/05/2017.
 */
@Controller(value = "usuarioControlador")
@RequestMapping(value = "/usuario")
public class UsuarioControladorImpl implements UsuarioControlador {

    private final UsuarioServicio usuarioServicio;

    @Autowired
    public UsuarioControladorImpl(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }

    @Override
    @GetMapping(value = "/mi-perfil.htm")
    public ModelAndView vistaMiPerfil() {
        return new ModelAndView("usuario/mi-perfil",
                "unidadApoyo", Suppliers.USUARIO.get());
    }
}
