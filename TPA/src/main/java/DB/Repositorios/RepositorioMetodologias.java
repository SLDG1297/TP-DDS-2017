package DB.Repositorios;

import DB.Repositorio;
import Modelo.Metodologias.Metodologia;

public class RepositorioMetodologias extends Repositorio<Metodologia> {
    private static RepositorioMetodologias ourInstance = new RepositorioMetodologias();

    public static RepositorioMetodologias getInstancia() {
        return ourInstance;
    }

    private RepositorioMetodologias() {
    }

    @Override
    public String getTipo() {
        return Metodologia.class.getSimpleName();
    }

}
