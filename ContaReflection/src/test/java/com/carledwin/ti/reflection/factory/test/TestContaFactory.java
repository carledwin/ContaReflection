package com.carledwin.ti.reflection.factory.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.carledwin.ti.reflection.factory.ContaFactory;
import com.carledwin.ti.reflection.model.ContaAbstract;
import com.carledwin.ti.reflection.model.ContaCorrente;
import com.carledwin.ti.reflection.model.ContaPoupanca;

public class TestContaFactory {

	
	@Test
	public void testaTipoInstance(){
		
		ContaAbstract contaCorrente = ContaFactory.getInstance("xx8765Correntexxxxxx");
		ContaAbstract contaPoupanca = ContaFactory.getInstance("xx0987Poupancaxxxxxx");
		
		Class<? extends ContaAbstract> corrente = contaCorrente.getClass();
		Class<? extends ContaAbstract> poupanca = contaPoupanca.getClass();
		
			assertTrue(corrente.getName().equals(ContaCorrente.class.getName()));
			assertTrue(poupanca.getName().equals(ContaPoupanca.class.getName()));
		
	}
}
