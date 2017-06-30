package Modelo.Metodologias.Condiciones;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import Modelo.Empresa.Empresa;
import Modelo.Indicadores.Indicador;
import Modelo.Metodologias.Try;

public class CasiSiempreDecreciente extends Comportamiento {

	public CasiSiempreDecreciente(Indicador indicador, Empresa empresa, int anios) {
		super(indicador, empresa, anios);
	}

	@Override
	protected boolean satisface(List<Boolean> comportamiento) {
		
		return comportamiento.stream().filter(bool->bool == false).collect(Collectors.toList()).size() <= 1;
	}

	@Override
	protected boolean comparacion(Try<BigDecimal> try1, Try<BigDecimal> try2) {

		return this.esMayor(try1, try2);
	}

}
