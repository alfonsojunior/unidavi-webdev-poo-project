package br.com.alfonso.nba;

import java.util.logging.Logger;

public class Main {

	private static Temporada temporada = new Temporada();
	
	public static void main(String[] args) {
		
		Logger.getGlobal().info("Teste");
		temporada.setID("2017-2018");
	}
	
}
