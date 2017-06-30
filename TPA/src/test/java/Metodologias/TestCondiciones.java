package Metodologias;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import org.junit.Test;

public class TestCondiciones {

	@Test
	public void aplicarMayorAListaVacia() {
		List<Integer> list = new ArrayList<Integer>();
		
		Assert.assertEquals(true, list.stream().allMatch(num -> num >2));			
	}
}
		
