package gob.senado.ppf.sed.dto.usuario;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by Administrador on 21/04/2017.
 */
public class UsuarioTest {

    @Test
    public void getIdUsuario() throws Exception {
        Usuario usuario = new Usuario();
        assertEquals(0L, usuario.getIdUsuario());
    }

    @Test
    public void setIdUsuario() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(23463L);
        assertEquals(23463L, usuario.getIdUsuario());
    }

    @Test
    public void getIdUnidadApoyo() throws Exception {
        Usuario usuario = new Usuario();
        assertEquals(0L, usuario.getIdUnidadApoyo());
    }

    @Test
    public void setIdUnidadApoyo() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setIdUnidadApoyo(23536L);
        assertEquals(23536L, usuario.getIdUnidadApoyo());
    }

    @Test
    public void getIdentidad() throws Exception {
        Usuario usuario = new Usuario();
        assertNull(usuario.getIdentidad());
    }

    @Test
    public void setIdentidad() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setIdentidad("Brayan");
        assertEquals("Brayan", usuario.getIdentidad());
    }

    @Test
    public void getClaveAcceso() throws Exception {
        Usuario usuario = new Usuario();
        assertNull(usuario.getClaveAcceso());
    }

    @Test
    public void setClaveAcceso() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setClaveAcceso("Brayan");
        assertEquals("Brayan", usuario.getClaveAcceso());
    }

    @Test
    public void getNombre() throws Exception {
        Usuario usuario = new Usuario();
        assertNull(usuario.getNombre());
    }

    @Test
    public void setNombre() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setNombre("Brayan");
        assertEquals("Brayan", usuario.getNombre());
    }

    @Test
    public void getApellidoPaterno() throws Exception {
        Usuario usuario = new Usuario();
        assertNull(usuario.getNombre());
    }

    @Test
    public void setApellidoPaterno() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setApellidoPaterno("Brayan");
        assertEquals("Brayan", usuario.getApellidoPaterno());
    }

    @Test
    public void getApellidoMaterno() throws Exception {
        Usuario usuario = new Usuario();
        assertNull(usuario.getApellidoMaterno());
    }

    @Test
    public void setApellidoMaterno() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setApellidoMaterno("Brayan");
        assertEquals("Brayan", usuario.getApellidoMaterno());
    }

    @Test
    public void getPuestoLaboral() throws Exception {
        Usuario usuario = new Usuario();
        assertNull(usuario.getPuestoLaboral());
    }

    @Test
    public void setPuestoLaboral() throws Exception {
    }

    @Test
    public void getCorreoElectronico() throws Exception {
        Usuario usuario = new Usuario();
        assertNull(usuario.getCorreoElectronico());
    }

    @Test
    public void setCorreoElectronico() throws Exception {
    }

    @Test
    public void getExtensionTelefonica() throws Exception {
        Usuario usuario = new Usuario();
        assertNull(usuario.getExtensionTelefonica());
    }

    @Test
    public void setExtensionTelefonica() throws Exception {
    }

    @Test
    public void getRolDesignado() throws Exception {
        Usuario usuario = new Usuario();
        assertNull(usuario.getRolDesignado());
    }

    @Test
    public void setRolDesignado() throws Exception {
    }

    @Test
    public void getFechaRegistro() throws Exception {
        Usuario usuario = new Usuario();
        assertNull(usuario.getFechaRegistro());
    }

    @Test
    public void setFechaRegistro() throws Exception {
    }

    @Test
    public void getHoraRegistro() throws Exception {
        Usuario usuario = new Usuario();
        assertNull(usuario.getHoraRegistro());
    }

    @Test
    public void setHoraRegistro() throws Exception {
    }

    @Test
    public void getUsuarioPermiso() throws Exception {
        Usuario usuario = new Usuario();
        assertNull(usuario.getUsuarioPermiso());
    }

    @Test
    public void setUsuarioPermiso() throws Exception {
    }

    @Test
    public void getUsuarioModulos() throws Exception {
    }

    @Test
    public void setUsuarioModulos() throws Exception {
    }

    @Test
    public void equals() throws Exception {
    }

    @Test
    public void testHashCode() throws Exception {
    }

    @Test
    public void testToString() throws Exception {
    }

}