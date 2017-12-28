package Archivo.CargaBatchV2.Excepciones;

public class CantidadCamposIncorrectosException extends ScannerException {
	private int cantidadActualCampos;
	
	public CantidadCamposIncorrectosException(String lineaFallada, int unaCantidadDeCampos) {
		super(lineaFallada);
		cantidadActualCampos = unaCantidadDeCampos;
	}
	
	@Override
	public String explicacionDelFallo() {
		return "La linea tiene " + camposDeMasOMenos() + "de " + masOMenos() + ".";
	}
	
	private int camposDeMasOMenos() {
		return Math.abs(4 - cantidadActualCampos);
	}
	
	private String masOMenos() {
		if (4 < cantidadActualCampos) return "menos";
		else return "más";
	}
}
