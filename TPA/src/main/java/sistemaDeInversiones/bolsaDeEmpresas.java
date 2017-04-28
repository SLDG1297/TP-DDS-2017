package sistemaDeInversiones;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class bolsaDeEmpresas {
	// Con unas empresas para probar las vistas.
	private static List<Empresa> empresas = Arrays.asList(new Empresa("Guaymallén"), new Empresa("Jorgito"), new Empresa("Aguila"));
	
	public List<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(List<Empresa> empresasNuevas) {
		empresas = empresasNuevas;
	}

	public static Empresa buscarEmpresa(String unNombre) {
		Empresa empresaBuscada = empresas.stream().filter( e -> e.getNombre() == unNombre).findFirst().get();
		return empresaBuscada;	
	}
	
	public static List<String> buscarNombresDeEmpresas() {
		List<String> nombres = empresas.stream().map((Empresa e) -> e.getNombre()).collect(Collectors.toList());
		return nombres;		
	}
}
