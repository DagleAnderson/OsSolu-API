package com.solutech.soluos.exceptionhandler;

public class InputValidation {

	private String name;
	private String mensage;

	public InputValidation(String name, String mensage) {
		this.name = name;
		this.mensage = mensage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMensage() {
		return mensage;
	}

	public void setMensage(String mensage) {
		this.mensage = mensage;
	}

}
