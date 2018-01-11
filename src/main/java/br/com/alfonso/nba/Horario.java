package br.com.alfonso.nba;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;

public class Horario {

	private LocalTime hora = LocalTime.MIN;
	private ArrayList<Partida> partidas = new ArrayList<Partida>();
	
	public Horario() {
		this.partidas = new ArrayList<Partida>();
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	
	public ArrayList<Partida> getPartidas() {
		return this.partidas;
	}
	
	public String listaPartidas() {
		
		String retorno = "";
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
		retorno = "[" +this.hora.format(dtf) + "]\r\n";
		for (Iterator<Partida> it = this.partidas.iterator(); it.hasNext(); ) {
			Partida partida = it.next();
			retorno += "\t[" +partida.getID() + "]\r\n";
		}
		
		return retorno;
		
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
