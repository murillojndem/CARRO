package com.murillojndem.service;

import com.murillojndem.model.Carro;
import com.murillojndem.model.enums.Direcao;
import com.murillojndem.model.enums.Marcha;

public class CarroService {
	private Carro carro = new Carro(
			"Chevrolet",
			"Onix", 
			"ASD-1234", 
			false, 
			50, 
			0, 
			Marcha.PONTOMORTO, 
			Direcao.PARADO);
	
	
	
	public void ligarCarroService() {
		if (carro.getEstado() == false) {
			carro.setEstado(true);
			
			System.out.println("\nCarro esta ligado\n");
		} else { 
			carro.setEstado(false);
			System.out.println("\nCarro esta desligado\n");
		}		
	}

	public void passarMarchaService() {
		if (checkEstado()) {			
			if (checkMarcha() != Marcha.SEXTA) {
				Marcha novaMarcha = carro.getMarcha().getNextMarcha();
				carro.setMarcha(novaMarcha);
				System.out.println("\nMarcha atual: " + carro.getMarcha() + "\n");
			} else {
				System.out.println("\nMarcha maxima, voce nao pode passar da SEXTA marcha\n");
			} 
		} else {
			System.out.println("\nO carro esta desligado\n");
		}
	}	

	public void voltarMarchaService() {
		if (checkEstado()) {			
			if (checkMarcha() != Marcha.RE) {
				Marcha novaMarcha = carro.getMarcha().getPreviousMarcha();
				carro.setMarcha(novaMarcha);
				System.out.println("\nMarcha atual: " + carro.getMarcha() + "\n");
			} else {
				System.out.println("\nMarcha minima, voce nao pode passar da marcha re\n");
			} 
		} else {
			System.out.println("\nO carro esta desligado\n");
		}
	}
	
	
	public Marcha checkMarcha() {
		return carro.getMarcha();
	}
	
	public boolean checkEstado() {
		return carro.getEstado();
	}
	
}
