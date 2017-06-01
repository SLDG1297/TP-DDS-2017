package Modelo;

import java.math.BigDecimal;
import java.util.List;

import Modelo.Cuenta;

public abstract class Expresion {

	
	public abstract BigDecimal calcular(Query query);
	
	
}
