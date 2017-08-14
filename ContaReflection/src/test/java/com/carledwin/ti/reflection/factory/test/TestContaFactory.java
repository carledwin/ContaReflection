package com.carledwin.ti.reflection.factory.test;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

import com.carledwin.ti.reflection.factory.ContaFactory;
import com.carledwin.ti.reflection.factory.exceptions.LimiteInvalidoException;
import com.carledwin.ti.reflection.factory.exceptions.LimiteNaoInformadoException;
import com.carledwin.ti.reflection.model.ContaAbstract;
import com.carledwin.ti.reflection.model.ContaCorrente;
import com.carledwin.ti.reflection.model.ContaPoupanca;
import com.carledwin.ti.reflection.model.Master;

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
	
	@Test
	public void testaPopulaListaMaster(){
		
		Master master = new Master();
		
		ContaAbstract contaCorrente = (ContaCorrente) ContaFactory.getInstance("xx8765Correntexxxxxx");
		int numeroContaCorrente = 1234;
		contaCorrente.setNumero(numeroContaCorrente);
		
		ContaAbstract contaPoupanca = (ContaPoupanca) ContaFactory.getInstance("xx0987Poupancaxxxxxx");
		int numeroContaPoupanca = 78855;
		contaPoupanca.setNumero(numeroContaPoupanca);
		master.addList(contaCorrente);
		master.addList(contaPoupanca);
		
			for(ContaCorrente corrente : master.getContasCorrentes()) {
				assertTrue("Numero de conta corrente correto:  " + corrente.getNumero(), numeroContaCorrente == corrente.getNumero());
				System.out.println("Conta CORRENTE numero: " + corrente.getNumero());
			}
			
			for(ContaPoupanca poupanca: master.getContasPoupancas()) {
				assertTrue("Numero de conta poupanca correto:  " + poupanca.getNumero(), numeroContaPoupanca == poupanca.getNumero());
				System.out.println("Conta POUPANCA numero: " + poupanca.getNumero());
			}
	}
	
	@Test(expected = LimiteInvalidoException.class)
	public void testaLimiteAcimaDoPermitido() throws NoSuchFieldException, SecurityException {
		ContaCorrente contaCorrente =  (ContaCorrente) ContaFactory.getInstance("ss8765rfrd");
		contaCorrente.setLimite(new BigDecimal("12500.01"));
		contaCorrente.validaLimite();
	}
	
	@Test
	public void testaLimiteValido() throws NoSuchFieldException, SecurityException {
		ContaCorrente contaCorrente =  (ContaCorrente) ContaFactory.getInstance("ss8765rfrd");
		contaCorrente.setLimite(new BigDecimal("12500.00"));
		assertTrue(contaCorrente.validaLimite());
	}
	
	@Test(expected = LimiteNaoInformadoException.class)
	public void testaLimiteNaoInformado() throws NoSuchFieldException, SecurityException {
		ContaCorrente contaCorrente =  (ContaCorrente) ContaFactory.getInstance("ss8765rfrd");
		assertTrue(contaCorrente.validaLimite());
	}
}
