package DB;

import java.util.List;

public interface Proveedor {

	List<ObjetoDeRepositorio> darLista(String unTipoDeStock);

	ObjetoDeRepositorio darObjeto(String unNombre, String unTipo);

	void agregar(ObjetoDeRepositorio unObjeto);

	void agregarLista(List<ObjetoDeRepositorio> listaObjetos);
	
	void eliminar(ObjetoDeRepositorio unObjeto);

	List<String> darListaNombres(String unTipo);

}
