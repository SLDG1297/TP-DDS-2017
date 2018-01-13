package Archivo.CargaBatch;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import Archivo.CargaBatch.Cargadores.Cargador;
import Archivo.CargaBatch.Cargadores.CargadorDeRespositorioNotificador;
import Archivo.CargaBatch.CargasBatch.CargaBatch;
import Archivo.CargaBatch.CargasBatch.CargaBatchKelly;
import Archivo.CargaBatch.Contenedores.Contenedor;
import Archivo.CargaBatch.Contenedores.ContenedorDeStrings;
import Archivo.CargaBatch.FuentesDeStrings.Archivo;
import Archivo.CargaBatch.FuentesDeStrings.FuenteDeStrings;
import Archivo.CargaBatch.Scanners.CSV;
import Archivo.CargaBatch.Scanners.StringScanner;

public class DespliegueCargaBatch {
	public static void iniciar() throws FileNotFoundException {
		FuenteDeStrings fuente = new Archivo("cuentas/cuentitasDeHector.csv");
		StringScanner scanner = new CSV(",");
		
		Contenedor contenedor = new ContenedorDeStrings(fuente, scanner);
		Cargador cargador = new CargadorDeRespositorioNotificador();
		
		CargaBatch tarea = new CargaBatchKelly(contenedor, cargador);

		Cronometro cron = new Cronometro();

		cron.ejecutaPeriodicamente(tarea, TimeUnit.SECONDS.toMillis(15));
	}
}
