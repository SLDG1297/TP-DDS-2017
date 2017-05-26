package Modelo;

import java.math.BigDecimal;
import java.util.List;

public class Suma implements Operacion{
    Operacion valorA, valorB;
    public Suma(Operacion valorA, Operacion valorB) {
    this.valorA = valorA;
    this.valorB = valorB;
  }
  public BigDecimal aplicar(List <Cuenta> cuentas) {
     return this.valorA.aplicar(cuentas).add(this.valorB.aplicar(cuentas));
  }
}
