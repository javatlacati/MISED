package gob.senado.ppf.sed.dto.usuario;

import gob.senado.ppf.sed.utilidades.Formateable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

public class UsuarioPermiso implements Serializable, Formateable {

    private static final long serialVersionUID = 1L;

    private long idPermiso;
    /**
     * Identificador &uacute;nico de cada usuario.
     */
    private long idUsuario;
    /**
     * Permiso de consulta.
     */
    private boolean puedeConsultar;
    /**
     * Permiso de modificaci&oacute;n.
     */
    private boolean puedeActualizar;
    /**
     * Permiso de inserci&oacute;n de nuevos registros.
     */
    private boolean puedeAgregar;
    /**
     * Permiso de eliminaci&oacute;n..
     */
    private boolean puedeBorrar;
    /**
     * Permiso de Autentificaci&oacute;n.
     */
    private boolean puedeAutenticarse;

    @java.beans.ConstructorProperties({"idPermiso", "idUsuario", "puedeConsultar", "puedeActualizar", "puedeAgregar", "puedeBorrar", "puedeAutenticarse"})
    private UsuarioPermiso(long idPermiso, long idUsuario, boolean puedeConsultar, boolean puedeActualizar, boolean puedeAgregar, boolean puedeBorrar, boolean puedeAutenticarse) {
        this.idPermiso = idPermiso;
        this.idUsuario = idUsuario;
        this.puedeConsultar = puedeConsultar;
        this.puedeActualizar = puedeActualizar;
        this.puedeAgregar = puedeAgregar;
        this.puedeBorrar = puedeBorrar;
        this.puedeAutenticarse = puedeAutenticarse;
    }

    public UsuarioPermiso() {
    }

    public static UsuarioPermiso from(long idPermiso, long idUsuario, boolean puedeConsultar, boolean puedeActualizar, boolean puedeAgregar, boolean puedeBorrar, boolean puedeAutenticarse) {
        return new UsuarioPermiso(idPermiso, idUsuario, puedeConsultar, puedeActualizar, puedeAgregar, puedeBorrar, puedeAutenticarse);
    }

    public boolean puedeConsultar() {
        return puedeConsultar;
    }

    public boolean puedeActualizar() {
        return puedeActualizar;
    }

    public boolean puedeAgregar() {
        return puedeAgregar;
    }

    public boolean puedeBorrar() {
        return puedeBorrar;
    }

    public boolean puedeAutenticarse() {
        return puedeAutenticarse;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

    public void setIdPermiso(long idPermiso) {
        this.idPermiso = idPermiso;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setPuedeConsultar(boolean puedeConsultar) {
        this.puedeConsultar = puedeConsultar;
    }

    public void setPuedeActualizar(boolean puedeActualizar) {
        this.puedeActualizar = puedeActualizar;
    }

    public void setPuedeAgregar(boolean puedeAgregar) {
        this.puedeAgregar = puedeAgregar;
    }

    public void setPuedeBorrar(boolean puedeBorrar) {
        this.puedeBorrar = puedeBorrar;
    }

    public void setPuedeAutenticarse(boolean puedeAutenticarse) {
        this.puedeAutenticarse = puedeAutenticarse;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof UsuarioPermiso)) return false;
        final UsuarioPermiso other = (UsuarioPermiso) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.idPermiso != other.idPermiso) return false;
        if (this.idUsuario != other.idUsuario) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $idPermiso = this.idPermiso;
        result = result * PRIME + (int) ($idPermiso >>> 32 ^ $idPermiso);
        final long $idUsuario = this.idUsuario;
        result = result * PRIME + (int) ($idUsuario >>> 32 ^ $idUsuario);
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof UsuarioPermiso;
    }

    public long getIdPermiso() {
        return this.idPermiso;
    }

    public long getIdUsuario() {
        return this.idUsuario;
    }
}
