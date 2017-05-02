package gob.senado.ppf.sed.dto.usuario;

import gob.senado.ppf.sed.utilidades.Formateable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

public class UsuarioModulo implements Serializable, Formateable {

    private static final long serialVersionUID = 1L;
    private long idUsuarioModulo;
    /**
     * Identificador &uacute;nico de cada usuario.
     */
    private long idUsuario;
    private long idModulo;
    private boolean puedeAcceder;

    @java.beans.ConstructorProperties({"idUsuarioModulo", "idUsuario", "idModulo", "puedeAcceder"})
    private UsuarioModulo(long idUsuarioModulo, long idUsuario, long idModulo, boolean puedeAcceder) {
        this.idUsuarioModulo = idUsuarioModulo;
        this.idUsuario = idUsuario;
        this.idModulo = idModulo;
        this.puedeAcceder = puedeAcceder;
    }

    public UsuarioModulo() {
    }

    public static UsuarioModulo from(long idUsuarioModulo, long idUsuario, long idModulo, boolean puedeAcceder) {
        return new UsuarioModulo(idUsuarioModulo, idUsuario, idModulo, puedeAcceder);
    }

    public boolean puedeAcceder() {
        return puedeAcceder;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

    public void setIdUsuarioModulo(long idUsuarioModulo) {
        this.idUsuarioModulo = idUsuarioModulo;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setIdModulo(long idModulo) {
        this.idModulo = idModulo;
    }

    public void setPuedeAcceder(boolean puedeAcceder) {
        this.puedeAcceder = puedeAcceder;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof UsuarioModulo)) return false;
        final UsuarioModulo other = (UsuarioModulo) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.idUsuario != other.idUsuario) return false;
        if (this.idModulo != other.idModulo) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $idUsuario = this.idUsuario;
        result = result * PRIME + (int) ($idUsuario >>> 32 ^ $idUsuario);
        final long $idModulo = this.idModulo;
        result = result * PRIME + (int) ($idModulo >>> 32 ^ $idModulo);
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof UsuarioModulo;
    }

    public long getIdUsuarioModulo() {
        return this.idUsuarioModulo;
    }

    public long getIdUsuario() {
        return this.idUsuario;
    }

    public long getIdModulo() {
        return this.idModulo;
    }
}
