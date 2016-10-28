package com.ibm.watsonibmer.service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.ibm.watsonibmer.action.Action;
import com.ibm.watsonibmer.action.ReplyTextAction;

public class SlackSlashCommandParser {

	private static HashMap<String, HashMap<String, Class>> teamActions = new HashMap<String, HashMap<String, Class>>();
	static {
		init();
	}
	public static Options createOptions(String team) {
		Options options = null;
		if(team.equalsIgnoreCase("w3c")) {
			options = createW3COptions();
		}
		return options;
	}
	
	public static Options createW3COptions() {
		Options options = new Options();
		options.addOption("help", false, "print this message");
		options.addOption("details", false, "determine if you want detailed or summary responses");
		options.addOption("search_crawl_status", false, "gather the latest w3c search crawl status available" );
		
		return options;
	}
	
	public static Action getTeamAction(String commandLine) {
		
	    // create the parser
	    CommandLineParser parser = new DefaultParser();
        // parse the command line arguments
	    
    	Options options = SlackSlashCommandParser.createW3COptions();
    	String args[] = commandLine.split(" ");
        CommandLine line = null;
		try {
			line = parser.parse( options, args );
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        String actionName = line.getArgs()[0];
		String team = "w3c";
		HashMap<String, Class> actions = actions = teamActions.get(team);
		System.out.println("team: " + team + " action " + actionName);
		Class c = actions.get(actionName);
		Constructor cons = null;
		try {
			cons = c.getConstructor(String.class, String.class);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		Action action = null;
		try {
			String sourceText = "";
			if(args.length > 1) {
				sourceText = args[1];
			}
			action = (Action) cons.newInstance(actionName, sourceText);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		return action;
	}
	
	public static void init() {
		String team = "w3c";
		String actionName = "search_crawl_status";
		addAction(team, actionName, ReplyTextAction.class);
	}
	
	public static void addAction(String team, String actionName, Class actionClass) {
		HashMap<String, Class> actions = actions = teamActions.get(team);
		if(actions == null) {
			actions = new HashMap<String, Class>();
			teamActions.put(team, actions);
		}
		actions.put(actionName, actionClass);
	}
	
}
