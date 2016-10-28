package com.ibm.watsonibmer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ReplyText extends TransferObject {

	@Id
	private String name;
	@Column(columnDefinition="LONGTEXT")
	private String text;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getText() {
		return text;
	}
	@Column(length = 4000)
	public void setText(String text) {
		this.text = text;
	}


}
