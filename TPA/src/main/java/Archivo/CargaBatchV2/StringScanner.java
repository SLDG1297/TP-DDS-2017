package Archivo.CargaBatchV2;

public interface StringScanner {
	EmpresaToken escanear(String renglon);

	boolean esLineaValida(String renglon);
}
