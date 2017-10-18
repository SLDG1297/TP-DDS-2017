package Controllers;

import Modelo.GestorDeUsuarios;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.Map;

public class IndicadoresCreacionController {

    public ModelAndView show(Request request, Response response) {

        Map<Object, Object> mapa = GestorDeUsuarios.getInstance().obtenerMapa(request);

        return new ModelAndView(mapa, "indicadoresCreacion.hbs");

    }

}
