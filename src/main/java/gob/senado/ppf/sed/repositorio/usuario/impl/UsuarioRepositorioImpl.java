package gob.senado.ppf.sed.repositorio.usuario.impl;

import gob.senado.ppf.sed.dto.usuario.Usuario;
import gob.senado.ppf.sed.repositorio.usuario.UsuarioRepositorio;
import gob.senado.ppf.sed.utilidades.Activacion;
import gob.senado.ppf.sed.utilidades.RowMappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

@Repository(value = "usuarioRepositorio")
public class UsuarioRepositorioImpl implements UsuarioRepositorio {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UsuarioRepositorioImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean altaUsuario(Usuario usuario) {
        final StringBuilder sqlUsuario = new StringBuilder();
        sqlUsuario.append("INSERT INTO USUARIO (id_unidad_apoyo, identidad, clave_acceso, nombre, ")
                .append("apellido_paterno, apellido_materno, puesto_laboral, correo_electronico, ")
                .append("extension_telefonica, rol_designado, tipo_usuario, fecha_registro, hora_registro, ")
                .append("puede_consultar, puede_actualizar, puede_agregar, puede_borrar, puede_autenticarse) ")
                .append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"); // 18
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int rowsAffectedUsuario = jdbcTemplate.update((Connection con) -> {
            PreparedStatement pst = con.prepareStatement(sqlUsuario.toString(), new String[]{"id_usuario"});
            pst.setLong(1, usuario.getIdUnidadApoyo());
            pst.setString(2, usuario.getIdentidad());
            pst.setString(3, usuario.getClaveAcceso());
            pst.setString(4, usuario.getNombre());
            pst.setString(5, usuario.getApellidoPaterno());
            pst.setString(6, usuario.getApellidoMaterno());
            pst.setString(7, usuario.getPuestoLaboral());
            pst.setString(8, usuario.getCorreoElectronico());
            pst.setString(9, usuario.getExtensionTelefonica());
            pst.setString(10, usuario.getRolDesignado());
            pst.setString(11, usuario.getTipoUsuario());
            pst.setString(12, usuario.getFechaRegistro());
            pst.setString(13, usuario.getHoraRegistro());
            pst.setBoolean(14, usuario.isPuedeConsultar());
            pst.setBoolean(15, usuario.isPuedeActualizar());
            pst.setBoolean(16, usuario.isPuedeAgregar());
            pst.setBoolean(17, usuario.isPuedeBorrar());
            pst.setBoolean(18, usuario.isPuedeAutenticarse());
            return pst;
        }, keyHolder);
        return rowsAffectedUsuario > 0;
    }

    @Override
    public boolean actualizarUsuario(Usuario usuario) {
        final StringBuilder sqlUsuario = new StringBuilder();
        sqlUsuario.append("UPDATE USUARIO SET id_unidad_apoyo = ?, nombre = ?, ")
                .append("apellido_paterno = ?, apellido_materno = ?, puesto_laboral = ?, ")
                .append("correo_electronico = ?, extension_telefonica = ?, rol_designado = ?, tipo_usuario = ?, ")
                .append("puede_consultar = ?, puede_actualizar = ?, puede_agregar = ?, puede_borrar = ?, puede_autenticarse = ? ")
                .append("WHERE id_usuario = ?");
        int rowsAffectedUsuario = jdbcTemplate.update((Connection con) -> {
            PreparedStatement pst = con.prepareStatement(sqlUsuario.toString());
            pst.setLong(1, usuario.getIdUnidadApoyo());
            pst.setString(2, usuario.getNombre());
            pst.setString(3, usuario.getApellidoPaterno());
            pst.setString(4, usuario.getApellidoMaterno());
            pst.setString(5, usuario.getPuestoLaboral());
            pst.setString(6, usuario.getCorreoElectronico());
            pst.setString(7, usuario.getExtensionTelefonica());
            pst.setString(8, usuario.getRolDesignado());
            pst.setString(9, usuario.getTipoUsuario());
            pst.setBoolean(10, usuario.isPuedeConsultar());
            pst.setBoolean(11, usuario.isPuedeActualizar());
            pst.setBoolean(12, usuario.isPuedeAgregar());
            pst.setBoolean(13, usuario.isPuedeBorrar());
            pst.setBoolean(14, usuario.isPuedeAutenticarse());
            pst.setLong(15, usuario.getIdUsuario());
            return pst;
        });
        return rowsAffectedUsuario > 0;
    }

    @Override
    public boolean bajaUsuario(long idUsuario) {
        return jdbcTemplate.update("DELETE FROM USUARIO WHERE id_usuario = ?", new Object[]{idUsuario}) > 0;
    }

