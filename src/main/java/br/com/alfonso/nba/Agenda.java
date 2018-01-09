package br.com.alfonso.nba;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

public class Agenda {

	private LocalDate data = LocalDate.MIN;
	private ArrayList<Horario> horarios = new ArrayList<Horario>();
	
	public Agenda() {
		
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}
	
	public ArrayList<Horario> getHorarios() {
		return this.horarios;
	}
	
	public void adicionarHorario(Horario horario) {
		boolean achou = false;
		for (Iterator<Horario> it = this.horarios.iterator(); it.hasNext(); ) {
			Horario hor = it.next();
			if (horario != null && hor != null) {
				if (horario.getHora() != null && hor.getHora() != null) {
					if (hor.getHora().compareTo(horario.getHora()) == 0) {
						achou = true;
						for (Partida part : horario.getPartidas()) {
							hor.adicionarPartida(part);
						}
					}
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
		
		String retorno = "";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYYY-MM-dd");
		retorno = "[" +this.data.format(dtf) + "]\r\n";
		//for (Horario horario : this.horarios) {
		for (Iterator<Horario> it = this.horarios.iterator(); it.hasNext(); ) {
			Horario horario = it.next();
			retorno += horario.toString();
		}
		
		return retorno;
	}
	
}
