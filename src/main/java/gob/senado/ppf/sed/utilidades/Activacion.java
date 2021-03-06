package gob.senado.ppf.sed.utilidades;


/**
 * Fases en la activaci&oacute;n de un usuario.
 */
public enum Activacion {

    ACTIVADO(true, "activado"),
    DESACTIVADO(false, "desactivado");

    private final boolean interruptor;
    private final String tipo;

    Activacion(boolean interruptor, String activacion) {
        this.interruptor = interruptor;
        this.tipo = activacion;
    }
    
    public String getTipo() {
		return tipo;
	}
    
    public boolean getEstadoInterruptor() {
		return interruptor;
	}

    @Override
    public String toString() {
        return this.interruptor + " " + this.tipo;
    }
}
