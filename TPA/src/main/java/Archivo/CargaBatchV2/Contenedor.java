package Archivo.CargaBatchV2;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import Archivo.CargaBatchV2.Excepciones.ScannerException;
import Archivo.CargaBatchV2.Excepciones.DeScaneo.NoFueEscaneadoException;
import Archivo.CargaBatchV2.Excepciones.DeScaneo.YaFueEscaneadoException;

public abstract class Contenedor {
	private boolean fueEscaneado = false;
	private List<ScannerException> fallos = new LinkedList<ScannerException>();

	public final List<EmpresaToken> serEscaneado() throws IOException {
		if (fueEscaneado) throw new YaFueEscaneadoException();
		
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
		
		this.manejarFallos();
	}
	
	public abstract boolean tieneTokensPendientes() throws IOException;
	
	public abstract EmpresaToken escanearProximoToken() throws IOException;

	public abstract void limpiarse() throws IOException;
	
	public abstract void manejarFallos();
}
