package Observers;

import java.util.List;

public abstract class TipoDeNotificador {

    public void notificarObservadores(String nombreEmpresa, List<ObserverModificacionEmpresa> observadores){

        observadores.forEach(observer -> observer.update(nombreEmpresa));

    }

}
