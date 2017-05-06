package gob.senado.ppf.sed.controlador.unidadapoyo.impl;

import gob.senado.ppf.sed.controlador.unidadapoyo.UnidadApoyoControlador;
import gob.senado.ppf.sed.dto.unidadapoyo.UnidadApoyo;
import gob.senado.ppf.sed.servicio.unidadapoyo.UnidadApoyoServicio;
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


@Controller(value = "unidadApoyoControlador")
@RequestMapping(value = "/administrador")
public class UnidadApoyoControladorImpl implements UnidadApoyoControlador{
    
    private final UnidadApoyoServicio unidadApoyoServicio;
    
    @Autowired
    public UnidadApoyoControladorImpl(UnidadApoyoServicio unidadApoyoServicio) {
        this.unidadApoyoServicio = unidadApoyoServicio;
    }
    
    @Override
    @GetMapping(value = "/unidad-apoyo/administracion-unidades-apoyo.htm")
    public ModelAndView vistaAdministracionUnidadesApoyo() {
        return new ModelAndView("administrador/unidades-apoyo/administracion-unidad-apoyo",
                "unidadApoyo", Suppliers.UNIDAD_APOYO.get());
    }
    
    @Override
    @PostMapping(value = "/unidad-apoyo/unidades-apoyo.json")
    public HttpEntity<List<UnidadApoyo>> obtenerUnidadesApoyo() {
        List<UnidadApoyo> listaUnidadesApoyo = unidadApoyoServicio.obtenerUnidadesApoyo();
        if(listaUnidadesApoyo.size() > 0){
            return new ResponseEntity<>(listaUnidadesApoyo, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(listaUnidadesApoyo, HttpStatus.NO_CONTENT);
        }
    }
    
    @Override
    @PostMapping(value = "/unidad-apoyo/registro-unidad-apoyo")
    public ResponseEntity<UnidadApoyo> registroUnidadApoyo(@ModelAttribute("unidadApoyo") UnidadApoyo unidadApoyo) {
        if(unidadApoyoServicio.altaUnidadApoyo(unidadApoyo)){
            return new ResponseEntity<>(unidadApoyo, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
    
    @Override
    @PostMapping(value = "/unidad-apoyo/baja-unidad-apoyo/{idUnidadApoyo}")
    public ResponseEntity<UnidadApoyo> bajaUnidadApoyo(@PathVariable("idUnidadApoyo") String idUnidadApoyo) {
        try{
            long identificadorUnidadApoyo = Long.parseLong(idUnidadApoyo);
            final UnidadApoyo unidadApoyo = unidadApoyoServicio
                    .buscarUnidadApoyo(identificadorUnidadApoyo);
            if(unidadApoyo != null){
                if(unidadApoyoServicio.bajaUnidadApoyo(identificadorUnidadApoyo)){
                    return new ResponseEntity<>(unidadApoyo, HttpStatus.OK);
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
    @PostMapping(value = "/unidad-apoyo/buscar-unidad-apoyo/{idUnidadApoyo}")
    public HttpEntity<UnidadApoyo> buscarUnidadApoyo(@PathVariable("idUnidadApoyo") String idUnidadApoyo) {
        try{
            long identificadorUnidadApoyo = Long.parseLong(idUnidadApoyo);
            final UnidadApoyo unidadApoyo = unidadApoyoServicio
                    .buscarUnidadApoyo(identificadorUnidadApoyo);
            if(unidadApoyo != null){
                return new ResponseEntity<>(unidadApoyo, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch(NumberFormatException nfe){
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
    
    @Override
    @PostMapping(value = "/unidad-apoyo/actualizar-unidad-apoyo")
    public ResponseEntity<UnidadApoyo> actualizarUnidadApoyo(@ModelAttribute("unidadApoyo") UnidadApoyo unidadApoyo, BindingResult result) {
        final UnidadApoyo unidadApoyoRegistrado = unidadApoyoServicio
                .buscarUnidadApoyo(unidadApoyo.getIdUnidadApoyo());
        if(unidadApoyoRegistrado != null){
            if(unidadApoyoServicio.actualizarUnidadApoyo(unidadApoyo)){
                return new ResponseEntity<>(unidadApoyo, HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
            }
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    
}
