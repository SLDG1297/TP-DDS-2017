package Archivo.CargaBatchV2.Excepciones.DeScaneo;

import Archivo.CargaBatchV2.Excepciones.ScannerException;

public class RenglonVacioException extends ScannerException {
	public RenglonVacioException(String lineaFallada) {
		super(lineaFallada);
	}

	@Override
	public String explicacionDelFallo() {
		return "No hay línea";
	}

	@Override
	public String causaDelFallo() {
		return "";
	}
}
