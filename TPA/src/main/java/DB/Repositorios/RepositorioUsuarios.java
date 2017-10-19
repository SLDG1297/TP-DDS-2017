package DB.Repositorios;

import DB.NombreRepositorio;
import DB.Repositorio;
import Modelo.Usuarios.Usuario;

public class RepositorioUsuarios extends Repositorio<Usuario> {
    private static RepositorioUsuarios ourInstance = new RepositorioUsuarios(NombreRepositorio.USUARIO);

    public RepositorioUsuarios(NombreRepositorio nombreTabla) {
        super(nombreTabla);
    }

    public static RepositorioUsuarios getInstancia() {
        return ourInstance;
    }

}
