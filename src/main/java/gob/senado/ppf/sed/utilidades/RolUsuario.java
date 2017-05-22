package gob.senado.ppf.sed.utilidades;

public enum RolUsuario {

	ROLE_ADMINISTRADOR("ROLE_ADMINISTRADOR"), 
	ROLE_USUARIO("ROLE_USUARIO");

	private String rol;

	private RolUsuario(String rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return this.rol;
	}
}
