package Archivo.CargaBatch.CargasBatch;

import Archivo.CargaBatch.Cargadores.Cargador;
import Archivo.CargaBatch.Contenedores.Contenedor;

public class CargaBatchKelly extends CargaBatch {

	public CargaBatchKelly(Contenedor contenedor, Cargador cargador) {
		super(contenedor, cargador);
	}
	
	@Override
	public void cargar() {
		super.cargar();
		
		this.getContenedor().limpiarse();
	}
}
