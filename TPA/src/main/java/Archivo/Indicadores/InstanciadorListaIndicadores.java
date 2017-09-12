package Archivo.Indicadores;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import Archivo.AdaptadorJson;
import Archivo.LectorDeArchivos;
import DB.IndicadoresRepository;
import Modelo.Indicadores.Indicador;

public class InstanciadorListaIndicadores {
	
	public void instanciarListaIndicadores() throws FileNotFoundException{
		
		Reader reader = generarReader("repositorioIndicadores.csv");
		Type type = generarType();
		
		List<Indicador> lista = deserializarListaIndicadores(reader, type);
		
		IndicadoresRepository.getInstancia().setIndicadores(lista);
	
	}

	private List<Indicador> deserializarListaIndicadores(Reader reader, Type type) {
		Gson gson = new AdaptadorJson().getAdaptador(); //Usamos un adaptador para poder luego deserializar sin probloemas, ya que usamos interfaces
		return gson.fromJson(reader, type);
	}

	private Type generarType() {
		return new TypeToken<List<Indicador>>(){}.getType();
		
	}

	private Reader generarReader(String ruta) throws FileNotFoundException {
		InputStream stream =  new LectorDeArchivos().getFile(ruta);
		return new BufferedReader(new InputStreamReader(stream));
	}
}
