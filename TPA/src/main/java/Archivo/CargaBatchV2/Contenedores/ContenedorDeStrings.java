package Archivo.CargaBatchV2.Contenedores;

import Archivo.CargaBatchV2.StringScanner;

import java.io.IOException;

import Archivo.CargaBatchV2.Contenedor;
import Archivo.CargaBatchV2.EmpresaToken;
import Archivo.CargaBatchV2.FuenteDeTokens;
import Archivo.CargaBatchV2.ScannerExceptionHandler;

public class ContenedorDeStrings extends Contenedor {
	private FuenteDeTokens fuente;
	private StringScanner scanner;
	
	public ContenedorDeStrings(FuenteDeTokens fuente, StringScanner scanner, ScannerExceptionHandler manejadorExcepciones)
	{
		super(manejadorExcepciones);
		this.fuente = fuente;
		this.scanner = scanner;
	}

	@Override
	public EmpresaToken escanearProximoToken() throws IOException {
		return scanner.escanear(fuente.darProximoToken());
	}

	@Override
	public boolean tieneTokensPendientes() throws IOException {
		return fuente.quedanTokens();
	}

	@Override
	public void limpiarse() throws IOException {
		fuente.limpiarse();
	}
}
