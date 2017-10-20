package Main;

import DB.Proveedores.ProveedorBD;
import DB.Repositorios.RepositorioEmpresas;
import Modelo.Empresa.Empresa;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		Bootstrap.iniciarModelo();
		RepositorioEmpresas.getInstancia().setProveedor(new ProveedorBD<Empresa>());
		WebMain.iniciarInterfazWeb();
	}

}