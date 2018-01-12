package br.com.alfonso.nba;

import java.util.Optional;

import br.com.alfonso.IPartida;

public class Partida extends IPartida<Time>  {
	
	private Temporada temporada = new Temporada();
	private Time casa = null;
	private int pontosCasa = 0;
	private Time visitante = null;
	private int pontosVisitante = 0;
	private boolean fim = true;
	private char vitorioso = 'X';
	
	public Partida(Temporada temporada) {
		
		this.temporada = temporada;
		casa = null;
		this.pontosCasa = 0;
		visitante = null;
		this.pontosVisitante = 0;
		this.fim = true;
		this.vitorioso = 'X';
		
	}
	
	@Override
	public void iniciarPartida() {
		if (this.casa != null && this.visitante != null)
		{
			this.fim = false;
			this.vitorioso = 'I';
		}
	}
	
	@Override
	public void adicionarPontosCasa(int pontos) {
		if (!this.fim) {
			if (pontos > 0 && pontos <= 3) {
				this.pontosCasa += pontos;
			}
		}
	}
	
	public int getPontosCasa() {
		return this.pontosCasa;
	}
	
	@Override
	public void adicionarPontosVisitante(int pontos) {
		if (!this.fim) {
			if (pontos > 0 && pontos <= 3) {
				this.pontosVisitante += pontos;
			}
		}
	}
	
	public int getPontosVisitante() {
		return this.pontosVisitante;
	}

	public Time getCasa() {
		return casa;
	}

	@Override
	public void setCasa(Time casa) {
		if (casa != null) {
			if (this.visitante != null) {
				if (!casa.toString().equals(this.visitante.toString())) {
					boolean idExists = this.temporada
							.getTimes()
							.stream()
							.anyMatch(p -> p.getSigla().equals(casa.getSigla()));
					if (idExists) {
						this.casa = casa;
					}
				}
			} else {
				boolean idExists = this.temporada
						.getTimes()
						.stream()
						.anyMatch(p -> p.getSigla().equals(casa.getSigla()));
				if (idExists) {
					this.casa = casa;
				}
			}
		} else {
			this.casa = null;
		}
	}
	
	public void setCasa(String sigla) {
		if (!sigla.equals("")) {
			Optional<Time> timeOp = temporada.getTimes().stream().filter(a -> a.getSigla().equals(sigla)).findFirst();
			if (timeOp.isPresent()) {
				Time time = timeOp.get();
				this.setCasa(time);
			}
		}
	}

	public Time getVisitante() {
		return visitante;
	}

	@Override
	public void setVisitante(Time visitante) {
		if (visitante != null) {
			if (this.casa != null) {
				if (!visitante.toString().equals(this.casa.toString())) {
					boolean idExists = this.temporada
							.getTimes()
							.stream()
							.anyMatch(p -> p.getSigla().equals(visitante.getSigla()));
					if (idExists) {
						this.visitante = visitante;
					}
				}
			} else {
				boolean idExists = this.temporada
						.getTimes()
						.stream()
						.anyMatch(p -> p.getSigla().equals(visitante.getSigla()));
				if (idExists) {
					this.visitante = visitante;
				}
			}
		} else {
			this.visitante = null;
		}
	}
	
	public void setVisitante(String sigla) {
		if (!sigla.equals("")) {
			Optional<Time> timeOp = temporada.getTimes().stream().filter(a -> a.getSigla().equals(sigla)).findFirst();
			if (timeOp.isPresent()) {
				Time time = timeOp.get();
				this.setVisitante(time);
			}
		}
	}
	
	@Override
	public void finalizarPartida() {
		if (this.pontosCasa != this.pontosVisitante) {
			this.fim = true;
			if (this.pontosCasa > this.pontosVisitante) {
				this.vitorioso = 'C';
			} else {
				this.vitorioso = 'V';
			}
		}
	}
	
	public char getVitorioso() {
		return this.vitorioso;
	}
	
	public String getID() {
		return this.casa.getNome().trim() + " X " + this.visitante.getNome().trim();
	}
	
	@Override
	public String toString() {
		if (this.casa == null || this.visitante == null) {
			return "Partida invalida";
		} else {
			return this.casa.getNome() + " X " + this.visitante.getNome() + "\r\n" 
					+ this.getPontosCasa() + " X " + this.getPontosVisitante() + "\r\n"
					+ (this.fim && this.vitorioso != 'X' ? "Partida finalizada" : 
						this.fim && this.vitorioso == 'X'? "Partida nao iniciada" : "Partida em andamento");
		}
	}
	
}
