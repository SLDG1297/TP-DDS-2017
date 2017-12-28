package Archivo.CargaBatchV2.Excepciones;

public class RenglonErroneoException extends ScannerException {
	FormatoException excepcionDeFormato;
	
	public RenglonErroneoException(String lineaFallada, FormatoException excepcionDeFormato) {
		super(lineaFallada);
		this.excepcionDeFormato = excepcionDeFormato;
	}

	@Override
	public String explicacionDelFallo() {
		return "La l�nea tiene un error en el campo " + excepcionDeFormato.explicarFalla();
	}
}
