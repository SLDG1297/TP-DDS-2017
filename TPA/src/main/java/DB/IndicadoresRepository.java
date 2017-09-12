package DB;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Excepciones.Indicadores.NoHayIndicadoresEnElRepositorioException;
import Excepciones.Indicadores.NombreIndicadorErroneoException;
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
			
	public void agregarIndicador(Indicador indicador) {//Tendriamos que hacer que NUNCA se puede ingresar un indicador con el mismo nombre que uno ya existente
		beginTransaction();
		persist(indicador);
		commit();
	}
	
	public void agregarIndicadores(List<Indicador> indicadores){
		beginTransaction();
		for (Indicador i : indicadores) {
			persist(i);
		}
		commit();
	}
	

	public void eliminarIndicador(Indicador indicador) {
		beginTransaction();
		//remove(indicador);
		createQuery("delete from Indicador i where i.id = :id").setParameter("id", indicador.getId()).executeUpdate();
		commit();
	}
	
	public List<String> getNombresIndicadores(){
		return (List<String>) createQuery("select i.nombre from Indicador i").getResultList();
	}

	public static IndicadoresRepository getInstancia() {

		if (instancia == null) {
		instancia = new IndicadoresRepository();
		}
		return instancia;
	}

	public static void setInstancia(IndicadoresRepository instancia) {
		IndicadoresRepository.instancia = instancia;
	}
	
}
