package sistemaDeInversiones;

import java.io.IOException;
import java.util.stream.Collectors;
import org.junit.Test;
import Archivo.Instanciador_Bolsa_Empresas;

import Modelo.Empresa.Empresa;
import Modelo.Empresa.Periodo;
import Modelo.Empresa.BolsaDeEmpresas;
import Modelo.Empresa.BolsaDeEmpresasMocking;
import Modelo.Empresa.Cuenta;

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

	@Test
	public void verEmpresas() {
		try {
			new Instanciador_Bolsa_Empresas().instanciar();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BolsaDeEmpresas bolsa = BolsaDeEmpresas.getInstancia();
		System.out.println(bolsa.getEmpresas().stream().map(e -> e.getNombre()).collect(Collectors.toList()));
	}
}
