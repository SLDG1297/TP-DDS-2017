package Archivo.CargaBatch.CargasBatch;

import java.util.List;
import java.util.TimerTask;

import Archivo.CargaBatch.Cargadores.Cargador;
import Archivo.CargaBatch.Contenedores.Contenedor;
import Archivo.CargaBatch.Excepciones.NoHayNadaException;
import Archivo.CargaBatch.ResultadosDeScan.ResultadoDeScan;

public class CargaBatch extends TimerTask {
	private Contenedor contenedor;
	private Cargador cargador;

	public CargaBatch(Contenedor contenedor, Cargador cargador) {
		this.contenedor = contenedor;
		this.cargador = cargador;
	}

	public Contenedor getContenedor() {
		return contenedor;
	}

	public void setContenedor(Contenedor contenedor) {
		this.contenedor = contenedor;
	}

	public Cargador getCargador() {
		return cargador;
	}

	public void setCargador(Cargador cargador) {
		this.cargador = cargador;
	}
	
	public void cargar() {
		List<ResultadoDeScan> resultados = contenedor.serEscaneado();
		
		resultados.forEach(resultado -> cargador.cargar(resultado));
	}

	@Override
	public void run() {
		try { this.cargar(); }
		
		catch (NoHayNadaException excepcion) { }
	}
}
