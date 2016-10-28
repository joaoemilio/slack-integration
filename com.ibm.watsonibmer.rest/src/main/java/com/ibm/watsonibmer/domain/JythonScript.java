package com.ibm.watsonibmer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class JythonScript extends TransferObject {
	
	@Id
	private String name;
	@Column(columnDefinition="LONGTEXT")
	private String contents;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	

}
