package View.Metodologias;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.utils.Observable;

import Modelo.Metodologias.MetodologiaBuilder;

@Observable
public class VMAgregarBooleana {

	private String operacionElegida;
	private List<String> operaciones = new ArrayList<String>();
	private BigDecimal valorElegido;
	private MetodologiaBuilder miMetodologiaBuilder;
	
	public VMAgregarBooleana(MetodologiaBuilder _miMetodologiaBuilder){
		super();
		miMetodologiaBuilder = _miMetodologiaBuilder;
		operaciones.add("Mayor");
		operaciones.add("Menor");
	}

	public String getOperacionElegida() {
		return operacionElegida;
	}

	public void setOperacionElegida(String operacionElegida) {
		this.operacionElegida = operacionElegida;
	}

	public List<String> getOperaciones() {
		return operaciones;
	}

	public void setOperaciones(List<String> operaciones) {
		this.operaciones = operaciones;
	}

	public MetodologiaBuilder getMiMetodologiaBuilder() {
		return miMetodologiaBuilder;
	}

	public void setMiMetodologiaBuilder(MetodologiaBuilder miMetodologiaBuilder) {
		this.miMetodologiaBuilder = miMetodologiaBuilder;
	}

	public BigDecimal getValorElegido() {
		return valorElegido;
	}

	public void setValorElegido(BigDecimal valorElegido) {
		this.valorElegido = valorElegido;
	}


	
}
