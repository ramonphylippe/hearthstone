package com.api.hearthstone.entidade.enums;

public enum EnumClasse {
	
	MAGO("Mago"),
	PALADINO("Paladino"),
	CACADOR("Caçador"),
	DRUIDA("Druida"),
	QUALQUER("Qualquer");
	
	
	private String descricao;
	
	
	EnumClasse(String descricao) {
		this.setDescricao(descricao);
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
