package com.api.hearthstone.excecoes;

public class MaximoDeCartasException extends Exception {

	private static final long serialVersionUID = 1L;

	public MaximoDeCartasException(Exception e) {
		super(e);
	}
	
	public MaximoDeCartasException(String msg) {
		super(msg);
	}
	
	public MaximoDeCartasException() {
		super("Limite de cartas no baralho");
	}
}
