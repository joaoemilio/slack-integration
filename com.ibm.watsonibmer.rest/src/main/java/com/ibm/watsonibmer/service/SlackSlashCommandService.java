package com.ibm.watsonibmer.service;

import com.ibm.watsonibmer.action.Action;
import com.ibm.watsonibmer.action.ReplyTextAction;
import com.ibm.watsonibmer.domain.ReplyText;
import com.ibm.watsonibmer.slack.domain.Payload;

public class SlackSlashCommandService extends Service {
	
	private Action parseCommandOptions(String commandLine) {
	    Action action = null;
	    try {
	        action = SlackSlashCommandParser.getTeamAction(commandLine);
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	    return action;
	}
	
	public Payload executeAction(String commandLine) {
		Payload result = null;
		Action action = parseCommandOptions(commandLine);
        
        if(action instanceof ReplyTextAction) {
        	ReplyTextAction r = (ReplyTextAction)action;
        	r.execute();
        	result = r.getPayload();
        }
        return result;
	}
	
	public void saveReplyText(ReplyText domain) {
		startTransaction();
		em.merge(domain);
		commitTransaction();
	}

	public ReplyText find(Class<ReplyText> class1, String name) {
		return null;
	}

}
