package Archivo.CargaBatchV2;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public abstract class Contenedor {
	public final List<EmpresaToken> serEscaneado() throws IOException {
		List<EmpresaToken> empresasEscaneadas = new LinkedList<EmpresaToken>();
		
		while (this.tieneTokensPendientes())
		{
			empresasEscaneadas.add(this.escanearProximoToken());
		}
		
		this.limpiarse();
		
		return empresasEscaneadas;
	}
	
	public abstract boolean tieneTokensPendientes() throws IOException;
	
	public abstract EmpresaToken escanearProximoToken() throws IOException;

	public abstract void limpiarse() throws IOException;
}
