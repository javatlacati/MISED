package gob.senado.ppf.sed.utilidades;

import com.google.gson.Gson;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Permite formatear una clase como JSON.
 * Provee una implementaci&oacute;n por defecto basada en GSON.
 */
public interface Formateable {
    /**
     * Obtiene una representaci&oacute;n de la instancia del objeto actual en formato JSON.
     *
     * @return representaci&oacute;n en JSON del objeto actual
     */
    default String json() {
        return new Gson().toJson(this);
    }
    
    default String atributosConCampos(){
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
    }
}
