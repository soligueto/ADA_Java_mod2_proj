package tech.ada.processor;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import tech.ada.dao.RegistroDao;
import tech.ada.java.Menus;
import tech.ada.read.Read;

public class RegistroProcessor {

	private Scanner scanner = null;
			
	public int obterEntrada() {
		scanner = new Scanner(System.in);
		int opcao = scanner.nextInt();
		return opcao;
	}

	public void iniciar() {

		Menus menu = new Menus();

		int sair = 0;
		menu.apresentacaoApp();

		int opcaoDigitada = obterEntrada();

		while (opcaoDigitada != 0) {
			menu.menuApp(opcaoDigitada);
			opcaoDigitada = obterEntrada();
			if (opcaoDigitada == sair) {
				menu.opcaoSair();
			}
		}
	}

	public List<RegistroDao> read() {
		List<RegistroDao> listaRegistro = null;
		Read leitor = new Read();

		try {
			listaRegistro = leitor.reader();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return listaRegistro;
	}

	public void totalRegistros(List<RegistroDao> listaRegistros) {

		long count = 0;

		count = listaRegistros.size();
		System.out.println("=============================");
		System.out.println("Total de registros : " + count);
		System.out.println("=============================");
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}

	public void listaDistritos(List<RegistroDao> listaRegistros) {

		List<String> listaEstados = new ArrayList<>();

		for (RegistroDao registroDao : listaRegistros) {

			listaEstados.add(registroDao.getUf());

		}

		Set<String> set = new LinkedHashSet<>(listaEstados);
		List<String> listaFinal = new ArrayList<>(set);

		for (String estado : listaFinal) {

			System.out.println("Estado : " + estado);

		}

	}

//	
//	
//	
	public void listaDistritosPorEstado(List<RegistroDao> listaRegistros) {


		System.out.println("Digite o estado desejado : ");

		scanner = new Scanner(System.in);
		String opcao = scanner.nextLine();

		int count = 0;

		for (RegistroDao registroDao : listaRegistros) {

			if (registroDao.getUf().contains(opcao)) {
				count++;
			}
		}

		System.out.println("O Estado de " + opcao + " contém : " + count + " distritos");

	}

	public void censoEscolas(List<RegistroDao> listaRegistros) {

		List<String> listaEstados = new ArrayList<>();

		for (RegistroDao registroDao : listaRegistros) {

			listaEstados.add(registroDao.getDep());

		}

		Set<String> set = new LinkedHashSet<>(listaEstados);
		List<String> listaFinal = new ArrayList<>(set);

		System.out.println("========= Tipos de escolas =========");
		for (String tipoEscola : listaFinal) {
			
			System.out.println("Escolas : " + tipoEscola);

		}
		System.out.println("====================================");
	}
	
	
//	
//	
//	
	public void listaEscolasEstado(List<RegistroDao> listaRegistros) {

		System.out.println("Digite o estado desejado : ");

		scanner = new Scanner(System.in);
		String opcao = scanner.nextLine();

		int count = 0;

		int municipalCount = 0;
		int estadualCount = 0;
		int particularCount = 0;
		int federalCount = 0;
		
		
		for (RegistroDao registroDao : listaRegistros) {


			
			if (registroDao.getUf().contains(opcao)) {
				
				switch (registroDao.getDep()) {
					case "Municipal" : {
						municipalCount++;
						break;
					}
					case "Estadual": {
						estadualCount++;
						break;
					}
					case "Particular": {
						particularCount++;
						break;
					}
					case "Federal": {
						federalCount++;
						break;
					}
				default:
					throw new IllegalArgumentException("Unexpected value: " + registroDao);
				}
			}
			count++;
		}
		System.out.println("========================================================");
		System.out.println("O Estado de " + opcao + " contém : " + count + " escolas");
		System.out.println("Municipais   : " + municipalCount);
		System.out.println("Estaduais    : " + estadualCount);		
		System.out.println("Particulares : " + particularCount);
		System.out.println("Federais     : " + particularCount);
		System.out.println("========================================================");
		
	}

	public void statusEscolas(List<RegistroDao> listaRegistros) {

		List<String> listaEstados = new ArrayList<>();

		for (RegistroDao registroDao : listaRegistros) {

			listaEstados.add(registroDao.getCodFuncionamento());

		}

		Set<String> set = new LinkedHashSet<>(listaEstados);
		List<String> listaFinal = new ArrayList<>(set);

		System.out.println("========= Status Existentes =========");
		for (String estado : listaFinal) {

			System.out.println("Status : " + estado);

		}
		System.out.println("=====================================");
	}
	
	public void listaStatusEstado(List<RegistroDao> listaRegistros) {

		System.out.println("Digite o estado desejado : ");

		scanner = new Scanner(System.in);
		String opcao = scanner.nextLine();

		int count = 0;

		int ativoCount = 0;
		int extintoCount = 0;
		int paralisadoCount = 0;

		
		
		for (RegistroDao registroDao : listaRegistros) {


			
			if (registroDao.getUf().contains(opcao)) {
				
				switch (registroDao.getCodFuncionamento()) {
					case "Ativo" : {
						ativoCount++;
						break;
					}
					case "Extinto": {
						extintoCount++;
						break;
					}
					case "Paralisado": {
						paralisadoCount++;
						break;
					}
				default:
					throw new IllegalArgumentException("Unexpected value: " + registroDao);
				}
			}
			count++;
		}
		System.out.println("========================================================");
		System.out.println("O Estado de " + opcao + " contém : " + count + " escolas");
		System.out.println("Ativo      : " + ativoCount);
		System.out.println("Extinto    : " + extintoCount);		
		System.out.println("Paralisado : " + paralisadoCount);
		System.out.println("========================================================");
		
	}
}
