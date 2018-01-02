package Archivo.CargaBatchV2;

public interface FuenteDeStrings {
	String darProximoString();

	boolean quedanStrings();
	
	void abrirse();

	void limpiarse();
	
	void restaurarse();

	void cerrarse();
	
}
