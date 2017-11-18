package DB.Repositorios;

import DB.TiposDeRepositorios.NombreRepositorio;
import Modelo.Indicadores.Precalculado;

import static DB.TiposDeRepositorios.NombreRepositorio.PRECALCULADO;

public class RepositorioPrecalculados extends Repositorio<Precalculado> {
    private static RepositorioPrecalculados instancia = null;

    private RepositorioPrecalculados(NombreRepositorio nombreTabla) {
        super(nombreTabla);
    }

    public static RepositorioPrecalculados getInstancia() {
        if(instancia == null) instancia = new RepositorioPrecalculados(PRECALCULADO);

        return instancia;
    }

}
