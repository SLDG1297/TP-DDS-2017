package Archivo.CargaBatchV2.Contenedores;

import Archivo.CargaBatchV2.Excepciones.NoHayNadaException;
import Archivo.CargaBatchV2.FuentesDeStrings.FuenteDeStrings;
import Archivo.CargaBatchV2.ResultadosDeScan.ResultadoDeScan;
import Archivo.CargaBatchV2.Scanners.StringScanner;

import java.util.List;
import java.util.stream.Collectors;

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

	@Override
	public void limpiarse() {
		fuente.limpiarse();
	}

}
