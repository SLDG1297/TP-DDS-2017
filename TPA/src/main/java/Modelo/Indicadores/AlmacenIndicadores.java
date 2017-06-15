package Modelo.Indicadores;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

public class AlmacenIndicadores {
	//static Gson serializador = new GsonBuilder().setPrettyPrinting().create();
	static Gson serializador = new Gson();
	static String ruta = "repositorioIndicadores.csv";
	
	private static String serializarRepositorioIndicadores(){
		Type listType  = new TypeToken<List<Indicador>>(){}.getType();
		List<Indicador> lista = IndicadoresRepository.getInstancia().getIndicadores();
		return serializador.toJson(lista, listType);
	}
		
	
	private static List<Indicador> deserializarRepositorioIndicadores(Reader reader){
		Type lista = new TypeToken<List<Indicador>>(){}.getType();
		return serializador.fromJson(reader, lista);
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
			
		/*Reader reader = new FileReader(ruta);
		
		List<Indicador> x = deserializarRepositorioIndicadores(reader);

		
		for(int i=0;i<x.size();i++){
			IndicadoresRepository.getInstancia().agregarIndicador(x.get(i));
		}*/
	
	
		
	}
}
