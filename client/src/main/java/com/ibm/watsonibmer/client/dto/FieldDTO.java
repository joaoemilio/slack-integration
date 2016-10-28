package com.ibm.watsonibmer.client.dto;

public class FieldDTO {
	private String title;
	private String value;
	private boolean isShort;
	private transient boolean isMrkdwn;

	FieldDTO() {
	}

	public FieldDTO(String title) {
		this(title, null, false);
	}

	public FieldDTO(String title, String value) {
		this(title, value, false);
	}

	public FieldDTO(String title, String value, boolean isShort) {
		this.title = title;
		this.value = value;
		this.isShort = isShort;
	}

	public static FieldDTO instance(String title) {
		return new FieldDTO(title);
	}

	public static FieldDTO instance(String title, String value) {
		return new FieldDTO(title, value);
	}

	public FieldDTO title(String title) {
		setTitle(title);
		return this;
	}

	public FieldDTO value(String value) {
		setValue(value);
		return this;
	}

	public FieldDTO isShort(boolean isShort) {
		setShort(isShort);
		return this;
	}

	public FieldDTO isMrkdwn(boolean isMrkdwn) {
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