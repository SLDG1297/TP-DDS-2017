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

public class ElementosDePrueba {
	public static void iniciarObjetosDePrueba() {
		iniciarEmpresasDePrueba();
		iniciarIndicadoresDePrueba();
		iniciarMetodologiasDePrueba();
	}
	
	public static void iniciarEmpresasDePrueba() {
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
	
	public static void iniciarIndicadoresDePrueba() {
		RepositorioIndicadores.getInstancia().agregarObjeto(
				crearIndicador("JejeSaluditos", 
							sumar(crearCuenta("EDITBA"), multiplicar(crearCuenta("FCF"), crearNumero(2)))));
	}
	
	public static void iniciarMetodologiasDePrueba() {
		RepositorioMetodologias.getInstancia().agregarObjeto(
				crearMetodologia("Leprita",
						crearMayorAEnPeriodos(RepositorioIndicadores.getInstancia().buscarObjeto("JejeSaluditos"), 10, 1)));
	}
}
