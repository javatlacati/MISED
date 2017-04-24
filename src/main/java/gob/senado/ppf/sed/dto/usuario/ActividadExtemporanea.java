package gob.senado.ppf.sed.dto.usuario;

import java.io.Serializable;
import java.util.Objects;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ActividadExtemporanea implements Serializable {

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

	public boolean isFasePlaneacion() {
		return fasePlaneacion;
	}

	public void setFasePlaneacion(boolean fasePlaneacion) {
		this.fasePlaneacion = fasePlaneacion;
	}

	public boolean isFaseCalendarizacion() {
		return faseCalendarizacion;
	}

	public void setFaseCalendarizacion(boolean faseCalendarizacion) {
		this.faseCalendarizacion = faseCalendarizacion;
	}

	public boolean isFasePrimerCuatrimestre() {
		return fasePrimerCuatrimestre;
	}

	public void setFasePrimerCuatrimestre(boolean fasePrimerCuatrimestre) {
		this.fasePrimerCuatrimestre = fasePrimerCuatrimestre;
	}

	public boolean isFaseSegundoCuatrimestre() {
		return faseSegundoCuatrimestre;
	}

	public void setFaseSegundoCuatrimestre(boolean faseSegundoCuatrimestre) {
		this.faseSegundoCuatrimestre = faseSegundoCuatrimestre;
	}

	public boolean isFaseTercerCuatrimestre() {
		return faseTercerCuatrimestre;
	}

	public void setFaseTercerCuatrimestre(boolean faseTercerCuatrimestre) {
		this.faseTercerCuatrimestre = faseTercerCuatrimestre;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof ActividadExtemporanea){
			final ActividadExtemporanea ae = (ActividadExtemporanea)obj;
			return this.idUsuario == ae.idUsuario;
		}else{
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(this.idUsuario);
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
