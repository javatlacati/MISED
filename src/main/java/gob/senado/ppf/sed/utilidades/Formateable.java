package gob.senado.ppf.sed.utilidades;

import com.google.gson.Gson;

/**
 * Permite formatear una clase como JSON.
 * Provee una implementaci&oacute;n por defecto basada en GSON.
 */
public interface Formateable {
	
	public static final String UTF_8 = "UTF-8";

    /**
     * Obtiene una representaci&oacute;n de la instancia del objeto actual en formato JSON.
     */
    public default String json() {
        return new Gson().toJson(this);
    }
}
