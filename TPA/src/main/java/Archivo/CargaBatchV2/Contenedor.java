package Archivo.CargaBatchV2;

import java.util.LinkedList;
import java.util.List;

import Archivo.CargaBatchV2.Excepciones.ScannerException;
import Archivo.CargaBatchV2.Excepciones.DeScaneo.NoFueEscaneadoException;
import Archivo.CargaBatchV2.Excepciones.DeScaneo.NoTieneFallosException;

public abstract class Contenedor {
	private boolean fueEscaneado = false;
	private List<ScannerException> fallos = new LinkedList<ScannerException>();

	public final List<EmpresaToken> serEscaneado() {
		List<EmpresaToken> empresasEscaneadas = new LinkedList<EmpresaToken>();
		
		while (this.tieneTokensPendientes())
		{
			try
			{
				empresasEscaneadas.add(this.escanearProximoToken());
			}
			catch (ScannerException excepcion)
			{
				fallos.add(excepcion);
			}
		}
		
		this.fueEscaneado = true;
		
		return empresasEscaneadas;
	}

	public List<ScannerException> getFallos() {
		return fallos;
	}

	public void setFallos(List<ScannerException> fallos) {
		this.fallos = fallos;
	}
	
	public boolean tieneFallos() {
		if(!fueEscaneado) throw new NoFueEscaneadoException();
		
		return this.fallos.size() != 0;
	}
	
	public void reportarFallos() {
		if(!fueEscaneado) throw new NoFueEscaneadoException();
		
		if(!this.tieneFallos()) throw new NoTieneFallosException();
		
		this.manejarFallos();
	}
	
	public abstract boolean tieneTokensPendientes();
	
	public abstract EmpresaToken escanearProximoToken();
	
	public abstract void abrirse();

	public abstract void limpiarse();

	public abstract void cerrarse();
	
	public abstract void restaurarse();
	
	public abstract void manejarFallos();
}
