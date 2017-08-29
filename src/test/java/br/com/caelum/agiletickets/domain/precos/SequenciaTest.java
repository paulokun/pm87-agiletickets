package br.com.caelum.agiletickets.domain.precos;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.caelum.agiletickets.models.Sequencia;

public class SequenciaTest {
	@Test
	public void testaPosicao1Retorna0() {
		Sequencia s = new Sequencia();
		int resultado = s.pegaNumero(1);
		assertEquals(0, resultado);
	}
	
	@Test
	public void testaPosicao2Retorna1() {
		Sequencia s = new Sequencia();
		int resultado = s.pegaNumero(1);
		assertEquals(0, resultado);
	}
	
	@Test
	public void testaPosicao5Retorna5() {
		Sequencia s = new Sequencia();
		int resultado = s.pegaNumero(5);
		assertEquals(5, resultado);
	}
	
	@Test
	public void testaPosicao6Retorna8() {
		Sequencia s = new Sequencia();
		int resultado = s.pegaNumero(6);
		assertEquals(8, resultado);
	}
	
	@Test
	public void testaPosicao7Retorna13() {
		Sequencia s = new Sequencia();
		int resultado = s.pegaNumero(7);
		assertEquals(13, resultado);
	}
}
