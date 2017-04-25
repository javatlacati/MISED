package gob.senado.ppf.sed.dto.usuario;

import java.io.Serializable;
import java.util.Objects;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import gob.senado.ppf.sed.utilidades.Formateable;

public class HistorialActividadExtemporanea implements Serializable, Formateable {

	private static final long serialVersionUID = 1L;

	private long idHistorialActividadExtemporanea;
	private long idActividadExtemporanea;
	private long idUsuario;
	private boolean solicitoFasePlaneacion;
	private boolean solicitoFaseCalendarizacion;
	private boolean solicitoFasePrimerCuatrimestre;
	private boolean solicitoFaseSegundoCuatrimestre;
	private boolean solicitoFaseTercerCuatrimestre;
	private String fechaSolicitud;
	private String horaSolicitud;

	public long getIdHistorialActividadExtemporanea() {
		return idHistorialActividadExtemporanea;
	}

	public void setIdHistorialActividadExtemporanea(long idHistorialActividadExtemporanea) {
		this.idHistorialActividadExtemporanea = idHistorialActividadExtemporanea;
	}

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

	public boolean solicitoFasePlaneacion() {
		return solicitoFasePlaneacion;
	}

	public void setSolicitoFasePlaneacion(boolean solicitoFasePlaneacion) {
		this.solicitoFasePlaneacion = solicitoFasePlaneacion;
	}

	public boolean solicitoFaseCalendarizacion() {
		return solicitoFaseCalendarizacion;
	}

	public void setSolicitoFaseCalendarizacion(boolean solicitoFaseCalendarizacion) {
		this.solicitoFaseCalendarizacion = solicitoFaseCalendarizacion;
	}

	public boolean solicitoFasePrimerCuatrimestre() {
		return solicitoFasePrimerCuatrimestre;
	}

	public void setSolicitoFasePrimerCuatrimestre(boolean solicitoFasePrimerCuatrimestre) {
		this.solicitoFasePrimerCuatrimestre = solicitoFasePrimerCuatrimestre;
	}

	public boolean solicitoFaseSegundoCuatrimestre() {
		return solicitoFaseSegundoCuatrimestre;
	}

	public void setSolicitoFaseSegundoCuatrimestre(boolean solicitoFaseSegundoCuatrimestre) {
		this.solicitoFaseSegundoCuatrimestre = solicitoFaseSegundoCuatrimestre;
	}

	public boolean solicitoFaseTercerCuatrimestre() {
		return solicitoFaseTercerCuatrimestre;
	}

	public void setSolicitoFaseTercerCuatrimestre(boolean solicitoFaseTercerCuatrimestre) {
		this.solicitoFaseTercerCuatrimestre = solicitoFaseTercerCuatrimestre;
	}

	public String getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public String getHoraSolicitud() {
		return horaSolicitud;
	}

	public void setHoraSolicitud(String horaSolicitud) {
		this.horaSolicitud = horaSolicitud;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof HistorialActividadExtemporanea) {
			final HistorialActividadExtemporanea hae = (HistorialActividadExtemporanea) obj;
			return this.idHistorialActividadExtemporanea == hae.idHistorialActividadExtemporanea;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.idHistorialActividadExtemporanea);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
