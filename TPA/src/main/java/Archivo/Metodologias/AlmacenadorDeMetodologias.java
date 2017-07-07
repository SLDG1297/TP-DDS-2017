package Archivo.Metodologias;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import Archivo.Indicadores.RuntimeTypeAdapterFactory;
import Modelo.Metodologias.Metodologia;
import Modelo.Metodologias.MetodologiasRepository;
import Modelo.Metodologias.Condiciones.Booleana;
import Modelo.Metodologias.Condiciones.CasiSiempreCreciente;
import Modelo.Metodologias.Condiciones.CasiSiempreDecreciente;
import Modelo.Metodologias.Condiciones.Comportamiento;
import Modelo.Metodologias.Condiciones.Condiciones;
import Modelo.Metodologias.Condiciones.Indicador;
import Modelo.Metodologias.Condiciones.MayorAEnPeriodos;
import Modelo.Metodologias.Condiciones.Mediana;
import Modelo.Metodologias.Condiciones.MedianaMayorA;
import Modelo.Metodologias.Condiciones.MedianaMenorA;
import Modelo.Metodologias.Condiciones.MenorAEnPeriodos;
import Modelo.Metodologias.Condiciones.Promedio;
import Modelo.Metodologias.Condiciones.PromedioMayorA;
import Modelo.Metodologias.Condiciones.PromedioMenorA;
import Modelo.Metodologias.Condiciones.SiempreCreciente;
import Modelo.Metodologias.Condiciones.SiempreDecreciente;
import Modelo.Metodologias.Condiciones.Sumatoria;
import Modelo.Metodologias.Condiciones.SumatoriaMayorA;
import Modelo.Metodologias.Condiciones.SumatoriaMenorA;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

// Sabemos que estamos repitiendo código. Esta clase la dejamos como deuda técnica porque necesitamos tener cosas funcionando a tiempo.

public class AlmacenadorDeMetodologias {
	
	static AlmacenadorDeMetodologias instancia = null;
	static String ruta = "repositorioMetodologias.csv";
	
	private RuntimeTypeAdapterFactory<Condiciones> adapter(){
		RuntimeTypeAdapterFactory<Condiciones> runtimeTypeAdapterFactory = RuntimeTypeAdapterFactory
            .of(Condiciones.class, "type")
            .registerSubtype(Booleana.class, "Booleana")
            .registerSubtype(Promedio.class, "Promedio")
            .registerSubtype(Sumatoria.class, "Sumatoria")
            .registerSubtype(Mediana.class, "Mediana")
            .registerSubtype(Comportamiento.class, "Comportamiento")
            .registerSubtype(MayorAEnPeriodos.class, "MayorAEnPeriodos")
            .registerSubtype(MenorAEnPeriodos.class, "MenorAEnPeriodos")
            .registerSubtype(PromedioMayorA.class, "PromedioMayorA")
            .registerSubtype(PromedioMenorA.class, "PromedioMenorA")
            .registerSubtype(SumatoriaMayorA.class, "SumatoriaMayorA")
            .registerSubtype(SumatoriaMenorA.class, "SumatoriaMenorA")
			.registerSubtype(MedianaMayorA.class, "MedianaMayorA")
			.registerSubtype(MedianaMenorA.class, "MedianaMenorA")
			.registerSubtype(SiempreCreciente.class, "SiempreCreciente")
			.registerSubtype(CasiSiempreCreciente.class, "CasiSiempreCreciente")
			.registerSubtype(SiempreDecreciente.class, "SiempreDecreciente")
			.registerSubtype(CasiSiempreDecreciente.class, "CasiSiempreDecreciente")
			.registerSubtype(Indicador.class, "Indicador");
		
		return runtimeTypeAdapterFactory;
	}
	
	private String serializarRepositorioMetodologias(){
		List<Metodologia> lista = MetodologiasRepository.getInstancia().getListaMetodologias();
		return this.serializador().toJson(lista, this.listType());
	}
		
	
	private List<Metodologia> deserializarRepositorioMetodologias(Reader reader){
		return this.serializador().fromJson(reader, this.listType());
	}
	
	public void almacenarRepositorioMetodologias() throws IOException{
		try
		{
			String texto = this.serializarRepositorioMetodologias();
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
	
	public void obtenerRepositorioMetodologias() throws IOException{
		
		Reader reader = new FileReader(ruta);
		
		List<Metodologia> x = this.deserializarRepositorioMetodologias(reader);

		MetodologiasRepository.getInstancia().setListaMetodologias(x);
		
	}
	
	public static AlmacenadorDeMetodologias getInstancia(){
		
		if(instancia == null){
			instancia = new AlmacenadorDeMetodologias();
		}
		
		return instancia;
	}
	
	private Gson serializador(){
		return new GsonBuilder().registerTypeAdapterFactory(this.adapter()).create();
	}
	
	private Type listType(){
		return new TypeToken<List<Metodologia>>(){}.getType();
	}
	
	
}
