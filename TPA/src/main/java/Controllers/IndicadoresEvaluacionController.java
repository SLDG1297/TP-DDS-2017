package Controllers;

import DB.Repositorios.RepositorioIndicadores;
import Modelo.GestorDeUsuarios;
import Modelo.Indicadores.Indicador;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.Map;

public class IndicadoresEvaluacionController {

	   public ModelAndView show(Request request, Response response){

		   Map<Object, Object> mapa = GestorDeUsuarios.getInstance().obtenerMapa(request);

		   mapa.put("indicador", RepositorioIndicadores.getInstancia().buscarListaDeObjetos());

		   return new ModelAndView(mapa,"indicadoresEvaluacion.hbs");

	   }

	public Void seleccionarIndicador(Request request, Response response) {
		
		String nombre = request.queryParams("nombre");

		response.redirect("/indicadores/evaluacion/" + nombre);

		return null;

	}

	public ModelAndView redireccionarIndicadorElegido(Request request, Response response) {

		Map<Object, Object> mapa = GestorDeUsuarios.getInstance().obtenerMapa(request);

		String nombreIndicador = request.params("nombre");

		Indicador indicadorElegido = RepositorioIndicadores.getInstancia().buscarObjeto(nombreIndicador);

		mapa.put("indicador", RepositorioIndicadores.getInstancia().buscarListaDeObjetos());
		mapa.put("formula", indicadorElegido.imprimirFormula());

		return new ModelAndView(mapa, "indicadoresEvaluacion.hbs");

	}
}
