package Archivo.CargaBatchV2;

public abstract class Cargador {
	public void cargar(EmpresaToken token) {
		if(this.existeLaCarga(token)) this.realizarModificacion(token);
		
		else this.realizarAlta(token);
	}
	
	public abstract boolean existeLaCarga(EmpresaToken token);

	public abstract void realizarAlta(EmpresaToken token);

	public abstract void realizarModificacion(EmpresaToken token);
}
