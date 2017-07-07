package Modelo.Metodologias;

import java.util.ArrayList;
import java.util.List;

public class MetodologiasRepository {

	private static MetodologiasRepository instancia = null;

	private List<Metodologia> listaMetodologias = new ArrayList<Metodologia>();

	public static MetodologiasRepository getInstancia() {
		if (instancia == null) {
			instancia = new MetodologiasRepository();
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

}
