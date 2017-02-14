package br.unifor.aulas.estruturadados;

import static org.junit.Assert.*;

import org.junit.Test;

public class BuscaBinariaTest {

	@Test
	public void testBuscaNenhumValor() {
		Integer numbers[] = {10, 25, 36, 72, 121, 437, 590};
		Integer valor = null;
		assertEquals(null, BuscaBinaria.busca(numbers, valor));
	}
	
	@Test
	public void testBuscaValorEspecifico(){
		Integer numbers[] = {10, 25, 36, 72, 121, 437, 590};
		Integer valor = 72;
		assertEquals((Integer)3, BuscaBinaria.busca(numbers, valor));
	} 
	
	@Test
	public void testBuscaValorInexistente(){
		Integer numbers[] = {10, 25, 36, 72, 121, 437, 590};
		Integer valor = 52;
		assertEquals(null, BuscaBinaria.busca(numbers, valor));
	} 
	
	@Test
	public void testBuscarNenhumValor() {
		Integer numbers[] = { 10, 25, 36, 72, 121, 437, 590 };
		Integer valor = null;
		assertEquals(null, BuscaBinaria.buscar(numbers, valor, (o1, o2) -> ((Integer) o1).compareTo((Integer) o2)));
	}

	@Test
	public void testBuscarValorEspecifico() {
		Integer numbers[] = { 10, 25, 36, 72, 121, 437, 590 };
		Integer valor = 72;
		assertEquals((Integer) 3,
				BuscaBinaria.buscar(numbers, valor, (o1, o2) -> ((Integer) o1).compareTo((Integer) o2)));
	}

	@Test
	public void testBuscarValorInexistente() {
		Integer numbers[] = { 10, 25, 36, 72, 121, 437, 590 };
		Integer valor = 52;
		assertEquals(null, BuscaBinaria.buscar(numbers, valor, (o1, o2) -> ((Integer) o1).compareTo((Integer) o2)));
	}

}
