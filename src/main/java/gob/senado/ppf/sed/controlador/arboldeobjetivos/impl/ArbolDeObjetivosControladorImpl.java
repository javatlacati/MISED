package gob.senado.ppf.sed.controlador.arboldeobjetivos.impl;

import gob.senado.ppf.sed.controlador.arboldeobjetivos.ArbolDeObjetivosControlador;
import gob.senado.ppf.sed.utilidades.Suppliers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrador on 19/05/2017.
 */
@RequestMapping(value = "/arboldeobjetivos")
@Controller(value = "arbolDeObjetivosControlador")
public class ArbolDeObjetivosControladorImpl implements ArbolDeObjetivosControlador {
    @Override
    @GetMapping(value = "/actualizar-objetivos.htm")
    public ModelAndView vistaActualizarObjetivos() {
        return new ModelAndView("/actualizar-objetivos",
                "arbol-de-objetivos", Suppliers.USUARIO.get()); //TODO corregir supplier
    }

    @Override
    @GetMapping(value = "/baja-objetivos.htm")
    public ModelAndView vistaBajaObjetivos() {
        return new ModelAndView("/baja-objetivos",
                "arbol-de-objetivos", Suppliers.USUARIO.get()); //TODO corregir supplier
    }

    @Override
    @GetMapping(value = "/captura-objetivos.htm")
    public ModelAndView vistaCapturaObjetivos() {
        return new ModelAndView("/captura-objetivos",
                "arbol-de-objetivos", Suppliers.USUARIO.get()); //TODO corregir supplier
    }

    @Override
    @GetMapping(value = "/creacion-arbol-objetivos.htm")
    public ModelAndView vistaCreacionArbolObjetivos() {
        return new ModelAndView("/creacion-arbol-objetivos",
                "arbol-de-objetivos", Suppliers.USUARIO.get()); //TODO corregir supplier
    }

    @Override
    @GetMapping(value = "/borrar-arbol-objetivos.htm")
    public ModelAndView vistaBorrarArbolObjetivos() {
        return new ModelAndView("/borrar-arbol-objetivos",
                "arbol-de-objetivos", Suppliers.USUARIO.get()); //TODO corregir supplier
    }

    @Override
    @GetMapping(value = "/reportes-arbol-objetivos.htm")
    public ModelAndView vistaReportesArbolObjetivos() {
        return new ModelAndView("/reportes-arbol-objetivos",
                "arbol-de-objetivos", Suppliers.USUARIO.get()); //TODO corregir supplier
    }

}
