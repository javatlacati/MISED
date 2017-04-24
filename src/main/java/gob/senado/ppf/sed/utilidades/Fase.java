package gob.senado.ppf.sed.utilidades;

public enum Fase {
	FASE_PLANEACION("fase planeacion"),
	FASE_CALENDARIZACION("fase calendarizacion"),
	FASE_PRIMER_CUATRIMESTRE("fase primer cuatrimestre"),
	FASE_SEGUNDO_CUATRIMESTRE("fase segundo cuatrimestre"),
	FASE_TERCER_CUATRIMESTRE("fase tercer cuatrimestre");
	
	private String fase;
	
	private Fase(String fase){
		this.fase = fase;
	}
	
	@Override
	public String toString() {
		return this.fase;
	}
	
}
