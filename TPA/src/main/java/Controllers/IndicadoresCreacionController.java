package Controllers;

import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.Map;

import Modelo.Usuarios.GestorDeUsuarios;

public class IndicadoresCreacionController {

    public ModelAndView show(Request request, Response response) {

        Map<Object, Object> mapa = GestorDeUsuarios.getInstance().obtenerMapa(request);

        return new ModelAndView(mapa, "indicadoresCreacion.hbs");

    }

    public Void redireccionarCrearIndicador(Request request, Response response) {

        response.redirect("/indicadores/creacion/" + request.queryParams("nombre"));

        response.cookie("cosaAOperar", request.queryParams("cosaAOperar"));

        return null;

    }

    public ModelAndView crearIndicador(Request request, Response response) {

        Map<Object, Object> mapa = GestorDeUsuarios.getInstance().obtenerMapa(request);

        String nombreIndicadorACrear = request.params("nombre");

        return null;

    }
}
