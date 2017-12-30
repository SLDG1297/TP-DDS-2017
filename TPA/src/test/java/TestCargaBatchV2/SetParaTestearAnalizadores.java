package TestCargaBatchV2;

import static Factories.FactoryCuenta.crearCuentaConValor;
import static Factories.FactoryEmpresa.crearEmpresa;
import static Factories.FactoryPeriodo.crearPeriodo;

import org.junit.Before;

import Archivo.CargaBatchV2.Carga;
import DB.Proveedores.ProveedorMock;
import DB.Repositorios.RepositorioEmpresas;
import Modelo.Empresa.Cuenta;
import Modelo.Empresa.Empresa;
import Modelo.Empresa.Periodo;

public abstract class SetParaTestearAnalizadores {
	public Cuenta cuenta1, cuenta2, cuenta3;
	public Periodo periodo1, periodo2;
	public Empresa empresa1;
	public RepositorioEmpresas repositorio = RepositorioEmpresas.getInstancia();
	
	public Carga alta, modificacion;
	
	public void iniciarCuentas() {
		cuenta1 = crearCuentaConValor("A", 2000);
		cuenta2 = crearCuentaConValor("A", 500);
		cuenta3 = crearCuentaConValor("B", 20);
	}
	
	public void iniciarPeriodos() {
		periodo1 = crearPeriodo(2006, cuenta1, cuenta3);
		periodo2 = crearPeriodo(2007, cuenta2);
	}
	
	public void iniciarEmpresa() {
		empresa1 = crearEmpresa("XD", periodo1, periodo2);
	}
	
	public void iniciarRepositorio() {
		repositorio.setProveedor(new ProveedorMock<Empresa>());
		repositorio.agregarObjeto(empresa1);
	}
	
	@Before
	public void iniciarTodo() {
		iniciarCuentas();
		iniciarPeriodos();
		iniciarEmpresa();
		iniciarRepositorio();
	}
}
