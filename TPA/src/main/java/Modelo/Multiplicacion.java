package Modelo;

import java.math.BigDecimal;
import java.util.List;

public class Multiplicacion extends Operacion{
  public Multiplicacion(Expresion valorA) {
  super(valorA);
  }
    
  @Override
  public BigDecimal calcular(Query query) {
     return this.valorA.calcular(query).multiply(this.valorB.calcular(query));
  }
  
}