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

        mapa.put("formula", GestorDeIndicadores.getInstance().obtenerFormula());

        return new ModelAndView(mapa, "indicadoresCreacion_elegirOperando.hbs");

    }

    public Void operandoColocado(Request request, Response response) {

        response.redirect("/indicadores/creacion/" + request.params("nombre") + "/" + request.queryParams("cosaAOperar"));

        return null;

    }

    public ModelAndView colocarIndicador(Request request, Response response) {

        Map<Object, Object> mapa = GestorDeUsuarios.getInstance().obtenerMapa(request);

        mapa.put("formula", GestorDeIndicadores.getInstance().obtenerFormula());

        return new ModelAndView(mapa, "indicadoresCreacion_elegirOperando_indicador.hbs");

    }

    public ModelAndView colocarCuenta(Request request, Response response) {
        Map<Object, Object> mapa = GestorDeUsuarios.getInstance().obtenerMapa(request);

        mapa.put("formula", GestorDeIndicadores.getInstance().obtenerFormula());

        return new ModelAndView(mapa, "indicadoresCreacion_elegirOperando_cuenta.hbs");
    }

    public ModelAndView colocarNumero(Request request, Response response) {
        Map<Object, Object> mapa = GestorDeUsuarios.getInstance().obtenerMapa(request);

        mapa.put("formula", GestorDeIndicadores.getInstance().obtenerFormula());

        return new ModelAndView(mapa, "indicadoresCreacion_elegirOperando_numero.hbs");
    }

    public Void redireccionarOperadorDesdeIndicador(Request request, Response response) {

        GestorDeIndicadores.getInstance().colocarIndicador(request.queryParams("nombre"));

        response.redirect("/indicadores/creacion/" + request.params("nombre") + "/operadores");

        return null;

    }

    public Void redireccionarOperadorDesdeCuenta(Request request, Response response) {

        GestorDeIndicadores.getInstance().colocarCuenta(request.queryParams("nombre"));

        response.redirect("/indicadores/creacion/" + request.params("nombre") + "/operadores");

        return null;

    }

    public Void redireccionarOperadorDesdeNumero(Request request, Response response) {

        GestorDeIndicadores.getInstance().colocarNumero(request.queryParams("numero"));

        response.redirect("/indicadores/creacion/" + request.params("nombre") + "/operadores");

        return null;

    }

    public ModelAndView mostrarOperadores(Request request, Response response) {

        Map<Object, Object> mapa = GestorDeUsuarios.getInstance().obtenerMapa(request);

        mapa.put("formula", GestorDeIndicadores.getInstance().obtenerFormula());

        return new ModelAndView(mapa, "indicadoresCreacion_elegirOperador.hbs");

    }

    public Void redireccionarOperadorElegido(Request request, Response response) {

        GestorDeIndicadores.getInstance().agregarOperador(request.queryParams("operador"));

        response.redirect("/indicadores/creacion/" + request.params("nombre"));

        return null;
    }

}
