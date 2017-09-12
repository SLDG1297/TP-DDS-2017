package DB;

import java.util.List;
import DB.IndicadoresRepository;
import Excepciones.Indicadores.NoHayIndicadoresEnElRepositorioException;
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

	public List<String> obtenerNombreDeTodosLosIndicadores() {
		return (List<String>) createQuery("select i.nombre from Indicador i").getResultList();
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

	public void eliminarIndicador(Indicador indicador) {

		beginTransaction();
		createQuery("delete from Indicador i where i.id = :indicador").setParameter("nombre", indicador.getId());
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

	public List<String> getNombresIndicadores() {
		return (List<String>) createQuery("select i.nombre from Indicador i").getResultList();
	}

}
