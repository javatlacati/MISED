package gob.senado.ppf.sed.controlador.organodireccionestrategica.impl;

import gob.senado.ppf.sed.controlador.organodireccionestrategica.OrganoDireccionEstrategicaControlador;
import gob.senado.ppf.sed.dto.organodireccionestrategica.OrganoDireccionEstrategica;
import gob.senado.ppf.sed.servicio.organodireccionestrategica.OrganoDireccionEstrategicaServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;


public class OrganoDireccionEstrategicaControladorImpl implements OrganoDireccionEstrategicaControlador {
    
    private final OrganoDireccionEstrategicaServicio organoDireccionEstrategicaServicio;
    
    @Autowired
    public OrganoDireccionEstrategicaControladorImpl(OrganoDireccionEstrategicaServicio organoDireccionEstrategicaServicio) {
        this.organoDireccionEstrategicaServicio = organoDireccionEstrategicaServicio;
    }
     
    @Override
    public ModelAndView vistaAdministracionOrganosDireccionEstrategica() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public HttpEntity<List<OrganoDireccionEstrategica>> obtenerOrganosDireccionEstrategica() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public ResponseEntity<OrganoDireccionEstrategica> registroOrganoDireccionEstrategica() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public ResponseEntity<OrganoDireccionEstrategica> bajaOrganoDireccionEstrategica() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public HttpEntity<OrganoDireccionEstrategica> buscarOrganoDireccionEstrategica(String idOrganoDireccionEstrategica) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public ResponseEntity<OrganoDireccionEstrategica> actualizarOrganosDireccionEstrategica(OrganoDireccionEstrategica organoDireccionEstrategica) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
