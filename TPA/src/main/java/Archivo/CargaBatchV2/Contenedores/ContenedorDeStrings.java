package Archivo.CargaBatchV2.Contenedores;

import Archivo.CargaBatchV2.StringScanner;

import java.io.IOException;

import org.apache.commons.lang.NotImplementedException;

import Archivo.CargaBatchV2.Contenedor;
import Archivo.CargaBatchV2.EmpresaToken;
import Archivo.CargaBatchV2.FuenteDeStrings;

public class ContenedorDeStrings extends Contenedor {
	private FuenteDeStrings fuente;
	private StringScanner scanner;
	
	public ContenedorDeStrings(FuenteDeStrings fuente, StringScanner scanner)
	{
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

	@Override
	public void reportarFallos() {
		throw new NotImplementedException();
	}
}
