package Controllers;

import DB.Repositorios.RepositorioIndicadores;
import Modelo.GestorDeUsuarios;
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
	
}
