package com.carledwin.ti.reflection.model;

public class ContaCorrente extends ContaAbstract{
	
	private Integer limite;
	
	public ContaCorrente(String string) {
		this.setString(string);
	}

	public Integer getLimite() {
		return limite;
	}

	public void setLimite(Integer limite) {
		this.limite = limite;
	}

}
