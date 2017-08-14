package com.carledwin.ti.reflection.model;

import java.lang.reflect.Field;
import java.math.BigDecimal;

import com.carledwin.ti.reflection.annotations.Limite;
import com.carledwin.ti.reflection.factory.exceptions.LimiteInvalidoException;
import com.carledwin.ti.reflection.factory.exceptions.LimiteNaoInformadoException;

public class ContaCorrente extends ContaAbstract {

	@Limite(limiteMaximo = "12500.00")
	private BigDecimal limite;

	public ContaCorrente(String string) {
		this.setString(string);
	}

	public BigDecimal getLimite() {
		return limite;
	}

	public void setLimite(BigDecimal limite) {
		this.limite = limite;
	}

	public boolean validaLimite() throws NoSuchFieldException, SecurityException {
		
		boolean result = false;
		
		if (this.limite != null) {

			Class<ContaCorrente> clazz = ContaCorrente.class;
			Field field = clazz.getDeclaredField("limite");

			if (field.isAnnotationPresent(Limite.class)) {

				Limite annotationLimite = field.getAnnotation(Limite.class);

				BigDecimal limiteMaximo = new BigDecimal(annotationLimite.limiteMaximo());

				if (this.limite.compareTo(limiteMaximo) == 1) {

					throw new LimiteInvalidoException("Limite acima do valor permitido.");
				}else {
					result = true;
				}
			}
		} else {
			throw new LimiteNaoInformadoException("Limite não informado.");
		}
		
		return result;
	}
}
