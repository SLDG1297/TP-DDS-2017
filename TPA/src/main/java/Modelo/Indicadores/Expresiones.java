package Modelo.Indicadores;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;



@Entity
@Table(name = "expresion")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Expresiones implements Expresion {
	
	@Id
	@GeneratedValue
	@Column(name = "expresion_id")
	private long id;
	
	public Expresiones(){};
	
	public long getId(){
		
		return id;
	}

}
