package Archivo.CargaBatchV2;

import java.util.List;
import java.util.TimerTask;

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
		List<EmpresaToken> tokens = contenedor.serEscaneado();
		
		tokens.forEach(token -> cargador.cargar(token));
	}
}
