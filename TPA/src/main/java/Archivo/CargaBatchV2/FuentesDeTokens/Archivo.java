package Archivo.CargaBatchV2.FuentesDeTokens;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Archivo.CargaBatchV2.FuenteDeTokens;

public class Archivo implements FuenteDeTokens {
	private String ruta;
	private FileReader reader;
	private BufferedReader buffer;
	
	public Archivo(String ruta) throws FileNotFoundException {
		this.ruta = ruta;
		this.reader = new FileReader(ruta);
		this.buffer = new BufferedReader(reader);
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
		try
		{
			File archivoDeLimpieza = new File(ruta);
			
			BufferedWriter bufferDeLimpieza = new BufferedWriter(new FileWriter(archivoDeLimpieza));

			bufferDeLimpieza.write("");

			bufferDeLimpieza.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			this.cerrarArchivo();
		}
	}
	
	public void cerrarArchivo() throws IOException
	{
		this.buffer.close();
		
		this.reader.close();
	}
}
