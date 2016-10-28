package com.ibm.watsonibmer.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ibm.watsonibmer.core.json.JSONParser;
import com.ibm.watsonibmer.domain.ReplyText;
import com.ibm.watsonibmer.service.SlackSlashCommandService;
import com.ibm.watsonibmer.slack.domain.Payload;

@Path("/slack")
public class SlackREST {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response command(@FormParam("token") String token, @FormParam("text") String commandLine, @FormParam("channel_id") String channel, @FormParam("response_url") String url) {
		System.out.println("token: " + token );
		System.out.println("mensagem: " + commandLine);
		
		SlackSlashCommandService service = new SlackSlashCommandService();
		Payload payload = service.executeAction(commandLine);
		
    	String json = JSONParser.getInstance().toJSONString(payload);
		
	    return Response.ok(json, MediaType.APPLICATION_JSON).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{command}")
	public Response sendReplyText(@PathParam("command") String command, String json) {
		SlackSlashCommandService service = new SlackSlashCommandService();
		System.out.println("command: " + command);
		System.out.println("payload: " + json);
		ReplyText domain = new ReplyText();
		domain.setName(command);
		domain.setText(json);
		service.saveReplyText(domain);
		System.out.println("saved successfully");
	    return Response.ok("{}", MediaType.APPLICATION_JSON).build();
	}
		
}
