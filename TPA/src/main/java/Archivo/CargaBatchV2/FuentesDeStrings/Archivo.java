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
	private FileReader reader;
	private BufferedReader buffer;
	
	public Archivo(String ruta) {
		this.ruta = ruta;
	}
	
	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	@Override
	public List<String> darLineas() {
		abrirse();
		
		List<String> lineas = obtenerLineas();
		
		cerrarse();
		
		limpiarse();
		
		return lineas;
	}
	
	@Override
	public boolean noTieneLineas() {
		boolean valorDeVerdad = false;
		
		abrirse();
		
		try
		{
			valorDeVerdad = buffer.read() == -1;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		cerrarse();
		
		return valorDeVerdad;
	}
	
	private List<String> obtenerLineas() {
		String lineaActual = "";
		
		List<String> lineas = new LinkedList<String>();
		
		do
		{
			if(!lineaActual.isEmpty()) lineas.add(lineaActual);
			
			try
			{
				lineaActual = buffer.readLine();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		while (lineaActual != null);
		
		
		return lineas;
	}

	private void abrirse() {
		try
		{
			reader = new FileReader(ruta);
			buffer = new BufferedReader(reader);
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	private void cerrarse() {
		try
		{
			buffer.close();
			reader.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private void limpiarse() {
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
}
