package Archivo.CargaBatchV2.FuentesDeStrings;

import java.util.Arrays;
import java.util.List;

import Archivo.CargaBatchV2.FuenteDeStrings;

public class MockArchivo implements FuenteDeStrings {
	private List<String> lineas;
	
	public MockArchivo(String... texto) {
		lineas = Arrays.asList(texto);
	}

	@Override
	public List<String> darLineas() {
		return lineas;
	}

	@Override
	public boolean noTieneLineas() {
		return lineas.isEmpty();
	}
}
