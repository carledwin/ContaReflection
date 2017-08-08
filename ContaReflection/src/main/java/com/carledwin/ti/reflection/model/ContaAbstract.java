package com.carledwin.ti.reflection.model;

public class ContaAbstract {

	protected static final String CORRENTE = "8765";
	protected static final String POUPANCA = "0987";
	
	private String string;
	private String tipo;
	private Integer agencia;
	private Integer numero;
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public Class<? extends ContaAbstract> getClazz(){
		return this.getClass();
	}
	
	public static String getTipo(String string) {
		return string.substring(2, 6);
	}

	public Integer getAgencia() {
		return agencia;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
}
