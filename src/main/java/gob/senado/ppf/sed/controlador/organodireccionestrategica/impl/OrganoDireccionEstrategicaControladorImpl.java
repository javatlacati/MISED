package gob.senado.ppf.sed.controlador.organodireccionestrategica.impl;

import gob.senado.ppf.sed.controlador.organodireccionestrategica.OrganoDireccionEstrategicaControlador;
import gob.senado.ppf.sed.dto.organodireccionestrategica.OrganoDireccionEstrategica;
import gob.senado.ppf.sed.servicio.organodireccionestrategica.OrganoDireccionEstrategicaServicio;
import gob.senado.ppf.sed.utilidades.Suppliers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "organoDireccionEstrategicaControlador")
@RequestMapping(value = "/administrador")
public class OrganoDireccionEstrategicaControladorImpl implements OrganoDireccionEstrategicaControlador {
    
    private final OrganoDireccionEstrategicaServicio organoDireccionEstrategicaServicio;
    
    @Autowired
    public OrganoDireccionEstrategicaControladorImpl(OrganoDireccionEstrategicaServicio organoDireccionEstrategicaServicio) {
        this.organoDireccionEstrategicaServicio = organoDireccionEstrategicaServicio;
    }
    
    @Override
    @GetMapping(value = "/organo-direccion-estrategica/administracion-organo-direccion-estrategica.htm")
    public ModelAndView vistaAdministracionOrganosDireccionEstrategica() {
        return new ModelAndView("administrador/organos-direccion-estrategica/administracion-organo-direccion-estrategica",
                "organoDireccionEstrategica", Suppliers.ORGANO_DIRECCION_ESTRATEGICA.get());
    }
    
    @Override
    @PostMapping(value = "/organo-direccion-estrategica/organos-direccion-estrategica.json")
    public HttpEntity<List<OrganoDireccionEstrategica>> obtenerOrganosDireccionEstrategica() {
        List<OrganoDireccionEstrategica> organosDireccionEstrategica = organoDireccionEstrategicaServicio.obtenerOrganosDireccionEstrategica();
        if(organosDireccionEstrategica.size() > 0){
            return new ResponseEntity<>(organosDireccionEstrategica, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(organosDireccionEstrategica, HttpStatus.NO_CONTENT);
        }
    }
    
    @Override
    @PostMapping(value = "/organo-direccion-estrategica/registro-organo-direccion-estrategica")
    public ResponseEntity<OrganoDireccionEstrategica> registroOrganoDireccionEstrategica(
            @ModelAttribute("organoDireccionEstrategica") OrganoDireccionEstrategica organoDireccionEstrategica) {
        if(organoDireccionEstrategicaServicio.altaOrganoDireccionEstrategica(organoDireccionEstrategica)){
            return new ResponseEntity<>(organoDireccionEstrategica, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
    
    @Override
    @PostMapping(value = "/organo-direccion-estrategica/baja-organo-direccion-estrategica/{idOrganoDireccionEstrategica}")
    public ResponseEntity<OrganoDireccionEstrategica> bajaOrganoDireccionEstrategica(
            @PathVariable(name = "idOrganoDireccionEstrategica") String idOrganoDireccionEstrategica) {
        try{
            long identificadorOrganoDireccionEstrategica = Long.parseLong(idOrganoDireccionEstrategica);
            final OrganoDireccionEstrategica organoDireccionEstrategica = organoDireccionEstrategicaServicio
                    .buscarOrganoDireccionEstrategica(identificadorOrganoDireccionEstrategica);
            if(organoDireccionEstrategica != null){
                if(organoDireccionEstrategicaServicio.bajaOrganoDireccionEstrategica(identificadorOrganoDireccionEstrategica)){
                    return new ResponseEntity<>(organoDireccionEstrategica, HttpStatus.OK);
                }else{
                    return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
                }
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch(NumberFormatException nfe){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
    
    @Override
    @PostMapping(value = "/organo-direccion-estrategica/buscar-organo-direccion-estrategica/{idOrganoDireccionEstrategica}")
    public HttpEntity<OrganoDireccionEstrategica> buscarOrganoDireccionEstrategica(
            @PathVariable(name = "idOrganoDireccionEstrategica") String idOrganoDireccionEstrategica) {
        try{
            long identificadorOrganoDireccionEstrategica = Long.parseLong(idOrganoDireccionEstrategica);
            final OrganoDireccionEstrategica organoDireccionEstrategica = organoDireccionEstrategicaServicio
                    .buscarOrganoDireccionEstrategica(identificadorOrganoDireccionEstrategica);
            if(organoDireccionEstrategica != null){
                return new ResponseEntity<>(organoDireccionEstrategica, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch(NumberFormatException nfe){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
    
    @Override
    @PostMapping(value = "/organo-direccion-estrategica/actualizar-organo-direccion-estrategica")
    public ResponseEntity<OrganoDireccionEstrategica> actualizarOrganosDireccionEstrategica(
            @ModelAttribute(name = "organoDireccionEstrategica") OrganoDireccionEstrategica organoDireccionEstrategica, BindingResult result) {
        final OrganoDireccionEstrategica OrganoDireccionEstrategicaRegistrado = organoDireccionEstrategicaServicio
                .buscarOrganoDireccionEstrategica(organoDireccionEstrategica.getIdOrganoDireccionEstrategica());
        if(OrganoDireccionEstrategicaRegistrado != null){
            if(organoDireccionEstrategicaServicio.actualizarOrganoDireccionEstrategica(organoDireccionEstrategica)){
                return new ResponseEntity<>(organoDireccionEstrategica, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
            }
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
}
