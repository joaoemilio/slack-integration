package com.ibm.watsonibmer.slack.domain;

public class Field {
	private String title;
	private String value;
	private boolean isShort;
	private transient boolean isMrkdwn;

	Field() {
	}

	public Field(String title) {
		this(title, null, false);
	}

	public Field(String title, String value) {
		this(title, value, false);
	}

	public Field(String title, String value, boolean isShort) {
		this.title = title;
		this.value = value;
		this.isShort = isShort;
	}

	public static Field instance(String title) {
		return new Field(title);
	}

	public static Field instance(String title, String value) {
		return new Field(title, value);
	}

	public Field title(String title) {
		setTitle(title);
		return this;
	}

	public Field value(String value) {
		setValue(value);
		return this;
	}

	public Field isShort(boolean isShort) {
		setShort(isShort);
		return this;
	}

	public Field isMrkdwn(boolean isMrkdwn) {
		setMrkdwn(isMrkdwn);
		return this;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isShort() {
		return isShort;
	}

	public void setShort(boolean isShort) {
		this.isShort = isShort;
	}

	public boolean isMrkdwn() {
		return isMrkdwn;
	}

	public void setMrkdwn(boolean isMrkdwn) {
		this.isMrkdwn = isMrkdwn;
	}

}