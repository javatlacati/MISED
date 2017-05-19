package gob.senado.ppf.sed.dto.usuario;

import org.junit.Test;

import java.util.ArrayList;

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
        Usuario usuario = new Usuario();
        usuario.setPuestoLaboral("Brayan");
        assertEquals("Brayan", usuario.getPuestoLaboral());
    }

    @Test
    public void getCorreoElectronico() throws Exception {
        Usuario usuario = new Usuario();
        assertNull(usuario.getCorreoElectronico());
    }

    @Test
    public void setCorreoElectronico() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setCorreoElectronico("Brayan");
        assertEquals("Brayan", usuario.getCorreoElectronico());
    }

    @Test
    public void getExtensionTelefonica() throws Exception {
        Usuario usuario = new Usuario();
        assertNull(usuario.getExtensionTelefonica());
    }

    @Test
    public void setExtensionTelefonica() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setExtensionTelefonica("Brayan");
        assertEquals("Brayan", usuario.getExtensionTelefonica());
    }

    @Test
    public void getRolDesignado() throws Exception {
        Usuario usuario = new Usuario();
        assertNull(usuario.getRolDesignado());
    }

    @Test
    public void setRolDesignado() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setRolDesignado("Brayan");
        assertEquals("Brayan", usuario.getRolDesignado());
    }

    @Test
    public void getTipoUsuario() throws Exception {
        Usuario usuario = new Usuario();
        assertNull(usuario.getTipoUsuario());
    }

    @Test
    public void setTipoUsuario() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setTipoUsuario("Brayan");
        assertEquals("Brayan", usuario.getTipoUsuario());
    }

    @Test
    public void getFechaRegistro() throws Exception {
        Usuario usuario = new Usuario();
        assertNull(usuario.getFechaRegistro());
    }

    @Test
    public void setFechaRegistro() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setFechaRegistro("Brayan");
        assertEquals("Brayan", usuario.getFechaRegistro());
    }

    @Test
    public void getHoraRegistro() throws Exception {
        Usuario usuario = new Usuario();
        assertNull(usuario.getHoraRegistro());
    }

    @Test
    public void setHoraRegistro() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setHoraRegistro("Brayan");
        assertEquals("Brayan", usuario.getHoraRegistro());
    }

    @Test
    public void getUsuarioPermiso() throws Exception {
        Usuario usuario = new Usuario();
        assertNull(usuario.getUsuarioPermiso());
    }

    @Test
    public void setUsuarioPermiso() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setUsuarioPermiso(new UsuarioPermiso());
        assertEquals(new UsuarioPermiso(), usuario.getUsuarioPermiso());
        //TODO add more once UsuarioPermiso is finished testing
    }

    @Test
    public void getUsuarioModulos() throws Exception {
        Usuario usuario = new Usuario();
        assertNull(usuario.getUsuarioModulos());
    }

    @Test
    public void setUsuarioModulos() throws Exception {
        Usuario usuario = new Usuario();
        ArrayList<UsuarioModulo> usuarioModulos = new ArrayList<>();
        usuario.setUsuarioModulos(usuarioModulos);
        assertEquals(usuarioModulos, usuario.getUsuarioModulos());
    }


    @Test
    public void equals() throws Exception {
        Usuario usuario = new Usuario();
        assertEquals(new Usuario(), usuario);
    }

    @Test
    public void testHashCode() throws Exception {
    }

    @Test
    public void testToString() throws Exception {
    }

}