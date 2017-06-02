package Modelo;

import java.math.BigDecimal;
import java.util.List;

public class Resta extends Operacion{
  public Resta(Expresion valorA) {
  super(valorA);
  }
  
  public Resta(Expresion valorA, Expresion valorB){
		super(valorA, valorB);
	}
    
  @Override
  public BigDecimal calcular(Query query) {
     return this.valorA.calcular(query).subtract(this.valorB.calcular(query));
  }
  
}