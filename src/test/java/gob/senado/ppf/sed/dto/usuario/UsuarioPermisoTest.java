package gob.senado.ppf.sed.dto.usuario;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Javatlacati on 21/04/2017.
 */
public class UsuarioPermisoTest {
    @Test
    public void getIdPermiso() throws Exception {
        UsuarioPermiso usuarioPermiso = new UsuarioPermiso();
        assertEquals(0, usuarioPermiso.getIdPermiso());
    }

    @Test
    public void setIdPermiso() throws Exception {
        UsuarioPermiso usuarioPermiso = new UsuarioPermiso();
        usuarioPermiso.setIdPermiso(120);
        assertEquals(120, usuarioPermiso.getIdPermiso());
    }

    @Test
    public void getIdUsuario() throws Exception {
        UsuarioPermiso usuarioPermiso = new UsuarioPermiso();
        assertEquals(0, usuarioPermiso.getIdUsuario());
    }

    @Test
    public void setIdUsuario() throws Exception {
    }

    @Test
    public void puedeConsultar() throws Exception {
        UsuarioPermiso usuarioPermiso = new UsuarioPermiso();
        assertEquals(false, usuarioPermiso.puedeConsultar());
    }

    @Test
    public void setPuedeConsultar() throws Exception {
    }

    @Test
    public void puedeActualizar() throws Exception {
        UsuarioPermiso usuarioPermiso = new UsuarioPermiso();
        assertEquals(false, usuarioPermiso.puedeActualizar());
    }

    @Test
    public void setPuedeActualizar() throws Exception {
    }

    @Test
    public void puedeAgregar() throws Exception {
        UsuarioPermiso usuarioPermiso = new UsuarioPermiso();
        assertEquals(false, usuarioPermiso.puedeAgregar());
    }

    @Test
    public void setPuedeAgregar() throws Exception {
    }

    @Test
    public void puedeBorrar() throws Exception {
        UsuarioPermiso usuarioPermiso = new UsuarioPermiso();
        assertEquals(false, usuarioPermiso.puedeBorrar());
    }

    @Test
    public void setPuedeBorrar() throws Exception {
    }

    @Test
    public void puedeAutenticarse() throws Exception {
        UsuarioPermiso usuarioPermiso = new UsuarioPermiso();
        assertEquals(false, usuarioPermiso.puedeAutenticarse());
    }

    @Test
    public void setPuedeAutenticarse() throws Exception {
    }

    @Test
    public void equals() throws Exception {
        UsuarioPermiso usuarioPermiso = new UsuarioPermiso();
        assertEquals(new UsuarioPermiso(), usuarioPermiso);
    }

    @Test
    public void testHashCode() throws Exception {
    }

    @Test
    public void testToString() throws Exception {
    }

}