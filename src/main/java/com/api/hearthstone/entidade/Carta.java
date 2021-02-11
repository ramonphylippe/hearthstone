package com.api.hearthstone.entidade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import com.api.hearthstone.entidade.enums.EnumClasse;
import com.api.hearthstone.entidade.enums.EnumTipo;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Carta {
	
	private int id;
	
	private String nome;
	
	private String descricao;
	
	private int ataque;
	
	private int defesa;
	
	private EnumTipo tipo;
	
	private EnumClasse classe;
	
}