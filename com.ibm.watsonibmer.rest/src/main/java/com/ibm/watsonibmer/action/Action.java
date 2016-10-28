package com.ibm.watsonibmer.action;

public abstract class Action {
	
	protected String actionName;
	protected String sourceText;
	
	public Action() {
		
	}
	
	public String getSourceText() {
		return sourceText;
	}

	public void setSourceText(String sourceText) {
		this.sourceText = sourceText;
	}

	public Action(String actionName, String sourceText) {
		this.actionName = actionName;
		this.sourceText = sourceText;
	}
	
	public abstract void execute();

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

}
