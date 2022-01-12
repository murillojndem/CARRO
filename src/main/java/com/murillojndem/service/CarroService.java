package com.murillojndem.service;

import com.murillojndem.model.Carro;
import com.murillojndem.model.enums.Direcao;
import com.murillojndem.model.enums.Marcha;

public class CarroService {
	private Carro carro = new Carro("Chevrolet", "Onix", "ASD-1234", false, 50, 0, Marcha.PONTOMORTO, Direcao.PARADO);

	public void ligarCarroService() {
		if (!carro.getEstado()) {
			carro.setEstado(true);
			System.out.println("\nCarro esta ligado");
		} else {
			carro.setEstado(false);
			System.out.println("\nCarro esta desligado");
		}
	}

	public void passarMarchaService() {
		if (checarEstado()) {
			if (checarMarcha() != Marcha.SEXTA) {
				Marcha novaMarcha = carro.getMarcha().getNextMarcha();
				carro.setMarcha(novaMarcha);
				System.out.println("\nMarcha atual: " + carro.getMarcha());
			} else {
				System.out.println("\nMarcha maxima, voce nao pode passar da SEXTA marcha");
			}
		} else {
			System.out.println("\nO carro esta desligado");
		}
	}

	public void voltarMarchaService() {
		if (checarEstado()) {
			if (checarMarcha() != Marcha.RE) {
				Marcha novaMarcha = carro.getMarcha().getPreviousMarcha();
				carro.setMarcha(novaMarcha);
				System.out.println("\nMarcha atual: " + carro.getMarcha());
			} else {
				System.out.println("\nMarcha minima, voce nao pode passar da marcha re");
			}
		} else {
			System.out.println("\nO carro esta desligado");
		}
	}

	public Marcha checarMarcha() {
		return carro.getMarcha();
	}

	public boolean checarEstado() {
		return carro.getEstado();
	}

	public void consumirCombustivel(double distancia) {
		double combustivelConsumido = distancia * 0.1;
		carro.setTanque(carro.getTanque() - combustivelConsumido);
		System.out.println("\nO tanque do carro agora contem " + carro.getTanque() + " litros de combustivel.");
		checaEstadoTanque();
	}

	public void abastecerCombustivel(double quantidade) {
		if (faltaNoTanque(quantidade) > 50) {
			double faltaNoTanque = 50 - carro.getTanque();
			System.out.println("\nVoce so pode abastecer mais " + faltaNoTanque + " litros.");
		} else {
			carro.setTanque(carro.getTanque() + quantidade);
			System.out.println("\nO tanque tem " + carro.getTanque() + " litros");
		}
	}
	
	private void checaEstadoTanque() {
		if(carro.getTanque() <= 10) {
			System.out.println("\nTanque esta na reserva");
		} else if(carro.getTanque() <= 25) {
			System.out.println("\nTanque esta na metade");
		}
	}

	private double faltaNoTanque(double quantidade) {
		return carro.getTanque() + quantidade;
	}

	private boolean checarCombustivel(double distancia) {
		double autonomia = carro.getTanque() * 10;
		if (autonomia >= distancia) {
			return true;
		} else {
			return false;
		}
	}

	public void andarCarroService(double distancia) {
		if (carro.getVelocidade() != 0) {
			if (checarEstado()) {
				if (checarCombustivel(distancia)) {
					if (carro.getMarcha() == Marcha.PONTOMORTO) {
						setDirecao();
						System.out.println("\nA marcha esta em ponto morto, o carro nao anda");
					} else if (carro.getMarcha() == Marcha.RE) {
						setDirecao();
						consumirCombustivel(distancia);
						System.out.println(
								"\nO carro andou " + distancia + " km, andando para " + carro.getDirecao() + ".");
					} else {
						consumirCombustivel(distancia);
						setDirecao();
						System.out.println(
								"\nO carro andou " + distancia + " km, andando para " + carro.getDirecao() + ".");
					}
				} else
					System.out.println("\nO tanque tem apenas " + carro.getTanque() + " litros, voce so pode andar "
							+ (carro.getTanque() * 10) + " km");
			} else
				System.out.println("\nCarro esta desligado");
		} else
			System.out.println("\nAcelere pra andar com o carro");
	}

	public void setDirecao() {
		if (carro.getMarcha() == Marcha.PONTOMORTO && carro.getVelocidade() == 0) {
			carro.setDirecao(Direcao.PARADO);
		} else if (carro.getMarcha() == Marcha.RE) {
			carro.setDirecao(Direcao.TRAS);
		} else
			carro.setDirecao(Direcao.FRENTE);
	}

	public void setVelocidade(double velocidade) {
		carro.setVelocidade(velocidade);
	}

	public void acelerarService() {
		if (checaVelocidadeMaxima()) {
			if (checarEstado() && carro.getMarcha() != Marcha.PONTOMORTO) {
				setVelocidade(carro.getVelocidade() + 10);
				andarCarroService(0.5);
				System.out.println("\nA velocidade agora e: " + carro.getVelocidade() + " km/h");
				contarGiro();
				if (carro.getContaGiro() == 3) {
					System.out.println("\nPode passar a marcha");
				}
			} else
				System.out.println("\nCarro esta desligado ou em ponto morto");
		} else
			System.out.println("\nCarro chegou na velocidade maxima");
	}
	
	public boolean checaVelocidadeMaxima() {
		if(carro.getVelocidade() < 120) {
			return true;
		}
		else return false;
	}

	public void desacelerarService() {
		if (checarEstado() && carro.getMarcha() != Marcha.PONTOMORTO) {
			if (carro.getVelocidade() > 0) {
				setVelocidade(carro.getVelocidade() - 10);
				andarCarroService(0.5);
				System.out.println("\nA velocidade agora e: " + carro.getVelocidade() + " km/h");
				contarGiro();
				if(carro.getContaGiro() == 2)
				{
					System.out.println("\nPode reduzir a marcha");
				}
			} else
				System.out.println("\nColoque em marcha re para andar pra tras");
		} else
			System.out.println("\nCarro esta desligado ou em ponto morto");
	}

	public void contarGiro() {
		double velocidade = carro.getVelocidade();
		if ((velocidade == 10 || velocidade == 30 || velocidade == 50 || velocidade == 70 || velocidade == 90
				|| velocidade == 110) && carro.getMarcha() != Marcha.RE) {
			carro.setContaGiro(2);
			System.out.println("\nValor do conta giro: " + carro.getContaGiro());
		} else if ((velocidade == 20 || velocidade == 40 || velocidade == 60 || velocidade == 80 || velocidade == 100) && carro.getMarcha() != Marcha.RE) {
			carro.setContaGiro(3);
			System.out.println("\nValor do conta giro: " + carro.getContaGiro());
		}
	}

	public void pararCarroService() {
		andarCarroService(0.5);
		carro.setDirecao(Direcao.PARADO);
		carro.setVelocidade(0);
		System.out.println("\nA velocidade agora e: " + carro.getVelocidade() + " km/h");
	}
}
