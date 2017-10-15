package Controllers;

import java.util.List;

import DB.Repositorios.RepositorioMetodologias;
import Modelo.Metodologias.Metodologia;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class MetodologiasController {
	public ModelAndView listar(Request request, Response response) {
		List<Metodologia> metodologias = RepositorioMetodologias.getInstancia().buscarListaDeObjetos();

		return new ModelAndView(metodologias, "metodologiasEvaluacion.hbs");

	}
}
