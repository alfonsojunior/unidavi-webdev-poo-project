package br.com.alfonso.nba;


import org.junit.Assert;
import org.junit.Test;

import br.com.alfonso.nba.Partida;
import br.com.alfonso.nba.Time;

public class PartidaTest {

	@Test
	public void testPartida() {
		Partida partida = new Partida();
		Assert.assertEquals("Partida inválida", partida.toString());
		
		Time time = new Time();
		time.setSigla("TS1");
		time.setNome("Teste1");
		partida.setCasa(time);
		Assert.assertEquals("Partida inválida", partida.toString());
		
		partida.setCasa(null);
		partida.iniciarPartida();
		Assert.assertEquals("Partida inválida", partida.toString());
		
		time = new Time();
		time.setSigla("TS2");
		time.setNome("Teste2");
		partida.setVisitante(time);
		Assert.assertEquals("Partida inválida", partida.toString());
		
		time = new Time();
		time.setSigla("TS1");
		time.setNome("Teste1");
		partida.setCasa(time);
		Assert.assertEquals("Teste1 X Teste2\r\n0 X 0\r\nPartida não iniciada", partida.toString());
	}

	@Test
	public void testIniciarPartida() {
		Partida partida = new Partida();
		partida.iniciarPartida();
		Assert.assertEquals('X', partida.getVitorioso());
		Assert.assertEquals("Partida inválida", partida.toString());
		
		Time time = new Time();
		time.setSigla("TS1");
		time.setNome("Teste1");
		partida.setCasa(time);
		time = new Time();
		time.setSigla("TS2");
		time.setNome("Teste2");
		partida.setVisitante(time);
		partida.iniciarPartida();
		Assert.assertEquals('I', partida.getVitorioso());
		Assert.assertEquals("Teste1 X Teste2\r\n0 X 0\r\nPartida em andamento", partida.toString());
	}

	@Test
	public void testAdicionarPontos() {
		Partida partida = new Partida();
		Time time = new Time();
		time.setSigla("TS1");
		time.setNome("Teste1");
		partida.setCasa(time);
		time = new Time();
		time.setSigla("TS2");
		time.setNome("Teste2");
		partida.setVisitante(time);
		Assert.assertEquals("Teste1 X Teste2\r\n0 X 0\r\nPartida não iniciada", partida.toString());
		
		partida.adicionarPontosCasa(1);
		Assert.assertEquals("Teste1 X Teste2\r\n0 X 0\r\nPartida não iniciada", partida.toString());
		
		partida.iniciarPartida();
		partida.adicionarPontosCasa(1);
		Assert.assertEquals("Teste1 X Teste2\r\n1 X 0\r\nPartida em andamento", partida.toString());
		
		partida.adicionarPontosVisitante(3);
		Assert.assertEquals("Teste1 X Teste2\r\n1 X 3\r\nPartida em andamento", partida.toString());
	}

	@Test
	public void testGetCasa() {
		Partida partida = new Partida();
		Time time = new Time();
		time.setSigla("TS1");
		time.setNome("Teste1");
		partida.setCasa(time);
		Assert.assertEquals("TS1 - Teste1", partida.getCasa().toString());
	}

	@Test
	public void testGetVisitante() {
		Partida partida = new Partida();
		Assert.assertEquals(null, partida.getVisitante());
		Time time = new Time();
		time.setSigla("TS2");
		time.setNome("Teste2");
		partida.setVisitante(time);
		Assert.assertEquals("TS2 - Teste2", partida.getVisitante().toString());
	}

	@Test
	public void testFinalizarPartida() {
		Partida partida = new Partida();
		Time time = new Time();
		time.setSigla("TS1");
		time.setNome("Teste1");
		partida.setCasa(time);
		time = new Time();
		time.setSigla("TS2");
		time.setNome("Teste2");
		partida.setVisitante(time);
		Assert.assertEquals("Teste1 X Teste2", partida.getID());
		Assert.assertEquals("Teste1 X Teste2\r\n0 X 0\r\nPartida não iniciada", partida.toString());
		
		partida.finalizarPartida();
		Assert.assertEquals("Teste1 X Teste2\r\n0 X 0\r\nPartida não iniciada", partida.toString());
		
		partida.iniciarPartida();
		partida.adicionarPontosCasa(1);
		partida.adicionarPontosVisitante(1);
		Assert.assertEquals("Teste1 X Teste2\r\n1 X 1\r\nPartida em andamento", partida.toString());
		
		partida.finalizarPartida();
		Assert.assertEquals("Teste1 X Teste2\r\n1 X 1\r\nPartida em andamento", partida.toString());
		
		partida.adicionarPontosVisitante(3);
		Assert.assertEquals("Teste1 X Teste2\r\n1 X 4\r\nPartida em andamento", partida.toString());
		
		partida.finalizarPartida();
		Assert.assertEquals("Teste1 X Teste2\r\n1 X 4\r\nPartida finalizada", partida.toString());
		Assert.assertEquals('V', partida.getVitorioso());
		
		partida = new Partida();
		time = new Time();
		time.setSigla("TS3");
		time.setNome("Teste3");
		partida.setCasa(time);
		time = new Time();
		time.setSigla("TS4");
		time.setNome("Teste4");
		partida.setVisitante(time);
		partida.iniciarPartida();
		partida.adicionarPontosCasa(3);
		partida.adicionarPontosVisitante(2);
		partida.adicionarPontosCasa(2);
		partida.adicionarPontosCasa(2);
		partida.adicionarPontosVisitante(3);
		partida.finalizarPartida();
		Assert.assertEquals("Teste3 X Teste4\r\n7 X 5\r\nPartida finalizada", partida.toString());
		Assert.assertEquals('C', partida.getVitorioso());
	}


}
