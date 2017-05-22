package gob.senado.ppf.sed.controlador.arboldeobjetivos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrador on 19/05/2017.
 */
public interface ArbolDeObjetivosControlador {
    ModelAndView vistaActualizarObjetivos();

    ModelAndView vistaBajaObjetivos();

    ModelAndView vistaCapturaObjetivos();

    ModelAndView vistaBorrarArbolObjetivos();

    ModelAndView vistaCreacionArbolObjetivos();

    ModelAndView vistaReportesArbolObjetivos();

    @GetMapping(value = "/busqueda-arbol-objetivos-historial.html")
    ModelAndView vistaBusquedaArbolObjetivosHistorial();
}
