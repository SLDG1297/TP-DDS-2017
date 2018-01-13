package Observers;

import java.util.ArrayList;
import java.util.List;

public class NotificadorModificacionEmpresa {

	public static NotificadorModificacionEmpresa instance;
	
	private List<ObserverModificacionEmpresa> observadores = new ArrayList<>();
	
	public static NotificadorModificacionEmpresa getInstance() {

		if (instance == null) {

			instance = new NotificadorModificacionEmpresa();
			

		}

		return instance;
	}
	
	public void agregarObservador() 
	{
		
	}
	
	
}
	
