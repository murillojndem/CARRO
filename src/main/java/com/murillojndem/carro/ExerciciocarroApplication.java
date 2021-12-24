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
			double distancia;
			
			do {
				System.out.println("0 - Sair");
				System.out.println("1 - Ligar/Desligar o carro");
				System.out.println("2 - Passar a marcha");
				System.out.println("3 - Retornar a marcha");
				System.out.println("4 - Andar com o carro");
				System.out.println("5 - Acelerar");
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
						distancia = scan.nextInt();
						carroController.andarCarroController(distancia);
						break;
					}
					
					case 5 : {
						carroController.acelerarController();
						break;
					}
				}
			} while (opcaoEscolhida != 0);
		}
	}

}
