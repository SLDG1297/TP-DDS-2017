package Archivo.CargaBatchV2;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import Archivo.CargaBatchV2.Excepciones.ScannerException;

public abstract class Contenedor {
	private List<ScannerException> fallos = new LinkedList<ScannerException>();

	public final List<EmpresaToken> serEscaneado() throws IOException {
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
		
		this.limpiarse();
		
		if(!fallos.isEmpty()) this.reportarFallos();
		
		return empresasEscaneadas;
	}

	public List<ScannerException> getFallos() {
		return fallos;
	}

	public void setFallos(List<ScannerException> fallos) {
		this.fallos = fallos;
	}
	
	public abstract boolean tieneTokensPendientes() throws IOException;
	
	public abstract EmpresaToken escanearProximoToken() throws IOException;

	public abstract void limpiarse() throws IOException;
	
	public abstract void reportarFallos();
}
