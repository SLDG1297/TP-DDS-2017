package DB;

import java.util.List;

public interface Proveedor<T extends TipoDeRepositorio> {

	T darObjeto(String unNombre, String unTipo);

	List<T> darLista(String unTipo);

	List<String> darListaNombres(String unTipo);

	void agregar(T unObjeto);

	void agregarLista(List<T> listaObjetos);

	void eliminar(T unObjeto);
	
}
