package Archivo.CargaBatchV2.Excepciones;

public class RenglonVacioException extends ScannerException {
	@Override
	public String explicacionDelFallo() {
		return "No hay línea";
	}
}
