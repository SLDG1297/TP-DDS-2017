package Archivo.CargaBatchV2.Cargadores;

import Archivo.CargaBatchV2.Analizador;
import Archivo.CargaBatchV2.Cargador;
import Archivo.CargaBatchV2.Contenedor;

public class CargadorMock extends Cargador {

	public CargadorMock(Contenedor contenedor, Analizador analizador) {
		super(contenedor, analizador);
	}

	@Override
	public void procesoPreliminar() {
		
	}

	@Override
	public void procesoPosterior() {
		
	}
}
