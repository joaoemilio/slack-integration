package com.ibm.watsonibmer.action;

import com.ibm.watsonibmer.slack.domain.Payload;

public class ReplyTextAction extends Action {
	
	private Payload payload;
	
	public ReplyTextAction(){
		
	}
	
	public ReplyTextAction(String actionName, String sourceText) {
		super(actionName, sourceText);
	}
	
	public void execute() {
		this.payload = new Payload(sourceText);
		System.out.println("executing reply text action");
		
		
	}

	public Payload getPayload() {
		return payload;
	}

	public void setPayload(Payload payload) {
		this.payload = payload;
	}

	
}
