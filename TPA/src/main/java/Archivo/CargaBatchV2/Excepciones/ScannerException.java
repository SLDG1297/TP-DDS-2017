package Archivo.CargaBatchV2.Excepciones;

public abstract class ScannerException extends ExcepcionBatch {
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
	
	public String explicacionDelFallo() {
		return "La línea " + this.lineaFallada + " falla porque " + this.causaDelFallo() + ".";
	};
	
	public abstract String causaDelFallo();

}
