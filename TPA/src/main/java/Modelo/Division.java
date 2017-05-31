package Modelo;

import java.math.BigDecimal;
import java.util.List;

public class Division extends Operacion{
    Operacion valorA, valorB;
    
  public Division(Operacion valorA) {
    super(valorA);
  }
    
  @Override
  public BigDecimal calcular(Query query) {
     return this.valorA.calcular(query).divide(this.valorB.calcular(query));
  }
  
}
