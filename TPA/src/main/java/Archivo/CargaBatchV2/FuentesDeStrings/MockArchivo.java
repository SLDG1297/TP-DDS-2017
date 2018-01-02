package Archivo.CargaBatchV2.FuentesDeStrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import Archivo.CargaBatchV2.FuenteDeStrings;

public class MockArchivo implements FuenteDeStrings {
	private String texto;
	private String textoBackup;
	private StringReader reader;
	private BufferedReader buffer;
	
	public MockArchivo(String texto) {
		this.setTexto(texto);
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
		this.textoBackup = texto;
	}

	@Override
	public String darProximoString() {
		String linea = "";
		
		try
		{
			return buffer.readLine();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return linea;
	}

	@Override
	public boolean quedanStrings() {
		boolean valorDeVerdad = false;
		
		try
		{
			buffer.mark(1);
			
			valorDeVerdad = buffer.read() != -1;
			
			buffer.reset();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return valorDeVerdad;
	}
	
	@Override
	public void abrirse() {
		this.reader = new StringReader(texto);
		this.buffer = new BufferedReader(reader);
	}

	@Override
	public void limpiarse() {
		setTexto("");
	}

	@Override
	public void restaurarse() {
		setTexto(this.textoBackup);
	}
	
	@Override
	public void cerrarse()
	{
		try
		{
			this.buffer.close();
			this.reader.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
