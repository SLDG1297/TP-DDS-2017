package Controllers;

import DB.Repositorios.RepositorioEmpresas;
import DB.Repositorios.RepositorioIndicadores;
import Modelo.Empresa.Empresa;
import Modelo.Excepciones.Indicadores.NoTieneLaCuentaException;
import Modelo.Indicadores.Indicador;
import Modelo.Indicadores.Query;
import Modelo.Usuarios.GestorDeUsuarios;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.math.BigDecimal;
import java.util.Map;

public class IndicadoresEvaluacionController {

	   public ModelAndView show(Request request, Response response){

		   Map<Object, Object> mapa = GestorDeUsuarios.getInstance().obtenerMapa(request);

		   mapa.put("indicadores", RepositorioIndicadores.getInstancia().buscarListaDeObjetos());

		   return new ModelAndView(mapa,"indicadoresEvaluacion.hbs");

	   }

	public Void seleccionarIndicador(Request request, Response response) {

		String nombreIndicador = request.queryParams("nombreIndicador");

		response.redirect("/indicadores/evaluacion/" + nombreIndicador);

		return null;

	}

	public ModelAndView redireccionarIndicadorElegido(Request request, Response response) {

		Map<Object, Object> mapa = GestorDeUsuarios.getInstance().obtenerMapa(request);
		
		String nombreIndicador = request.params(":nombreIndicador");

		Indicador indicadorElegido = RepositorioIndicadores.getInstancia().buscarObjeto(nombreIndicador);

		mapa.put("nombreIndicadorSeleccionado", nombreIndicador);
		mapa.put("formula", indicadorElegido.imprimirFormula());
		mapa.put("empresas", RepositorioEmpresas.getInstancia().buscarListaDeObjetos());

		return new ModelAndView(mapa, "indicadoresEvaluacion.hbs");

	}
	
	public Void seleccionarEmpresa(Request request, Response response) {

		String nombreIndicador = request.params(":nombreIndicador");
		String nombreEmpresa = request.queryParams("nombreEmpresa");

		response.redirect("/indicadores/evaluacion/" + nombreIndicador + "/"+ nombreEmpresa);

		return null;

	}
	
	public ModelAndView redireccionarEmpresaElegida(Request request, Response response) {
		
		Map<Object, Object> mapa = GestorDeUsuarios.getInstance().obtenerMapa(request);
		
		String nombreEmpresa = request.params(":nombreEmpresa");
		String nombreIndicador = request.params(":nombreIndicador");
		
		Indicador indicadorElegido = RepositorioIndicadores.getInstancia().buscarObjeto(nombreIndicador);
		
		Empresa empresaElegida = RepositorioEmpresas.getInstancia().buscarObjeto(nombreEmpresa);
		
		mapa.put("nombreIndicadorSeleccionado", nombreIndicador);
		mapa.put("nombreEmpresaSeleccionada", nombreEmpresa);
		mapa.put("formula", indicadorElegido.imprimirFormula());
		mapa.put("periodos", empresaElegida.getPeriodos());
		
		return new ModelAndView(mapa, "indicadoresEvaluacion.hbs");
	}
	
	public Void seleccionarPeriodo(Request request, Response response) {

		String nombreIndicador = request.params(":nombreIndicador");
		String nombreEmpresa = request.params(":nombreEmpresa");
		String anio = request.queryParams("periodo");

		response.redirect("/indicadores/evaluacion/" + nombreIndicador +  "/" + nombreEmpresa + "/" + anio);

		return null;

	}
	
	public ModelAndView redireccionarPeriodoElegido(Request request, Response response) {
		
		Map<Object, Object> mapa = GestorDeUsuarios.getInstance().obtenerMapa(request);
		
		String nombreEmpresa = request.params(":nombreEmpresa");
		String nombreIndicador = request.params(":nombreIndicador");
		int periodo = Integer.parseInt(request.params(":periodo"));
		
		Indicador indicadorElegido = RepositorioIndicadores.getInstancia().buscarObjeto(nombreIndicador);
		Empresa empresaElegida = RepositorioEmpresas.getInstancia().buscarObjeto(nombreEmpresa);

		BigDecimal resultado = indicadorElegido.calcular(new Query(empresaElegida,periodo));
		
		/*
		try {
			resultado = indicadorElegido.calcular(new Query(empresaElegida,periodo));
		}
		catch(NoTieneLaCuentaException e) {
			resultado = null;
		}*/
		
		mapa.put("nombreIndicadorSeleccionado", nombreIndicador);
		mapa.put("nombreEmpresaSeleccionada", nombreEmpresa);
		mapa.put("periodoSeleccionado", periodo);
		mapa.put("formula", indicadorElegido.imprimirFormula());
		mapa.put("resultado", resultado);
		
		return new ModelAndView(mapa, "indicadoresEvaluacion.hbs");
	}
}
