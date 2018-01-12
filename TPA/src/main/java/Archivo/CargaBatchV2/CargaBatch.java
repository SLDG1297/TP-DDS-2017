package Archivo.CargaBatchV2;

import java.util.List;
import java.util.TimerTask;

import Archivo.CargaBatchV2.Cargadores.Cargador;
import Archivo.CargaBatchV2.Contenedores.Contenedor;
import Archivo.CargaBatchV2.Excepciones.NoHayNadaException;
import Archivo.CargaBatchV2.ResultadosDeScan.ResultadoDeScan;

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

	@Override
	public void run() {
		try
		{
			List<ResultadoDeScan> resultados = contenedor.serEscaneado();
			
			resultados.forEach(resultado -> cargador.cargar(resultado));
		}
		catch (NoHayNadaException excepcion)
		{
			
		}
	}
}
