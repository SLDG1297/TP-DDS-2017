package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class AlmacenIndicadores {
	static Gson serializador = new GsonBuilder().setPrettyPrinting().create();
	
	private static String serializarRepositorioIndicadores(IndicadoresRepository unRepositorio){
		return serializador.toJson(unRepositorio);
	}
	
	private static IndicadoresRepository deserializarRepositorioIndicadores(String indicadorJSON){
		return serializador.fromJson(indicadorJSON, IndicadoresRepository.class);
	}
	
	public static void almacenarRepositorioIndicadores(String nombreRuta, IndicadoresRepository unRepositorio) throws IOException{
		String texto = serializarRepositorioIndicadores(unRepositorio);
		String ruta = nombreRuta + ".txt";
		File archivo = new File(ruta);			
		BufferedWriter buffer = new BufferedWriter(new FileWriter(archivo));

        buffer.write(texto);
        
        buffer.close();
	}
	
	public static void obtenerRepositorioIndicadores(String nombreRuta, IndicadoresRepository unRepositorio) throws IOException{
		File archivo = new File(nombreRuta + ".txt");
		BufferedReader buffer = new BufferedReader(new FileReader(archivo));
		String texto = new String();
		
		while(buffer.readLine() != null)
		{
			texto.concat(buffer.readLine());
		}
		buffer.close();
		
		IndicadoresRepository nuevoRepositorio = deserializarRepositorioIndicadores(texto);
		unRepositorio.agregarIndicador(nuevoRepositorio.getIndicadores());
	}
}
