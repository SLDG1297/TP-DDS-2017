package sistemaDeInversiones;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Determinador;

public class TestDeterminador {

@Test
public void puedoVerSiStringRepresentaNumero(){
	String numero1 = "20.4";
	String numero2 = "3.a22";
	String numero3 = "abc";
	Assert.assertEquals(true, Determinador.esNumeroValido(numero1));
	Assert.assertEquals(false, Determinador.esNumeroValido(numero2));
	Assert.assertEquals(false, Determinador.esNumeroValido(numero3));
}
}