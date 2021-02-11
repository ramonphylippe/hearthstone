package com.api.hearthstone.entidade.enums;

public enum EnumTipo {
	
	MAGIA("Magia"),
	CRIATURA("Criatura");
	
	
	private String descricao;
	
	
	EnumTipo(String descricao) {
		this.setDescricao(descricao);
	}
	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	

}