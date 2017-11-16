package DB.Repositorios;

import java.util.List;

import DB.Excepciones.NoExisteObjetoConEseNombreException;
import DB.Excepciones.NoExistenObjetosException;
import DB.Proveedores.Proveedor;
import DB.TiposDeRepositorios.NombreRepositorio;
import DB.TiposDeRepositorios.TipoDeRepositorio;

public abstract class Repositorio<T extends TipoDeRepositorio> {
	protected NombreRepositorio tabla;
	private Proveedor<T> proveedor = null;
	
	public Repositorio(NombreRepositorio nombreTabla) {
		this.tabla = nombreTabla;
	}
	
	public String getTabla() {
		return this.tabla.darNombreRepositorio();
	};
	
	public void setProveedor(Proveedor<T> unProveedor) {
		this.proveedor = unProveedor;
	}
	
	public Proveedor<T> getProveedor() {
		return proveedor;
	}
	
	public T buscarObjeto(String unNombre) throws NoExisteObjetoConEseNombreException {
		return this.getProveedor().darObjeto(unNombre, this.getTabla());
	}
	
	public List<T> buscarListaDeObjetos() throws NoExistenObjetosException {
		return this.getProveedor().darLista(this.getTabla());
	}
	
	public List<String> darListaNombres() {
		return this.getProveedor().darListaNombres(this.getTabla());
	}
	
	public void agregarObjeto(T unObjeto) {
		this.getProveedor().agregar(unObjeto);
	}
	
	public void agregarListaDeObjetos(List<T> listaObjetos) {
		this.getProveedor().agregarLista(listaObjetos);
	}
	
	public void modificarObjeto(T unObjeto) {
		this.getProveedor().modificar(unObjeto);
	}
	
	public void eliminarObjeto(T unObjeto) {
		this.getProveedor().eliminar(unObjeto);
	}
}
