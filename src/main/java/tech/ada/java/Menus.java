package tech.ada.java;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import tech.ada.dao.RegistroDao;
import tech.ada.processor.RegistroProcessor;

public class Menus {

	
	private RegistroProcessor processor = new RegistroProcessor();
	
	private int um = 1;
	private int zero = 0;
	

	
	public void menuApp(int opcao) {
				
		switch (opcao) {
		case 1: {

			List<RegistroDao> listaRegistros = processor.read();
			processor.totalRegistros(listaRegistros);
			apresentacaoApp();
			break;
			
		}
		case 2: {

			List<RegistroDao> listaRegistros = processor.read();

			processor.listaDistritos(listaRegistros);
			apresentacaoOp2();
			int opcao2 = processor.obterEntrada();

			while (opcao2 != 0) {
				if (opcao2 == 1) {
					processor.listaDistritosPorEstado(listaRegistros);
					apresentacaoOp2();
					opcao2 = processor.obterEntrada();
				} else {
					opcaoInvalida();
					opcao2 = processor.obterEntrada();
					apresentacaoOp2();
				}
			}
			apresentacaoApp();
			break;
		}
		case 3: {

			List<RegistroDao> listaRegistros = processor.read();

			processor.censoEscolas(listaRegistros);
			apresentacaoOp3();
			int opcao2 = processor.obterEntrada();

			while (opcao2 != 0) {
				if (opcao2 == 1) {
					processor.listaEscolasEstado(listaRegistros);
					apresentacaoOp3();
					opcao2 = processor.obterEntrada();
				} else {
					opcaoInvalida();
					opcao2 = processor.obterEntrada();
					apresentacaoOp3();
				}
			}
			apresentacaoApp();
			break;
		}
		case 4: {

			List<RegistroDao> listaRegistros = processor.read();

			processor.statusEscolas(listaRegistros);
			apresentacaoOp2();
			int opcao2 = processor.obterEntrada();

			while (opcao2 != 0) {
				if (opcao2 == 1) {
					processor.listaStatusEstado(listaRegistros);
					apresentacaoOp2();
					opcao2 = processor.obterEntrada();
				} else {
					opcaoInvalida();
					opcao2 = processor.obterEntrada();
					apresentacaoOp2();
				}
			}
			apresentacaoApp();
			break;
		}
		case 0: {
			opcaoSair();			
		}
        default:
            opcaoInvalida();
            break;
		}
		
	}
	
	public void opcaoInvalida(){
        System.out.println("Opção INVÁLIDA. Tente novamente.");
    }
	
	public void opcaoSair(){
        System.out.println("Obrigado !");
    }
	
	public void returnMenu(){
		System.out.println("========= Menu de opções =========");
		System.out.println("Retornar : 0");
    }
	
//	public void apresentacaoInicial() {
//		System.out.println("========= Menu de opções =========");
//		System.out.println("Ler arquivo : 1");
//		System.out.println("Sair : 0");
//	}

	
	public void apresentacaoOp2() {
		System.out.println("========= Menu de opções =========");
		System.out.println("Listar distritos por estado : 1");
		System.out.println("Retornar : 0");
	}
	
	
	public void apresentacaoOp3() {
		System.out.println("========= Menu de opções =========");
		System.out.println("Listar escolas por estado : 1");
		System.out.println("Retornar : 0");
	}
	
	
	public void apresentacaoOp4() {
		System.out.println("========= Menu de opções =========");
		System.out.println("Status escolas por estado : 1");
		System.out.println("Retornar : 0");
	}
	
	
	
	public void apresentacaoApp() {
		System.out.println("==================================");
		System.out.println("============ Menu App ============");
		System.out.println("==================================");
		System.out.println("Total de Registros ------------- 1");
		System.out.println("Listar estados avaliados ------- 2");
		System.out.println("Censo das escolas -------------- 3");
		System.out.println("Status das escolas ------------- 4");
		System.out.println("Sair : 0");
	}
}
