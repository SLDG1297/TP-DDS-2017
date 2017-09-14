package DB;

import java.util.List;

public abstract class Repositorio<T extends TipoDeRepositorio> {
	public Proveedor<T> proveedor = null;
	
	public abstract String getTipo();
	
	public void setProveedor(Proveedor<T> unProveedor) {
		this.proveedor = unProveedor;
	}
	
	public Proveedor<T> getProveedor() {
		return proveedor;
	}
	
	public T buscarObjeto(String unNombre) {
		return this.getProveedor().darObjeto(unNombre, this.getTipo());
	}
	
	public List<T> buscarListaDeObjetos() {
		return this.getProveedor().darLista(this.getTipo());
	}
	
	public List<String> darListaNombres() {
		return this.getProveedor().darListaNombres(this.getTipo());
	}
	
	public void agregarObjeto(T unObjeto) {
		this.getProveedor().agregar(unObjeto);
	}
	
	public void agregarListaDeObjetos(List<T> listaObjetos) {
		this.getProveedor().agregarLista(listaObjetos);
	}
	
	public void eliminarObjeto(T unObjeto) {
		this.getProveedor().eliminar(unObjeto);
	}
	
}
