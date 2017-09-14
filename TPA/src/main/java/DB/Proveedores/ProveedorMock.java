package DB.Proveedores;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import DB.Proveedor;
import DB.TipoDeRepositorio;
import Excepciones.Empresas.NoExisteEnElRepositorioException;

public class ProveedorMock<T extends TipoDeRepositorio> implements Proveedor<T> {
	
	public ProveedorMock(List<T> lista) {
		this.setLista(lista);
	}
	
	@SuppressWarnings("unchecked")
	public ProveedorMock(T... lista) {
		this.setLista(Arrays.asList(lista));
	}

	private List<T> lista = new ArrayList<T>();
	
	public List<T> getLista() {
		return lista;
	}

	public void setLista(List<T> lista) {
		this.lista = lista;
	}

	@Override
	public T darObjeto(String unNombre, String unTipo) {
		return this.getLista().stream().filter(o -> o.getNombre().equals(unNombre)).findFirst().orElseThrow(() -> new NoExisteEnElRepositorioException());
	}

	@Override
	public List<T> darLista(String unTipo) {
		return this.getLista();
	}

	@Override
	public List<String> darListaNombres(String unTipo) {
		return this.getLista().stream().map((TipoDeRepositorio e) -> e.getNombre()).collect(Collectors.toList());	
	}

	@Override
	public void agregar(T unObjeto) {
		this.getLista().add(unObjeto);
	}

	@Override
	public void agregarLista(List<T> listaObjetos) {
		this.lista.addAll(listaObjetos);	
	}

	@Override
	public void eliminar(T unObjeto) {
		this.lista.remove(unObjeto);
	}

}
