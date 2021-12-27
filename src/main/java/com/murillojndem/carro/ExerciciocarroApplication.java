package com.murillojndem.carro;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.murillojndem.controller.CarroController;

@SpringBootApplication
public class ExerciciocarroApplication {

	public static void main(String[] args) {
		
		CarroController carroController = new CarroController();
		try (Scanner scan = new Scanner(System.in)) {
			int opcaoEscolhida;
			double auxiliar;
			
			do {
				System.out.println("\n0 - Sair");
				System.out.println("1 - Ligar/Desligar o carro");
				System.out.println("2 - Passar a marcha");
				System.out.println("3 - Retornar a marcha");
				System.out.println("4 - Andar com o carro");
				System.out.println("5 - Acelerar + 10 km");
				System.out.println("6 - Desacelerar - 10 km");
				System.out.println("7 - Parar carro");
				System.out.println("8 - Abastecer carro");
				opcaoEscolhida = scan.nextInt();
				
				switch(opcaoEscolhida) {
					case 1 : {
						carroController.ligarCarroController();
						break;
					}
					case 2 : {
						carroController.passarMarchaController();
						break;
					}
					
					case 3 : {
						carroController.voltarMarchaController();
						break;
					}
					
					case 4 : {
						
						System.out.println("Digite quantos quilometros quer andar:");
						auxiliar = scan.nextInt();
						carroController.andarCarroController(auxiliar);
						break;
					}
					
					case 5 : {
						carroController.acelerarController();
						break;
					}
					
					case 6 : {
						carroController.desacelerarController();
						break;
					}
					
					case 7 : {
						carroController.pararCarroController();
						break;
					}
					
					case 8 : {
						System.out.println("Digite quantos litros quer abastecer:");
						auxiliar = scan.nextInt();
						carroController.abastecerCarroController(auxiliar);
						break;
					}
				}
			} while (opcaoEscolhida != 0);
		}
	}

}
