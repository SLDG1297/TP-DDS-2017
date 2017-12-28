package Archivo.CargaBatchV2.Excepciones;

public class RenglonErroneoException extends ScannerException {
	FormatoException excepcionDeFormato;
	
	public RenglonErroneoException(String lineaFallada, FormatoException excepcionDeFormato) {
		super(lineaFallada);
		this.excepcionDeFormato = excepcionDeFormato;
	}

	@Override
	public String explicacionDelFallo() {
		return "La línea tiene un error en el campo " + excepcionDeFormato.explicarFalla();
	}
}
