package DB.Repositorios;

import static DB.NombreRepositorio.*;

import DB.NombreRepositorio;
import DB.Repositorio;
import Modelo.Indicadores.Indicador;

public class RepositorioIndicadores extends Repositorio<Indicador> {
	private static RepositorioIndicadores instancia = null;
	
	public RepositorioIndicadores(NombreRepositorio nombreTabla) {
		super(nombreTabla);
	}
	
	public static RepositorioIndicadores getInstancia() {
		if(instancia == null) instancia = new RepositorioIndicadores(INDICADOR);
		
		return instancia;
	}
}
