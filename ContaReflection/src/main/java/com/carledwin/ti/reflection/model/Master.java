package com.carledwin.ti.reflection.model;

import java.util.ArrayList;
import java.util.List;

public class Master {

	private List<ContaCorrente> contasCorrentes = new ArrayList<>();
	private List<ContaPoupanca> contasPoupancas = new ArrayList<>();
	
	public List<ContaCorrente> getContasCorrentes() {
		return contasCorrentes;
	}
	public void setContasCorrentes(List<ContaCorrente> contasCorrentes) {
		this.contasCorrentes = contasCorrentes;
	}
	
	public void addList(ContaAbstract conta) {
		
		if(conta.getClazz().getName().equals(ContaCorrente.class.getName())) {
			this.contasCorrentes.add((ContaCorrente) conta);
		}
		
		if(conta.getClazz().getName().equals(ContaPoupanca.class.getName())) {
			this.getContasPoupancas().add((ContaPoupanca) conta);
		}
	}
	public List<ContaPoupanca> getContasPoupancas() {
		return contasPoupancas;
	}
	public void setContasPoupancas(List<ContaPoupanca> contasPoupancas) {
		this.contasPoupancas = contasPoupancas;
	}
	
}
