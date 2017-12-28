package Archivo.CargaBatchV2;

import java.io.IOException;

public interface FuenteDeStrings {
	String darProximoString() throws IOException;

	boolean quedanStrings() throws IOException;

	void limpiarse() throws IOException;
}
