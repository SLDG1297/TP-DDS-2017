package Archivo.CargaBatchV2.Contenedores;

import Archivo.CargaBatchV2.StringScanner;

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
	
	public FuenteDeStrings getFuente() {
		return fuente;
	}

	public void setFuente(FuenteDeStrings fuente) {
		this.fuente = fuente;
	}

	public StringScanner getScanner() {
		return scanner;
	}

	public void setScanner(StringScanner scanner) {
		this.scanner = scanner;
	}

	@Override
	public EmpresaToken escanearProximoToken() {
		return scanner.escanear(fuente.darProximoString());
	}

	@Override
	public boolean tieneTokensPendientes() {
		return fuente.quedanStrings();
	}
	
	@Override
	public void abrirse() {
		fuente.abrirse();
	}

	@Override
	public void limpiarse() {
		fuente.limpiarse();
	}
	
	@Override
	public void restaurarse() {
		fuente.restaurarse();
	}

	@Override
	public void cerrarse() {
		fuente.cerrarse();
	}
	
	@Override
	public void manejarFallos() {
		throw new NotImplementedException();
	}
}
