package Archivo.CargaBatchV2.FuentesDeStrings.GestoresDeArchivo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import Archivo.CargaBatchV2.FuentesDeStrings.Archivo;

public class EscritorDeArchivo implements GestorDeArchivo {
	private String[] texto;
	
	public EscritorDeArchivo(String... texto) {
		this.texto = texto;
	}

	@Override
	public void atender(Archivo archivo) {
		try
		{
			BufferedWriter writerRestauracion = new BufferedWriter(new FileWriter(new File(archivo.getRuta())));
		    
		    for(int i = 0; i < texto.length; i++)
		    {
		    	writerRestauracion.write(texto[i]);
		    	if(i != texto.length - 1) writerRestauracion.newLine();
		    }
		    
		    writerRestauracion.flush();
		    writerRestauracion.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
