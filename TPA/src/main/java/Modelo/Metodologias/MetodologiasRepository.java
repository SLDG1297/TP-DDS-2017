package Modelo.Metodologias;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Modelo.Indicadores.IndicadoresRepository;
import Modelo.Metodologias.Condiciones.MayorAEnPeriodos;
import Modelo.Metodologias.Condiciones.MenorAEnPeriodos;
import Modelo.Metodologias.Condiciones.PromedioMayorA;
import Modelo.Metodologias.Condiciones.SiempreCreciente;
import Modelo.Metodologias.Condiciones.SumatoriaMenorA;
import Excepciones.Metodologias.NoExisteLaMetodologiaException;



public class MetodologiasRepository {

	private static MetodologiasRepository instancia = null;

	private List<Metodologia> listaMetodologias = new ArrayList<Metodologia>();

	public static MetodologiasRepository getInstancia() {
		if (instancia == null) {
			instancia = new MetodologiasRepository();

			instancia.agregarMetodologia(new Metodologia("MayorA_500_En1_Periodo", new MayorAEnPeriodos(IndicadoresRepository.getInstancia().getIndicadores().get(0), new BigDecimal(500), 1)));
			instancia.agregarMetodologia(new Metodologia("MayorA_20_En1_Periodo", new MayorAEnPeriodos(IndicadoresRepository.getInstancia().getIndicadores().get(0), new BigDecimal(20), 1)));
			instancia.agregarMetodologia(new Metodologia("MayorA_500_En3Periodo_Cuenta", new MayorAEnPeriodos(IndicadoresRepository.getInstancia().getIndicadores().get(4), new BigDecimal(500), 3)));
			instancia.agregarMetodologia(new Metodologia("MenorA_500_En4Periodo_Cuenta", new MenorAEnPeriodos(IndicadoresRepository.getInstancia().getIndicadores().get(4), new BigDecimal(500), 4)));
			instancia.agregarMetodologia(new Metodologia("PromedioMayorA_750_Cuenta", new PromedioMayorA(IndicadoresRepository.getInstancia().getIndicadores().get(4), new BigDecimal(750))));
			instancia.agregarMetodologia(new Metodologia("SumatoriaMenorA_2000_Cuenta", new SumatoriaMenorA(IndicadoresRepository.getInstancia().getIndicadores().get(4), new BigDecimal(2000))));
			instancia.agregarMetodologia(new Metodologia("SiempreCreciente_En5Periodos_Cuenta", new SiempreCreciente(IndicadoresRepository.getInstancia().getIndicadores().get(4), 5)));


		}
		return instancia;
	}

	public List<Metodologia> getListaMetodologias() {
		return listaMetodologias;
	}
	
	public void setListaMetodologias(List<Metodologia> listaMetodologias) {
		this.listaMetodologias = listaMetodologias;
	}
	
	public void agregarMetodologia(Metodologia metodologia) {
		listaMetodologias.add(metodologia);
	}
	
	public void removerMetodologia(Metodologia metodologia) {
		listaMetodologias.remove(metodologia);
	}
	
	public void removerMetodologia(String metodologia) {
		this.removerMetodologia(this.obtenerMetodologia(metodologia));
	}
	
	public Metodologia obtenerMetodologia(String nombreDeMetodologia) {
		try{
			Metodologia metodologiaBuscada= instancia.getListaMetodologias().stream().filter( m -> m.getNombre().equals(nombreDeMetodologia)).findFirst().get();
			return metodologiaBuscada;
		} catch(RuntimeException e){
			throw new NoExisteLaMetodologiaException();
		}
	}
	
	public List<String> nombresDeMetodologias() {
		return listaMetodologias.stream().map(miMetodologia -> miMetodologia.getNombre()).collect(Collectors.toList());
	}
}
