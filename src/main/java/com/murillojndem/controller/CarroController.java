package com.murillojndem.controller;

import com.murillojndem.service.CarroService;

public class CarroController {
	private CarroService carroService = new CarroService();
	
	public void ligarCarroController() {
		carroService.ligarCarroService();
	}
	
	public void passarMarchaController() {
		carroService.passarMarchaService();
	}
	
	public void voltarMarchaController() {
		carroService.voltarMarchaService();
	}

	

}