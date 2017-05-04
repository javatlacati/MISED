package gob.senado.ppf.sed.controlador.organodireccionestrategica;

import gob.senado.ppf.sed.dto.organodireccionestrategica.OrganoDireccionEstrategica;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;

public interface OrganoDireccionEstrategicaControlador {
    
    public abstract ModelAndView vistaAdministracionOrganosDireccionEstrategica();
    
    public abstract HttpEntity<List<OrganoDireccionEstrategica>> obtenerOrganosDireccionEstrategica();
    
    public abstract ResponseEntity<OrganoDireccionEstrategica> registroOrganoDireccionEstrategica();
    
    public abstract ResponseEntity<OrganoDireccionEstrategica> bajaOrganoDireccionEstrategica();
    
    public abstract HttpEntity<OrganoDireccionEstrategica> buscarOrganoDireccionEstrategica(String idOrganoDireccionEstrategica);
    
    public abstract ResponseEntity<OrganoDireccionEstrategica> actualizarOrganosDireccionEstrategica(OrganoDireccionEstrategica organoDireccionEstrategica);
}
