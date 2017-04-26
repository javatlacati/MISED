package gob.senado.ppf.sed.dto.usuario;

import gob.senado.ppf.sed.utilidades.Formateable;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode(of = {"idUsuario", "idPermiso"})
@NoArgsConstructor
@AllArgsConstructor(staticName = "from")
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

}
