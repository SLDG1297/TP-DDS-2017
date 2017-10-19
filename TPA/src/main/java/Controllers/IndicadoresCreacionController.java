package Controllers;

import Modelo.Indicadores.GestorDeIndicadores;
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

    public Void redireccionarCreacion(Request request, Response response) {

        GestorDeIndicadores.getInstance().nombrar(request.queryParams("nombre"));

        response.redirect("/indicadores/creacion/" + request.queryParams("nombre"));

        return null;

    }

    public ModelAndView colocarOperando(Request request, Response response) {

        Map<Object, Object> mapa = GestorDeUsuarios.getInstance().obtenerMapa(request);

        return new ModelAndView(mapa, "indicadoresCreacion_elegirOperando.hbs");

    }

    public Void operandoColocado(Request request, Response response) {

        response.redirect("/indicadores/creacion/" + request.params("nombre") + "/" + request.queryParams("cosaAOperar"));

        return null;

    }

    public ModelAndView colocarIndicador(Request request, Response response) {

        Map<Object, Object> mapa = GestorDeUsuarios.getInstance().obtenerMapa(request);

        GestorDeIndicadores.getInstance().colocarIndicador(request.queryParams("nombre"));

        return new ModelAndView(mapa, "indicadoresCreacion_elegirOperando_indicador.hbs");

    }

    public ModelAndView colocarCuenta(Request request, Response response) {
        Map<Object, Object> mapa = GestorDeUsuarios.getInstance().obtenerMapa(request);

        GestorDeIndicadores.getInstance().colocarCuenta(request.queryParams("nombre"));

        return new ModelAndView(mapa, "indicadoresCreacion_elegirOperando_cuenta.hbs");

    }

    public ModelAndView colocarNumero(Request request, Response response) {
        Map<Object, Object> mapa = GestorDeUsuarios.getInstance().obtenerMapa(request);

        return new ModelAndView(mapa, "indicadoresCreacion_elegirOperando_numero.hbs");
    }

}
