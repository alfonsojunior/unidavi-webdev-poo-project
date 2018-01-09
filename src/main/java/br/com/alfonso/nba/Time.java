package br.com.alfonso.nba;

public class Time {

	private String sigla = "";
	private String nome = "";
	
	public Time() {
		this.setSigla("");
		this.setNome("");
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		if (sigla.length() > 3)
			sigla = sigla.substring(0, 3);
		this.sigla = sigla.toUpperCase();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return this.sigla.trim() 
				+ " - " 
				+ this.nome.trim();
	}
	
}
