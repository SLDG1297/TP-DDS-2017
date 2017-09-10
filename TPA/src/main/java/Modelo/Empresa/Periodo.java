package Modelo.Empresa;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import Excepciones.Indicadores.NoTieneLaCuentaException;
import Excepciones.Empresas.PeriodoSinCuentasException;
import Excepciones.Empresas.YaExisteLaCuentaException;
import Modelo.Empresa.Cuenta;

@Entity
public class Periodo {
	
	@Id
	@GeneratedValue
	@Column(name = "Periodo_Id")
	private long id;
	
	@Column(name = "Anio")
	Integer anio;
	
	@OneToMany
	@JoinColumn(name = "Id_Periodo", referencedColumnName = "Periodo_Id")
	List<Cuenta> cuentas = new ArrayList<Cuenta>();
	
	@SuppressWarnings("unused")
	private Periodo(){};
	
	public Periodo(Integer nuevoAnio, List<Cuenta> nuevasCuentas) {
		this.setAnio(nuevoAnio);
		this.setCuentas(nuevasCuentas);
	}
	
	// Esto solo lo usa el Parser para crear la empresa rápidamente
	public Periodo(Integer nuevoAnio, Cuenta nuevaCuenta) {
		this.setAnio(nuevoAnio);
		cuentas.add(nuevaCuenta);
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		if(cuentas.size() == 0) throw new PeriodoSinCuentasException();
		this.cuentas = cuentas;
	}
	
	public void agregarCuenta(Cuenta miCuenta) {
		if(this.cuentas.contains(miCuenta)) throw new YaExisteLaCuentaException();
		
		this.cuentas.add(miCuenta);
	}
	
	public boolean estaEntre(int anios, List<Periodo> lista, Periodo periodo){
		if(lista.size() > anios){
			return lista.subList(lista.size()-1-anios, lista.size()-1).contains(periodo);
		}
		else if(lista.size() == anios){
			return lista.contains(periodo);
		}
		else{
			return false;
		}
	}
	
	public Cuenta buscarCuenta(String nombreCuenta){
	     return this.cuentas.stream().filter(c -> c.getNombre().equals(nombreCuenta)).findFirst().orElseThrow(()-> new NoTieneLaCuentaException());
	}
}
