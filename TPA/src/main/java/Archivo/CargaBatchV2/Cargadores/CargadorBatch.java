package Archivo.CargaBatchV2.Cargadores;

import Archivo.CargaBatchV2.Analizador;
import Archivo.CargaBatchV2.Cargador;
import Archivo.CargaBatchV2.Contenedor;

public class CargadorBatch extends Cargador {

	public CargadorBatch(Contenedor contenedor, Analizador analizador) {
		super(contenedor, analizador);
	}

	@Override
	public void procesoPreliminar() {
		this.getContenedor().abrirse();
	}
	
	@Override
	public void procesoPosterior() {
		this.getContenedor().limpiarse();
		this.getContenedor().cerrarse();
	}
}
