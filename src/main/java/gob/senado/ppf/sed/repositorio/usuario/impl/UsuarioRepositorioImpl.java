package gob.senado.ppf.sed.repositorio.usuario.impl;

import gob.senado.ppf.sed.dto.usuario.Usuario;
import gob.senado.ppf.sed.repositorio.usuario.UsuarioRepositorio;
import gob.senado.ppf.sed.utilidades.Activacion;
import gob.senado.ppf.sed.utilidades.RowMappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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

    private Environment env;

    @Autowired
    public UsuarioRepositorioImpl(JdbcTemplate jdbcTemplate, Environment env) {
        this.jdbcTemplate = jdbcTemplate;
        this.env = env;
    }

    @Override
    public boolean altaUsuario(Usuario usuario) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        return jdbcTemplate.update(
                (Connection con) -> {
                    PreparedStatement pst = con.prepareStatement(
                            env.getProperty("alta_usuario")
                            , new String[]{"id_usuario"}
                    );
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
                },
                keyHolder
        ) > 0;

//        return jdbcTemplate.update(
//                env.getProperty("alta_usuario")
//                , new String[]{"id_usuario"}
//        ) > 0;
    }

    @Override
    public boolean actualizarUsuario(Usuario usuario) {

        int rowsAffectedUsuario = jdbcTemplate.update((Connection con) -> {
            PreparedStatement pst = con.prepareStatement(env.getProperty("actualiza_usuario"));
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
        return jdbcTemplate.update(
                env.getProperty("baja_usuario")
                , new Object[]{idUsuario}
        ) > 0;
    }

    @Override
    public Usuario buscarUsuario(long idUsuario) {
        try {

            return jdbcTemplate.queryForObject(
                    env.getProperty("buscar_usuario_por_id")
                    , new Object[]{idUsuario}
                    , RowMappers.ROW_MAPPER_USUARIO
            );
        } catch (EmptyResultDataAccessException erdae) {
            return null;
        } catch (IncorrectResultSizeDataAccessException irsdae) {
            return null;
        }
    }

    @Override
    public Usuario buscarUsuario(String identidad) {
        try {
            return jdbcTemplate.queryForObject(
                    env.getProperty("buscar_usuario_por_identidad")
                    , new Object[]{identidad}
                    , RowMappers.ROW_MAPPER_USUARIO
            );
        } catch (EmptyResultDataAccessException erdae) {
            return null;
        } catch (IncorrectResultSizeDataAccessException irsdae) {
            return null;
        }
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        return jdbcTemplate.query(env.getProperty("obtener_usuarios"), RowMappers.ROW_MAPPER_USUARIO);
    }

    @Override
    public boolean permitirUsoCuentaUsuario(long idUsuario, Activacion activacion) {
        return jdbcTemplate.update(
                env.getProperty("permitir_uso_cuenta_usuario")
                , activacion.getEstadoInterruptor(), idUsuario
        ) > 0;
    }

    @Override
    public boolean reestablecerClaveAcceso(long idUsuario, String nuevaClaveAcceso) {
        return jdbcTemplate.update(env.getProperty("restablecer_clave_acceso")
                , nuevaClaveAcceso
                , idUsuario
        ) > 0;
    }

    @Override
    public long contarUsuarios() {
        return jdbcTemplate.queryForObject(env.getProperty("contar_usuarios"), Long.class);
    }

    @Override
    public long contarUsuariosPorUnidadApoyo(long idUnidadApoyo) {
        return jdbcTemplate.queryForObject(env.getProperty("contar_usuarios_por_ua"),
                new Object[]{idUnidadApoyo},
                Long.class
        );
    }

    @Override
    public long contarUsuariosPorOrganoDireccionEstrategica(long idOrganoDireccionEstrategica) {
        return jdbcTemplate.queryForObject(env.getProperty("contar_usuarios_por_ode"),
                new Object[]{idOrganoDireccionEstrategica}, Long.class
        );
    }

    @Override
    public long contarUsuariosPorProgramaInstitucional(long idProgramaInstitucional) {
        return jdbcTemplate.queryForObject(env.getProperty("contar_usuarios_por_programa"),
                new Object[]{idProgramaInstitucional}, Long.class
        );
    }

}
