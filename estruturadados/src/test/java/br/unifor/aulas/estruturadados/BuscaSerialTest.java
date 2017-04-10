package br.unifor.aulas.estruturadados;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.unifor.aulas.estruturadados.np1.BuscaSerial;

public class BuscaSerialTest {

	@Test
	public void testBuscaNenhumValor() {
		Integer numbers[] = {10, 25, 36, 72, 121, 437, 590};
		Integer valor = null;
		assertEquals(null, BuscaSerial.busca(numbers, valor));
	}
	
	@Test
	public void testBuscaValorEspecifico(){
		Integer numbers[] = {10, 25, 36, 72, 121, 437, 590};
		Integer valor = 72;
		assertEquals((Integer)3, BuscaSerial.busca(numbers, valor));
	} 
	
	@Test
	public void testBuscaValorInexistente(){
		Integer numbers[] = {10, 25, 36, 72, 121, 437, 590};
		Integer valor = 52;
		assertEquals(null, BuscaSerial.busca(numbers, valor));
	} 

}
