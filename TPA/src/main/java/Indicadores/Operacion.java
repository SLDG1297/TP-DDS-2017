package Indicadores;

import java.util.List;
import com.ibm.icu.math.BigDecimal;

import Modelo.Cuenta;

public interface Operacion {
	public BigDecimal aplicar(List <Cuenta> cuentas);
}
