package Modelo.Metodologias.Condiciones;

import Modelo.Empresa.Empresa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CONDICIONES")
public abstract class Condiciones {

	@Id
	@GeneratedValue
	private long id_condiciones;

	public abstract boolean cumple(Empresa empresa);
	
	public abstract String mostrarCadena();
		
}
