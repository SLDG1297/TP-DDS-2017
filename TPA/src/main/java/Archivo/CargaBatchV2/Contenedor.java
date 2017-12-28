package Archivo.CargaBatchV2;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import Archivo.CargaBatchV2.Excepciones.ScannerException;

public abstract class Contenedor {
	private ScannerExceptionHandler manejadorExcepciones;
	
	public Contenedor(ScannerExceptionHandler manejadorExcepciones) {
		this.manejadorExcepciones = manejadorExcepciones;
	}
	
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
				manejadorExcepciones.manejalo(excepcion);
			}
		}
		
		this.limpiarse();
		
		return empresasEscaneadas;
	}
	
	public abstract boolean tieneTokensPendientes() throws IOException;
	
	public abstract EmpresaToken escanearProximoToken() throws IOException;

	public abstract void limpiarse() throws IOException;
}
