package DB;

import java.util.List;

public class ProveedorBD extends DBManager implements Proveedor {
	private static ProveedorBD instancia = null;
	
	public static ProveedorBD getInstancia() {
		if(instancia == null) instancia = new ProveedorBD();
		
		return instancia;
	}

	@SuppressWarnings("unchecked")
	public List<ObjetoDeRepositorio> darLista(String unTipo) {
		return (List<ObjetoDeRepositorio>) createQuery("from " + unTipo).getResultList();
	}

	public ObjetoDeRepositorio darObjeto(String unNombre, String unTipo) {
		return (ObjetoDeRepositorio) createQuery("from " + unTipo + " objeto where objeto.nombre = :nombre").setParameter("nombre", unNombre).getSingleResult();
	}

	public void agregar(ObjetoDeRepositorio unObjeto) {
		beginTransaction();
		
    	persist(unObjeto);
    	
    	commit();
	}

	public void agregarLista(List<ObjetoDeRepositorio> listaObjetos) {
		beginTransaction();
		
    	for (ObjetoDeRepositorio objeto : listaObjetos) persist(objeto);
    	
    	commit();
    }

	public void eliminar(ObjetoDeRepositorio unObjeto) {
		beginTransaction();
		
		remove(unObjeto);
		
		commit();
	}

	@SuppressWarnings("unchecked")
	public List<String> darListaNombres(String unTipo) {
		return (List<String>) createQuery("select objeto.nombre from " + unTipo + " objeto").getResultList();	
	}

}
