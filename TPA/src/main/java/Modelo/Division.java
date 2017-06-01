package Modelo;

import java.math.BigDecimal;
import java.util.List;

public class Division extends Operacion{
	Expresion valorA, valorB;
    
  public Division(Expresion valorA) {
    super(valorA);
  }
    
  @Override
  public BigDecimal calcular(Query query) {
     return this.valorA.calcular(query).divide(this.valorB.calcular(query));
  }
  
}
