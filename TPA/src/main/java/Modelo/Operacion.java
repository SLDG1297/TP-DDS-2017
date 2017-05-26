package Modelo;

import java.math.BigDecimal;
import java.util.List;

import Modelo.Cuenta;

public interface Operacion {
	public BigDecimal aplicar(List <Cuenta> cuentas);
}
