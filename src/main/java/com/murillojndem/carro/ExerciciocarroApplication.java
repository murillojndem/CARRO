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
			
			do {
				System.out.println("0 - Sair");
				System.out.println("1 - Ligar/Desligar o carro");
				System.out.println("2 - Passar a marcha");
				System.out.println("3 - Retornar a marcha");
				opcaoEscolhida = scan.nextInt();
				
				//comentario
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
					}
				}
			} while (opcaoEscolhida != 0);
		}
	}

}
