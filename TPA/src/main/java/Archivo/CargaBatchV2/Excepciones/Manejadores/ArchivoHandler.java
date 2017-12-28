package Archivo.CargaBatchV2.Excepciones.Manejadores;

import org.apache.commons.lang.NotImplementedException;

import Archivo.CargaBatchV2.ScannerExceptionHandler;
import Archivo.CargaBatchV2.Excepciones.ScannerException;

public class ArchivoHandler implements ScannerExceptionHandler{

	@Override
	public void manejalo(ScannerException excepcion) {
		throw new NotImplementedException();
	}

}
