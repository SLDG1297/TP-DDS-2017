package View.Metodologias;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.uqbar.commons.utils.Observable;
import Modelo.Indicadores.Indicador;
import Modelo.Metodologias.Metodologia;
import Modelo.Metodologias.MetodologiaBuilder;
import Modelo.Metodologias.Condiciones.Condicion;
import Modelo.Metodologias.Condiciones.CondicionFactory;

@Observable
public class VMAgregarBooleana {

	private String operacionElegida;
	private List<String> operaciones = new ArrayList<String>();
	private BigDecimal valorElegido;
	private Integer periodoElegido;
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

	public Integer getPeriodoElegido() {
		return periodoElegido;
	}

	public void setPeriodoElegido(Integer periodoElegido) {
		this.periodoElegido = periodoElegido;
	}
	
    public void crearCondicion(){
    	Indicador indicadorSeleccionado = miMetodologiaBuilder.getIndicadorSeleccionado();
    	Condicion nuevaCondicion;
    	if(operacionElegida.equals("Mayor")){
    		nuevaCondicion = new CondicionFactory().crearMayorAEnPeriodos(indicadorSeleccionado, valorElegido, periodoElegido);
    	}
    	else{
    		nuevaCondicion = new CondicionFactory().crearMenorAEnPeriodos(indicadorSeleccionado, valorElegido, periodoElegido);
    	}
    	miMetodologiaBuilder.agregarCondicion(nuevaCondicion);
    }

	public Metodologia crearMetodologia() {
		return miMetodologiaBuilder.crearMetodologia();
	}
	
}
