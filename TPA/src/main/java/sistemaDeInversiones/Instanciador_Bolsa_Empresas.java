package sistemaDeInversiones;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Instanciador_Bolsa_Empresas {
	
	private static List<List<String>> obtenerListaString(){
		return LectorDeArchivos.entregarLista();
	}
	
	private static List<Empresa> obtenerListaEmpresas(){
		return Parser.aEmpresas(obtenerListaString());
	}
	
	public static BolsaDeEmpresas instanciar(){
		BolsaDeEmpresas bolsaEmpresa = new BolsaDeEmpresas();
		bolsaEmpresa.setEmpresas(obtenerListaEmpresas());
		return bolsaEmpresa;
	}

}
