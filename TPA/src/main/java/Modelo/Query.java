package Modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Query {

	private List<Cuenta> cuentas = new ArrayList<Cuenta>();
	
	public Query(Empresa empresa, Periodo periodo){
	cuentas = empresa.obtenerCuentasEnPeriodo(periodo.getAnio());
	}
	
	public BigDecimal obtenerValorCuenta(String nombreCuenta){
	Cuenta cuenta = cuentas.stream().filter(c -> c.getNombre().equals(nombreCuenta)).collect(Collectors.toList()).get(0);
	return new BigDecimal(cuenta.getValor().toString());
	}
	
}
