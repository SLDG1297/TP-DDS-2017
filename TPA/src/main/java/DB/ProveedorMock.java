package DB;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Excepciones.Empresas.NoExisteEnElRepositorioException;

public class ProveedorMock implements Proveedor {
	private static ProveedorMock instancia = null;
	private List<ObjetoDeRepositorio> lista = new ArrayList<ObjetoDeRepositorio>();
	
	public static ProveedorMock getInstancia() {
		if(instancia == null) instancia = new ProveedorMock();
		
		return instancia;
	}

	public List<ObjetoDeRepositorio> darLista(String unTipoDeStock) {
		return this.lista;
	}

	public ObjetoDeRepositorio darObjeto(String unNombre, String unTipo) {
		return this.lista.stream().filter(o -> o.getNombre().equals(unNombre)).findFirst().orElseThrow(() -> new NoExisteEnElRepositorioException());
	}

	public void agregar(ObjetoDeRepositorio unObjeto) {
		this.lista.add(unObjeto);
	}

	public void agregarLista(List<ObjetoDeRepositorio> listaObjetos) {
		this.lista = listaObjetos;	
	}

	public void eliminar(ObjetoDeRepositorio unObjeto) {
		this.lista.remove(unObjeto);
	}

	public List<String> darListaNombres(String unTipo) {
		return lista.stream().map((ObjetoDeRepositorio e) -> e.getNombre()).collect(Collectors.toList());	
	}
	
}
