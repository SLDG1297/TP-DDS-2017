package Archivo.CargaBatch;

import java.util.Arrays;

import Archivo.CargaBatch.Excepciones.NoSePuedeModificarException;
import Modelo.Empresa.Cuenta;
import Modelo.Empresa.Empresa;
import Modelo.Empresa.Periodo;
import Modelo.Excepciones.Empresas.NoExisteElPeriodoException;
import Modelo.Excepciones.Indicadores.NoTieneLaCuentaException;

public class RenglonCSV {
	private Empresa empresa;
	private Periodo periodo;
	private Cuenta cuenta;
	private Integer valor;
	
	public RenglonCSV(String nombreEmpresa, String nombreCuenta, String numeroPeriodo, String numeroValor)
	{
		this.valor = Integer.parseInt(numeroValor);
		this.cuenta = new Cuenta(nombreCuenta, this.valor);
		this.periodo = new Periodo(Integer.parseInt(numeroPeriodo), Arrays.asList(this.cuenta));
		this.empresa = new Empresa(nombreEmpresa, Arrays.asList(this.periodo));
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}
	
	public void actualizar(Empresa empresaVieja) {
		if (!quiereModificarEmpresa(empresaVieja)) throw new NoSePuedeModificarException();
		
		else if (!quiereModificarPeriodo(empresaVieja)) empresaVieja.getPeriodos().add(this.getPeriodo());
		
		else if (!quiereModificarCuenta(empresaVieja)) empresaVieja.buscarPeriodo(this.getPeriodo().getAnio()).agregarCuenta(this.getCuenta());
		
		else empresaVieja.buscarPeriodo(this.getPeriodo().getAnio()).buscarCuenta(this.getCuenta().getNombre()).setValor(this.getCuenta().getValor());
	}

	public Boolean quiereModificarEmpresa(Empresa unaEmpresa) {
		return unaEmpresa.getNombre().equals(this.getEmpresa().getNombre());
	}
	
	public Boolean quiereModificarPeriodo(Empresa unaEmpresa) {
		try
		{
			return this.quiereModificarEmpresa(unaEmpresa) && unaEmpresa.buscarPeriodo(this.getPeriodo().getAnio()).getAnio().equals(this.getPeriodo().getAnio());
		}
		catch(NoExisteElPeriodoException excepcion)
		{
			return false;
		}
	}
	
	public Boolean quiereModificarCuenta(Empresa unaEmpresa) {
		try
		{
			return this.quiereModificarPeriodo(unaEmpresa) && unaEmpresa.buscarPeriodo(this.getPeriodo().getAnio()).buscarCuenta(this.getCuenta().getNombre()).getNombre().equals(this.getCuenta().getNombre());
		}
		catch(NoTieneLaCuentaException exception)
		{
			return false;
		}
	}
}
