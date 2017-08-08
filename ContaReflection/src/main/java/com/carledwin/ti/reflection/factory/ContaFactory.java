package com.carledwin.ti.reflection.factory;

import com.carledwin.ti.reflection.model.ContaAbstract;
import com.carledwin.ti.reflection.model.ContaCorrente;
import com.carledwin.ti.reflection.model.ContaPoupanca;

public class ContaFactory {

	private static final String CORRENTE = "8765";
	private static final String POUPANCA = "0987";

	public static ContaAbstract getInstance(String string) {
		ContaAbstract retorno = null;
		switch (getTipo(string)) {
		case CORRENTE:
			retorno  = new ContaCorrente(string);
			break;

		case POUPANCA:
			retorno = new ContaPoupanca(string);
			break;

		default:
			retorno = null;
		}
		
		return retorno;
	}

	private static String getTipo(String string) {
		return string.substring(2, 6);
	}

}
