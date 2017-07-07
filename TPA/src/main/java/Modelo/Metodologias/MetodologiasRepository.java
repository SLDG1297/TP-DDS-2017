package Modelo.Metodologias;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Modelo.Indicadores.IndicadoresRepository;
import Modelo.Metodologias.Condiciones.MayorAEnPeriodos;

public class MetodologiasRepository {
	
	private static MetodologiasRepository instancia = null;

	private List<Metodologia> listaMetodologias = new ArrayList<Metodologia>();

	
	public static MetodologiasRepository getInstancia() {
		if (instancia == null) {
			instancia = new MetodologiasRepository();
			instancia.agregarMetodologia(new Metodologia("PRUEBA_MayorAEnPeriodos", new MayorAEnPeriodos(IndicadoresRepository.getInstancia().getIndicadores().get(0), new BigDecimal(1), 1)));
		}
		return instancia;
	}

	public List<Metodologia> getListaMetodologias() {
		return listaMetodologias;
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
		return listaMetodologias.stream().filter(metodologia -> metodologia.getNombre() == nombreDeMetodologia).collect(Collectors.toList()).get(0); // Medio leproso. No me funca el findFirst
	}
	
	public List<String> nombresDeMetodologias() {
		return listaMetodologias.stream().map(miMetodologia -> miMetodologia.getNombre()).collect(Collectors.toList());
	}
	
	
}
