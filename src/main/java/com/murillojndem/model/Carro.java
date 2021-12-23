package com.murillojndem.model;

import com.murillojndem.model.enums.Direcao;
import com.murillojndem.model.enums.Marcha;

public class Carro {

	private String marca;
	private String modelo;
	private String placa;
	private boolean estado;
	private int tanque;
	private float velocidade;
	private Marcha marcha;
	private Direcao direcao;
	
	
	public Carro(String marca, String modelo, String placa, boolean estado, int tanque, float velocidade,
			com.murillojndem.model.enums.Marcha marcha, com.murillojndem.model.enums.Direcao direcao) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
		this.estado = estado;
		this.tanque = tanque;
		this.velocidade = velocidade;
		this.marcha = marcha;
		this.direcao = direcao;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	public int getTanque() {
		return tanque;
	}
	public void setTanque(int tanque) {
		this.tanque = tanque;
	}
	public float getVelocidade() {
		return velocidade;
	}
	public void setVelocidade(float velocidade) {
		this.velocidade = velocidade;
	}
	public com.murillojndem.model.enums.Marcha getMarcha() {
		return marcha;
	}
	public void setMarcha(com.murillojndem.model.enums.Marcha marcha) {
		this.marcha = marcha;
	}
	public com.murillojndem.model.enums.Direcao getDirecao() {
		return direcao;
	}
	public void setDirecao(com.murillojndem.model.enums.Direcao direcao) {
		this.direcao = direcao;
	}
	
}
