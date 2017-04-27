package gob.senado.ppf.sed.servicio.usuario.impl;

import gob.senado.ppf.sed.dto.usuario.ActividadExtemporanea;
import gob.senado.ppf.sed.dto.usuario.Usuario;
import gob.senado.ppf.sed.repositorio.usuario.UsuarioRepositorio;
import gob.senado.ppf.sed.servicio.usuario.UsuarioServicio;
import gob.senado.ppf.sed.utilidades.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;

@Service(value = "usuarioServicio")
public class UsuarioServicioImpl implements UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public boolean altaUsuario(Usuario usuario) {
        if (null == usuarioRepositorio.buscarUsuario(usuario.getIdentidad())) {
            usuario.setClaveAcceso(passwordEncoder.encode(usuario.getClaveAcceso()));
            usuario.setFechaRegistro(Fecha.FORMATO_FECHA_PRESENTACION.format(LocalDate.now()));
            usuario.setHoraRegistro(Hora.FORMATO_HORA_PRESENTACION.format(LocalTime.now()));
            ActividadExtemporanea ae = Suppliers.ACTIVIDAD_EXTEMPORANEA.get();
            ae.setFasePlaneacion(false);
            ae.setFaseCalendarizacion(false);
            ae.setFasePrimerCuatrimestre(false);
            ae.setFaseSegundoCuatrimestre(false);
            ae.setFaseTercerCuatrimestre(false);
            usuario.setActividadExtemporanea(ae);
            return usuarioRepositorio.altaUsuario(usuario);
        } else {
            return false;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public boolean actualizarUsuario(Usuario usuario) {
        return usuarioRepositorio.actualizarUsuario(usuario);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public boolean bajaUsuario(long idUsuario) {
        return usuarioRepositorio.bajaUsuario(idUsuario);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    public Usuario buscarUsuario(long idUsuario) {
        return usuarioRepositorio.buscarUsuario(idUsuario);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    public Usuario buscarUsuario(String identidad) {
        return usuarioRepositorio.buscarUsuario(identidad);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public boolean aplicarActividadExtemporanea(long idUsuario, Fase fase, Activacion activacion) {
        return usuarioRepositorio.aplicarActividadExtemporanea(idUsuario, fase, activacion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public boolean permitirUsoCuentaUsuario(long idUsuario, Activacion activacion) {
        return usuarioRepositorio.permitirUsoCuentaUsuario(idUsuario, activacion);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public boolean reestablecerClaveAcceso(long idUsuario, String nuevaClaveAcceso) {
        return usuarioRepositorio.reestablecerClaveAcceso(idUsuario, passwordEncoder.encode(nuevaClaveAcceso));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    public long contarUsuarios() {
        return usuarioRepositorio.contarUsuarios();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    public long contarUsuariosPorProgramaInstitucional(long idProgramaInstitucional) {
        return usuarioRepositorio.contarUsuariosPorProgramaInstitucional(idProgramaInstitucional);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    public long contarUsuariosPorOrganoDireccionEstrategica(long idOrganoDireccionEstrategica) {
        return usuarioRepositorio.contarUsuariosPorOrganoDireccionEstrategica(idOrganoDireccionEstrategica);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    public long contarUsuariosPorUnidadApoyo(long idUnidadApoyo) {
        return usuarioRepositorio.contarUsuariosPorUnidadApoyo(idUnidadApoyo);
    }

}
