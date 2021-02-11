package com.api.hearthstone.excecoes;

public class CartaNaoExisteException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public CartaNaoExisteException(Exception e) {
		super(e);
	}
	
	public CartaNaoExisteException(String msg) {
		super(msg);
	}
	
	public CartaNaoExisteException() {
		super("Carta não existe");
	}

}
