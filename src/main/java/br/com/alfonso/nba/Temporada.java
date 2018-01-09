package br.com.alfonso.nba;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

public class Temporada {

	private String id = "";
	private ArrayList<Time> times = new ArrayList<Time>();
	private ArrayList<Agenda> agendas = new ArrayList<Agenda>();	
	
	public Temporada() {
		this.id = "";
		this.times = new ArrayList<Time>();
		this.agendas = new ArrayList<Agenda>();
	}
	
	public void setID(String id) {
		this.id = id;
	}
	
	public String getID() {
		return this.id;
	}
	
	public void adicionarTimes(Time time) {
		boolean achou = false;
		if (time != null) {
			for (Iterator<Time> it = this.times.iterator(); it.hasNext(); ) {
				Time tm = it.next();
				if (tm != null) {
					if (tm.getSigla().equals(time.getSigla())) {
						achou = true;
						break;
					}
				}
			}
			if (!achou) {
				this.times.add(time);
			}
		}
	}
	
	public void adicionarTimes(String sigla, String nome) {
		Time time = new Time();
		time.setSigla(sigla);
		time.setNome(nome);
		this.adicionarTimes(time);
	}
	
	public void removerTimes(Time time) {
		for (Iterator<Time> it = this.times.iterator(); it.hasNext(); ) {
			Time tm = it.next();
			if (tm.getSigla().equals(time.getSigla())) {
				it.remove();
			}
		}
	}
	
	public void removerTimes(String sigla) {
		Time time = new Time();
		time.setSigla(sigla);
		this.removerTimes(time);
	}
	
	public ArrayList<Time> getTimes() {
		return this.times;
	}
	
	public void adicionarAgenda(Agenda agenda) {
		boolean achou = false;
		if (agenda != null) {
			for (Iterator<Agenda> it = this.agendas.iterator(); it.hasNext(); ) {
				Agenda ag = it.next();
				if (ag != null) {
					if (ag.getID().equals(agenda.getID())) {
						achou = true;
						for (Horario hor : agenda.getHorarios()) {
							ag.adicionarHorario(hor);
						}
					}
				}
			}
			if (!achou) {
				this.agendas.add(agenda);
			}
		}
	}
	
	public void removerAgendas(Agenda agenda) {
		for (Iterator<Agenda> it = this.agendas.iterator(); it.hasNext(); ) {
			Agenda ag = it.next();
			if (ag.getID().equals(agenda.getID())) {
				it.remove();
			}
		}
	}
	
	public void removerAgendas(LocalDate data) {
		Agenda agenda = new Agenda();
		agenda.setData(data);
		this.removerAgendas(agenda);
	}
	
	public void reagendarPartida(Partida partida, LocalDate novaData, LocalTime novaHora) {
		boolean achou = false;
		for (Iterator<Agenda> it = this.agendas.iterator(); it.hasNext(); ) {
			Agenda agenda = it.next();
			for (Iterator<Horario> it1 = agenda.getHorarios().iterator(); it.hasNext(); ) {
				Horario horario = it1.next();
				for (Iterator<Partida> it2 = horario.getPartidas().iterator(); it.hasNext(); ) {
					Partida partida1 = it2.next();
					if (partida.getID().equals(partida1.getID())) {
						it2.remove();
						achou = true;
						break;
					}
				}
				if (achou) {
					if (horario.getPartidas().size() == 0)
						it1.remove();
					break;
				}
			}
			if (achou) {
				if (agenda.getHorarios().size() == 0)
					it.remove();
				break;
			}
		}
		Agenda agenda1 = new Agenda();
		agenda1.setData(novaData);
		Horario horario1 = new Horario();
		horario1.setHora(novaHora);
		horario1.adicionarPartida(partida);
		agenda1.adicionarHorario(horario1);
		this.adicionarAgenda(agenda1);
	}
	
	public void reagendarPartida(LocalDate dataAtual, Partida partida, LocalDate novaData, LocalTime novaHora) {
		boolean achou = false;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYYMMdd");
		for (Iterator<Agenda> it = this.agendas.iterator(); it.hasNext(); ) {
			Agenda agenda = it.next();
			if (agenda.getID().equals(dataAtual.format(dtf))) {
				for (Iterator<Horario> it1 = agenda.getHorarios().iterator(); it.hasNext(); ) {
					Horario horario = it1.next();
					for (Iterator<Partida> it2 = horario.getPartidas().iterator(); it.hasNext(); ) {
						Partida partida1 = it2.next();
						if (partida.getID().equals(partida1.getID())) {
							it2.remove();
							achou = true;
							break;
						}
					}
					if (achou) {
						if (horario.getPartidas().size() == 0)
							it1.remove();
						break;
					}
				}
			}
			if (achou) {
				if (agenda.getHorarios().size() == 0)
					it.remove();
				break;
			}
		}
		Agenda agenda1 = new Agenda();
		agenda1.setData(novaData);
		Horario horario1 = new Horario();
		horario1.setHora(novaHora);
		horario1.adicionarPartida(partida);
		agenda1.adicionarHorario(horario1);
		this.adicionarAgenda(agenda1);
	}
	
	public String listarPartidas(LocalDate data) {
		String retorno = "";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYYMMdd");
		for (Agenda agenda : this.agendas) {
			if (agenda.getID().equals(data.format(dtf))) {
				retorno += agenda.toString() + "\r\n";
			}
		}
		
		return retorno;
	}
	
	@Override
	public String toString() {
		String retorno = "";
		
		retorno = "[" + this.id.trim() + "]\r\n";
		for (Agenda agenda : this.agendas) {
			retorno += agenda.toString() + "\r\n";
		}
		
		return retorno;
	}
}
