package Controllers;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import DB.Repositorios.RepositorioEmpresas;
import DB.Repositorios.RepositorioIndicadores;
import DB.Repositorios.RepositorioPrecalculados;
import DB.Repositorios.RepositorioUsuarios;
import Modelo.Empresa.Empresa;
import Modelo.Excepciones.Indicadores.NoTieneLaCuentaException;
import Modelo.Indicadores.Indicador;
import Modelo.Indicadores.Query;
import Modelo.Usuarios.GestorDeUsuarios;
import Modelo.Usuarios.Usuario;
import com.mongodb.client.model.Filters;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

public class IndicadoresEvaluacionController {

	   public ModelAndView show(Request request, Response response){

		   Map<Object, Object> mapa = GestorDeUsuarios.getInstance().obtenerMapa(request);

		   if (mapa.get("email") != null){

			   Usuario usuario = RepositorioUsuarios.getInstancia().buscarObjeto((String) mapa.get("email"));

			   List<Indicador> indicadores = RepositorioIndicadores.getInstancia().buscarListaDeObjetosDeUsuario(usuario);

			   mapa.put("indicadores", indicadores);

			   return new ModelAndView(mapa,"indicadoresEvaluacion.hbs");

		   } else {
			   response.redirect("/login");
			   return null;
		   }
	   }

	public Void seleccionarIndicador(Request request, Response response) {

		String nombreIndicador = request.queryParams("nombreIndicador");

		response.redirect("/indicadores/evaluacion/" + nombreIndicador);

		return null;

	}

	public ModelAndView redireccionarIndicadorElegido(Request request, Response response) {

		Map<Object, Object> mapa = GestorDeUsuarios.getInstance().obtenerMapa(request);
		
		String nombreIndicador = request.params(":nombreIndicador");

		Indicador indicadorElegido =  RepositorioIndicadores.getInstancia().buscarObjeto(nombreIndicador);

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

		BigDecimal resultado;
		
		mapa.put("nombreIndicadorSeleccionado", nombreIndicador);
		mapa.put("nombreEmpresaSeleccionada", nombreEmpresa);
		mapa.put("periodoSeleccionado", periodo);
		mapa.put("formula", indicadorElegido.imprimirFormula());/*

		try {

			String emailUsuario = (String)mapa.get("email");
			//Estoy seleccionando el id del periodo o que? Tambien esta query es gigante, es horrible, lo debo meter en el gestor de cache aunque no haga nada mas que pedirle cosas al repo?
//			resultado = RepositorioPrecalculados.getInstancia().buscarObjetoPorQuery(Filters.and(Filters.eq("nombreIndicador",nombreIndicador),Filters.eq("nombreEmpresa",nombreEmpresa),Filters.eq("idPeriodo",periodo),Filters.eq("nombreUsuario",emailUsuario)));

		}

		try {
			resultado = indicadorElegido.calcular(new Query(empresaElegida,periodo));
			mapa.put("resultado", resultado);
			return new ModelAndView(mapa, "indicadoresEvaluacion.hbs");
		}
		catch(NoTieneLaCuentaException e) {
			return new ModelAndView(mapa, "indicadoresEvaluacionError.hbs");
		}*/

		return null;

	}
}
