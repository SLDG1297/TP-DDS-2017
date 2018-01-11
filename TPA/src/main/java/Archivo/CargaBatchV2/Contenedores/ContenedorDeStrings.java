package Archivo.CargaBatchV2.Contenedores;

import Archivo.CargaBatchV2.StringScanner;
import Archivo.CargaBatchV2.Excepciones.NoHayNadaException;

import java.util.List;
import java.util.stream.Collectors;

import Archivo.CargaBatchV2.Contenedor;
import Archivo.CargaBatchV2.FuenteDeStrings;
import Archivo.CargaBatchV2.ResultadoDeScan;

public class ContenedorDeStrings implements Contenedor {
	private FuenteDeStrings fuente;
	private StringScanner scanner;
	
	public ContenedorDeStrings(FuenteDeStrings fuente, StringScanner scanner)
	{
		this.fuente = fuente;
		this.scanner = scanner;
	}

	@Override
	public List<ResultadoDeScan> serEscaneado() {
		if(fuente.noTieneLineas()) throw new NoHayNadaException();
			
		List<String> lineas = fuente.darLineas();
		
		List<ResultadoDeScan> resultados = lineas.stream().map(linea -> scanner.escanear(linea)).collect(Collectors.toList());
		
		return resultados;
	}

}
