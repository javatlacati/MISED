package gob.senado.ppf.sed.utilidades;

import gob.senado.ppf.sed.dto.organizaciontecnicaadministrativa.OrganizacionTecnicaAdministrativa;
import java.sql.ResultSet;
import org.springframework.jdbc.core.RowMapper;
import gob.senado.ppf.sed.dto.organodireccionestrategica.OrganoDireccionEstrategica;
import gob.senado.ppf.sed.dto.programainstitucional.ProgramaInstitucional;
import gob.senado.ppf.sed.dto.unidadapoyo.UnidadApoyo;
import gob.senado.ppf.sed.dto.usuario.Usuario;
import gob.senado.ppf.sed.dto.usuario.UsuarioPermiso;

public class RowMappers {
    
    public static final RowMapper<Usuario> ROW_MAPPER_USUARIO = (ResultSet rs, int rowNum) -> {
        Usuario u = Suppliers.USUARIO.get();
        UsuarioPermiso up = Suppliers.USUARIO_PERMISO.get();
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
        u.setRolDesignado(rs.getString(12));
        u.setFechaRegistro(rs.getString(13));
        u.setHoraRegistro(rs.getString(14));
        up.setIdPermiso(rs.getLong(15));
        up.setIdUsuario(rs.getLong(16));
        up.setPuedeConsultar(rs.getBoolean(17));
        up.setPuedeActualizar(rs.getBoolean(18));
        up.setPuedeAgregar(rs.getBoolean(19));
        up.setPuedeBorrar(rs.getBoolean(20));
        up.setPuedeAutenticarse(rs.getBoolean(21));
        u.setUsuarioPermiso(up);
        return u;
    };
    
    public static final RowMapper<ProgramaInstitucional> ROW_MAPPER_PROGRAMA_INSTITICIONAL = (ResultSet rs, int rowNum)->{
        ProgramaInstitucional pi = Suppliers.PROGRAMA_INSTITUCIONAL.get();
        pi.setIdProgramaInstitucional(rs.getLong(1));
        pi.setClave(rs.getString(2));
        pi.setNombre(rs.getString(3));
        pi.setDescripcion(rs.getString(4));
        pi.setTotalOrganosDireccionEstrategicaAdscritos(rs.getLong(5));
        pi.setTotalUnidadesApoyoAsociadasPorOrganosDireccionEstrategicaAdscritos(rs.getLong(6));
        return pi;
    };
    
    public static final RowMapper<OrganoDireccionEstrategica> ROW_MAPPER_ORGANO_DIRECCION_ESTRATEGICA = (ResultSet rs, int rowNum)->{
        OrganoDireccionEstrategica ode = Suppliers.ORGANO_DIRECCION_ESTRATEGICA.get();
        ode.setIdOrganoDireccionEstrategica(rs.getLong(1));
        ode.setIdProgramaInstitucional(rs.getLong(2));
        ode.setNombre(rs.getString(3));
        ode.setDescripcion(rs.getString(4));
        ode.setTotalUnidadesApoyoAdscritas(rs.getLong(5));
        return ode;
    };
    
    public static final RowMapper<UnidadApoyo> ROW_MAPPER_UNIDAD_APOYO = (ResultSet rs, int rowNum)->{
        UnidadApoyo ua = Suppliers.UNIDAD_APOYO.get();
        ua.setIdUnidadApoyo(rs.getLong(1));
        ua.setIdOrganoDireccionEstrategica(rs.getLong(2));
        ua.setNombre(rs.getString(3));
        ua.setProposito(rs.getString(4));
        return ua;
    };
    
    public static final RowMapper<OrganizacionTecnicaAdministrativa> ROW_MAPPER_ORGANIZACION_TECNICA_ADMINISTRATIVA = (ResultSet rs, int rowNum)->{
        ProgramaInstitucional pi = Suppliers.PROGRAMA_INSTITUCIONAL.get();
        OrganoDireccionEstrategica ode = Suppliers.ORGANO_DIRECCION_ESTRATEGICA.get();
        UnidadApoyo ua = Suppliers.UNIDAD_APOYO.get();
        OrganizacionTecnicaAdministrativa ota = Suppliers.ORGANIZACION_TECNICA_ADMINISTRATIVA.get();
       
        pi.setIdProgramaInstitucional(rs.getLong(1));
        pi.setClave(rs.getString(2));
        pi.setNombre(rs.getString(3));
        pi.setDescripcion(rs.getString(4));
        pi.setTotalOrganosDireccionEstrategicaAdscritos(rs.getLong(5));
        pi.setTotalUnidadesApoyoAsociadasPorOrganosDireccionEstrategicaAdscritos(rs.getLong(6));
        ode.setIdOrganoDireccionEstrategica(rs.getLong(7));
        ode.setIdProgramaInstitucional(rs.getLong(8));
        ode.setNombre(rs.getString(9));
        ode.setDescripcion(rs.getString(10));
        ode.setTotalUnidadesApoyoAdscritas(rs.getLong(11));
        ua.setIdUnidadApoyo(rs.getLong(12));
        ua.setIdOrganoDireccionEstrategica(rs.getLong(13));
        ua.setNombre(rs.getString(14));
        ua.setProposito(rs.getString(15));
        ota.setProgramInstitucional(pi);
        ota.setOrganoDireccionEstrategica(ode);
        ota.setUnidadApoyo(ua);
        return ota;
    };
}
