package Archivo.Empresa;

import java.util.List;
import Archivo.FileCleaner;
import Archivo.LectorDeArchivos;
import Modelo.Empresa.Empresa;
import Modelo.Empresa.EmpresasManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Instanciador_Bolsa_Empresas {
	
	public void instanciar() throws IOException {
	    EmpresasManager.getInstancia().insertarListaDeEmpresas(obtenerEmpresas());
	    this.vaciarCsv();
	}

	private List<Empresa> obtenerEmpresas() throws IOException {
	
		// Instancio el Lector de Archivos
		LectorDeArchivos miLector = new LectorDeArchivos();
		FileInputStream stream = miLector.getFile("cuentitasDeHector.csv");
		
		// Instancio el Parser
		CSVParser miParser = new CSVParser(",");
		List<Empresa> misEmpresas = new ArrayList<Empresa>();
		misEmpresas = miParser.parse(stream);
		
		return misEmpresas;
	}
	
	private void vaciarCsv() {
		new FileCleaner().limpiar("cuentitasDeHector.csv");
	}
	
}
