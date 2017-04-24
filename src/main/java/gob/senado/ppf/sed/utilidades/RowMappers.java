package gob.senado.ppf.sed.utilidades;

import java.sql.ResultSet;
import org.springframework.jdbc.core.RowMapper;

import gob.senado.ppf.sed.dto.organodireccionestrategica.OrganoDireccionEstrategica;
import gob.senado.ppf.sed.dto.programainstitucional.ProgramaInstitucional;
import gob.senado.ppf.sed.dto.unidadapoyo.UnidadApoyo;
import gob.senado.ppf.sed.dto.usuario.ActividadExtemporanea;
import gob.senado.ppf.sed.dto.usuario.Usuario;
import gob.senado.ppf.sed.dto.usuario.UsuarioPermiso;

public class RowMappers {

	public static final RowMapper<Usuario> ROW_MAPPER_USUARIO = (ResultSet rs, int rowNum) -> {

		Usuario u = Suppliers.USUARIO.get();
		UsuarioPermiso up = Suppliers.USUARIO_PERMISO.get();
		ActividadExtemporanea ae = Suppliers.ACTIVIDAD_EXTEMPORANEA.get();

		u.setIdUsuario(rs.getLong(1));
		u.setIdUnidadApoyo(rs.getLong(2));
		u.setIdentidad(rs.getString(3));
		u.setClaveAcceso(rs.getString(4));
		u.setNombre(rs.getString(5));
		u.setApellidoPaterno(rs.getString(6));
		u.setApellidoMaterno(rs.getString(7));
		u.setPuestoLaboral(rs.getString(8));
		u.setCorreoElectronico(rs.getString(9));
		u.setExtensionTelefonica(rs.getString(10));
		u.setRolDesignado(rs.getString(11));
		u.setFechaRegistro(rs.getString(12));
		u.setHoraRegistro(rs.getString(13));

		up.setIdPermiso(rs.getLong(14));
		up.setIdUsuario(rs.getLong(15));
		up.setPuedeConsultar(rs.getBoolean(16));
		up.setPuedeActualizar(rs.getBoolean(17));
		up.setPuedeAgregar(rs.getBoolean(18));
		up.setPuedeBorrar(rs.getBoolean(19));
		up.setPuedeAutenticarse(rs.getBoolean(20));

		ae.setIdActividadExtemporanea(rs.getLong(21));
		ae.setIdUsuario(rs.getLong(22));
		ae.setFasePlaneacion(rs.getBoolean(23));
		ae.setFaseCalendarizacion(rs.getBoolean(24));
		ae.setFasePrimerCuatrimestre(rs.getBoolean(25));
		ae.setFaseSegundoCuatrimestre(rs.getBoolean(26));
		ae.setFaseTercerCuatrimestre(rs.getBoolean(27));

		u.setUsuarioPermiso(up);
		u.setActividadExtemporanea(ae);

		return u;
	};
	
	public static final RowMapper<ProgramaInstitucional> ROW_MAPPER_PROGRAMA_INSTITICIONAL = (ResultSet rs, int rowNum)->{
		ProgramaInstitucional pi = Suppliers.PROGRAMA_INSTITUCIONAL.get();
		pi.setIdProgramaInstitucional(rs.getLong(1));
		pi.setClave(rs.getString(2));
		pi.setNombre(rs.getString(3));
		pi.setDescripcion(rs.getString(4));
		return pi;
	};
	
	public static final RowMapper<OrganoDireccionEstrategica> ROW_MAPPER_ORGANO_DIRECCION_ESTRATEGICA = (ResultSet rs, int rowNum)->{
		OrganoDireccionEstrategica ode = Suppliers.ORGANO_DIRECCION_ESTRATEGICA.get();
		ode.setIdOrganoDireccionEstrategica(rs.getLong(1));
		ode.setIdProgramaInstitucional(rs.getLong(2));
		ode.setNombre(rs.getString(3));
		ode.setDescripcion(rs.getString(4));
		return ode;
	};
	
	public static final RowMapper<UnidadApoyo> ROW_MAPPER_UNIDAD_APOYO = (ResultSet rs, int rowNum)->{
		UnidadApoyo ua = Suppliers.UNIDAD_APOYO.get();
		ua.setIdUnidadaApoyo(rs.getLong(1));
		ua.setIdOrganoDireccionEstrategica(rs.getLong(2));
		ua.setNombre(rs.getString(3));
		ua.setProposito(rs.getString(4));
		return ua;
	};
}
