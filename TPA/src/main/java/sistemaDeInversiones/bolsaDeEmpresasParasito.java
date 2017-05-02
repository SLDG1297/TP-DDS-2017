package sistemaDeInversiones;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class bolsaDeEmpresasParasito {
	    // Con unas empresas para probar las vistas.
	    
	    private static List<Cuenta> listaC1 = Arrays.asList(new Cuenta("EBITDA",2000),new Cuenta("Free Cash Flow",3000),new Cuenta("FDS",4000));
		private static List<Cuenta> listaC2 = Arrays.asList(new Cuenta("FDS",1000),new Cuenta("EBITDA",1500));
		private static List<Cuenta> listaC3 = Arrays.asList(new Cuenta("Free Cash Flow",2000));
		private static List<Periodo> periodo1 = Arrays.asList(new Periodo(1990, listaC1));
	    private static List<Periodo> periodo2 = Arrays.asList(new Periodo(2001, listaC2),new Periodo(2014, listaC3),new Periodo(2016, listaC1));
		private static List<Empresa> empresas = Arrays.asList(new Empresa("Guaymallén",periodo1), new Empresa("Jorgito",periodo2), new Empresa("Aguila",periodo1));
		
		public List<Empresa> getEmpresas() {
			return empresas;
		}

		public void setEmpresas(List<Empresa> empresasNuevas) {
			empresas = empresasNuevas;
		}

		public Empresa buscarEmpresa(String unNombre) {
			Empresa empresaBuscada = empresas.stream().filter( e -> e.getNombre() == unNombre).findFirst().get();
			return empresaBuscada;	
		}
		
		public List<String> buscarNombresDeEmpresas() {
			List<String> nombres = empresas.stream().map((Empresa e) -> e.getNombre()).collect(Collectors.toList());
			return nombres;		
		}
		
}
