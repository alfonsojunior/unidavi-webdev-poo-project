package br.com.alfonso.nba;


import org.junit.Assert;
import org.junit.Test;

import br.com.alfonso.nba.Partida;
import br.com.alfonso.nba.Time;

public class PartidaTest {

	@Test
	public void testPartida() {
		Temporada temporada = new Temporada();
		temporada.setID("2017-2018");
		
		Partida partida = new Partida(temporada);
		Assert.assertEquals("Partida inválida", partida.toString());
		
		Time casa = new Time();
		casa.setSigla("TS1");
		casa.setNome("Teste1");
		partida.setCasa(casa);
		Assert.assertEquals("Partida inválida", partida.toString());
		
		partida.setCasa("");
		partida.iniciarPartida();
		Assert.assertEquals("Partida inválida", partida.toString());
		
		Time visitante = new Time();
		visitante.setSigla("TS2");
		visitante.setNome("Teste2");
		partida.setVisitante(visitante);
		Assert.assertEquals("Partida inválida", partida.toString());
		
		partida.setCasa(casa);
		Assert.assertEquals("Partida inválida", partida.toString());
		
		temporada.adicionarTimes(casa);
		temporada.adicionarTimes(visitante);
		partida.setCasa(casa);
		partida.setVisitante(visitante);
		
		Assert.assertEquals("Teste1 X Teste2\r\n0 X 0\r\nPartida não iniciada", partida.toString());
	}

	@Test
	public void testIniciarPartida() {
		Temporada temporada = new Temporada();
		temporada.setID("2017-2018");
		
		Partida partida = new Partida(temporada);
		partida.iniciarPartida();
		Assert.assertEquals('X', partida.getVitorioso());
		Assert.assertEquals("Partida inválida", partida.toString());
		
		Time casa = new Time();
		casa.setSigla("TS1");
		casa.setNome("Teste1");
		partida.setCasa(casa);
		
		Time visitante = new Time();
		visitante.setSigla("TS2");
		visitante.setNome("Teste2");
		partida.setVisitante(visitante);
		
		Assert.assertEquals('X', partida.getVitorioso());
		Assert.assertEquals("Partida inválida", partida.toString());
		
		partida.iniciarPartida();
		
		Assert.assertEquals('X', partida.getVitorioso());
		Assert.assertEquals("Partida inválida", partida.toString());		
		
		temporada.adicionarTimes(casa);
		temporada.adicionarTimes(visitante);
		partida.setCasa(casa);
		partida.setVisitante(visitante);
		
		partida.iniciarPartida();
		
		Assert.assertEquals('I', partida.getVitorioso());
		Assert.assertEquals("Teste1 X Teste2\r\n0 X 0\r\nPartida em andamento", partida.toString());
	}

	@Test
	public void testAdicionarPontos() {
		Temporada temporada = new Temporada();
		temporada.setID("2017-2018");
		
		Partida partida = new Partida(temporada);
		
		Time casa = new Time();
		casa.setSigla("TS1");
		casa.setNome("Teste1");
		partida.setCasa(casa);
		
		Time visitante = new Time();
		visitante.setSigla("TS2");
		visitante.setNome("Teste2");
		partida.setVisitante(visitante);
		
		Assert.assertEquals("Partida inválida", partida.toString());
		
		temporada.adicionarTimes(casa);
		temporada.adicionarTimes(visitante);
		partida.setCasa(casa);
		partida.setVisitante(visitante);
		
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
	public void testSetCasaWithoutVisitanteNull() {
		Temporada temporada = new Temporada();
		temporada.setID("2017-2018");
		
		Partida partida = new Partida(temporada);
		
		Time visitante = new Time();
		visitante.setSigla("TS2");
		visitante.setNome("Teste2");
		
		Time casa = new Time();
		casa.setSigla("TS1");
		casa.setNome("Teste1");
		
		Assert.assertEquals(null, partida.getVisitante());
		
		temporada.adicionarTimes(visitante);
		partida.setVisitante(visitante);
		temporada.adicionarTimes(casa);
		partida.setCasa(casa);
		//Assert.assertEquals("TS1 - Teste1", partida.getCasa().toString());
		Assert.assertEquals("Teste1 X Teste2", partida.getID());
	}

	@Test
	public void testGetCasa() {
		Temporada temporada = new Temporada();
		temporada.setID("2017-2018");
		
		Partida partida = new Partida(temporada);
		Time time = new Time();
		time.setSigla("TS1");
		time.setNome("Teste1");
		partida.setCasa(time);
		
		Assert.assertEquals(null, partida.getVisitante());
		
		temporada.adicionarTimes(time);
		partida.setCasa(time);
		Assert.assertEquals("TS1 - Teste1", partida.getCasa().toString());
	}

	@Test
	public void testGetVisitante() {
		Temporada temporada = new Temporada();
		temporada.setID("2017-2018");
		
		Partida partida = new Partida(temporada);
		Assert.assertEquals(null, partida.getVisitante());
		Time time = new Time();
		time.setSigla("TS2");
		time.setNome("Teste2");
		partida.setVisitante(time);
		
		Assert.assertEquals(null, partida.getVisitante());
		
		temporada.adicionarTimes(time);
		partida.setVisitante(time);
		Assert.assertEquals("TS2 - Teste2", partida.getVisitante().toString());
	}

	@Test
	public void testFinalizarPartida() {
		Temporada temporada = new Temporada();
		temporada.setID("2017-2018");
		
		Partida partida = new Partida(temporada);
		
		Time casa = new Time();
		casa.setSigla("TS1");
		casa.setNome("Teste1");
		temporada.adicionarTimes(casa);
		partida.setCasa(casa);
		
		Time visitante = new Time();
		visitante.setSigla("TS2");
		visitante.setNome("Teste2");
		temporada.adicionarTimes(visitante);
		partida.setVisitante(visitante);
		
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
		
		partida = new Partida(temporada);
		
		casa = new Time();
		casa.setSigla("TS3");
		casa.setNome("Teste3");
		temporada.adicionarTimes(casa);
		partida.setCasa(casa);
		
		visitante = new Time();
		visitante.setSigla("TS4");
		visitante.setNome("Teste4");
		temporada.adicionarTimes(visitante);
		partida.setVisitante(visitante);
		
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
