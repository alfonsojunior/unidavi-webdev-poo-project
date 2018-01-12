package br.com.alfonso.nba;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

import org.junit.Assert;
import org.junit.Test;

import br.com.alfonso.nba.Agenda;
import br.com.alfonso.nba.Horario;
import br.com.alfonso.nba.Partida;
import br.com.alfonso.nba.Temporada;
import br.com.alfonso.nba.Time;

public class TemporadaTest {

	@Test
	public void testTemporada() {
		Temporada temporada = new Temporada();
		Assert.assertEquals("[]\r\n", temporada.toString());
		Assert.assertEquals("[]", temporada.getTimes().toString());
		
		temporada.setID("2017-2018");
		Assert.assertEquals("[2017-2018]\r\n", temporada.toString());
		Assert.assertEquals("2017-2018", temporada.getID());
	}
	
	@Test
	public void testRemoverTimes() {
		Temporada temporada = new Temporada();
		temporada.setID("2017-2018");
		
		Time time = new Time();
		time.setSigla("TS1");
		time.setNome("Teste1");
		temporada.adicionarTimes(time);
		
		time = new Time();
		time.setSigla("TS2");
		time.setNome("Teste2");
		temporada.adicionarTimes(time);
		
		time = new Time();
		time.setSigla("TS3");
		time.setNome("Teste3");
		temporada.adicionarTimes(time);
		
		temporada.adicionarTimes("TS4", "Teste4");
		
		Assert.assertEquals("[TS1 - Teste1, TS2 - Teste2, TS3 - Teste3, TS4 - Teste4]", temporada.getTimes().toString());
		
		time = new Time();
		time.setSigla("TS4");
		time.setNome("Teste4");
		temporada.adicionarTimes(time);
		
		Assert.assertEquals("[TS1 - Teste1, TS2 - Teste2, TS3 - Teste3, TS4 - Teste4]", temporada.getTimes().toString());
		
		time = new Time();
		time.setSigla("TS2");
		time.setNome("Teste2");
		temporada.removerTimes(time);
		
		Assert.assertEquals("[TS1 - Teste1, TS3 - Teste3, TS4 - Teste4]", temporada.getTimes().toString());
		
		temporada.removerTimes("TS1");
		Assert.assertEquals("[TS3 - Teste3, TS4 - Teste4]", temporada.getTimes().toString());
	}

	@Test
	public void testRemoverAgendas() {
		Temporada temporada = new Temporada();
		temporada.setID("2017-2018");
		
		LocalDate data = LocalDate.of(2017, Month.OCTOBER, 10);
		Agenda agenda = new Agenda();
		agenda.setData(data);
		
		LocalTime hora = LocalTime.of(21, 00);
		Horario horario = new Horario();
		horario.setHora(hora);
		
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
		temporada.adicionarAgenda(agenda);
		
		data = LocalDate.of(2017, Month.OCTOBER, 11);
		agenda = new Agenda();
		agenda.setData(data);
		
		hora = LocalTime.of(21, 00);
		horario = new Horario();
		horario.setHora(hora);
		
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
		temporada.adicionarAgenda(agenda);
		
		String teste = "[2017-2018]\r\n[2017-10-10]\r\n[21:00]\r\n\t[Teste1 X Teste2]\r\n\r\n[2017-10-11]\r\n[21:00]\r\n\t[Teste3 X Teste4]\r\n\r\n";
		Assert.assertEquals(teste, temporada.toString());
		
		data = LocalDate.of(2017, Month.OCTOBER, 10);
		agenda = new Agenda();
		agenda.setData(data);
				
		temporada.removerAgendas(agenda);
		teste = "[2017-2018]\r\n[2017-10-11]\r\n[21:00]\r\n\t[Teste3 X Teste4]\r\n\r\n";
		Assert.assertEquals(teste, temporada.toString());
		
		//data = LocalDate.of(2017, Month.OCTOBER, 11);
		agenda = new Agenda();
		agenda.setData(2017, 10, 11);
		
		//hora = LocalTime.of(22, 00);
		horario = new Horario();
		horario.setHora(22, 00);
		
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
		agenda.adicionarHorario(horario);
		
		temporada.adicionarAgenda(agenda);
		teste = "[2017-2018]\r\n[2017-10-11]\r\n[21:00]\r\n\t[Teste3 X Teste4]\r\n[22:00]\r\n\t[Teste1 X Teste2]\r\n\r\n";
		Assert.assertEquals(teste, temporada.toString());
		
		data = LocalDate.of(2017, Month.OCTOBER, 11);
		temporada.removerAgendas(data);
		
		teste = "[2017-2018]\r\n";
		Assert.assertEquals(teste, temporada.toString());
	}

