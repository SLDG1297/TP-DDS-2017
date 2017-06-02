package sistemaDeInversiones;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Archivo.Instanciador_Bolsa_Empresas;
import Modelo.BolsaDeEmpresas;
import Modelo.BolsaDeEmpresasMocking;
import Modelo.Cuenta;
import Modelo.Empresa;
import Modelo.Periodo;

public class TestDominio {
    /*
	private BolsaDeEmpresasMocking bolsaEmpresas = new BolsaDeEmpresasMocking();
	
	@Test
	public void cuentasDeUnaEmpresa(){
	List<Cuenta> listaC1 = Arrays.asList(new Cuenta("EBITDA",2000),new Cuenta("Free Cash Flow",3000),new Cuenta("FDS",4000));
	List<Cuenta> listaC2 = Arrays.asList(new Cuenta("FDS",1000),new Cuenta("EBITDA",1500));
	List<Cuenta> listaC3 = Arrays.asList(new Cuenta("Free Cash Flow",2000));
	List<Periodo> periodo2 = Arrays.asList(new Periodo(2001, listaC2),new Periodo(2014, listaC3),new Periodo(2016, listaC1));
	
	Empresa empresa = new Empresa();
	empresa = bolsaEmpresas.buscarEmpresa("Guaymallén");
	List<Integer> periodosEmpresa = new ArrayList<Integer>();
	periodosEmpresa = empresa.obtenerPeriodos();
	Assert.assertEquals(periodosEmpresa,periodo2);
	
	}*/
}