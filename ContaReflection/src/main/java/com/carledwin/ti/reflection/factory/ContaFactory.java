package com.carledwin.ti.reflection.factory;

import com.carledwin.ti.reflection.model.ContaAbstract;
import com.carledwin.ti.reflection.model.ContaCorrente;
import com.carledwin.ti.reflection.model.ContaPoupanca;

public class ContaFactory extends ContaAbstract{

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

}
