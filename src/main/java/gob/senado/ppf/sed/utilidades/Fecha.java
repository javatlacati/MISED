package gob.senado.ppf.sed.utilidades;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Fecha {
	public static final DateTimeFormatter FORMATO_FECHA_PRESENTACION = DateTimeFormatter.ofPattern("EEEE d 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
	public static final DateTimeFormatter FORMATO_FECHA_DEFAULT = DateTimeFormatter.ofPattern("dd/MM/yyyy", new Locale("es", "ES"));
}
