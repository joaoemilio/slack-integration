package com.ibm.watsonibmer.rest;


public class ConfigREST {
	/*
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(String json) {
		ConfigService service = new ConfigService();
		Config domain = (Config)JSONParser.getInstance().toObject(json, Config.class);
		if(domain != null) {
			UUID uuid = service.create(domain);
			domain.setConfig_uuid(uuid);
			json = JSONParser.getInstance().toJSONString(domain);
		    return Response.ok(json, MediaType.APPLICATION_JSON).build();
		} else {
			return Response.status(Response.Status.CONFLICT).entity("N�o � possivel criar o Config com as informa��es fornecidas").build();
		}
	}
	
	@GET
	@Path("/{uuid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("uuid") String _uuid) {
		ConfigService service = new ConfigService();
		Config domain = service.find( UUID.fromString(_uuid) );
		if( domain != null) {
			String json = JSONParser.getInstance().toJSONString(domain);
		    return Response.ok( json , MediaType.APPLICATION_JSON).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).entity("Config n�o encontrado: " + _uuid).build();
		}
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAllGames() {
		ConfigService service = new ConfigService();
		Collection<Config> list = service.findAll();
		String json = JSONParser.getInstance().toJSONString(list);
		return Response.ok(json, MediaType.APPLICATION_JSON).build();
	}
	
	@DELETE
	@Path("/{uuid}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("uuid") String _uuid) {
		ConfigService service = new ConfigService();
		Config domain = service.find( UUID.fromString(_uuid) );
		if( domain != null) {
			service.delete(domain);
		    return Response.ok( "Config removido com sucesso" , MediaType.APPLICATION_JSON).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).entity("Config n�o encontrado: " + _uuid).build();
		}
	}
	*/
	
}
