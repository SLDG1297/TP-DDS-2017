package Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DB.Repositorios.RepositorioMetodologias;
import Modelo.GestorDeUsuarios;
import Modelo.Metodologias.Metodologia;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class MetodologiasController {
	public ModelAndView listarMetodologias(Request request, Response response) {
		Map<Object, Object> model = GestorDeUsuarios.getInstance().obtenerMapa(request);

		List<Metodologia> metodologias = RepositorioMetodologias.getInstancia().buscarListaDeObjetos();

		model.put("metodologias", metodologias);

		return new ModelAndView(model, "Metodologias/metodologiasComparacion.hbs");
	}
	
	public ModelAndView mostrarComparacion(Request request, Response response) {
		Map<Object, Object> model = GestorDeUsuarios.getInstance().obtenerMapa(request);

		Metodologia metodologiaElegida = RepositorioMetodologias.getInstancia().buscarObjeto(request.queryParams("metodologia"));

		model.put("nombre", metodologiaElegida.getNombre());
		
		return new ModelAndView(model, "Metodologias/metodologiasResultado.hbs");
	}
}
