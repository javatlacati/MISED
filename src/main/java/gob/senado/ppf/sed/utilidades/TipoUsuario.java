package gob.senado.ppf.sed.utilidades;

import java.io.Serializable;

public enum TipoUsuario implements Serializable, Formateable {
    
    ENLACE("ENLACE"),
    TITULAR("TITULAR");
    
    private String tipoUsuario;
    
    private TipoUsuario(String tipoUsuario){
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public String toString() {
        return this.tipoUsuario;
    }
    
    
}
