package Archivo.CargaBatchV2.Scanners;

import Archivo.CargaBatchV2.EmpresaToken;
import Archivo.CargaBatchV2.StringScanner;
import Archivo.CargaBatchV2.Excepciones.ExcepcionBatch;
import Archivo.CargaBatchV2.Excepciones.DeScaneo.CantidadCamposIncorrectosException;
import Archivo.CargaBatchV2.Excepciones.DeScaneo.RenglonVacioException;

public class CSV implements StringScanner {
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
		
		return new EmpresaToken(vector[0], vector[1], vector[2], vector[3]);
	}

	@Override
	public boolean esLineaValida(String renglon) {
		try
		{
			if(renglon.isEmpty()) throw new RenglonVacioException("");
			
			String[] vector = renglon.split(this.delimitador);
			
			if(vector.length != 4) throw new CantidadCamposIncorrectosException(renglon, vector.length);
			
			new EmpresaToken(vector[0], vector[1], vector[2], vector[3]);
			
			return true;
		}
		catch (ExcepcionBatch excepcion)
		{
			return false;
		}
	}
	
}
