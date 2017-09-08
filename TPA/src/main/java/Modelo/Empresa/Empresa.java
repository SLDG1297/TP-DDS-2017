package Modelo.Empresa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.uqbar.commons.utils.Observable;
import Excepciones.Empresas.EmpresaSinNombreException;
import Excepciones.Empresas.EmpresaSinPeriodoException;
import Excepciones.Empresas.NoExisteElPeriodoException;

@Entity
@Observable
public class Empresa {
	
	@Id
	@Column(name = "Nombre")
	private String nombre;
	
	@OneToMany
	@JoinColumn(name = "Nombre_empresa", referencedColumnName = "Nombre")
	private List<Periodo> periodos = new ArrayList<Periodo>();
	
	@SuppressWarnings("unused")
	private Empresa(){};
	
	// Esto solo lo usa el Parser para crear la empresa rápidamente
	public Empresa(String nombre, String nombreCuenta, String anio, String valor) {
		 this.setNombre(nombre);	
		 periodos.add(new Periodo(Integer.parseInt(anio), new Cuenta(nombreCuenta, Integer.parseInt(valor))));
		 }
	
	public Empresa(String nuevoNombre, List<Periodo> nuevosPeriodos) {
		this.setNombre(nuevoNombre);
		this.setPeriodos(nuevosPeriodos);
	}

	public Empresa(String nuevoNombre, Periodo nuevoPeriodo) { // Agregar un periodo
		this.setNombre(nuevoNombre);
		periodos.add(nuevoPeriodo);
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre == "") throw new EmpresaSinNombreException();
		this.nombre = nombre;
	}

	public List<Periodo> getPeriodos() {
		return periodos;
	}

	public void setPeriodos(List<Periodo> periodos) {
		if(periodos.size() == 0) throw new EmpresaSinPeriodoException();
		this.periodos = periodos;
	}
	
	public List<Integer> obtenerAniosDeTodosLosPeriodos(){
		List<Integer> periodosEmpresa = this.getPeriodos().stream().map(p -> p.getAnio()).collect(Collectors.toList());
		return periodosEmpresa;
	}
	
	public Periodo buscarPeriodo(Integer periodo){
	    return this.periodos.stream().filter(p -> p.getAnio().equals(periodo)).findFirst().orElseThrow(()-> new NoExisteElPeriodoException());
    }

}

