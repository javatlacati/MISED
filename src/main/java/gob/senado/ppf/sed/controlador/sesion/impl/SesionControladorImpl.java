package gob.senado.ppf.sed.controlador.sesion.impl;

import gob.senado.ppf.sed.controlador.sesion.SesionControlador;
import gob.senado.ppf.sed.dto.organodireccionestrategica.OrganoDireccionEstrategica;
import gob.senado.ppf.sed.dto.programainstitucional.ProgramaInstitucional;
import gob.senado.ppf.sed.dto.unidadapoyo.UnidadApoyo;
import gob.senado.ppf.sed.dto.usuario.Usuario;
import gob.senado.ppf.sed.servicio.organodireccionestrategica.OrganoDireccionEstrategicaServicio;
import gob.senado.ppf.sed.servicio.programainstitucional.ProgramaInstitucionalServicio;
import gob.senado.ppf.sed.servicio.unidadapoyo.UnidadApoyoServicio;
import gob.senado.ppf.sed.servicio.usuario.UsuarioServicio;
import gob.senado.ppf.sed.utilidades.Fecha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.time.LocalDate;

@Controller(value = "sesionControlador")
public class SesionControladorImpl implements SesionControlador {

    /**
     * Servicio de administración de usuarios.
     */
    @Autowired
    private UsuarioServicio usuarioServicio;

    /**
     * Servicio de administración de unidades de apoyo.
     */
    @Autowired
    private UnidadApoyoServicio unidadApoyoServicio;

    /**
     * Servicio de administración de órganos de dirección estratégica.
     */
    @Autowired
    private OrganoDireccionEstrategicaServicio organoDireccionEstrategicaServicio;

    /**
     * Servicio de administración de programas institucionales.
     */
    @Autowired
    private ProgramaInstitucionalServicio programaInstitucionalServicio;

    @Override
    @GetMapping(value = "/inicio-sesion")
    public ModelAndView vistaInicioSesion(@RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout) {
        ModelAndView model = new ModelAndView("login/login");
        if (error != null) {
            model.addObject("error", "Has escrito mal tu usuario o contrase\u00f1a.");
        }
        if (logout != null) {
            model.addObject("message", "Cierre de sesi\u00f3n exitosamente.");
        }
        return model;
    }

    @Override
    @GetMapping(value = {"/inicio.htm", "/"})
    public ModelAndView vistaMenuPrincipal(HttpSession sesion, HttpServletResponse response, HttpServletRequest request, Principal principal) {
        ModelAndView mv = new ModelAndView("login/inicio");
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(1800);
        Usuario u = usuarioServicio.buscarUsuario(principal.getName());
        UnidadApoyo ua = unidadApoyoServicio.buscarUnidadApoyo(u.getIdUnidadApoyo());
        OrganoDireccionEstrategica ode = organoDireccionEstrategicaServicio.buscarOrganoDireccionEstrategica(ua.getIdOrganoDireccionEstrategica());
        ProgramaInstitucional pi = programaInstitucionalServicio.buscarProgramaInstitucional(ode.getIdProgramaInstitucional());
        mv.addObject("programaInstitucional", pi.getClave() + " " + pi.getNombre());
        mv.addObject("organoDireccionEstrategica", ode.getNombre());
        mv.addObject("unidadApoyo", ua.getNombre());
        mv.addObject("fechaActual", Fecha.FORMATO_FECHA_PRESENTACION.format(LocalDate.now()));
        mv.addObject("nombreCompleto", u.getNombre() + " " + u.getApellidoPaterno() + " " + u.getApellidoMaterno());
        return mv;
    }
}
