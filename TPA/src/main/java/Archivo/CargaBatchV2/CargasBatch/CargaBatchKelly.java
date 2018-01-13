package Archivo.CargaBatchV2.CargasBatch;

import Archivo.CargaBatchV2.Cargadores.Cargador;
import Archivo.CargaBatchV2.Contenedores.Contenedor;

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
