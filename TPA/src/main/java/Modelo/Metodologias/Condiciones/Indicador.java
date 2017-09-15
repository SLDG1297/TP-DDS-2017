package Modelo.Metodologias.Condiciones;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import DB.Repositorios.RepositorioIndicadores;
import Modelo.Empresa.Deserializa;
import Modelo.Empresa.Empresa;

@Entity
@DiscriminatorValue("indicador")
public class Indicador extends Condiciones implements Deserializa{

	@OneToOne
	private Modelo.Indicadores.Indicador indicador;

	public Indicador(Modelo.Indicadores.Indicador indicador) {
		this.indicador = indicador;
	}

	@Override
	public boolean cumple(Empresa empresa) {
		return RepositorioIndicadores.getInstancia().buscarListaDeObjetos().contains(indicador);
	}
	
	@Override
	public String mostrarCadena() {
		return "El indicador " + indicador.getNombre() + "";
	}
}
