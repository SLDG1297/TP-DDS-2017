package sistemaDeInversiones;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.uqbar.commons.utils.Observable;

@Observable
public class VMTablaCuentas {
	
	VMBolsaComercial miBolsaComercial;
	
	VMTablaCuentas(VMBolsaComercial mi_Bolsa_Comercial) {
		miBolsaComercial = mi_Bolsa_Comercial;
		miBolsaComercial.buscarEmpresa();
		listaDeCuentas = this.buscarCuentas();
	}

	private List<Cuenta> listaDeCuentas; //Representaria la lista de objetos cuenta de una empresa
	
	public VMBolsaComercial getMiBolsaComercial() {
		return miBolsaComercial;
	}

	public void setMiBolsaComercial(VMBolsaComercial miBolsaComercial) {
		this.miBolsaComercial = miBolsaComercial;
	}

	public List<Cuenta> getListaDeCuentas() {
		return listaDeCuentas;
	}

	public void setListaDeCuentas(List<Cuenta> listaDeCuentas) {
		this.listaDeCuentas = listaDeCuentas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	private String nombre = this.nombresDeCuentas().get(0); //Representaria el nombre de SOLO UNA cuenta
	
	private Integer valor = this.valoresDeCuentas().get(0); //Representaria el valor de SOLO UNA cuenta
	
	//Retorna la lista de objetos cuentas de la empresa de la vista anterior
	public List<Cuenta> buscarCuentas() {
		List<Cuenta> cuentas = new ArrayList<Cuenta>();
		Empresa e = miBolsaComercial.getEmpresa();
		cuentas = e.getCuentas();
		return cuentas;
	}

	//Retorna una lista de nombres, de la lista de objetos cuentas
	public List<String> nombresDeCuentas() {
		List<String> nombres = this.buscarCuentas().stream().map((Cuenta e) -> e.getNombre()).collect(Collectors.toList());
		return nombres;
	}

	//Retorna una lista de valores, de la lista de objetos cuentas	
	public List<Integer> valoresDeCuentas() {
		List<Integer> valores = this.buscarCuentas().stream().map((Cuenta e) -> e.getValor()).collect(Collectors.toList());
		return valores;
	}
	
}
