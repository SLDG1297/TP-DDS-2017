package Archivo.CargaBatchV2;

import java.util.Timer;
import java.util.TimerTask;

public class Cronometro {
	private Timer timer = new Timer();

	public void ejecutaPeriodicamente(TimerTask tarea, long tiempo) {
		timer.schedule(tarea, 0, tiempo);
	}
	
	public void terminarTareas() {
		timer.cancel();
		timer.purge();
	}
}
