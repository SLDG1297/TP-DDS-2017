package Archivo.CargaBatchV2.Contenedores;

import Archivo.CargaBatchV2.StringScanner;

import java.io.IOException;

import Archivo.CargaBatchV2.Contenedor;
import Archivo.CargaBatchV2.EmpresaToken;
import Archivo.CargaBatchV2.FuenteDeStrings;
import Archivo.CargaBatchV2.ScannerExceptionHandler;

public class ContenedorDeStrings extends Contenedor {
	private FuenteDeStrings fuente;
	private StringScanner scanner;
	
	public ContenedorDeStrings(FuenteDeStrings fuente, StringScanner scanner, ScannerExceptionHandler manejadorExcepciones)
	{
		super(manejadorExcepciones);
		this.fuente = fuente;
		this.scanner = scanner;
	}

	@Override
	public EmpresaToken escanearProximoToken() throws IOException {
		return scanner.escanear(fuente.darProximoString());
	}

	@Override
	public boolean tieneTokensPendientes() throws IOException {
		return fuente.quedanStrings();
	}

	@Override
	public void limpiarse() throws IOException {
		fuente.limpiarse();
	}
}
