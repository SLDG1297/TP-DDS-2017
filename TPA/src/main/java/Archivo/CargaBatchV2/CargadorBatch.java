package Archivo.CargaBatchV2;

import java.io.IOException;
import java.util.List;

public class CargadorBatch {	
	public static void cargar(Contenedor contenedor, Analizador analizador) throws IOException {
		List<EmpresaToken> tokens = contenedor.serEscaneado();
		
		List<Carga> cargas = analizador.analizarContenedor(tokens);
		
		cargas.forEach(c -> c.efectuarse());
		
		contenedor.limpiarse();
	}
	
	public static void cargarMock(Contenedor contenedor, Analizador analizador) throws IOException {
		List<EmpresaToken> tokens = contenedor.serEscaneado();
		
		List<Carga> cargas = analizador.analizarContenedor(tokens);
		
		cargas.forEach(c -> c.efectuarse());
	}
}
