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
public class VMAgregarPromedioSumatoriaMediana {

	private String operacionElegida;
	private List<String> operaciones = new ArrayList<String>();
	private String comparadorElegido;
	private List<String> comparadores = new ArrayList<String>();
	private BigDecimal valorElegido;
	private MetodologiaBuilder miMetodologiaBuilder;
	
	public VMAgregarPromedioSumatoriaMediana(MetodologiaBuilder _miMetodologiaBuilder){
		super();
		miMetodologiaBuilder = _miMetodologiaBuilder;
		operaciones.add("Promedio");
		operaciones.add("Sumatoria");
		operaciones.add("Mediana");
		comparadores.add("Mayor");
		comparadores.add("Menor");
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


	public String getComparadorElegido() {
		return comparadorElegido;
	}


	public void setComparadorElegido(String comparadorElegido) {
		this.comparadorElegido = comparadorElegido;
	}


	public List<String> getComparadores() {
		return comparadores;
	}


	public void setComparadores(List<String> comparadores) {
		this.comparadores = comparadores;
	}


	public BigDecimal getValorElegido() {
		return valorElegido;
	}


	public void setValorElegido(BigDecimal valorElegido) {
		this.valorElegido = valorElegido;
	}


	public MetodologiaBuilder getMiMetodologiaBuilder() {
		return miMetodologiaBuilder;
	}


	public void setMiMetodologiaBuilder(MetodologiaBuilder miMetodologiaBuilder) {
		this.miMetodologiaBuilder = miMetodologiaBuilder;
	}


	public void crearCondicion(){
    	
     	Indicador indicadorSeleccionado = miMetodologiaBuilder.getIndicadorSeleccionado();
    	Condicion nuevaCondicion;
    	
    	switch(operacionElegida) {
    	
    	case "Promedio":
    		if(comparadorElegido.equals("Mayor")) {
    		nuevaCondicion = new CondicionFactory().crearPromedioMayorA(indicadorSeleccionado, valorElegido);
    		}
    		else{
        		nuevaCondicion = new CondicionFactory().crearPromedioMenorA(indicadorSeleccionado, valorElegido);
        	}
    		break;
    		
    	case "Sumatoria":
    		
    		if(comparadorElegido.equals("Mayor")){
        		nuevaCondicion = new CondicionFactory().crearSumatoriaMayorA(indicadorSeleccionado, valorElegido);
        	}
        	else{
        		nuevaCondicion = new CondicionFactory().crearSumatoriaMenorA(indicadorSeleccionado, valorElegido);
        	}
    		break;
    		
    	default: //El caso en el que sea una mediana
    		
    		if(comparadorElegido.equals("Mayor")){
        		nuevaCondicion = new CondicionFactory().crearMedianaMayorA(indicadorSeleccionado, valorElegido);
        	}
        	else{
        		nuevaCondicion = new CondicionFactory().crearMedianaMenorA(indicadorSeleccionado, valorElegido);
        	}
    		break;
    		
    	}
    	miMetodologiaBuilder.agregarCondicion(nuevaCondicion);
    }

	public Metodologia crearMetodologia() {
		return miMetodologiaBuilder.crearMetodologia();
	}
}
