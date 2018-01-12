package br.com.alfonso.nba;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class Temporada {

	private String id = "";
	private List<Time> times = new ArrayList<>();
	private List<Agenda> agendas = new ArrayList<>();	
	
	private static String dateFormat = "YYYYMMdd";
	private static String hourFormat = "HHmm";
	
	public Temporada() {
		this.id = "";
		this.times = new ArrayList<>();
		this.agendas = new ArrayList<>();
	}
	
	public void setID(String id) {
		this.id = id;
	}
	
	public String getID() {
		return this.id;
	}
	
	public void adicionarTimes(Time time) {
		if (time != null) {
			
			Optional<Time> timeOp = this.getTimes().stream().filter(a -> a.getSigla().equals(time.getSigla())).findFirst();
			if (!timeOp.isPresent()) {
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
		
		this.times.removeIf((Time tm) -> tm.getSigla().equals(time.getSigla()));
		
	}
	
	public void removerTimes(String sigla) {
		Time time = new Time();
		time.setSigla(sigla);
		this.removerTimes(time);
	}
	
	public List<Time> getTimes() {
		return this.times;
	}
	
	public void adicionarAgenda(Agenda agenda) {
		boolean achou = false;
		if (agenda != null) {
			for (Iterator<Agenda> it = this.agendas.iterator(); it.hasNext(); ) {
				Agenda ag = it.next();
				if (ag != null && ag.getID().equals(agenda.getID())) {
					achou = true;
					for (Horario hor : agenda.getHorarios()) {
						ag.adicionarHorario(hor);
					}
				}
			}
			if (!achou) {
				this.agendas.add(agenda);
			}
		}
	}
	
	public void removerAgendas(Agenda agenda) {
		
		this.agendas.removeIf((Agenda ag) -> ag.getID().equals(agenda.getID()));

	}
	
	public void removerAgendas(LocalDate data) {
		Agenda agenda = new Agenda();
		agenda.setData(data);
		this.removerAgendas(agenda);
	}
	
	public Partida buscaPartida(int ano, int mes, int dia, int hora, int minuto, String siglaCasa, String siglaVisitante) {
		LocalDate data = LocalDate.of(ano, mes, dia);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateFormat);
		Partida partida = null;
		
		Optional<Agenda> agendaOp = this.agendas.stream()
					.filter(a -> a.getID().equals(data.format(dtf)))
					.findFirst();
		if (agendaOp.isPresent()) {
			Agenda agenda = agendaOp.get();
		
			DateTimeFormatter hrf = DateTimeFormatter.ofPattern(hourFormat);
			LocalTime hora1 = LocalTime.of(hora, minuto);
			Optional<Horario> horarioOp = agenda.getHorarios().stream()
				.filter(b -> b.getID().equals(hora1.format(hrf)))
				.findFirst();
			if (horarioOp.isPresent()) {
				Horario horario = horarioOp.get();
			
				Optional<Partida> partidaOp = horario.getPartidas().stream()
						.filter(c -> c.getCasa().getSigla().equals(siglaCasa) && c.getVisitante().getSigla().equals(siglaVisitante))
						.findFirst();
				if (partidaOp.isPresent()) {
					partida = partidaOp.get();
				}
			}
		}
		
		return partida;
	}
	
	public void reagendarPartida(LocalDate dataAtual, Partida partida, LocalDate novaData, LocalTime novaHora) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateFormat);
		
		this.agendas.stream()
					.filter( a -> a.getID().equals(dataAtual.format(dtf)))
					.forEach( agenda -> {
						agenda.getHorarios().stream().forEach( 
									horario -> horario.getPartidas().removeIf((Partida partida1) -> partida1.getID().equals(partida.getID()))
								);
						agenda.getHorarios().removeIf((Horario horario) -> horario.getPartidas().isEmpty());
					});
		this.agendas.removeIf((Agenda agenda) -> agenda.getHorarios().isEmpty());
		
		Agenda agenda1 = new Agenda();
		agenda1.setData(novaData);
		Horario horario1 = new Horario();
		horario1.setHora(novaHora);
		horario1.adicionarPartida(partida);
		agenda1.adicionarHorario(horario1);
		this.adicionarAgenda(agenda1);
	}
	
	public String listarPartidas(LocalDate data) {
		StringBuilder retorno = new StringBuilder();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateFormat);
		for (Agenda agenda : this.agendas) {
			if (agenda.getID().equals(data.format(dtf))) {
				retorno.append(agenda.toString() + "\r\n");
			}
		}
		
		return retorno.toString();
	}
	
	@Override
	public String toString() {
		StringBuilder retorno = new StringBuilder();
		
		retorno.append("[" + this.id.trim() + "]\r\n");
		for (Agenda agenda : this.agendas) {
			retorno.append(agenda.toString() + "\r\n");
		}
		
		return retorno.toString();
	}
}
