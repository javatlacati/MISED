package gob.senado.ppf.sed.utilidades;

import gob.senado.ppf.sed.dto.organodireccionestrategica.OrganoDireccionEstrategica;
import gob.senado.ppf.sed.dto.programainstitucional.ProgramaInstitucional;
import gob.senado.ppf.sed.dto.unidadapoyo.UnidadApoyo;
import gob.senado.ppf.sed.dto.usuario.Usuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;

public class RowMappers {

    public static final RowMapper<Usuario> ROW_MAPPER_USUARIO = (ResultSet rs, int rowNum) -> {

        Usuario u = Suppliers.USUARIO.get();
        u.setClaveProgramaInstitucionalAdscrito(rs.getString(1));
        u.setNombreProgramaInstitucionalAdscrito(rs.getString(2));
        u.setNombreOrganoDireccionEstrategicaAdscrito(rs.getString(3));
        u.setNombreUnidadApoyoAdscrito(rs.getString(4));
        u.setIdUsuario(rs.getLong(5));
        u.setIdUnidadApoyo(rs.getLong(6));
        u.setIdentidad(rs.getString(7));
        u.setClaveAcceso(rs.getString(8));
        u.setNombre(rs.getString(9));
        u.setApellidoPaterno(rs.getString(10));
        u.setApellidoMaterno(rs.getString(11));
        u.setPuestoLaboral(rs.getString(12));
        u.setCorreoElectronico(rs.getString(13));
        u.setExtensionTelefonica(rs.getString(14));
        u.setRolDesignado(rs.getString(15));
        u.setTipoUsuario(rs.getString(16));
        u.setFechaRegistro(rs.getString(17));
        u.setHoraRegistro(rs.getString(18));
        u.setPuedeConsultar(rs.getBoolean(19));
        u.setPuedeActualizar(rs.getBoolean(20));
        u.setPuedeAgregar(rs.getBoolean(21));
        u.setPuedeBorrar(rs.getBoolean(22));
        u.setPuedeAutenticarse(rs.getBoolean(23));
        return u;
    };

    public static final RowMapper<ProgramaInstitucional> ROW_MAPPER_PROGRAMA_INSTITICIONAL = (ResultSet rs,
                                                                                              int rowNum) -> {
        ProgramaInstitucional pi = Suppliers.PROGRAMA_INSTITUCIONAL.get();
        pi.setIdProgramaInstitucional(rs.getLong(1));
        pi.setClave(rs.getString(2));
        pi.setNombre(rs.getString(3));
        pi.setDescripcion(rs.getString(4));
        pi.setTotalOrganosDireccionEstrategicaAdscritos(rs.getLong(5));
        pi.setTotalUnidadesApoyoAsociadasPorOrganosDireccionEstrategicaAdscritos(rs.getLong(6));
        return pi;
    };

    public static final RowMapper<OrganoDireccionEstrategica> ROW_MAPPER_ORGANO_DIRECCION_ESTRATEGICA = (ResultSet rs, int rowNum) -> {
        OrganoDireccionEstrategica ode = Suppliers.ORGANO_DIRECCION_ESTRATEGICA.get();
        ode.setIdProgramaInstitucional(rs.getLong(1));
        ode.setClaveProgramaInstitucional(rs.getString(2));
        ode.setNombreProgramaInstitucional(rs.getString(3));
        ode.setDescripcionProgramaInstitucional(rs.getString(4));
        ode.setIdOrganoDireccionEstrategica(rs.getLong(5));
        ode.setNombre(rs.getString(6));
        ode.setDescripcion(rs.getString(7));
        ode.setTotalUnidadesApoyoAdscritas(rs.getLong(8));
        return ode;
    };

    public static final RowMapper<UnidadApoyo> ROW_MAPPER_UNIDAD_APOYO = (ResultSet rs, int rowNum) -> {
        UnidadApoyo ua = Suppliers.UNIDAD_APOYO.get();
        ua.setIdProgramaInstitucional(rs.getLong(1));
        ua.setClaveProgramaInstitucional(rs.getString(2));
        ua.setNombreProgramaInstitucional(rs.getString(3));
        ua.setDescripcionProgramaInstitucional(rs.getString(4));
        ua.setIdOrganoDireccionEstrategica(rs.getLong(5));
        ua.setNombreOrganoDireccionEstrategica(rs.getString(6));
        ua.setDescripcionOrganoDireccionEstrategica(rs.getString(7));
        ua.setIdUnidadApoyo(rs.getLong(8));
        ua.setNombre(rs.getString(9));
        ua.setProposito(rs.getString(10));
        ua.setTotalUsuariosAdscritosUnidadApoyo(rs.getLong(11));
        return ua;
    };

//    public static final RowMapper<OrganizacionTecnicaAdministrativa> ROW_MAPPER_ORGANIZACION_TECNICA_ADMINISTRATIVA = (ResultSet rs, int rowNum)->{
//        ProgramaInstitucional pi = Suppliers.PROGRAMA_INSTITUCIONAL.get();
//        OrganoDireccionEstrategica ode = Suppliers.ORGANO_DIRECCION_ESTRATEGICA.get();
//        UnidadApoyo ua = Suppliers.UNIDAD_APOYO.get();
//        OrganizacionTecnicaAdministrativa ota = Suppliers.ORGANIZACION_TECNICA_ADMINISTRATIVA.get();
//
//        pi.setIdProgramaInstitucional(rs.getLong(1));
//        pi.setClave(rs.getString(2));
//        pi.setNombre(rs.getString(3));
//        pi.setDescripcion(rs.getString(4));
//        pi.setTotalOrganosDireccionEstrategicaAdscritos(rs.getLong(5));
//        pi.setTotalUnidadesApoyoAsociadasPorOrganosDireccionEstrategicaAdscritos(rs.getLong(6));
//        ode.setIdOrganoDireccionEstrategica(rs.getLong(7));
//        ode.setIdProgramaInstitucional(rs.getLong(8));
//        ode.setNombre(rs.getString(9));
//        ode.setDescripcion(rs.getString(10));
//        ode.setTotalUnidadesApoyoAdscritas(rs.getLong(11));
//        ua.setIdUnidadApoyo(rs.getLong(12));
//        ua.setIdOrganoDireccionEstrategica(rs.getLong(13));
//        ua.setNombre(rs.getString(14));
//        ua.setProposito(rs.getString(15));
//        ota.setProgramInstitucional(pi);
//        ota.setOrganoDireccionEstrategica(ode);
//        ota.setUnidadApoyo(ua);
//        return ota;
//    };
}
