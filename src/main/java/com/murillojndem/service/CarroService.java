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
	
	public void consomeCombustivel(double distancia) {
		double combustivelConsumido = distancia * 0.1;
		carro.setTanque(carro.getTanque() - combustivelConsumido);
		System.out.println("\nO tanque do carro agora contem " + carro.getTanque() + " litros de combustivel\n");
	}
	
	public void abasteceCombustivel(int quantidade) {
		
		if (faltaNoTanque(quantidade) > 50) {
			double faltaNoTanque = 50 - carro.getTanque();
			System.out.println("\nO tanque de combustivel esta com " + carro.getTanque() + "litros. Voce so pode abastecer mais " + faltaNoTanque + "\n");
		} else {
			carro.setTanque(carro.getTanque() + quantidade);
			System.out.println("\nO tanque tem " + carro.getTanque() + " litros\n");
		}
	}

	private double faltaNoTanque(int quantidade) {
		return carro.getTanque() + quantidade;
	}

	public void andarCarroService(double distancia) {
		if(carro.getMarcha() == Marcha.PONTOMORTO) {
			setDirecao();
			System.out.println("\nA marcha esta em ponto morto, o carro nao anda\n");
		}else if(carro.getMarcha() == Marcha.RE) {
			consomeCombustivel(distancia);
			System.out.println("\nO carro andou " + distancia + " km, andando para " + carro.getDirecao() + ".\n");
		}else {
			consomeCombustivel(distancia);
			setDirecao();
			System.out.println("\nO carro andou " + distancia + " km, andando para " + carro.getDirecao() + ".\n");
		}
	}
	
	public void setDirecao() {
		if(carro.getMarcha() == Marcha.PONTOMORTO && carro.getVelocidade() == 0) {
			carro.setDirecao(Direcao.PARADO);
		}else if(carro.getMarcha() == Marcha.RE && carro.getVelocidade() != 0) {
			carro.setDirecao(Direcao.TRAS);
		} else if((carro.getMarcha() != Marcha.PONTOMORTO && carro.getMarcha() != Marcha.RE) && carro.getVelocidade() > 0){
			carro.setDirecao(Direcao.FRENTE);
		}
	}
	
	public void setVelocidade(double velocidade) {
		carro.setVelocidade(velocidade);
	}
	
	public void acelerarService() {
		setVelocidade(carro.getVelocidade() + 10);
		System.out.println("\nA velocidade agora e: " + carro.getVelocidade() + " km/h\n");
	}
	
}
