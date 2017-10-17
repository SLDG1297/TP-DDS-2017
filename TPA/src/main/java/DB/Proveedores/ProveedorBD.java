package DB.Proveedores;

import java.util.List;

import javax.persistence.NoResultException;

import DB.DBManager;
import DB.Proveedor;
import DB.TipoDeRepositorio;
import DB.Excepciones.NoExisteObjetoConEseNombreException;

public class ProveedorBD<T extends TipoDeRepositorio> extends DBManager implements Proveedor<T> {

	public ProveedorBD() {
		super();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T darObjeto(String unNombre, String unTipo) throws NoExisteObjetoConEseNombreException {
		try
		{
			return (T) createQuery("from " + unTipo + " objeto where objeto.nombre = :nombre").setParameter("nombre", unNombre).getSingleResult();
		}
		catch(NoResultException excepcion)
		{
			throw new NoExisteObjetoConEseNombreException();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> darLista(String unTipo) {
		return (List<T>) createQuery("from " + unTipo).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> darListaNombres(String unTipo) {
		return (List<String>) createQuery("select objeto.nombre from " + unTipo + " objeto").getResultList();	
	}

	@Override
	public void agregar(T unObjeto) {
		beginTransaction();
		
    	persist(unObjeto);
    	
    	commit();
	}

	@Override
	public void agregarLista(List<T> listaObjetos) {
		beginTransaction();
		
    	for (T objeto : listaObjetos) persist(objeto);
    	
    	commit();
	}

	@Override
	public void eliminar(T unObjeto) {
		beginTransaction();
		
		remove(unObjeto);
		
		commit();
	}

}
