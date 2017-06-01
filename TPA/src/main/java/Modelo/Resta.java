package Modelo;

import java.math.BigDecimal;
import java.util.List;

public class Resta extends Operacion{
	Expresion valorA, valorB;
    
  public Resta(Expresion valorA) {
  super(valorA);
  }
    
  @Override
  public BigDecimal calcular(Query query) {
     return this.valorA.calcular(query).subtract(this.valorB.calcular(query));
  }
  
}