package Modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Exepciones.NombreCuentaErroneoException;

public class Query {

	private List<Cuenta> cuentas = new ArrayList<Cuenta>();
	
	public Query(Empresa empresa, Periodo periodo){
	cuentas = empresa.obtenerCuentasEnPeriodo(periodo.getAnio());
	}
	
	public BigDecimal obtenerValorCuenta(String nombreCuenta){
		Cuenta cuenta = this.buscarCuenta(nombreCuenta);
		return new BigDecimal(cuenta.getValor().toString());
	}
	
	public Cuenta buscarCuenta(String nombreCuenta){
		List<Cuenta> cuentaEncontrada = cuentas.stream().filter(c -> c.getNombre().equals(nombreCuenta)).collect(Collectors.toList());
		if(cuentaEncontrada.size() == 0)
			throw new NombreCuentaErroneoException();
		else
			return cuentaEncontrada.get(0);
	}
}
