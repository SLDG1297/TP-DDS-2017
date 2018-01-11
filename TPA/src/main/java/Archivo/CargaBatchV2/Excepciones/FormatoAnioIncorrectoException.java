package Archivo.CargaBatchV2.Excepciones;

public class FormatoAnioIncorrectoException extends ScannerException {
	String anioErroneo;

	public FormatoAnioIncorrectoException(String anioErroneo) {
		this.anioErroneo = anioErroneo;
	}

	@Override
	public String explicacionDelFallo() {
		return "El campo " + anioErroneo + " no sigue un formato numérico para un año.";
	}
}
