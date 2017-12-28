package Archivo.CargaBatchV2.Excepciones;

public abstract class ScannerException extends RuntimeException {
	private String lineaFallada;
	
	public ScannerException(String lineaFallada) {
		this.lineaFallada = lineaFallada;
	}
	
	public String getLineaFallada() {
		return lineaFallada;
	}

	public void setLineaFallada(String lineaFallada) {
		this.lineaFallada = lineaFallada;
	}
	
	public abstract String explicacionDelFallo();

}
