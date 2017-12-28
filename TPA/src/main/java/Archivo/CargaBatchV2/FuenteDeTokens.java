package Archivo.CargaBatchV2;

import java.io.IOException;

public interface FuenteDeTokens {
	String darProximoToken() throws IOException;

	boolean quedanTokens() throws IOException;

	void limpiarse() throws IOException;
}
