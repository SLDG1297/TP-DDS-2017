package Modelo.Excepciones.Empresas;

import Archivo.CargaBatchV2.Excepciones.FormatoException;

public class CuentaSinNombreException extends FormatoException {

	@Override
	public String explicarFalla() {
		return "Le falta nombre a la cuenta";
	}

}
