package DB;

public enum NombreRepositorio {
	EMPRESA("Empresa"),
	INDICADOR("Indicador"),
	METODOLOGIA("Metodologia");
	
	private String nombre;
	
	private NombreRepositorio(String nombre) {
		this.nombre = nombre;
	}

	public String darNombreRepositorio() {
		return this.nombre;
	}
}
