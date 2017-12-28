package Archivo.CargaBatchV2.Excepciones.DeScaneo;

import Archivo.CargaBatchV2.Excepciones.FormatoException;
import Archivo.CargaBatchV2.Excepciones.ScannerException;

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
