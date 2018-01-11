package br.com.alfonso.nba;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

import org.junit.Assert;
import org.junit.Test;

import br.com.alfonso.nba.Agenda;
import br.com.alfonso.nba.Horario;
import br.com.alfonso.nba.Partida;
import br.com.alfonso.nba.Time;

public class AgendaTest {

	@Test
	public void testAgenda() {
		Temporada temporada = new Temporada();
		temporada.setID("2017-2018");
		
		Agenda agenda = new Agenda();
		LocalDate data = LocalDate.of(2017, Month.DECEMBER, 15);
		agenda.setData(data);
		Assert.assertEquals("20171215", agenda.getID());
		Assert.assertEquals("2017-12-15", agenda.getData().toString());
	}

	@Test
	public void testAdicionarHorario() {
		Temporada temporada = new Temporada();
		temporada.setID("2017-2018");
		
		Agenda agenda = new Agenda();
		LocalDate data = LocalDate.of(2017, Month.DECEMBER, 15);
		agenda.setData(data);
		
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
		
		agenda.adicionarHorario(horario);
		String test = "[2017-12-15]\r\n[21:00]\r\n\t[Teste1 X Teste2]\r\n";
		Assert.assertEquals(test, agenda.toString());
		
		horario = new Horario();
		horario.setHora(LocalTime.of(21, 00));
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
		
		agenda.adicionarHorario(horario);
		test = "[2017-12-15]\r\n[21:00]\r\n\t[Teste1 X Teste2]\r\n\t[Teste3 X Teste4]\r\n";
		Assert.assertEquals(test, agenda.toString());
		test = "[[21:00]\r\n\t[Teste1 X Teste2]\r\n\t[Teste3 X Teste4]\r\n]";
		Assert.assertEquals(test, agenda.getHorarios().toString());
	}

	@Test
	public void testRemoverHorario() {
		Temporada temporada = new Temporada();
		temporada.setID("2017-2018");
		
		Agenda agenda = new Agenda();
		LocalDate data = LocalDate.of(2017, Month.DECEMBER, 15);
		agenda.setData(data);
		
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
		
		agenda.adicionarHorario(horario);
		String test = "[2017-12-15]\r\n[21:00]\r\n\t[Teste1 X Teste2]\r\n";
		Assert.assertEquals(test, agenda.toString());
		
		horario = new Horario();
		horario.setHora(LocalTime.of(21, 00));
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
		agenda.adicionarHorario(horario);
		test = "[2017-12-15]\r\n[21:00]\r\n\t[Teste1 X Teste2]\r\n\t[Teste3 X Teste4]\r\n";
		Assert.assertEquals(test, agenda.toString());
		test = "[[21:00]\r\n\t[Teste1 X Teste2]\r\n\t[Teste3 X Teste4]\r\n]";
		Assert.assertEquals(test, agenda.getHorarios().toString());
		
		horario = new Horario();
		horario.setHora(LocalTime.of(21, 00));
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
		horario.adicionarPartida(partida);
		agenda.removerHorario(horario);
		test = "[2017-12-15]\r\n";
		Assert.assertEquals(test, agenda.toString());
	}

}
