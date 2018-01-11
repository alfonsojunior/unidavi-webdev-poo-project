package br.com.alfonso.nba;


import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Test;

import br.com.alfonso.nba.Horario;
import br.com.alfonso.nba.Partida;
import br.com.alfonso.nba.Time;

public class HorarioTest {

	@Test
	public void testHorario() {
		Horario horario = new Horario();
		horario.setHora(LocalTime.of(21, 00));
		Assert.assertEquals("2100", horario.getID());
	}

	@Test
	public void testListaPartidas() {
		Temporada temporada = new Temporada();
		temporada.setID("2017-2018");
		
		Horario horario = new Horario();
		horario.setHora(LocalTime.of(21, 00));
		
		Partida partida = new Partida(temporada);
		Time time = new Time();
		time.setSigla("TS1");
		time.setNome("Teste1");
		temporada.adicionarTimes(time);
		partida.setCasa(time);
		
		time = new Time();
		time.setSigla("TS2");
		time.setNome("Teste2");
		temporada.adicionarTimes(time);
		partida.setVisitante(time);
		
		horario.adicionarPartida(partida);
		String test = "[21:00]\r\n\t[Teste1 X Teste2]\r\n";
		Assert.assertEquals(test, horario.listaPartidas());
	}

	@Test
	public void testRemoverPartida() {
		Temporada temporada = new Temporada();
		temporada.setID("2017-2018");
		
		Horario horario = new Horario();
		horario.setHora(LocalTime.of(21, 00));
		
		Partida partida = new Partida(temporada);
		Time time = new Time();
		time.setSigla("TS1");
		time.setNome("Teste1");
		temporada.adicionarTimes(time);
		partida.setCasa(time);
		
		time = new Time();
		time.setSigla("TS2");
		time.setNome("Teste2");
		temporada.adicionarTimes(time);
		partida.setVisitante(time);
		
		horario.adicionarPartida(partida);
		String test = "[21:00]\r\n\t[Teste1 X Teste2]\r\n";
		Assert.assertEquals(test, horario.listaPartidas());
		
		partida = new Partida(temporada);
		time = new Time();
		time.setSigla("TS3");
		time.setNome("Teste3");
		temporada.adicionarTimes(time);
		partida.setCasa(time);
		
		time = new Time();
		time.setSigla("TS4");
		time.setNome("Teste4");
		temporada.adicionarTimes(time);
		partida.setVisitante(time);
		
		horario.adicionarPartida(partida);
		test = "[21:00]\r\n\t[Teste1 X Teste2]\r\n\t[Teste3 X Teste4]\r\n";
		Assert.assertEquals(test, horario.listaPartidas());
		
		partida = new Partida(temporada);
		time = new Time();
		time.setSigla("TS1");
		time.setNome("Teste1");
		temporada.adicionarTimes(time);
		partida.setCasa(time);
		
		time = new Time();
		time.setSigla("TS2");
		time.setNome("Teste2");
		temporada.adicionarTimes(time);
		partida.setVisitante(time);
		
		horario.removerPartida(partida);
		test = "[21:00]\r\n\t[Teste3 X Teste4]\r\n";
		Assert.assertEquals(test, horario.listaPartidas());
		
	}

}
