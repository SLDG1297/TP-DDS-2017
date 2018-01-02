package Archivo.CargaBatchV2.FuentesDeStrings;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import Archivo.CargaBatchV2.FuenteDeStrings;

public class Archivo implements FuenteDeStrings {
	private String ruta;
	private String rutaRestauradora;
	private FileReader reader;
	private BufferedReader buffer;
	
	public Archivo(String ruta) {
		this.ruta = ruta;
	}
	
	public Archivo(String ruta, String rutaRestauradora) {
		this.ruta = ruta;
		this.rutaRestauradora = rutaRestauradora;
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
		try
		{
			this.reader = new FileReader(ruta);
			this.buffer = new BufferedReader(reader);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void limpiarse() {
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
	}
	
	@Override
	public void restaurarse() {
		try
		{
			BufferedReader bufferRestauracion = new BufferedReader(new FileReader(this.rutaRestauradora));
			BufferedWriter writerRestauracion = new BufferedWriter(new FileWriter(new File(this.ruta))); 
			
			String lineaActual;
		    List<String> lineas = new LinkedList<String>();
		    
		    while ((lineaActual = bufferRestauracion.readLine()) != null) lineas.add(lineaActual);
		    
		    for(int i = 0; i < lineas.size(); i++)
		    {
		    	writerRestauracion.write(lineas.get(i));
		    	if(i != lineas.size() - 1) writerRestauracion.newLine();
		    }
		    
		    writerRestauracion.flush();
		    writerRestauracion.close();
		    
		    bufferRestauracion.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void cerrarse() {
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
