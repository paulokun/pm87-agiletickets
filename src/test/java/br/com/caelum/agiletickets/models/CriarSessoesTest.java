package br.com.caelum.agiletickets.models;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

public class CriarSessoesTest {
	@Test
	public void inicioIgualAoFim() {
		Espetaculo e = new Espetaculo();
		LocalDate hoje = new LocalDate();
		LocalTime hora = new LocalTime();
		
		List<Sessao> lista = e.criaSessoes(hoje, hoje, hora, Periodicidade.DIARIA);
		assertEquals(1, lista.size());
		assertEquals(hoje.toDateTime(hora), lista.get(0).getInicio());
	}
	
	@Test
	public void fimDepoisDoInicio() {
		DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy");
		
		Espetaculo e = new Espetaculo();
		LocalDate inicio = LocalDate.parse("28/08/2017", formatter);
		LocalDate fim = LocalDate.parse("30/08/2017", formatter);;
		LocalTime hora = new LocalTime();
		
		List<Sessao> lista = e.criaSessoes(inicio, fim, hora, Periodicidade.DIARIA);
		assertEquals(3, lista.size());
		assertEquals(inicio.toDateTime(hora), lista.get(0).getInicio());
		assertEquals(inicio.plusDays(1).toDateTime(hora), lista.get(1).getInicio());
		assertEquals(fim.toDateTime(hora), lista.get(2).getInicio());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void inicioMaiorQueOFim() {
		Espetaculo e = new Espetaculo();
		
		LocalDate fim = new LocalDate();
		LocalDate inicio = fim.plusDays(2);
		LocalTime hora = new LocalTime();
		
		List<Sessao> lista = e.criaSessoes(inicio, fim, hora, Periodicidade.DIARIA);
	}
	
	@Test
	public void semanalInicioIgualAoFim() {
		Espetaculo e = new Espetaculo();
		
		LocalDate inicio = new LocalDate();
		LocalTime hora = new LocalTime();
		
		List<Sessao> lista = e.criaSessoes(inicio, inicio, hora, Periodicidade.SEMANAL);
		assertEquals(1, lista.size());
		assertEquals(inicio.toDateTime(hora), lista.get(0).getInicio());
	}
	
	@Test
	public void semanalFimDepoisDoInicio() {
		Espetaculo e = new Espetaculo();
		LocalDate inicio = new LocalDate();
		LocalDate fim = inicio.plusWeeks(1);
		LocalTime hora = new LocalTime();
		
		List<Sessao> lista = e.criaSessoes(inicio, fim, hora, Periodicidade.SEMANAL);
		assertEquals(2, lista.size());
		assertEquals(inicio.toDateTime(hora), lista.get(0).getInicio());
		assertEquals(fim.toDateTime(hora), lista.get(1).getInicio());
	}
	
	// @Test(expected = IllegalArgumentException.class)
	public void semanalInicioMaiorQueOFim() {
		Espetaculo e = new Espetaculo();
		
		LocalDate fim = new LocalDate();
		LocalDate inicio = fim.plusWeeks(2);
		LocalTime hora = new LocalTime();
		
		List<Sessao> lista = e.criaSessoes(inicio, fim, hora, Periodicidade.SEMANAL);
	}
}
