package Controllers;

import DB.Repositorios.RepositorioIndicadores;
import Modelo.Indicadores.GestorDeDestruccionDeIndicadores;
import Modelo.Usuarios.GestorDeUsuarios;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.Map;

public class IndicadoresDestruccionController {

    public ModelAndView show(Request request, Response response) {

        Map<Object, Object> mapa = GestorDeUsuarios.getInstance().obtenerMapa(request);

        mapa.put("indicadores", RepositorioIndicadores.getInstancia().buscarListaDeObjetos());

        return new ModelAndView(mapa, "indicadoresDestruccion.hbs");

    }

    public Void destruir(Request request, Response response) {

        String nombreIndicadorABorrar = request.queryParams("nombre");

        RepositorioIndicadores.getInstancia().eliminarObjeto(
                RepositorioIndicadores.getInstancia().buscarObjeto(nombreIndicadorABorrar)
        );
        
        response.redirect("/indicadores/destruccion");

        return null;

    }
}
