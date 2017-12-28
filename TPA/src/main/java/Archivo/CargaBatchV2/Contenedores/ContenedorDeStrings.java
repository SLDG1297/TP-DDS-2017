package Archivo.CargaBatchV2.Contenedores;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

import Archivo.CargaBatchV2.StringScanner;
import Archivo.CargaBatchV2.Contenedor;
import Archivo.CargaBatchV2.EmpresaToken;
import Archivo.CargaBatchV2.ScannerExceptionHandler;

public abstract class ContenedorDeStrings extends Contenedor {
	private BufferedReader buffer;
	private StringScanner scanner;

	public ContenedorDeStrings(String ruta, StringScanner scanner, ScannerExceptionHandler manejadorExcepciones) throws FileNotFoundException
	{
		super(manejadorExcepciones);
		this.buffer = new BufferedReader(this.getReader());
		this.scanner = scanner;
	}

	public abstract Reader getReader();

	@Override
	public boolean tieneTokensPendientes() throws IOException {
		return buffer.read() != -1;
	}

	@Override
	public EmpresaToken escanearProximoToken() throws IOException {
		return scanner.escanear(buffer.readLine());
	}

	@Override
	public void limpiarse() throws IOException {
		
	}

}
