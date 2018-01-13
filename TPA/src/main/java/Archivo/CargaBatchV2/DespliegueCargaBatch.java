package Archivo.CargaBatchV2;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import Archivo.CargaBatchV2.Cargadores.Cargador;
import Archivo.CargaBatchV2.Cargadores.CargadorDeRepositorio;
import Archivo.CargaBatchV2.CargasBatch.CargaBatch;
import Archivo.CargaBatchV2.CargasBatch.CargaBatchKelly;
import Archivo.CargaBatchV2.Contenedores.Contenedor;
import Archivo.CargaBatchV2.Contenedores.ContenedorDeStrings;
import Archivo.CargaBatchV2.FuentesDeStrings.Archivo;
import Archivo.CargaBatchV2.FuentesDeStrings.FuenteDeStrings;
import Archivo.CargaBatchV2.Scanners.CSV;
import Archivo.CargaBatchV2.Scanners.StringScanner;

public class DespliegueCargaBatch {
	public static void iniciar() throws FileNotFoundException {
		FuenteDeStrings fuente = new Archivo("cuentas/cuentitasDeHector.csv");
		StringScanner scanner = new CSV(",");
		
		Contenedor contenedor = new ContenedorDeStrings(fuente, scanner);
		Cargador cargador = new CargadorDeRepositorio();
		
		CargaBatch tarea = new CargaBatchKelly(contenedor, cargador);

		Cronometro cron = new Cronometro();

		cron.ejecutaPeriodicamente(tarea, TimeUnit.SECONDS.toMillis(15));
	}
}
