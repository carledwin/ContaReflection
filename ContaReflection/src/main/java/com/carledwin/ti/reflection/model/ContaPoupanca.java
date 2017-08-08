package com.carledwin.ti.reflection.model;

public class ContaPoupanca extends ContaAbstract{

	private Double taxaRendimento;
	
	public ContaPoupanca(String string) {
		this.setString(string);
	}

	public Double getTaxaRendimento() {
		return taxaRendimento;
	}

	public void setTaxaRendimento(Double taxaRendimento) {
		this.taxaRendimento = taxaRendimento;
	}
}
