package gob.senado.ppf.sed.dto.usuario;

import lombok.*;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import gob.senado.ppf.sed.utilidades.Formateable;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(of = {"usuarioPermiso","identidad"})
@NoArgsConstructor
@AllArgsConstructor(staticName = "from")
public class Usuario implements Serializable, Formateable {

	private static final long serialVersionUID = 1L;

	private long idUsuario;
	private long idUnidadApoyo;
	private String identidad;
	private String claveAcceso;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String puestoLaboral;
	private String correoElectronico;
	private String extensionTelefonica;
	private String rolDesignado;
	private String fechaRegistro;
	private String horaRegistro;
	private UsuarioPermiso usuarioPermiso;
	private ActividadExtemporanea actividadExtemporanea;
	private List<UsuarioModulo> usuarioModulos;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
