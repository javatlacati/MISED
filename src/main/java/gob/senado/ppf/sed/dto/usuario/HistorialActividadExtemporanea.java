package gob.senado.ppf.sed.dto.usuario;

import gob.senado.ppf.sed.utilidades.Formateable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.io.Serializable;

public class HistorialActividadExtemporanea implements Serializable, Formateable {

	private static final long serialVersionUID = 1L;

	private long idHistorialActividadExtemporanea;
	private long idActividadExtemporanea;
	/**
	 * Identificador &uacute;nico de cada usuario.
	 */
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

	public void setSolicitoFasePlaneacion(boolean solicitoFasePlaneacion) {
		this.solicitoFasePlaneacion = solicitoFasePlaneacion;
	}

	public void setSolicitoFaseCalendarizacion(boolean solicitoFaseCalendarizacion) {
		this.solicitoFaseCalendarizacion = solicitoFaseCalendarizacion;
	}

	public void setSolicitoFasePrimerCuatrimestre(boolean solicitoFasePrimerCuatrimestre) {
		this.solicitoFasePrimerCuatrimestre = solicitoFasePrimerCuatrimestre;
	}

	public void setSolicitoFaseSegundoCuatrimestre(boolean solicitoFaseSegundoCuatrimestre) {
		this.solicitoFaseSegundoCuatrimestre = solicitoFaseSegundoCuatrimestre;
	}

	public void setSolicitoFaseTercerCuatrimestre(boolean solicitoFaseTercerCuatrimestre) {
		this.solicitoFaseTercerCuatrimestre = solicitoFaseTercerCuatrimestre;
	}

	public boolean solicitoFasePlaneacion() {
		return solicitoFasePlaneacion;
	}

	public boolean solicitoFaseCalendarizacion() {
		return solicitoFaseCalendarizacion;
	}

	public boolean solicitoFasePrimerCuatrimestre() {
		return solicitoFasePrimerCuatrimestre;
	}

	public boolean solicitoFaseSegundoCuatrimestre() {
		return solicitoFaseSegundoCuatrimestre;
	}

	public boolean solicitoFaseTercerCuatrimestre() {
		return solicitoFaseTercerCuatrimestre;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}

}
