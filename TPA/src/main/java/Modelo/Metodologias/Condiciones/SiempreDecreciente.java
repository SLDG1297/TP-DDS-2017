package Modelo.Metodologias.Condiciones;

import java.math.BigDecimal;
import java.util.List;
import Modelo.Indicadores.Indicador;
import Modelo.Metodologias.Try;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SIEMPRE_DECRECIENTE")
public class SiempreDecreciente extends Comportamiento {

	@Id
	@GeneratedValue
	private long id_siempre_decreciente;

	public SiempreDecreciente(Indicador indicador, int anios) {
		super(indicador, anios);
	}

	public SiempreDecreciente() {
	}

	@Override
	protected boolean satisface(List<Boolean> comportamiento) {
		
		return comportamiento.stream().allMatch(bool -> bool);
	}

	@Override
	protected boolean comparacion(Try<BigDecimal> try1, Try<BigDecimal> try2) {
		
		return this.esMayor(try1, try2);
	}

	@Override
	public String mostrarCadena() {
		return "El indicador " + indicador.getNombre() + " es siempre decreciente en " + String.valueOf(anios) + " a�os";
	}
	
}
