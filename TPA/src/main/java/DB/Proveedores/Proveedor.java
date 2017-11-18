package DB.Proveedores;

import java.util.List;

import DB.TiposDeRepositorios.TipoDeRepositorio;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

public interface Proveedor<T extends TipoDeRepositorio> {

	T darObjeto(String unNombre, String unTipo);

	List<T> darLista(String unTipo);

	List<String> darListaNombres(String unTipo);

	void agregar(T unObjeto);

	void agregarLista(List<T> listaObjetos);
	
	void modificar(T unObjeto);

	void eliminar(T unObjeto);
}
