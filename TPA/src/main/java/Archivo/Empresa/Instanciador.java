package Archivo.Empresa;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Archivo.LectorDeArchivos;
import Modelo.Empresa.Empresa;

public class Instanciador {
	public static List<Empresa> obtenerEmpresas(String pathCSV) throws IOException {
		LectorDeArchivos miLector = new LectorDeArchivos();
		FileInputStream stream = miLector.getFile(pathCSV);

		CSVParser miParser = new CSVParser(",");
		List<Empresa> misEmpresas = new ArrayList<Empresa>();
		misEmpresas = miParser.parse(stream);
		
		return misEmpresas;
	}
}
