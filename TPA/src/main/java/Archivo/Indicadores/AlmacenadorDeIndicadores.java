package Archivo.Indicadores;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import Modelo.Empresa.Cuenta;
import Modelo.Indicadores.Division;
import Modelo.Indicadores.Expresion;
import Modelo.Indicadores.Indicador;
import Modelo.Indicadores.IndicadoresRepository;
import Modelo.Indicadores.Multiplicacion;
import Modelo.Indicadores.Numero;
import Modelo.Indicadores.Resta;
import Modelo.Indicadores.Suma;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;


public class AlmacenadorDeIndicadores {
	
	static AlmacenadorDeIndicadores instancia = null;
	static String ruta = "repositorioIndicadores.csv";
	
	private RuntimeTypeAdapterFactory<Expresion> adapter(){
		RuntimeTypeAdapterFactory<Expresion> runtimeTypeAdapterFactory = RuntimeTypeAdapterFactory
            .of(Expresion.class, "type")
            .registerSubtype(Suma.class, "Suma")
            .registerSubtype(Resta.class, "Resta")
            .registerSubtype(Numero.class, "Numero")
            .registerSubtype(Indicador.class, "Indicador")
            .registerSubtype(Division.class, "Division")
            .registerSubtype(Multiplicacion.class, "Multiplicacion")
            .registerSubtype(Cuenta.class, "Cuenta");
		return runtimeTypeAdapterFactory;
	}
	
	private String serializarRepositorioIndicadores(){
		List<Indicador> lista = IndicadoresRepository.getInstancia().getIndicadores();
		return this.serializador().toJson(lista, this.listType());
	}
		
	
	private List<Indicador> deserializarRepositorioIndicadores(Reader reader){
		return this.serializador().fromJson(reader, this.listType());
	}
	
	public void almacenarRepositorioIndicadores() throws IOException{
		try
		{
			String texto = this.serializarRepositorioIndicadores();
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
	
	public void obtenerRepositorioIndicadores() throws IOException{
		
		Reader reader = new FileReader(ruta);
		
		List<Indicador> x = this.deserializarRepositorioIndicadores(reader);

		IndicadoresRepository.getInstancia().setIndicadores(x);
		
	}
	
	public static AlmacenadorDeIndicadores getInstancia(){
		
		if(instancia == null){
			instancia = new AlmacenadorDeIndicadores();
		}
		
		return instancia;
	}
	
	private Gson serializador(){
		return new GsonBuilder().registerTypeAdapterFactory(this.adapter()).create();
	}
	
	private Type listType(){
		return new TypeToken<List<Indicador>>(){}.getType();
	}
	
	
}
