package View.Indicadores;

import java.math.BigDecimal;
import java.util.List;
import org.uqbar.commons.utils.Observable;

import DB.Repositorios.IndicadoresRepository;
import Modelo.Indicadores.Cuenta_Indicadores;
import Modelo.Indicadores.Expresiones;
import Modelo.Indicadores.Indicador;
import Modelo.Indicadores.IndicadorBuilder;
import Modelo.Indicadores.Numero;

@Observable
public abstract class VMAgregar {
	 	
		//Creo que esta clase deberia estar vacia y que las VM de las clases concretas tener el codigo correspondiente de cada una 
		//a lo sumo solamente dejar el contructor y los get y set del builder
		//Pero si no hago todo este rejunte de codigo de todas las VM concretas que heredan de esta, me tira error
	
		public String nombreDeIndicadorElegido;
		public List<String> nombresDeIndicadoresExistentes;
		public IndicadorBuilder miIndicadorBuilder;
		public BigDecimal numeroElegido;
		public String miCadena;
		public String cuentaElegida;
		
		//Constructor
		public VMAgregar(IndicadorBuilder indicadorBuilder) {
			super();	
			miIndicadorBuilder = indicadorBuilder;
			miCadena = miIndicadorBuilder.imprimirFormula();
		}

		public IndicadorBuilder getMiIndicadorBuilder() {
			return miIndicadorBuilder;
		}

		public void setMiIndicadorBuilder(IndicadorBuilder miIndicadorBuilder) {
			this.miIndicadorBuilder = miIndicadorBuilder;
		}

		public String getNombreDeIndicadorElegido() {
			return nombreDeIndicadorElegido;
		}

		public void setNombreDeIndicadorElegido(String nombreDeIndicadorElegido) {
			this.nombreDeIndicadorElegido = nombreDeIndicadorElegido;
		}

		public List<String> getNombresDeIndicadoresExistentes() {
			return nombresDeIndicadoresExistentes;
		}

		public void setNombresDeIndicadoresExistentes(List<String> nombresDeIndicadoresExistentes) {
			this.nombresDeIndicadoresExistentes = nombresDeIndicadoresExistentes;
		}
		
		public Indicador devolverIndicador() {
			return IndicadoresRepository.getInstancia().getIndicador(nombreDeIndicadorElegido);	
		}
		
		public BigDecimal getNumeroElegido() {
			return numeroElegido;
		}

		public void setNumeroElegido(BigDecimal numeroElegido) {
			this.numeroElegido = numeroElegido;
		}
		
		public Expresiones devolverNumero() {
			
			return new Numero(numeroElegido);
			
		}
		
		public String devolverStringDeNumero() {		
			 return numeroElegido.toString();
		}
		
		public String getMiCadena() {
			return miCadena;
		}

		public void setMiCadena(String miCadena) {
			this.miCadena = miCadena;
		}
		
		public String getCuentaElegida() {
			return cuentaElegida;
		}

		public void setCuentaElegida(String cuentaElegida) {
			this.cuentaElegida = cuentaElegida;
		}
		
		public Expresiones devolverCuenta() {

			Cuenta_Indicadores cuenta = new Cuenta_Indicadores(cuentaElegida);
			return cuenta;
		}
		
	}

