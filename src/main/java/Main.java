import java.util.Scanner;

import br.com.alfonso.nba.Temporada;
import br.com.alfonso.nba.Time;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.print("Informe a temporada: ");
		String tmprd = scanner.nextLine();
		
		Temporada temporada = new Temporada();
		temporada.setID(tmprd);
		
		System.out.print("Informe o nro de times que serão adicionados: ");
		String qtdeS = scanner.nextLine();
		int qtde = Integer.parseInt(qtdeS);
		
		//Time time = new Time();
		String aux = "";
		//int auxN = 0;
		for (int tm = 0; tm < qtde; tm++) {
			/*
			time = new Time();
			
			auxN = tm +1;
			System.out.print("Informe o nome do time "+auxN+": ");
			aux = scanner.nextLine();
			time.setNome(aux);
			
			System.out.print("Informe a sigla do time "+auxN+": ");
			aux = scanner.nextLine();
			time.setSigla(aux);
			
			temporada.adicionarTimes(time);
			*/
			
			temporada = adicionarTime(temporada);
			
			System.out.print("Informe a letra Q para sair ou qualquer tecla para continuar: ");
			aux = scanner.nextLine();
			aux = aux.toUpperCase();
			if (aux.equals("Q")) {
				System.exit(0);
			}
		}
		
		String opcao = "";
		while (!opcao.equals("Q")) {
			opcao = getMenu();
			opcao = scanner.nextLine();
			opcao = opcao.toUpperCase();
		}
		
		scanner.close();
	}
	
	
	public static String getMenu() {
		
		String opcao = "";
		System.out.println("###### MENU ######");
		System.out.println("1 - Adicionar time");
		System.out.println("2 - Remover time");
		System.out.println("3 - Remover time");
		System.out.println("Q - Sair");
		System.out.println("##################");
		System.out.print("Informe uma opção: ");
		
		return opcao;
	}
	
	public static Temporada adicionarTime(Temporada temporada) {
		
		Scanner scanner = new Scanner(System.in);
		Time time = new Time();
		String aux = "";
		System.out.print("Informe o nome do time: ");
		aux = scanner.nextLine();
		time.setNome(aux);
		
		System.out.print("Informe a sigla do time: ");
		aux = scanner.nextLine();
		time.setSigla(aux);
		
		temporada.adicionarTimes(time);
		scanner.close();
		
		return temporada;
	} 

}
