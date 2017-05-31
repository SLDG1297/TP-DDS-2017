package Modelo;

import java.math.BigDecimal;
import java.util.List;

public class Suma extends Operacion{
    Operacion valorA, valorB;
    
  public Suma(Operacion valorA) {
    super(valorA);
  }
    
  @Override
  public BigDecimal calcular(Query query) {
     return this.valorA.calcular(query).add(this.valorB.calcular(query));
  }
  
}
