package Archivo.CargaBatchV2.Excepciones;

public class RenglonVacioException extends ScannerException {
	public RenglonVacioException(String lineaFallada) {
		super(lineaFallada);
	}

	@Override
	public String explicacionDelFallo() {
		return "Esta línea está vacía.";
	}
}
