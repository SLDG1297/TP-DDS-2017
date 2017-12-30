package Archivo.CargaBatchV2;

public abstract class Carga {
	EmpresaToken empresa;
	
	public EmpresaToken getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaToken empresa) {
		this.empresa = empresa;
	}

	public Carga(EmpresaToken empresa) {
		this.empresa = empresa;
	}
	
	public abstract void efectuarse();
}
