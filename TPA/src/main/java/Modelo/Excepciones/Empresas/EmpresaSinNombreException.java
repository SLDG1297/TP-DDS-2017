package Modelo.Excepciones.Empresas;

import Archivo.CargaBatchV2.Excepciones.FormatoException;

public class EmpresaSinNombreException extends FormatoException {
	@Override
	public String explicacionDelFallo() {
		return "Le falta nombre a la empresa.";
	}
}
