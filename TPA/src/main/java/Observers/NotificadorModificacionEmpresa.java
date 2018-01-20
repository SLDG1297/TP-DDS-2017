package Observers;
import java.util.LinkedList;
import java.util.List;

public class NotificadorModificacionEmpresa {

	public static NotificadorModificacionEmpresa instance;

	private TipoDeNotificador tipoDeNotificador = new TipoPosta();
	
	private List<ObserverModificacionEmpresa> observadores = new LinkedList<>();

	public static NotificadorModificacionEmpresa getInstance() {

		if (instance == null) instance = new NotificadorModificacionEmpresa();

		return instance;
	}
	
	public void agregarObservador(ObserverModificacionEmpresa observer) {
		observadores.add(observer);
	}
	
	public void notificarObservadores(String nombreEmpresa) {
		tipoDeNotificador.notificarObservadores(nombreEmpresa,observadores);
	}
	
}