package com.api.hearthstone.service;

import java.util.List;

import javax.ws.rs.core.Response;


import com.api.hearthstone.entidade.Carta;
import com.api.hearthstone.excecoes.CartaNaoExisteException;
import com.api.hearthstone.excecoes.MaximoDeCartasException;
import com.api.hearthstone.repository.CartaRepository;


public class CartaServiceImpl implements CartaService {
	
	private CartaRepository cartaRepository;

	
	public CartaServiceImpl(CartaRepository repository) {
		this.cartaRepository = repository;
	}

	@Override
	public List<Carta> buscarTodas() {
		return cartaRepository.consultarTodas();
	}

	@Override
	public Response buscarPorId(Integer id) {
		try {
			Carta carta = null;
			carta = cartaRepository.consultarPorId(id);
			if (carta != null) {
				return Response.ok(carta).build();
			} else {
				throw new CartaNaoExisteException();
			}
		} catch (CartaNaoExisteException e) {
			e.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(404).build();
		}
		
		
	}

	@Override
	public Response inserirCarta(Carta carta) {
		try {
			cartaRepository.adicionarCarta(carta);
			return Response.status(Response.Status.CREATED).entity(carta).build();
		} catch (MaximoDeCartasException e) {
			e.printStackTrace();
			return Response.status(Response.Status.NOT_ACCEPTABLE).entity(e.getMessage()).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
		}
		
	}

	@Override
	public Response excluirCarta(Integer id) {
		try {
			cartaRepository.deletarPorId(id);
			return Response.ok().build();
		} catch (CartaNaoExisteException e) {
			e.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
		} catch (Exception e) {
			return Response.status(404).build();
		}
	}
	
	

}
