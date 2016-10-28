package com.ibm.watsonibmer.client;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataOutput;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.watsonibmer.client.dto.PayloadDTO;
import com.ibm.watsonibmer.client.dto.ReplyTextDTO;
import com.ibm.watsonibmer.core.json.JSONParser;

public class SlackIntegrationDelegate {

	private static SlackIntegrationDelegate me;
	private String SLACK_WEBHOOK = "https://slackibm.mybluemix.net/watsonibmer/rest/slack";
	//private String SLACK_WEBHOOK = "http://localhost:9080/watsonibmer/rest/slack";
	
	private SlackIntegrationDelegate() {
		
	}
	
	public static SlackIntegrationDelegate getInstance() {
		if(me == null) {
			me = new SlackIntegrationDelegate();
		}
		return me;
	}
	
	public void sendReplyText(String command, String json) {
		post("/" + command, json);
	}
	
	private String post(String path, String jsonString) {
		ClientRequest request = new ClientRequest(this.SLACK_WEBHOOK + path);
		System.out.println("post: " + this.SLACK_WEBHOOK + path + " --- " + jsonString);
		ClientResponse response = null;
		try {
			request.body("application/json", jsonString);
			response = request.post(String.class);
			System.out.println(response.getResponseStatus().getStatusCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
		String result = (String)response.getEntity(String.class);
        return result;
		
	}
	
	private void postMultipart(String path, PayloadDTO payload) {
		ClientRequest request = new ClientRequest(this.SLACK_WEBHOOK  );

		request.accept(MediaType.MULTIPART_FORM_DATA_TYPE);
		
		MultipartFormDataOutput form = new MultipartFormDataOutput();
		form.addFormData("text", payload.getText(), MediaType.TEXT_PLAIN_TYPE);
		request.body(MediaType.MULTIPART_FORM_DATA_TYPE, form);
		try {
			ClientResponse<?> response = request.post();
			System.out.println(response.getEntity(String.class));
			System.out.println(response.getResponseStatus().getStatusCode());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String get(String path, String uuid) {
		ClientRequest client = new ClientRequest(this.SLACK_WEBHOOK + path + "/" + uuid);
		ClientResponse response = null;
		try {
			response = client.get(String.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String result = (String) response.getEntity(String.class);
        return result;
	}

	private String get(String path) {
		ClientRequest client = new ClientRequest(this.SLACK_WEBHOOK + path);
		ClientResponse response = null;
		try {
			response = client.get(String.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String result = (String) response.getEntity(String.class);
        return result;
	}

	
	public List<ReplyTextDTO> findReplies() {
        String json = get("/reply/list");
        ObjectMapper mapper = new ObjectMapper();
        List<ReplyTextDTO> myObjects = null;
		try {
			myObjects = mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, ReplyTextDTO.class));
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myObjects;
	}
	
	
	public static void main(String args[]) {
		PayloadDTO payload = new PayloadDTO("search_crawl_status");
		SlackIntegrationDelegate delegate = SlackIntegrationDelegate.getInstance();

		String json = JSONParser.getInstance().toJSONString(payload);
		
		delegate.sendReplyText("search_crawl_status", json);
	}
	
}
