package Modelo.Metodologias.Condiciones;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import Modelo.Empresa.Empresa;
import Modelo.Empresa.Periodo;
import Modelo.Indicadores.Indicador;
import Modelo.Metodologias.Try;

public abstract class Booleana extends Condicion {

	protected BigDecimal valor;
	protected int anios;
	
	public Booleana(Indicador indicador, BigDecimal valor, int anios) {
		super(indicador);
		this.valor = valor;
		this.anios = anios;
	}

	@Override
	public List<Periodo> inicio(List<Periodo> lista) {
		return lista.stream().filter(periodo -> periodo.estaEntre(anios, lista, periodo)).collect(Collectors.toList());
	}
	
	@Override
	public boolean fin(List<Try<BigDecimal>> success) {
		return success.stream().allMatch(successMonad -> successMonad.get().compareTo(valor) == this.booleano() || successMonad.get().compareTo(valor) == 0); // == 1 representa el "> valor", == 0 representa el "= valor"
	}
	
	

}
