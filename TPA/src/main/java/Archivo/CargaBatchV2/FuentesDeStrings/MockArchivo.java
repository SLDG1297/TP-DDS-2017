package Archivo.CargaBatchV2.FuentesDeStrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import Archivo.CargaBatchV2.FuenteDeStrings;

public class MockArchivo implements FuenteDeStrings {
	private String texto;
	private StringReader reader;
	private BufferedReader buffer;
	
	public MockArchivo(String texto) {
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
	public String darProximoString() throws IOException {
		return buffer.readLine();
	}

	@Override
	public boolean quedanStrings() throws IOException {
		buffer.mark(1);
		
		boolean valorDeVerdad = buffer.read() != -1;
		
		buffer.reset();
		
		return valorDeVerdad;
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
