package Modelo.Empresa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import org.uqbar.commons.utils.Observable;
import Excepciones.Empresas.CuentaConValorNegativoException;
import Excepciones.Empresas.CuentaSinNombreException;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Observable
@Table(name = "cuenta")

public class Cuenta {
	
	@Id
	@GeneratedValue
	@Column(name = "cuenta_id")
	private Long Id;
	
	@Column(name = "cuenta_nombre")
	String nombre;
	@Column(name = "cuenta_valor")
	Integer valor;
	
	@SuppressWarnings("unused")
	private Cuenta(){};

	public Cuenta(String nombre, Integer nuevoValor) {
		this.setNombre(nombre);
		this.setValor(nuevoValor);
	}

	public Cuenta(String nuevoNombre) {
		this.setNombre(nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if(nombre == "") throw new CuentaSinNombreException();
		this.nombre = nombre;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		if(valor < 0) throw new CuentaConValorNegativoException();
		this.valor = valor;
	}


}
