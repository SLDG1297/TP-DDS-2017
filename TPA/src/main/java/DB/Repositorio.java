package DB;

import java.util.List;

public class Repositorio {
	private static Repositorio instancia = null;
	
	public static Repositorio getInstancia() {
		if(instancia == null) instancia = new Repositorio();
		
		return instancia;
	}
	
	public ObjetoDeRepositorio buscarObjeto(String unNombre, String unTipo, Proveedor unProveedor) {
		return unProveedor.darObjeto(unNombre, unTipo);
	}
	
	public List<ObjetoDeRepositorio> buscarListaDeObjetos(String unTipo, Proveedor unProveedor) {
		return unProveedor.darLista(unTipo);
	}
	
	public void agregarObjeto(ObjetoDeRepositorio unObjeto, Proveedor unProveedor) {
		unProveedor.agregar(unObjeto);
	}
	
	public void agregarListaDeObjetos(List<ObjetoDeRepositorio> listaObjetos, Proveedor unProveedor) {
		unProveedor.agregarLista(listaObjetos);
	}
	
	public void eliminarObjeto(ObjetoDeRepositorio unObjeto, Proveedor unProveedor) {
		unProveedor.eliminar(unObjeto);
	}
	
	public List<String> getListaNombres(String unTipo, Proveedor unProveedor) {
		return unProveedor.darListaNombres(unTipo);
	}
}
