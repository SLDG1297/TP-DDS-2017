package Archivo.CargaBatchV2.Excepciones.DeScaneo;

import Archivo.CargaBatchV2.Excepciones.ScannerException;

public class CantidadCamposIncorrectosException extends ScannerException {
	private int cantidadActualCampos;
	
	public CantidadCamposIncorrectosException(String lineaFallada, int unaCantidadDeCampos) {
		super(lineaFallada);
		cantidadActualCampos = unaCantidadDeCampos;
	}
	
	@Override
	public String causaDelFallo() {
		return "tiene " + camposDeMasOMenos() + "de " + masOMenos() + ".";
	}
	
	private int camposDeMasOMenos() {
		return Math.abs(4 - cantidadActualCampos);
	}
	
	private String masOMenos() {
		if (4 < cantidadActualCampos) return "menos";
		else return "más";
	}
}
