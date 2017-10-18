package Main;

import java.util.Arrays;

import static Factories.FactoryCuenta.*;
import static Factories.FactoryEmpresa.crearEmpresa;
import static Factories.FactoryIndicador.crearIndicador;
import static Factories.FactoryNumero.crearNumero;
import static Factories.FactoryOperaciones.*;
import static Factories.FactoryPeriodo.crearPeriodo;

import static Factories.FactoryCondiciones.*;
import static Factories.FactoryMetodologia.*;

import DB.Repositorios.RepositorioEmpresas;
import DB.Repositorios.RepositorioIndicadores;
import DB.Repositorios.RepositorioMetodologias;

public class Bootstrap {
	public static void iniciarObjetos() {
		iniciarEmpresas();
		iniciarIndicadores();
		iniciarMetodologias();
	}
	
	public static void iniciarEmpresas() {
		RepositorioEmpresas.getInstancia().agregarListaDeObjetos(
			Arrays.asList(
				crearEmpresa("Rolito",
						crearPeriodo(2006,
								crearCuentaConValor("EDITBA", 2),
								crearCuentaConValor("FCF", 3)),
						crearPeriodo(2007,
								crearCuentaConValor("EDITBA", 5),
								crearCuentaConValor("FCF", 10))),
				crearEmpresa("Axxxel's Consortium Bag",
						crearPeriodo(2006,
								crearCuentaConValor("EDITBA", 3),
								crearCuentaConValor("FCF", 2)),
						crearPeriodo(2007,
								crearCuentaConValor("EDITBA", 1),
								crearCuentaConValor("FCF", 2)))));
	}
	
	public static void iniciarIndicadores() {
		RepositorioIndicadores.getInstancia().agregarListaDeObjetos(
			Arrays.asList(
				crearIndicador("ArrorROE", 
						sumar(crearCuenta("EDITBA"), multiplicar(crearCuenta("FCF"), crearNumero(2)))),
				crearIndicador("VANcomoLasCamionetas",
						restar(crearCuenta("FCF"), crearCuenta("EDITBA")))));
		RepositorioIndicadores.getInstancia().agregarObjeto(
				crearIndicador("VAI-BYE",
						dividir(RepositorioIndicadores.getInstancia().buscarObjeto("ArrorROE"), crearNumero(5))));
				
	}
	
	public static void iniciarMetodologias() {
		RepositorioMetodologias.getInstancia().agregarListaDeObjetos(
			Arrays.asList(
				crearMetodologia("MetodologiaAgil",
						crearMayorAEnPeriodos(RepositorioIndicadores.getInstancia().buscarObjeto("ArrorROE"), 10, 1)),
				crearMetodologia("MaomenoMaomeno2",
						crearMedianaMayorA(RepositorioIndicadores.getInstancia().buscarObjeto("VANcomoLasCamionetas"), 5000)),
				crearMetodologia("GGWP",
						crearSumatoriaMayorA(RepositorioIndicadores.getInstancia().buscarObjeto("VAI-BYE"), 0))));
	}

}
