package View.Metodologias;

import org.uqbar.commons.utils.Observable;

import Modelo.Metodologias.MetodologiaBuilder;

@Observable
public class VMMasCondiciones {

	private MetodologiaBuilder miMetodologiaBuilder;
	
	public VMMasCondiciones(MetodologiaBuilder _MiMetodologiaBuilder){
		super();
		miMetodologiaBuilder = _MiMetodologiaBuilder;
	}
	
}