	@Test
	public void testReagendarPartidaPartidaLocalDateLocalTime() {
		Temporada temporada = new Temporada();
		temporada.setID("2017-2018");
		
		LocalDate data = LocalDate.of(2017, Month.OCTOBER, 10);
		Agenda agenda = new Agenda();
		agenda.setData(data);
		
		LocalTime hora = LocalTime.of(21, 00);
		Horario horario = new Horario();
		horario.setHora(hora);
		
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
		temporada.adicionarAgenda(agenda);
		
		data = LocalDate.of(2017, Month.OCTOBER, 11);
		agenda = new Agenda();
		agenda.setData(data);
		
		hora = LocalTime.of(21, 00);
		horario = new Horario();
		horario.setHora(hora);
		
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
		temporada.adicionarAgenda(agenda);
		
		String teste = "[2017-2018]\r\n[2017-10-10]\r\n[21:00]\r\n\t[Teste1 X Teste2]\r\n\r\n[2017-10-11]\r\n[21:00]\r\n\t[Teste3 X Teste4]\r\n\r\n";
		Assert.assertEquals(teste, temporada.toString());
		
		partida = new Partida(temporada);		
		time = new Time();
		time.setSigla("TS1");
		time.setNome("Teste1");
		partida.setCasa(time);
		time = new Time();
		time.setSigla("TS2");
		time.setNome("Teste2");
		partida.setVisitante(time);
		
		data = LocalDate.of(2017, Month.NOVEMBER, 11);
		hora = LocalTime.of(22, 00);
		temporada.reagendarPartida(partida, data, hora);
		
		teste = "[2017-2018]\r\n[2017-10-11]\r\n[21:00]\r\n\t[Teste3 X Teste4]\r\n\r\n[2017-11-11]\r\n[22:00]\r\n\t[Teste1 X Teste2]\r\n\r\n";
		Assert.assertEquals(teste, temporada.toString());
		
		partida = new Partida(temporada);
		//time = new Time();
		//time.setSigla("TS3");
		//time.setNome("Teste3");
		partida.setCasa("TS3");
		//time = new Time();
		//time.setSigla("TS4");
		//time.setNome("Teste4");
		partida.setVisitante("TS4");
		
		LocalDate dataAtual = LocalDate.of(2017, Month.OCTOBER, 11);
		
		data = LocalDate.of(2017, Month.NOVEMBER, 11);
		hora = LocalTime.of(21, 00);
		
		temporada.reagendarPartida(dataAtual, partida, data, hora);
		
		teste = "[2017-2018]\r\n[2017-11-11]\r\n[22:00]\r\n\t[Teste1 X Teste2]\r\n[21:00]\r\n\t[Teste3 X Teste4]\r\n\r\n";
		Assert.assertEquals(teste, temporada.toString());
		
		data = LocalDate.of(2017, Month.NOVEMBER, 11);
		teste = "[2017-11-11]\r\n[22:00]\r\n\t[Teste1 X Teste2]\r\n[21:00]\r\n\t[Teste3 X Teste4]\r\n\r\n";
		Assert.assertEquals(teste, temporada.listarPartidas(data));
		
		Partida partida1 = temporada.buscaPartida(2017, 11, 11, 22, 00, "TS1", "TS2");
		Assert.assertEquals("Teste1 X Teste2", partida1.getID());
	}

}
