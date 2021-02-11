package com.api.hearthstone.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.api.hearthstone.entidade.Carta;
import com.api.hearthstone.entidade.enums.EnumClasse;
import com.api.hearthstone.entidade.enums.EnumTipo;
import com.api.hearthstone.excecoes.CartaNaoExisteException;
import com.api.hearthstone.excecoes.MaximoDeCartasException;

@Repository
public class CartaRepository {
	
	private static Map<Integer, Carta> cartas = new HashMap<>();
	
	
	public List<Carta> consultarTodas() {
        return new ArrayList<Carta>(cartas.values());
    }
     
    public Carta consultarPorId(Integer id) throws CartaNaoExisteException {
        Carta carta=null;
    	if (cartas.containsKey(id)) {
        	carta = cartas.get(id);
        	return carta;
        } else {
        	throw new CartaNaoExisteException();
        }
        
    }
    
    public void deletarPorId(Integer id) throws CartaNaoExisteException {
    	if (cartas.containsKey(id)) {
    		cartas.remove(id);
    	} else {
    		throw new CartaNaoExisteException();
    	}
    }
    
    public void adicionarCarta(Carta carta) throws MaximoDeCartasException {
    	if (cartas.size() >= 30) {
    		throw new MaximoDeCartasException();
    	}
    	if (buscarCartasIguais(carta).size() >= 2) {
    		throw new MaximoDeCartasException();
    	}
    	if (carta.getId() == 0) {
    		carta.setId(gerarId(cartas.size() + 1));
    	}
    	cartas.put(carta.getId(), carta);
    }
    
    
    /**
     * Verifica se possui mais de duas cartas iguais no baralho
     * @param carta
     * @return {@link ArrayList}
     */
    public List<Carta> buscarCartasIguais(Carta carta) {
    	ArrayList<Carta> cartasIguais = new ArrayList<Carta>();
    	for (int i = 1; i <= cartas.size(); i++) {
    		if (cartas.get(i).getNome().contentEquals(carta.getNome()) ) {
    			cartasIguais.add(cartas.get(i));
    		}
    	}
    	return cartasIguais;
    }
    
    
    /**
     * auxilia no incremento de id's da entidade
     * @param cont
     * @return {@link Integer}
     */
    private int gerarId(int cont)
    {
        if(cartas.containsKey(cont))
            return gerarId(cont + 1);
        return cont;
    }
    
    
    @PostConstruct
	public void init() {
		cartas.put(01, new Carta(01, "Lâmina Vill Illidari", "Dervixe rodopiante de devastação demoníaca.", 5, 3, EnumTipo.CRIATURA, EnumClasse.DRUIDA));
		cartas.put(02, new Carta(02, "Lobo Silvestre", "As outras feras adoram ficar perto de lobos silvestres.", 1, 1, EnumTipo.CRIATURA, EnumClasse.CACADOR));
		cartas.put(03, new Carta(03, "Sinalizador", "Não só revela os inimigos, como também é ótimo para festas!.", 0, 0, EnumTipo.MAGIA, EnumClasse.CACADOR));
		cartas.put(04, new Carta(04, "Seta de Gelo", "É de praxe gritar 'Fica frio!' ou 'Estátua!' ou até 'Não esquenta!' quando se joga este card.", 0, 0, EnumTipo.MAGIA, EnumClasse.MAGO));
		cartas.put(05, new Carta(05, "Lady Liadrin", "Quando o assunto é feitiço, ela prefere os incunábulos mais cabulosos.", 4, 6, EnumTipo.MAGIA, EnumClasse.MAGO));
		cartas.put(06, new Carta(06, "Seta de Gelo", "É de praxe gritar 'Fica frio!' ou 'Estátua!' ou até 'Não esquenta!' quando se joga este card.", 0, 0, EnumTipo.CRIATURA, EnumClasse.PALADINO));
	}

}
