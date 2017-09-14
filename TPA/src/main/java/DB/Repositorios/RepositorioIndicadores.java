package DB.Repositorios;

import DB.Repositorio;
import Modelo.Indicadores.Indicador;

public class RepositorioIndicadores extends Repositorio<Indicador> {
	public static RepositorioIndicadores instancia = null;
	
	@Override
	public String getTipo() {
		return Indicador.class.getSimpleName();
	}

	public static RepositorioIndicadores getInstancia() {
		if(instancia == null) instancia = new RepositorioIndicadores();
		
		return instancia;
	}
}
