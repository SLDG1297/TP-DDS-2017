package Modelo.Metodologias.Condiciones;

import java.math.BigDecimal;
import java.util.List;

import Modelo.Empresa.Empresa;
import Modelo.Indicadores.Indicador;
import Modelo.Metodologias.Try;
import Modelo.Metodologias.Condiciones.Condicion;

public abstract class Promedio extends Condicion {
	
		protected BigDecimal valor;
	
		public Promedio(Indicador indicador, BigDecimal valor) {
			super(indicador);
			this.valor = valor;
		}
		
		public boolean fin(List<Try<BigDecimal>> success){
			 Double promedio = this.sum(success) // Suma la lista, no puedo usar sum()
					 			/ empresa.getPeriodos().size(); // Obtiene el promedio
			 return new BigDecimal(promedio).compareTo(valor) == this.booleano() || new BigDecimal(promedio).compareTo(valor) == 0; //Comparacion de BigDecimal
		}
	
}