    @Override
    public Usuario buscarUsuario(long idUsuario) {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT PI.CLAVE AS CLAVE_PROGRAMA_INSTITUCIONAL, PI.NOMBRE AS NOMBRE_PROGRAMA_INSTITUCIONAL, ")
                    .append("ODE.NOMBRE AS NOMBRE_ORGANO_DIRECCION_ESTRATEGICA, UA.NOMBRE AS NOMBRE_UNIDAD_APOYO, ")
                    .append("U.* FROM PROGRAMA_INSTITUCIONAL PI INNER JOIN ORGANO_DIRECCION_ESTRATEGICA ODE ")
                    .append("ON PI.ID_PROGRAMA_INSTITUCIONAL = ODE.ID_PROGRAMA_INSTITUCIONAL ")
                    .append("INNER JOIN UNIDAD_APOYO UA ON ODE.ID_ORGANO_DIRECCION_ESTRATEGICA = UA.ID_ORGANO_DIRECCION_ESTRATEGICA ")
                    .append("INNER JOIN USUARIO U ON UA.ID_UNIDAD_APOYO = U.ID_UNIDAD_APOYO ")
                    .append("WHERE U.ID_USUARIO = ?");
            return jdbcTemplate.queryForObject(sql.toString(), new Object[]{idUsuario},
                    RowMappers.ROW_MAPPER_USUARIO);
        } catch (EmptyResultDataAccessException erdae) {
            return null;
        } catch (IncorrectResultSizeDataAccessException irsdae) {
            return null;
        }
    }

    @Override
    public Usuario buscarUsuario(String identidad) {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT PI.CLAVE AS CLAVE_PROGRAMA_INSTITUCIONAL, PI.NOMBRE AS NOMBRE_PROGRAMA_INSTITUCIONAL, ")
                    .append("ODE.NOMBRE AS NOMBRE_ORGANO_DIRECCION_ESTRATEGICA, UA.NOMBRE AS NOMBRE_UNIDAD_APOYO, ")
                    .append("U.* FROM PROGRAMA_INSTITUCIONAL PI INNER JOIN ORGANO_DIRECCION_ESTRATEGICA ODE ")
                    .append("ON PI.ID_PROGRAMA_INSTITUCIONAL = ODE.ID_PROGRAMA_INSTITUCIONAL ")
                    .append("INNER JOIN UNIDAD_APOYO UA ON ODE.ID_ORGANO_DIRECCION_ESTRATEGICA = UA.ID_ORGANO_DIRECCION_ESTRATEGICA ")
                    .append("INNER JOIN USUARIO U ON UA.ID_UNIDAD_APOYO = U.ID_UNIDAD_APOYO ")
                    .append("WHERE U.IDENTIDAD = ?");
            return jdbcTemplate.queryForObject(sql.toString(), new Object[]{identidad},
                    RowMappers.ROW_MAPPER_USUARIO);
        } catch (EmptyResultDataAccessException erdae) {
            return null;
        } catch (IncorrectResultSizeDataAccessException irsdae) {
            return null;
        }
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT PI.CLAVE AS CLAVE_PROGRAMA_INSTITUCIONAL, PI.NOMBRE AS NOMBRE_PROGRAMA_INSTITUCIONAL, ")
                .append("ODE.NOMBRE AS NOMBRE_ORGANO_DIRECCION_ESTRATEGICA, UA.NOMBRE AS NOMBRE_UNIDAD_APOYO, ")
                .append("U.* FROM PROGRAMA_INSTITUCIONAL PI INNER JOIN ORGANO_DIRECCION_ESTRATEGICA ODE ")
                .append("ON PI.ID_PROGRAMA_INSTITUCIONAL = ODE.ID_PROGRAMA_INSTITUCIONAL ")
                .append("INNER JOIN UNIDAD_APOYO UA ON ODE.ID_ORGANO_DIRECCION_ESTRATEGICA = UA.ID_ORGANO_DIRECCION_ESTRATEGICA ")
                .append("INNER JOIN USUARIO U ON UA.ID_UNIDAD_APOYO = U.ID_UNIDAD_APOYO ");
        return jdbcTemplate.query(sql.toString(), RowMappers.ROW_MAPPER_USUARIO);
    }

    @Override
    public boolean permitirUsoCuentaUsuario(long idUsuario, Activacion activacion) {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE USUARIO SET puede_autenticarse = ? WHERE id_usuario = ?");
        return jdbcTemplate.update(sql.toString(), new Object[]{activacion.getEstadoInterruptor(), idUsuario}) > 0;
    }

    @Override
    public boolean reestablecerClaveAcceso(long idUsuario, String nuevaClaveAcceso) {
        return jdbcTemplate.update("UPDATE USUARIO SET clave_acceso = ? WHERE id_usuario = ?",
                new Object[]{nuevaClaveAcceso, idUsuario}) > 0;
    }

    @Override
    public long contarUsuarios() {
        return jdbcTemplate.queryForObject("SELECT TOTAL_CONTEO FROM CONTAR_USUARIOS", Long.class);
    }

    @Override
    public long contarUsuariosPorUnidadApoyo(long idUnidadApoyo) {
        return jdbcTemplate.queryForObject("SELECT CONTAR_USUARIOS_POR_UNIDAD_APOYO(?)", new Object[]{idUnidadApoyo},
                Long.class);
    }

    @Override
    public long contarUsuariosPorOrganoDireccionEstrategica(long idOrganoDireccionEstrategica) {
        return jdbcTemplate.queryForObject("SELECT CONTAR_USUARIOS_POR_ORGANO_DIRECCION_ESTRATEGICA(?)",
                new Object[]{idOrganoDireccionEstrategica}, Long.class);
    }

    @Override
    public long contarUsuariosPorProgramaInstitucional(long idProgramaInstitucional) {
        return jdbcTemplate.queryForObject("SELECT CONTAR_USUARIOS_POR_PROGRAMA_INSTITUCIONAL(?)",
                new Object[]{idProgramaInstitucional}, Long.class);
    }

}
