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
import Modelo.Indicadores.Indicador;
import Modelo.Indicadores.IndicadoresRepository;

public class InstanciadorListaIndicadores {
	
	public void instanciarListaIndicadores() throws FileNotFoundException{
		
		Reader reader = generarReader("repositorioIndicadores.csv");
		Type type = generarType();
		
		List<Indicador> lista = deserializarListaIndicadores(reader, type);
		
		IndicadoresRepository.getInstancia().setIndicadores(lista);
	
	}

	private List<Indicador> deserializarListaIndicadores(Reader reader, Type type) {
		Gson gson = AdaptadorJson.getInstancia().getAdaptador(); //Usamos un adaptador para poder luego deserializar sin probloemas, ya que usamos interfaces
		return gson.fromJson(reader, type);
	}

	private Type generarType() {
		Type type = new TypeToken<List<Indicador>>(){}.getType();
		return type;
	}

	private Reader generarReader(String ruta) throws FileNotFoundException {
		InputStream stream =  new LectorDeArchivos().getFile(ruta);
		Reader reader = new BufferedReader(new InputStreamReader(stream));
		return reader;
	}
}
