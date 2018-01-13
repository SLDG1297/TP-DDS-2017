package DB;

import DB.Repositorios.RepositorioPrecalculados;
import Observers.*;
import com.mongodb.client.model.Filters;

public class GestorDeCache implements ObserverModificacionEmpresa{

    private static GestorDeCache ourInstance = new GestorDeCache();

    public static GestorDeCache getInstance() {
        return ourInstance;
    }

    private GestorDeCache() {

    }

    public void eliminarEmpresa(String nombreEmpresa) {

        //smellCode, no hace nada, llama a otra clase. Se hizo asi porque el codigo queda màs ordenado
        RepositorioPrecalculados.getInstancia().deteleByQuery(Filters.eq("nombreEmpresa",nombreEmpresa));

    }

    /*
    public void obtenerIndicadorEvaluado (String nombreIndicador) {



    }*/

	@Override
	public void update(String nombreEmpresa) {
	
		this.eliminarEmpresa(nombreEmpresa);
		
	}
}
