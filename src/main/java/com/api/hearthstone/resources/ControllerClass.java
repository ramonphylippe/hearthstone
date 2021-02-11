package com.api.hearthstone.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/main")
public class ControllerClass {

	@GET
	public String teste() {
		return "deu bom";
	}
}
