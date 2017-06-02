package Modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IndicadoresRepository {
	
	private static IndicadoresRepository instancia = null;
	
	
	//Indicadores predefinidos
/*
	///Indicador1 = EDITBA + 4.5
	Indicador indicador1 = new Indicador("Indicador1",new Suma(new Cuenta("EDITBA"),new Numero(new BigDecimal(4.5))));
    //Indicador2 = Free Cash Flow / 3 - EDITBA
	Indicador indicador2 = new Indicador("Indicador2",new Resta(new Division(new Cuenta("Free Cash Flow"),new Numero(new BigDecimal(3))),new Cuenta("EDITBA")));
	//Indicador3 = Indicador1 * Indicador2
	Indicador indicador3 = new Indicador("Indicador3",new Multiplicacion(indicador1,indicador2));
	*/
	
	private List<Indicador> indicadores = new ArrayList<Indicador>();
	
	//private List<Indicador> indicadores = Arrays.asList(indicador1, indicador2, indicador3);
	
	public List<Indicador> getIndicadores() {
		return indicadores;
	}
	
	public Indicador getIndicador(String nombre){
		return indicadores.stream().filter(i -> i.getNombre().equals(nombre)).findFirst().get();
	}
	
	public void agregarIndicador(Indicador indicador){
		indicadores.add(indicador);
	}

	public static IndicadoresRepository getInstancia() {
		
		if(instancia == null) {
			instancia = new IndicadoresRepository();
		}
		
		return instancia;
	}
}
