package Modelo;

import java.math.BigDecimal;
import java.util.List;

import Modelo.Cuenta;

public interface Expresion {
	
	public BigDecimal calcular(Query query);
	
}
