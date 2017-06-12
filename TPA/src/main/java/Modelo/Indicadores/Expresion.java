package Modelo.Indicadores;

import java.math.BigDecimal;

public interface Expresion {

	public BigDecimal calcular(Query query);

}
