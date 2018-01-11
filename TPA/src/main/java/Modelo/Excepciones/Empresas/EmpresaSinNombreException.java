package Modelo.Excepciones.Empresas;

import Archivo.CargaBatchV2.Excepciones.ScannerException;

public class EmpresaSinNombreException extends ScannerException {
	@Override
	public String explicacionDelFallo() {
		return "Le falta nombre a la empresa.";
	}
}
