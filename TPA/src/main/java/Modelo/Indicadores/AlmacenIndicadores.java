package Modelo.Indicadores;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class AlmacenIndicadores {
	static Gson serializador = new GsonBuilder().setPrettyPrinting().create();
	static String ruta = "repositorioIndicadores.txt";
	
	private static String serializarRepositorioIndicadores(){
		return serializador.toJson(IndicadoresRepository.getInstancia());
	}
		
	
	private static IndicadoresRepository deserializarRepositorioIndicadores(String indicadoresJSON){
		return serializador.fromJson(indicadoresJSON, IndicadoresRepository.class);
	}
	
	public static void almacenarRepositorioIndicadores() throws IOException{
		try
		{
			String texto = serializarRepositorioIndicadores();
			File archivo = new File(ruta);			
			BufferedWriter buffer = new BufferedWriter(new FileWriter(archivo));

			buffer.write(texto);
        
			buffer.close();
		}
		
		catch(IOException error)
		{
			error.printStackTrace();
		}
	}
	
	public static void obtenerRepositorioIndicadores() throws IOException{
		try
		{
			String texto = "";
			String linea = "";
			File archivo = new File(ruta);
			
			if(archivo.createNewFile())
			{
				almacenarRepositorioIndicadores();
			}
			
			BufferedReader buffer = new BufferedReader(new FileReader(archivo));
			while((linea = buffer.readLine()) != null)
			{
				texto.concat(linea);
			}
			buffer.close();
		
			List<Indicador> indicadores = deserializarRepositorioIndicadores(texto).getInstancia().getIndicadores();
			IndicadoresRepository.getInstancia().agregarIndicadores(indicadores);
		}
		
		catch(IOException error)
		{
			error.printStackTrace();
		}
	}
}
