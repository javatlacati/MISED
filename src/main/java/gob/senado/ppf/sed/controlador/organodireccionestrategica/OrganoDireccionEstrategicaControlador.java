package gob.senado.ppf.sed.controlador.organodireccionestrategica;

import gob.senado.ppf.sed.dto.organodireccionestrategica.OrganoDireccionEstrategica;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface OrganoDireccionEstrategicaControlador {
    
    ModelAndView vistaAdministracionOrganosDireccionEstrategica();
    
    HttpEntity<List<OrganoDireccionEstrategica>> obtenerOrganosDireccionEstrategica();
    
    ResponseEntity<OrganoDireccionEstrategica> registroOrganoDireccionEstrategica(OrganoDireccionEstrategica organoDireccionEstrategica);
    
    ResponseEntity<OrganoDireccionEstrategica> bajaOrganoDireccionEstrategica(String idOrganoDireccionEstrategica);
    
    HttpEntity<OrganoDireccionEstrategica> buscarOrganoDireccionEstrategica(String idOrganoDireccionEstrategica);
    
    ResponseEntity<OrganoDireccionEstrategica> actualizarOrganosDireccionEstrategica(OrganoDireccionEstrategica organoDireccionEstrategica, BindingResult result);
}
