package Archivo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Modelo.Empresa.Cuenta;
import Modelo.Indicadores.Division;
import Modelo.Indicadores.Expresion;
import Modelo.Indicadores.Indicador;
import Modelo.Indicadores.Multiplicacion;
import Modelo.Indicadores.Numero;
import Modelo.Indicadores.Resta;
import Modelo.Indicadores.Suma;

public class AdaptadorJson {
	
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
	
	public Gson getAdaptador(){
		return new GsonBuilder().registerTypeAdapterFactory(this.adapter()).create();
	}
	
}
