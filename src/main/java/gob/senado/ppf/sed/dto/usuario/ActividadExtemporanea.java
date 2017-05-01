package gob.senado.ppf.sed.dto.usuario;

import gob.senado.ppf.sed.utilidades.Formateable;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.io.Serializable;

public class ActividadExtemporanea implements Serializable, Formateable {

	private static final long serialVersionUID = 1L;

	private long idActividadExtemporanea;
	private long idUsuario;
	private boolean fasePlaneacion;
	private boolean faseCalendarizacion;
	private boolean fasePrimerCuatrimestre;
	private boolean faseSegundoCuatrimestre;
	private boolean faseTercerCuatrimestre;

	public long getIdActividadExtemporanea() {
		return idActividadExtemporanea;
	}

	public void setIdActividadExtemporanea(long idActividadExtemporanea) {
		this.idActividadExtemporanea = idActividadExtemporanea;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public void setFasePlaneacion(boolean fasePlaneacion) {
		this.fasePlaneacion = fasePlaneacion;
	}

	public boolean estaEnFasePlaneacion() {
		return fasePlaneacion;
	}

	public void setFaseCalendarizacion(boolean faseCalendarizacion) {
		this.faseCalendarizacion = faseCalendarizacion;
	}

	public boolean estaEnFaseCalendarizacion() {
		return faseCalendarizacion;
	}

	public void setFasePrimerCuatrimestre(boolean fasePrimerCuatrimestre) {
		this.fasePrimerCuatrimestre = fasePrimerCuatrimestre;
	}

	public boolean estaEnFasePrimerCuatrimestre() {
		return fasePrimerCuatrimestre;
	}

	public void setFaseSegundoCuatrimestre(boolean faseSegundoCuatrimestre) {
		this.faseSegundoCuatrimestre = faseSegundoCuatrimestre;
	}

	public boolean estaEnFaseSegundoCuatrimestre() {
		return faseSegundoCuatrimestre;
	}

	public void setFaseTercerCuatrimestre(boolean faseTercerCuatrimestre) {
		this.faseTercerCuatrimestre = faseTercerCuatrimestre;
	}

	public boolean estaEnFaseTercerCuatrimestre() {
		return faseTercerCuatrimestre;
	}

	@Override
	public String toString() {
		return org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}

}
