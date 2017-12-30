package Archivo.CargaBatchV2;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import Archivo.CargaBatchV2.Cargas.Alta;
import Archivo.CargaBatchV2.Cargas.Modificacion;

public abstract class AnalizadorDeCargas {
	private List<Carga> cargas = new LinkedList<Carga>();
	
	public List<Carga> getCargas() {
		return cargas;
	}

	public void setCargas(List<Carga> cargas) {
		this.cargas = cargas;
	}

	public final List<Carga> analizarContenedor(Contenedor unContenedor) throws IOException {
		List<EmpresaToken> tokens = unContenedor.serEscaneado();
		
		tokens.forEach(t -> this.analizarToken(t));
		
		return this.cargas;
	}

	public void analizarToken(EmpresaToken token) {
		if(this.existeLaCarga(token) || this.cargas.stream().anyMatch(c -> c.getEmpresa().getNombreEmpresa().equals(token.getNombreEmpresa())))
			this.cargas.add(new Modificacion(token));
		else
			this.cargas.add(new Alta(token));
	}

	public abstract boolean existeLaCarga(EmpresaToken token);
}
