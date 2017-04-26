package gob.senado.ppf.sed.utilidades;

import lombok.Getter;

/**
 * Fases en la activaci&oacute;n de un usuario.
 */
@Getter
public enum Activacion {

    ACTIVADO(true, "activado"),
    DESACTIVADO(false, "desactivado");

    private final boolean interruptor;
    private final String tipo;

    private Activacion(boolean interruptor, String activacion) {
        this.interruptor = interruptor;
        this.tipo = activacion;
    }

    @Override
    public String toString() {
        return this.interruptor + " " + this.tipo;
    }
}
