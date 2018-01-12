package br.com.alfonso.nba;
import java.util.Scanner;

public class Main {

	private static Scanner scanner = new Scanner(System.in);
	private static Temporada temporada = new Temporada();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Scanner scanner = new Scanner(System.in);
		System.out.print("Informe a temporada: ");
		String tmprd = scanner.nextLine();
		
		//Temporada temporada = new Temporada();
		temporada.setID(tmprd);
		
		System.out.print("Informe o nro de times que serão adicionados: ");
		String qtdeS = scanner.nextLine();
		int qtde = Integer.parseInt(qtdeS);
		
		//Time time = new Time();
		String aux = "";
		int auxN = 0;
		for (int tm = 0; tm < qtde; tm++) {
			auxN = tm +1;
			
			System.out.println("Dados do time "+auxN+": ");
			temporada = adicionarTime();
			
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
			opcao = opcao.toUpperCase();
			if (opcao.equals("1")) {
				adicionarTime();
			} else if (opcao.equals("2")) {
				removerTime();
			} else if (opcao.equals("3")) {
				listarTimes();
			}
		}
		
		scanner.close();
	}
	
	
	public static String getMenu() {
		
		String opcao = "";
		System.out.println("###### MENU ######");
		System.out.println("1 - Adicionar time");
		System.out.println("2 - Remover time");
		System.out.println("3 - Listar times");
		System.out.println("Q - Sair");
		System.out.println("##################");
		System.out.print("Informe uma opção: ");
		opcao = scanner.nextLine();
		
		return opcao;
	}
	
	public static Temporada adicionarTime() {
		
		//Scanner scanner = new Scanner(System.in);
		Time time = new Time();
		String aux = "";
		System.out.print("Informe o nome do time: ");
		aux = scanner.nextLine();
		time.setNome(aux);
		
		System.out.print("Informe a sigla do time: ");
		aux = scanner.nextLine();
		time.setSigla(aux);
		
		temporada.adicionarTimes(time);
		//scanner.close();
		
		return temporada;
	} 
	
	public static void listarTimes() {
		
		System.out.println();
		System.out.println("#### LISTA DE TIMES ####");
		System.out.println();
		temporada.getTimes().forEach(System.out::println);
		System.out.println();
		System.out.println("########################");
		System.out.println();
		
	}
	
	public static void removerTime() {
		String opcao = "";
		System.out.println();
		System.out.println("#### LISTA DE TIMES ####");
		System.out.println();
		temporada.getTimes().forEach(System.out::println);
		System.out.println();
		System.out.println("########################");
		System.out.println();
		System.out.print("Informe a sigla do time que será removido: ");
		opcao = scanner.nextLine();
		temporada.removerTimes(opcao);
	}

}
