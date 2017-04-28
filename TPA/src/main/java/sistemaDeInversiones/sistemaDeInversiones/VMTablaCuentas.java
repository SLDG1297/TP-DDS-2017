package sistemaDeInversiones;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.uqbar.commons.utils.Observable;

@Observable
public class VMTablaCuentas {
	
	VMBolsaComercial miBolsa;
	
	VMTablaCuentas(VMBolsaComercial miNuevaBolsa) {
		miBolsa = miNuevaBolsa;
	}

	private List<Cuenta> listaDeCuentas = this.buscarCuentas(); //Representaria la lista de obejtos cuenta de una empresa
	
	private String nombre = this.nombresDeCuentas().get(0); //Representaria el nombre de SOLO UNA cuenta
	
	private Integer valor = this.valoresDeCuentas().get(0); //Representaria el valor de SOLO UNA cuenta
	
	//Retorna la lista de objetos cuentas de la empresa de la vista anterior
	public List<Cuenta> buscarCuentas() {
		List<Cuenta> cuentas = new ArrayList<Cuenta>();
		cuentas = miBolsa.buscarEmpresa(miBolsa.getNombreEmpresa()).getCuentas();
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
