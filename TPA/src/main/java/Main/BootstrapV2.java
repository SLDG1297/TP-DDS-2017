package Main;

import java.io.FileNotFoundException;

import Archivo.CargaBatchV2.DespliegueCargaBatch;
import DB.Proveedores.ProveedorBD;
import DB.Repositorios.RepositorioEmpresas;
import DB.Repositorios.RepositorioIndicadores;
import DB.Repositorios.RepositorioMetodologias;
import DB.Repositorios.RepositorioUsuarios;
import Modelo.Empresa.Empresa;
import Modelo.Indicadores.Indicador;
import Modelo.Metodologias.Metodologia;
import Modelo.Usuarios.Usuario;

public class BootstrapV2 {
	public static void iniciarModelo() throws FileNotFoundException {
		RepositorioUsuarios.getInstancia().setProveedor(new ProveedorBD<Usuario>());
		
		RepositorioEmpresas.getInstancia().setProveedor(new ProveedorBD<Empresa>());
		
		RepositorioIndicadores.getInstancia().setProveedor(new ProveedorBD<Indicador>());

		RepositorioMetodologias.getInstancia().setProveedor(new ProveedorBD<Metodologia>());
		
		DespliegueCargaBatch.iniciar();
	}
}
