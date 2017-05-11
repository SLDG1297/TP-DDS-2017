package sistemaDeInversiones;

import java.util.List;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Instanciador_Bolsa_Empresas {
	
	public static BolsaDeEmpresas instanciar() throws IOException {
		BolsaDeEmpresas bolsaEmpresa = new BolsaDeEmpresas();
		bolsaEmpresa.setEmpresas(obtenerEmpresas());
		
		return bolsaEmpresa;
	}
	
	private static List<Empresa> obtenerEmpresas() throws IOException {
	
		// Instancio el Lector de Archivos
		LectorDeArchivos miLector = new LectorDeArchivos();
		InputStream stream = miLector.getFile("cuentitasDeHector.csv");
		
		// Instancio el Parser
		CSVParser miParser = new CSVParser(",");
		List<Empresa> misEmpresas = new ArrayList<Empresa>();
		misEmpresas = miParser.parse(stream);
		
		return misEmpresas;
	}
	
}
