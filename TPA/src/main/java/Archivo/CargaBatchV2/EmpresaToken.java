package Archivo.CargaBatchV2;

public class EmpresaToken {
	private String nombreEmpresa;
	private String nombreCuenta;
	private int anioPeriodo;
	private int valor;
	
	public EmpresaToken(String nombreEmpresa, String nombreCuenta, int anioPeriodo, int valor) {
		this.nombreEmpresa = nombreEmpresa;
		this.nombreCuenta = nombreCuenta;
		this.anioPeriodo = anioPeriodo;
		this.valor = valor;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}
	
	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}
	
	public String getNombreCuenta() {
		return nombreCuenta;
	}
	
	public void setNombreCuenta(String nombreCuenta) {
		this.nombreCuenta = nombreCuenta;
	}
	
	public int getAnioPeriodo() {
		return anioPeriodo;
	}
	
	public void setAnioPeriodo(int anioPeriodo) {
		this.anioPeriodo = anioPeriodo;
	}
	
	public int getValor() {
		return valor;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public boolean esIgual(EmpresaToken otro)
	{
		boolean mismaEmpresa = this.nombreEmpresa.equals(otro.getNombreEmpresa());
		boolean mismaCuenta = this.nombreCuenta.equals(otro.getNombreCuenta());
		boolean mismoPeriodo = this.anioPeriodo == otro.getAnioPeriodo();
		boolean mismoValor = this.valor == otro.getValor();
		
		return mismaEmpresa && mismaCuenta && mismoPeriodo && mismoValor;
	}
}
