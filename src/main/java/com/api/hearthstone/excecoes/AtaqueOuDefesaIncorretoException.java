package com.api.hearthstone.excecoes;

public class AtaqueOuDefesaIncorretoException extends Exception{

	private static final long serialVersionUID = 1L;

	public AtaqueOuDefesaIncorretoException(Exception e) {
		super(e);
	}
	
	public AtaqueOuDefesaIncorretoException(String msg) {
		super(msg);
	}
	
	public AtaqueOuDefesaIncorretoException() {
		super("Valores de ataque e/ou defesa fora do limite permitido");
	}
}
