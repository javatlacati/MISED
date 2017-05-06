package gob.senado.ppf.sed.utilidades;

import gob.senado.ppf.sed.dto.organizaciontecnicaadministrativa.OrganizacionTecnicaAdministrativa;
import java.util.function.Supplier;
import gob.senado.ppf.sed.dto.organodireccionestrategica.OrganoDireccionEstrategica;
import gob.senado.ppf.sed.dto.programainstitucional.ProgramaInstitucional;
import gob.senado.ppf.sed.dto.unidadapoyo.UnidadApoyo;
import gob.senado.ppf.sed.dto.usuario.Usuario;
import gob.senado.ppf.sed.dto.usuario.UsuarioPermiso;

public final class Suppliers {
    
    public static final Supplier<Usuario> USUARIO = Usuario::new;
    public static final Supplier<UsuarioPermiso> USUARIO_PERMISO = UsuarioPermiso::new;
    public static final Supplier<ProgramaInstitucional> PROGRAMA_INSTITUCIONAL = ProgramaInstitucional::new;
    public static final Supplier<OrganoDireccionEstrategica> ORGANO_DIRECCION_ESTRATEGICA = OrganoDireccionEstrategica::new;
    public static final Supplier<UnidadApoyo> UNIDAD_APOYO = UnidadApoyo::new;
    public static final Supplier<OrganizacionTecnicaAdministrativa> ORGANIZACION_TECNICA_ADMINISTRATIVA = OrganizacionTecnicaAdministrativa::new;
    
}
