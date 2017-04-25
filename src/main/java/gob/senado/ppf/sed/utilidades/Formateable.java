package gob.senado.ppf.sed.utilidades;

import com.google.gson.Gson;

public interface Formateable {

	public default String json() {
		return new Gson().toJson(this);
	}
}
