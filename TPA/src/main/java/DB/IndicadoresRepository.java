package DB;

import java.util.List;
import Excepciones.Indicadores.NoHayIndicadoresEnElRepositorioException;
import DB.IndicadoresRepository;
import Modelo.Indicadores.Indicador;

public class IndicadoresRepository extends DBManager {

	private static IndicadoresRepository instancia = null;

	public List<Indicador> getIndicadores() {
		List<Indicador> listaIndicadores = (List<Indicador>) createQuery("from Indicador").getResultList();
		if (listaIndicadores.size() == 0)
			throw new NoHayIndicadoresEnElRepositorioException();
		return listaIndicadores;
	}

	public Indicador getIndicador(String nombre) {
		return (Indicador) createQuery("from Indicador i where i.nombre = :nombre").setParameter("nombre", nombre)
				.getSingleResult();
		 }

	public void agregarIndicador(Indicador indicador) {
		beginTransaction();
		persist(indicador);
		commit();
	}

	public void agregarIndicadores(List<Indicador> unosIndicadores) {

		beginTransaction();
		for (Indicador i : unosIndicadores) {
			persist(i);
		}
		commit();
	}
	
	public List<String> getNombresIndicadores() {
		return (List<String>) createQuery("select i.nombre from Indicador i").getResultList();
	}
	

	public void eliminarIndicador(Indicador indicador) {
		beginTransaction();
		//remove(indicador);
		createQuery("delete from Indicador i where i.id = :id").setParameter("id", indicador.getId()).executeUpdate();
		commit();
	}
	

	public static IndicadoresRepository getInstancia() {

		if (instancia == null) {
		instancia = new IndicadoresRepository();
		}
		return instancia;
	}


	public static void setInstancia(IndicadoresRepository NuevaInstancia) {
		instancia = NuevaInstancia;
	}

}
