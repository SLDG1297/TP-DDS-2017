package Modelo.Indicadores;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;



@Entity(name = "Expresion")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Expresiones implements Expresion {
	
	@Id
	@GeneratedValue
	@Column(name = "Expresion_Id")
	private long id;
	
	public Expresiones(){};

}
