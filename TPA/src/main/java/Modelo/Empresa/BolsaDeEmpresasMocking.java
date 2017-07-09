package Modelo.Empresa;

import java.util.Arrays;
import java.util.List;

public class BolsaDeEmpresasMocking extends BolsaDeEmpresas {
	    // Con unas empresas para probar las vistas.
	    
	    private static List<Cuenta> listaC1 = Arrays.asList(new Cuenta("EBITDA",2000),new Cuenta("Free Cash Flow",3000),new Cuenta("FDS",4000));
		private static List<Cuenta> listaC2 = Arrays.asList(new Cuenta("FDS",1000),new Cuenta("EBITDA",1500));
		private static List<Cuenta> listaC3 = Arrays.asList(new Cuenta("Free Cash Flow",2000));
		private static List<Periodo> periodo1 = Arrays.asList(new Periodo(1990, listaC1));
	    private static List<Periodo> periodo2 = Arrays.asList(new Periodo(2001, listaC2),new Periodo(2014, listaC3),new Periodo(2016, listaC1));
		
	    private static List<Empresa> empresas = Arrays.asList(new Empresa("Jorgito",periodo1), new Empresa("Guaymallén",periodo2), new Empresa("Aguila",periodo1));
		
		@Override
		public List<Empresa> getEmpresas() {
			return empresas;
		}
		
}
