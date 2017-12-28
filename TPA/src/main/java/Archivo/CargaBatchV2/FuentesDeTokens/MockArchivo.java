package Archivo.CargaBatchV2.FuentesDeTokens;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;

import Archivo.CargaBatchV2.FuenteDeTokens;

public class MockArchivo implements FuenteDeTokens {
	private String texto;
	private StringReader reader;
	private BufferedReader buffer;
	
	public MockArchivo(String texto) throws FileNotFoundException {
		this.setTexto(texto);
		this.reader = new StringReader(texto);
		this.buffer = new BufferedReader(reader);
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public String darProximoToken() throws IOException {
		return buffer.readLine();
	}

	@Override
	public boolean quedanTokens() throws IOException {
		return buffer.read() != -1;
	}

	@Override
	public void limpiarse() throws IOException {
		setTexto("");
		
		this.cerrarArchivo();
	}
	
	public void cerrarArchivo() throws IOException
	{
		this.buffer.close();
		
		this.reader.close();
	}
}
