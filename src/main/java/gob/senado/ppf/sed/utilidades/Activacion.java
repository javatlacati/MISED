package gob.senado.ppf.sed.utilidades;

public enum Activacion {
	
	ACTIVADO(true, "activado"), 
	DESACTIVADO(false, "desactivado");
	
	private final boolean interruptor;
	private final String tipo;

	private Activacion(boolean interruptor, String activacion) {
		this.interruptor = interruptor;
		this.tipo = activacion;
	}

	public String getTipo() {
		return tipo;
	}

	public boolean getInterruptor() {
		return interruptor;
	}

	@Override
	public String toString() {
		return this.interruptor + " " + this.tipo;
	}
}
