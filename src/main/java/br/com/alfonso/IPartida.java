package br.com.alfonso;

public abstract class IPartida<T> {

	public abstract void iniciarPartida();
	public abstract void setCasa(T casa);
	public abstract void adicionarPontosCasa(int pontos);
	public abstract void setVisitante(T casa);
	public abstract void adicionarPontosVisitante(int pontos);
	public abstract void finalizarPartida();

}
