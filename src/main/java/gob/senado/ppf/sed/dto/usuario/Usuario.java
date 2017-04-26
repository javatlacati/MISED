package gob.senado.ppf.sed.dto.usuario;

import gob.senado.ppf.sed.utilidades.Formateable;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(of = {"usuarioPermiso", "identidad"})
@NoArgsConstructor
@AllArgsConstructor(staticName = "from")
public class Usuario implements Serializable, Formateable {

    private static final long serialVersionUID = 1L;

    /**
     * Identificador &uacute;nico de cada usuario.
     */
    private long idUsuario;
    /**
     * Unidad de apoyo a la que petenece este usuario.
     *
     * @see gob.senado.ppf.sed.dto.unidadapoyo.UnidadApoyo
     */
    private long idUnidadApoyo;
    private String identidad;
    private String claveAcceso;
    /**
     * Nombre del usuario del sistema.
     */
    private String nombre;
    /**
     * Primer apellido del usuario del sistema.
     */
    private String apellidoPaterno;
    /**
     * Segundo apellido del usuario del sistema.
     */
    private String apellidoMaterno;
    /**
     * Nombre del puesto laboral que ocupa.
     */
    private String puestoLaboral;
    /**
     * Direcci&oacute;n de correo electr&oacute;nico del usuario.
     * Se espera que sea un coreo elect[onico institucional.
     */
    private String correoElectronico;
    /**
     * Numero de extensi&oacute;n.
     */
    private String extensionTelefonica;
    /**
     * Nombre del rol de usuario que ocupa en el sistema.
     */
    private String rolDesignado;
    /**
     * Fecha en que se registr&oacute; en el sistema.
     */
    private String fechaRegistro;
    /**
     * Hora en que se rergistr&oacute; en el sistema.
     */
    private String horaRegistro;
    private UsuarioPermiso usuarioPermiso;
    private ActividadExtemporanea actividadExtemporanea;
    /**
     * M&oacute;dulos en los que tiene permisos el usuario actual.
     */
    private List<UsuarioModulo> usuarioModulos;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
