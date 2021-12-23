package com.murillojndem.model.enums;

public enum Marcha {

	RE,
	PONTOMORTO,
	PRIMEIRA,
	SEGUNDA,
	TERCEIRA,
	QUARTA,
	QUINTA,
	SEXTA;
	
			
	
	private static Marcha[] valores = values();
	
	public Marcha getNextMarcha() {
		return valores[(this.ordinal() + 1) % valores.length];
	}
	
	public Marcha getPreviousMarcha() {
		return valores[(this.ordinal() - 1) % valores.length];
	}
	
}

	
	
	
	
	
	
	

