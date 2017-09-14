package DB;

import java.util.HashMap;
import java.util.List;

import DB.Excepciones.NoExisteProveedorException;
import DB.Proveedores.ProveedorBD;
import DB.Proveedores.ProveedorMock;

public abstract class Repositorio<T extends TipoDeRepositorio> {
	public HashMap<String, Proveedor<T>> proveedores = new HashMap<String, Proveedor<T>>();
	
	public abstract String getTipo();
	
	public T buscarObjeto(String unNombre, String tipoProveedor) {
		return this.getProveedor(tipoProveedor).darObjeto(unNombre, this.getTipo());
	}
	
	public List<T> buscarListaDeObjetos(String tipoProveedor) {
		return this.getProveedor(tipoProveedor).darLista(this.getTipo());
	}
	
	public List<String> darListaNombres(String tipoProveedor) {
		return this.getProveedor(tipoProveedor).darListaNombres(this.getTipo());
	}
	
	public void agregarObjeto(T unObjeto, String tipoProveedor) {
		this.getProveedor(tipoProveedor).agregar(unObjeto);
	}
	
	public void agregarListaDeObjetos(List<T> listaObjetos, String tipoProveedor) {
		this.getProveedor(tipoProveedor).agregarLista(listaObjetos);
	}
	
	public void eliminarObjeto(T unObjeto, Proveedor<T> unProveedor) {
		unProveedor.eliminar(unObjeto);
	}
	
	public Proveedor<T> getProveedor(String tipoProveedor) {
		if(!proveedores.containsKey(tipoProveedor)) this.iniciarProveedor(tipoProveedor);
		
		return proveedores.get(tipoProveedor);
	}
	
	public void iniciarProveedor(String tipoProveedor) {
		switch(tipoProveedor)
		{
			case "BD":		proveedores.put(tipoProveedor, new ProveedorBD<T>());
			break;
			case "Mock":	proveedores.put(tipoProveedor, new ProveedorMock<T>());
			break;
			default:		throw new NoExisteProveedorException();
		}
	}
}
