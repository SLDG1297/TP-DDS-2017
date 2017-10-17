package Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DB.Excepciones.NoExisteObjetoConEseNombreException;
import DB.Repositorios.RepositorioMetodologias;
import Modelo.Metodologias.Metodologia;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class MetodologiasController {
	public ModelAndView listarMetodologias(Request request, Response response) {
		Map<String, List<Metodologia>> modelo = new HashMap<>();
		
		modelo.put("metodologias", RepositorioMetodologias.getInstancia().buscarListaDeObjetos());
		
		return new ModelAndView(modelo, "Metodologias/metodologiasComparacion.hbs");
	}

	public ModelAndView mostrarComparacion(Request request, Response response) {
		Map<String, Object> modelo = new HashMap<>();
		
		String ruta = "";
		
		try
		{
			Metodologia metodologiaElegida = RepositorioMetodologias.getInstancia().buscarObjeto(request.queryParams("metodologia"));
			
			modelo.put("metodologias", RepositorioMetodologias.getInstancia().buscarListaDeObjetos());
			
			modelo.put("metodologiaElegida", metodologiaElegida);
			
			ruta = "Metodologias/metodologiasResultado.hbs";
		}
		catch (NoExisteObjetoConEseNombreException excepcion)
		{
			modelo.put("metodologias", RepositorioMetodologias.getInstancia().buscarListaDeObjetos());
			
			modelo.put("metodologiaInexistente", request.queryParams("metodologia"));
			
			ruta = "Metodologias/metodologiasComparacionErronea.hbs";
		}
		
		return new ModelAndView(modelo, ruta);
	}
}
