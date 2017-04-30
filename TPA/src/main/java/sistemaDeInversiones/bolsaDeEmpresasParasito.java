package sistemaDeInversiones;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class bolsaDeEmpresasParasito {
	// Con unas empresas para probar las vistas.
	    
	    private static List<Periodo> periodo1 = Arrays.asList(new Periodo(1990, 2000));
	    private static List<Periodo> periodo2 = Arrays.asList(new Periodo(2001, 1000),new Periodo(2017, 4000));
	    private static List<Cuenta> lista1 = Arrays.asList(new Cuenta("EDITBA",periodo1),new Cuenta("Free Cash Flow",periodo2));
		private static List<Cuenta> lista2 = Arrays.asList(new Cuenta("EDITBA2",periodo2),new Cuenta("Free Cash Flow2",periodo1));
		private static List<Cuenta> lista3 = Arrays.asList(new Cuenta("EDITBA3",periodo1));
		private static List<Empresa> empresas = Arrays.asList(new Empresa("Guaymallén",lista1), new Empresa("Jorgito",lista2), new Empresa("Aguila",lista3));
		
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
