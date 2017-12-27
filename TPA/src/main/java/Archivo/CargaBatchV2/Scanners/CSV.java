package Archivo.CargaBatchV2.Scanners;

import Archivo.CargaBatchV2.ArchivoScanner;
import Archivo.CargaBatchV2.EmpresaToken;

public class CSV implements ArchivoScanner {
	private String delimitador;
	
	public CSV(String delimitador) {
		this.delimitador = delimitador;
	}
	
	public String getDelimitador() {
		return delimitador;
	}

	public void setDelimitador(String delimitador) {
		this.delimitador = delimitador;
	}

	@Override
	public EmpresaToken escanear(String renglon) {
		String[] vector = renglon.split(this.delimitador);
		
		return new EmpresaToken(vector[0], vector[1], Integer.parseInt(vector[2]), Integer.parseInt(vector[3]));
	}
	
}
