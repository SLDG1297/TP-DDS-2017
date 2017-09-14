package View.Indicadores;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.uqbar.commons.utils.Observable;

import DB.Repositorios.EmpresasRepository;
import DB.Repositorios.IndicadoresRepository;
import Modelo.Empresa.Empresa;
import Modelo.Indicadores.Indicador;
import Modelo.Indicadores.Query;

@Observable
public class VMEvaluacionIndicadores {
  
	    //Para bindear items del selector de empresas
		public List<String> listaDeNombresDeEmpresas;
		public String nombreEmpresa;
		//Empresa seleccionada en el selector 
		public Empresa empresa;
		public EmpresasRepository bolsaEmpresas;
		//Para bindear items del selector de periodos de la empresa elegida
		public Integer periodoElegido;
		public List<Integer> listaDePeriodosDeEmpresa;
		//Para bindear items del selector de indicador elegido
		public String nombreIndicador;
		public List<String> listaDeNombresDeIndicador;
		//Indicador seleccionado
		Indicador indicadorSeleccionado;
		//Para ver el resultado de la evaluacion
		BigDecimal resultado;
		
		//Constructor
		public VMEvaluacionIndicadores() {
			super();
			bolsaEmpresas = EmpresasRepository.getInstancia();
			listaDeNombresDeEmpresas = this.buscarNombresDeEmpresas();
			listaDeNombresDeIndicador = this.buscarNombresDeIndicadores();
		}

		private List<String> buscarNombresDeIndicadores() {
			return IndicadoresRepository.getInstancia().getNombresIndicadores();
		}

		public Integer getPeriodoElegido() {
			return periodoElegido;
		}

		public void setPeriodoElegido(Integer periodoElegido) {
			this.periodoElegido = periodoElegido;
		}


		public List<Integer> getListaDePeriodosDeEmpresa() {
			return listaDePeriodosDeEmpresa;
		}


		public void setListaDePeriodosDeEmpresa(List<Integer> listaDePeriodosDeEmpresa) {
			this.listaDePeriodosDeEmpresa = listaDePeriodosDeEmpresa;
		}


		public EmpresasRepository getBolsaEmpresas() {
			return bolsaEmpresas;
		}

		public void setBolsaEmpresas(EmpresasRepository bolsaEmpresas) {
			this.bolsaEmpresas = bolsaEmpresas;
		}

		public Empresa getEmpresa() {
			return empresa;
		}

		public void setEmpresa(Empresa empresa) {
			this.empresa = empresa;
		}

		public void setListaDeNombresDeEmpresas(List<String> listaDeNombresDeEmpresas) {
			this.listaDeNombresDeEmpresas = listaDeNombresDeEmpresas;
		}

		public List<String> getListaDeNombresDeEmpresas() {
			return listaDeNombresDeEmpresas;
		}

		public String getNombreEmpresa() {
			return nombreEmpresa;
		}

		public void setNombreEmpresa(String nombre_Empresa) {
			this.nombreEmpresa = nombre_Empresa;
		}

		//Sirve para actualizar el VM con la empresa seleccionada a partir de su nombre y además 
		//obtener la lista de periodos correspondientes a esa empresa
		public void buscarEmpresaYSusPeriodos() {
			empresa = this.bolsaEmpresas.buscarEmpresa(nombreEmpresa);
			this.listaDePeriodosDeEmpresa = this.buscarPeriodosDeEmpresa();
		}
	    
		public List<String> buscarNombresDeEmpresas() {
			return this.bolsaEmpresas.getNombresDeEmpresas();
		}
		
		public List<Integer> buscarPeriodosDeEmpresa(){
			return this.empresa.obtenerAniosDeTodosLosPeriodos();
		}

		public String getNombreIndicador() {
			return nombreIndicador;
		}

		public void setNombreIndicador(String nombreIndicador) {
			this.nombreIndicador = nombreIndicador;
		}

		public List<String> getListaDeNombresDeIndicador() {
			return listaDeNombresDeIndicador;
		}

		public void setListaDeNombresDeIndicador(List<String> listaDeNombresDeIndicador) {
			this.listaDeNombresDeIndicador = listaDeNombresDeIndicador;
		}
		
		public void buscarIndicadorSeleccionado(){
		indicadorSeleccionado = IndicadoresRepository.getInstancia().getIndicador(nombreIndicador);
		}
		
		//Metodo para evaluar la empresa seleccionada en determinado periodo con el indicador seleccionado
		public void evaluar(){
	    this.buscarIndicadorSeleccionado();
	    resultado = indicadorSeleccionado.calcular(new Query(empresa,periodoElegido));
		}

		public Indicador getIndicadorSeleccionado() {
			return indicadorSeleccionado;
		}

		public void setIndicadorSeleccionado(Indicador indicadorSeleccionado) {
			this.indicadorSeleccionado = indicadorSeleccionado;
		}

		public BigDecimal getResultado() {
			return resultado;
		}

		public void setResultado(BigDecimal resultado) {
			this.resultado = resultado;
		}
	
}
