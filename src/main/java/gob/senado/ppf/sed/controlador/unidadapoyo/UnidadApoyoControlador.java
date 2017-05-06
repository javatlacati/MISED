package gob.senado.ppf.sed.controlador.unidadapoyo;

import gob.senado.ppf.sed.dto.unidadapoyo.UnidadApoyo;
import java.util.List;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

public interface UnidadApoyoControlador {
    
    ModelAndView vistaAdministracionUnidadesApoyo();
    
    HttpEntity<List<UnidadApoyo>> obtenerUnidadesApoyo();
    
    ResponseEntity<UnidadApoyo> registroUnidadApoyo(UnidadApoyo unidadApoyo);
    
    ResponseEntity<UnidadApoyo> bajaUnidadApoyo(String idUnidadApoyo);
    
    HttpEntity<UnidadApoyo> buscarUnidadApoyo(String idUnidadApoyo);
    
    ResponseEntity<UnidadApoyo> actualizarUnidadApoyo(UnidadApoyo unidadApoyo, BindingResult result);
}
