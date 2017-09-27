package DB.Repositorios;

import static DB.NombreRepositorio.*;

import DB.NombreRepositorio;
import DB.Repositorio;
import Modelo.Metodologias.Metodologia;

public class RepositorioMetodologias extends Repositorio<Metodologia> {
	private static RepositorioMetodologias instancia = null;
    
    private RepositorioMetodologias(NombreRepositorio nombreTabla) {
		super(nombreTabla);
	}
	
    public static RepositorioMetodologias getInstancia() {
    	if(instancia == null) instancia = new RepositorioMetodologias(METODOLOGIA);
    	
        return instancia;
    }

}
