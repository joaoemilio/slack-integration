package com.ibm.watsonibmer.slack.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Payload {
	private String text;
	private String channel;
	private String username;
	@JsonProperty("icon-url")
	private String iconUrl;
	@JsonProperty("icon-emoji")
	private String iconEmoji;
	@JsonProperty("unfurl-links")
	private boolean unfurlLinks;
	private List<Attachment> attachments;

	Payload() {
	}

	public Payload(String text) {
		this.text = text;
	}

	public static Payload instance(String text) {
		return new Payload(text);
	}

	public Payload text(String text) {
		setText(text);
		return this;
	}

	public Payload channel(String channel) {
		setChannel(channel);
		return this;
	}

	public Payload username(String username) {
		setUsername(username);
		return this;
	}

	public Payload iconUrl(String url) {
		setIconUrl(url);
		return this;
	}

	public Payload iconEmoji(String emoji) {
		setIconEmoji(emoji);
		return this;
	}

	public Payload icon(String icon) {
		if (icon != null && !icon.isEmpty()) {
			if (icon.indexOf("://") == -1) {
	    		iconEmoji(icon);
			} else {
				setIconUrl(icon);
			}
		}
		return this;
	}

	public Payload attachments(Attachment... attachments) {
		if (this.attachments == null)
			this.attachments = new ArrayList<Attachment>(Arrays.asList(attachments));
		else
			this.attachments.addAll(Arrays.asList(attachments));
		return this;
	}

	public Payload unfurlLinks(boolean unfurlLinks) {
		setUnfurlLinks(unfurlLinks);
		return this;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconEmoji = null;
		this.iconUrl = iconUrl;
	}

	public String getIconEmoji() {
		return iconEmoji;
	}

	public void setIconEmoji(String iconEmoji) {
		this.iconUrl = null;

		if (iconEmoji != null && iconEmoji.isEmpty()) {
			if (iconEmoji.charAt(0) != ':') {
				iconEmoji = ":" + iconEmoji;
			}
			if (iconEmoji.charAt(iconEmoji.length() - 1) != ':') {
				iconEmoji = iconEmoji + ":";
			}
		}
		this.iconEmoji = iconEmoji;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void addAttachment(Attachment attachment) {
		if (attachments == null)
			attachments = new ArrayList<Attachment>(3);
		attachments.add(attachment);
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	public void setUnfurlLinks(boolean unfurlLinks) {
		this.unfurlLinks = unfurlLinks;
	}
}