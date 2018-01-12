package br.com.alfonso.nba;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Agenda {

	private LocalDate data = LocalDate.MIN;
	private List<Horario> horarios = new ArrayList<>();

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public void setData(int ano, int mes, int dia) {
		this.data = LocalDate.of(ano, Month.of(mes), dia);
	}
	
	public List<Horario> getHorarios() {
		return this.horarios;
	}
	
	public void adicionarHorario(Horario horario) {
		boolean achou = false;
		for (Iterator<Horario> it = this.horarios.iterator(); it.hasNext(); ) {
			Horario hor = it.next();
			if (horario != null 
					&& Horario.isSetted(horario) 
					&& hor.getHora().compareTo(horario.getHora()) == 0) {
				achou = true;
				for (Partida part : horario.getPartidas()) {
					hor.adicionarPartida(part);
				}
			}
		}
		if (!achou) {
			this.horarios.add(horario);
		}
	}
	
	public void removerHorario(Horario horario) {
		for (Iterator<Horario> it = this.horarios.iterator(); it.hasNext(); ) {
			Horario part = it.next();
			if (part.getID().equals(horario.getID())) {
				it.remove();
			}
		}
	}
	
	public String getID() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYYMMdd");
		return data.format(dtf);
	}
	
	@Override
	public String toString() {
		
		StringBuilder retorno = new StringBuilder();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-dd");
		retorno.append("[" +this.data.format(dtf) + "]\r\n");
		for (Iterator<Horario> it = this.horarios.iterator(); it.hasNext(); ) {
			Horario horario = it.next();
			retorno.append(horario.toString());
		}
		
		return retorno.toString();
	}
	
}
