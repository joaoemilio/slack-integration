package com.ibm.watsonibmer.slack.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Attachment {
	private String fallback;
	private String text;
	private String pretext;
	private String color;
	private List<Field> fields;
	private Set<String> mrkdwn_in;
	private String title;
	@JsonProperty("title-link")
	private String titleLink;
	private String footer;
	@JsonProperty("footer-icon")
	private String footerIcon;
	private String ts;

	Attachment() {
	}

	public Attachment(String fallback) {
		this.fallback = fallback;
	}

	public static Attachment instance(String fallback) {
		return new Attachment(fallback);
	}

	public Attachment fallback(String fallback) {
		setFallback(fallback);
		return this;
	}

	public Attachment text(String text) {
		setText(text);
		return this;
	}

	public Attachment pretext(String pretext) {
		setPretext(pretext);
		return this;
	}

	public Attachment color(String color) {
		setColor(color);
		return this;
	}

	public Attachment fields(Field...fields) {
		if (this.fields == null)
			setFields(new ArrayList<Field>(Arrays.asList(fields)));
		else
			setFields(Arrays.asList(fields));
		return this;
	}

	public String getFallback() {
		return fallback;
	}

	public void setFallback(String fallback) {
		this.fallback = fallback;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getPretext() {
		return pretext;
	}

	public void setPretext(String pretext) {
		this.pretext = pretext;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public List<Field> getFields() {
		return fields;
	}

	public void addField(Field field) {
		if (fields == null) {
			fields = new ArrayList<Field>();
		}
		fields.add(field);

		if (field.isMrkdwn()) {
			if (mrkdwn_in == null) {
				mrkdwn_in = new TreeSet<String>();
			}
			mrkdwn_in.add("fields");
		}
	}

	public void setFields(List<Field> fields) {
		this.fields = null;
		this.mrkdwn_in = null;

		for (Field field : fields) {
			addField(field);
		}
	}

	public Set<String> getMrkdwn_in() {
		return mrkdwn_in;
	}

	public void setMrkdwn_in(Set<String> mrkdwn_in) {
		this.mrkdwn_in = mrkdwn_in;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitleLink() {
		return titleLink;
	}

	public void setTitleLink(String titleLink) {
		this.titleLink = titleLink;
	}

	public String getFooter() {
		return footer;
	}

	public void setFooter(String footer) {
		this.footer = footer;
	}

	public String getFooterIcon() {
		return footerIcon;
	}

	public void setFooterIcon(String footerIcon) {
		this.footerIcon = footerIcon;
	}

	public String getTs() {
		return ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}
	
	
}