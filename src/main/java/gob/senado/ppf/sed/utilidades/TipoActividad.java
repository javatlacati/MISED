package gob.senado.ppf.sed.utilidades;

public enum TipoActividad {
    PLANEACION("planeacion"),
    CALENDARIZACION("calendarizacion"),
    INFORME_PRIMER_CUATRIMESTRE("primer cuatrimestre"),
    INFORME_SEGUNDO_CUATRIMESTRE("segundo cuatrimestre"),
    INFORME_TERCER_CUATRIMESTRE("tercer cuatrimestre");
    
    private String actividad;
    
    private TipoActividad(String fase){
        this.actividad = fase;
    }
    
    @Override
    public String toString() {
        return this.actividad;
    }
    
}
