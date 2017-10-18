package Controllers;

import java.util.Map;
import java.util.stream.Collectors;

import DB.Excepciones.NoExisteObjetoConEseNombreException;
import DB.Excepciones.NoExistenObjetosException;
import DB.Repositorios.RepositorioEmpresas;
import DB.Repositorios.RepositorioMetodologias;
import Modelo.GestorDeUsuarios;
import Modelo.Metodologias.Metodologia;
import Modelo.Metodologias.Resultados.Evaluacion;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class MetodologiasController {
	public ModelAndView listarMetodologias(Request request, Response response) {
		Map<Object, Object> modelo = GestorDeUsuarios.getInstance().obtenerMapa(request);
		
		String ruta = "";
		
		try
		{
			modelo.put("metodologias", RepositorioMetodologias.getInstancia().buscarListaDeObjetos());
			
			ruta = "Metodologias/metodologiasComparacion.hbs";
		}
		catch (NoExistenObjetosException excepcion)
		{
			ruta = "Metodologias/metodologiasInexistentes.hbs";
		}
		
		return new ModelAndView(modelo, ruta);
	}

	public ModelAndView mostrarComparacion(Request request, Response response) {
		Map<Object, Object> modelo = GestorDeUsuarios.getInstance().obtenerMapa(request);
		
		String ruta = "";
		
		try
		{
			modelo.put("metodologias", RepositorioMetodologias.getInstancia().buscarListaDeObjetos());
			
			Metodologia metodologiaElegida = RepositorioMetodologias.getInstancia().buscarObjeto(request.queryParams("metodologia"));	
			
			modelo.put("resultados", RepositorioEmpresas.getInstancia().buscarListaDeObjetos().stream().map(e -> new Evaluacion(e, metodologiaElegida)).collect(Collectors.toList()));
			
			modelo.put("metodologiaElegida", metodologiaElegida);
			
			ruta = "Metodologias/metodologiasResultado.hbs";
		}
		catch (NoExistenObjetosException excepcion)
		{
			ruta = "Metodologias/metodologiasInexistentes.hbs";
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
