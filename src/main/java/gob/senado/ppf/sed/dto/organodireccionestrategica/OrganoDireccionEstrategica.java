package gob.senado.ppf.sed.dto.organodireccionestrategica;

import gob.senado.ppf.sed.utilidades.Formateable;
import lombok.*;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode(of = {"nombre"})
@NoArgsConstructor
@AllArgsConstructor(staticName = "from")
public class OrganoDireccionEstrategica implements Serializable, Formateable {

    private static final long serialVersionUID = 1L;

    private long idOrganoDireccionEstrategica;
    private long idProgramaInstitucional;
    private String nombre;
    private String descripcion;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}
