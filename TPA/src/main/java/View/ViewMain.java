package View;

import java.io.IOException;
import java.math.BigDecimal;

import DB.Repositorios.RepositorioMetodologias;
import Modelo.Metodologias.Condiciones.CondicionFactory;
import Modelo.Metodologias.Metodologia;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.MainWindow;
import Archivo.Empresa.Instanciador_Bolsa_Empresas;
import DB.Proveedores.ProveedorBD;
import DB.Repositorios.RepositorioEmpresas;
import DB.Repositorios.RepositorioIndicadores;
import Modelo.Empresa.Empresa;
import Modelo.Indicadores.Indicador;
import View.Cuentas.VMCargarCuentas;
import View.Cuentas.ViewCargarCuentas;
import View.Indicadores.VMGestionDeIndicadores;
import View.Indicadores.ViewGestionDeIndicadores;
import View.Metodologias.VMGestionDeMetodologias;
import View.Metodologias.ViewGestionDeMetodologias;

public class ViewMain extends MainWindow<VM_Main> {
	
		
	public ViewMain() {
		super(new VM_Main());
	}

	@Override
	public void createContents(Panel panelPrincipal) {
		this.setTitle("Sistema de inversiones");

		new Button(panelPrincipal).setCaption("Gestionar Cuentas").onClick(() -> new ViewCargarCuentas(this, new VMCargarCuentas()).open());
		
		new Button(panelPrincipal).setCaption("Gestionar Indicadores").onClick(() -> new ViewGestionDeIndicadores(this, new VMGestionDeIndicadores()).open());
		
		new Button(panelPrincipal).setCaption("Gestionar Metodologias").onClick(() -> new ViewGestionDeMetodologias(this, new VMGestionDeMetodologias()).open());

		
	}

	public static void main(String[] args) throws IOException {
		RepositorioEmpresas.getInstancia().setProveedor(new ProveedorBD<Empresa>());
		
		RepositorioIndicadores.getInstancia().setProveedor(new ProveedorBD<Indicador>());

		// RepositorioMetodologias.getInstancia().setProveedor(new ProveedorBD<Metodologia>());

		// RepositorioMetodologias.getInstancia().agregarObjeto((new Metodologia("MayorA_500_En1_Periodo", new CondicionFactory().crearMayorAEnPeriodos(RepositorioIndicadores.getInstancia().buscarObjeto("prueba"), new BigDecimal(500), 1))));
		
		new Instanciador_Bolsa_Empresas().instanciar();
		
		new ViewMain().startApplication(); 
		
	}

}