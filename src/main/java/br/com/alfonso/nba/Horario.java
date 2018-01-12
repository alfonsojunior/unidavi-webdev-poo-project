package br.com.alfonso.nba;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Horario {

	private LocalTime hora = LocalTime.MIN;
	private List<Partida> partidas = new ArrayList<>();
	
	public Horario() {
		this.partidas = new ArrayList<>();
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	
	public void setHora(int hora, int minuto) {
		this.hora = LocalTime.of(hora, minuto);
	}
	
	public void setHora(int hora, int minuto, int segundos) {
		this.hora = LocalTime.of(hora, minuto, segundos);
	}
	
	public void setHora(int hora, int minuto, int segundos, int nanoSegundos) {
		this.hora = LocalTime.of(hora, minuto, segundos, nanoSegundos);
	}
	
	public static boolean isSetted(Horario horario) {
		return horario.getHora() != null;
	}
	
	public List<Partida> getPartidas() {
		return this.partidas;
	}
	
	public String listaPartidas() {
		
		StringBuilder retorno = new StringBuilder();
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
		retorno.append("[" +this.hora.format(dtf) + "]\r\n");
		for (Iterator<Partida> it = this.partidas.iterator(); it.hasNext(); ) {
			Partida partida = it.next();
			retorno.append("\t[" +partida.getID() + "]\r\n");
		}
		
		return retorno.toString();
		
	}
	
	public void adicionarPartida(Partida partida) {
		this.partidas.add(partida);
	}
	
	public void removerPartida(Partida partida) {
		for (Iterator<Partida> it = this.partidas.iterator(); it.hasNext(); ) {
			Partida part = it.next();
			if (part.toString().equals(partida.toString())) {
				it.remove();
			}
		}
	}
	
	public String getID() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HHmm");
		return hora.format(dtf);
	}
	
	@Override
	public String toString() {
		return listaPartidas();
	}

}
