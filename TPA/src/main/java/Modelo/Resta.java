package Modelo;

import java.math.BigDecimal;
import java.util.List;

public class Resta implements Operacion{
	  Operacion valorA, valorB;
	    public Resta(Operacion valorA, Operacion valorB) {
	    this.valorA = valorA;
	    this.valorB = valorB;
	  }
	  public BigDecimal aplicar(List <Cuenta> cuentas) {
	     return this.valorA.aplicar(cuentas).subtract(this.valorB.aplicar(cuentas));
	  }
}
