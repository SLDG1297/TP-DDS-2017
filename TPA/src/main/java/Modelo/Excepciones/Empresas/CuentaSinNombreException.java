package Modelo.Excepciones.Empresas;

import Archivo.CargaBatchV2.Excepciones.ScannerException;

public class CuentaSinNombreException extends ScannerException {
	@Override
	public String explicacionDelFallo() {
		return "Le falta nombre a la cuenta";
	}
}
