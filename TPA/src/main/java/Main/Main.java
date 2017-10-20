package Main;

import Archivo.Empresa.Instanciador_Bolsa_Empresas;
import DB.Excepciones.NoExistenObjetosException;
import DB.Proveedores.ProveedorBD;
import DB.Repositorios.RepositorioEmpresas;
import Modelo.Empresa.Empresa;

import java.io.IOException;
import java.util.Arrays;

import static Factories.FactoryCuenta.crearCuentaConValor;
import static Factories.FactoryEmpresa.crearEmpresa;
import static Factories.FactoryPeriodo.crearPeriodo;

public class Main {
	public static void main(String[] args) throws IOException {
		Bootstrap.iniciarModelo();
		RepositorioEmpresas.getInstancia().setProveedor(new ProveedorBD<Empresa>());
//		chequearEmpresas();
//		iniciarEmpresas();
		WebMain.iniciarInterfazWeb();
	}

//	public static void iniciarEmpresas() {
//		RepositorioEmpresas.getInstancia().agregarListaDeObjetos(
//				Arrays.asList(
//						crearEmpresa("Feel-Fort",
//								crearPeriodo(2006,
//										crearCuentaConValor("EDITBA", 2),
//										crearCuentaConValor("FCF", 3)),
//								crearPeriodo(2007,
//										crearCuentaConValor("EDITBA", 5),
//										crearCuentaConValor("FCF", 10))),
//						crearEmpresa("Axxxel's Another Consortium Bag",
//								crearPeriodo(2006,
//										crearCuentaConValor("EDITBA", 3),
//										crearCuentaConValor("FCF", 2)),
//								crearPeriodo(2007,
//										crearCuentaConValor("EDITBA", 1),
//										crearCuentaConValor("FCF", 2)))));
//	}
//
//	public static void chequearEmpresas() throws IOException {
//		try
//		{
//			RepositorioEmpresas.getInstancia().buscarListaDeObjetos();
//		}
//		catch (NoExistenObjetosException excepcion) {
//			new Instanciador_Bolsa_Empresas().instanciar();
//			iniciarEmpresas();
//		}
//	}


}