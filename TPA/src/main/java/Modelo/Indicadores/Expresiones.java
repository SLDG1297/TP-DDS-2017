package Modelo.Indicadores;

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
	private long id;
	
	public Expresiones(){};

}
