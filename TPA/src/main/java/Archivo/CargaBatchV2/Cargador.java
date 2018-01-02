package Archivo.CargaBatchV2;

import java.util.List;
import java.util.TimerTask;

public abstract class Cargador extends TimerTask {
	private Contenedor contenedor;
	private Analizador analizador;
	
	public Cargador(Contenedor contenedor, Analizador analizador) {
		this.contenedor = contenedor;
		this.analizador = analizador;
	}

	public Contenedor getContenedor() {
		return contenedor;
	}

	public void setContenedor(Contenedor contenedor) {
		this.contenedor = contenedor;
	}

	public Analizador getAnalizador() {
		return analizador;
	}

	public void setAnalizador(Analizador analizador) {
		this.analizador = analizador;
	}
	
	public void run() {
		this.procesoPreliminar();
		this.cargar();
		this.procesoPosterior();
	}

	public void cargar() {
		List<EmpresaToken> tokens = contenedor.serEscaneado();
			
		List<Carga> cargas = analizador.analizarContenedor(tokens);
			
		cargas.forEach(c -> c.efectuarse());
	}

	public abstract void procesoPreliminar();
	
	public abstract void procesoPosterior();
}
