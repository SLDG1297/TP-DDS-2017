package Modelo;

import java.math.BigDecimal;
import java.util.List;

public class Multiplicacion extends Operacion{
    Operacion valorA, valorB;
    
  public Multiplicacion(Operacion valorA) {
  super(valorA);
  }
    
  @Override
  public BigDecimal calcular(Query query) {
     return this.valorA.calcular(query).multiply(this.valorB.calcular(query));
  }
  
}