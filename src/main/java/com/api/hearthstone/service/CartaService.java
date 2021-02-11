package com.api.hearthstone.service;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.api.hearthstone.entidade.Carta;

@Path("/carta")
@Produces(MediaType.APPLICATION_JSON)
public interface CartaService {
	
	@GET
	public List<Carta> buscarTodas();
	
	@Path("{id}")
	@GET
	public Response buscarPorId(@PathParam("id") Integer id);
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserirCarta(Carta carta);
	
	@Path("{id}")
	@DELETE
	public Response excluirCarta(@PathParam("id") Integer id);
}
