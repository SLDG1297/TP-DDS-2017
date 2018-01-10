package Archivo.CargaBatchV2.Contenedores;

import Archivo.CargaBatchV2.StringScanner;

import java.util.List;
import java.util.stream.Collectors;

import Archivo.CargaBatchV2.Contenedor;
import Archivo.CargaBatchV2.EmpresaToken;
import Archivo.CargaBatchV2.FuenteDeStrings;

public class ContenedorDeStrings implements Contenedor {
	private FuenteDeStrings fuente;
	private StringScanner scanner;
	
	public ContenedorDeStrings(FuenteDeStrings fuente, StringScanner scanner)
	{
		this.fuente = fuente;
		this.scanner = scanner;
	}

	@Override
	public List<EmpresaToken> serEscaneado() {
		List<String> lineas = fuente.darLineas();
		
		List<String> lineasValidas = lineas.stream().filter(linea -> scanner.esLineaValida(linea)).collect(Collectors.toList());
		
		return lineasValidas.stream().map(linea -> scanner.escanear(linea)).collect(Collectors.toList());
	}

}
