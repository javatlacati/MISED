package gob.senado.ppf.sed.utilidades;

import com.google.gson.Gson;

/**
 * Permite formatear una clase como JSON.
 * Provee una implementaci&oacute;n por defecto basada en GSON.
 */
public interface Formateable {
    /**
     * Obtiene una representaci&oacute;n de la instancia del objeto actual en formato JSON.
     */
    default String json() {
        return new Gson().toJson(this);
    }
}
