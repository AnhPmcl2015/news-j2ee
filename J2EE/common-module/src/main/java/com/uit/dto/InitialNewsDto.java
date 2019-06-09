package com.uit.dto;

import com.uit.common.base.BaseDto;

public class InitialNewsDto extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6937154656976049639L;

	private String id;
	private String title;
	private String description;
	private String thumpnail;
	private int tag;
	private String content;
	public InitialNewsDto(String id, String title, String description, String thumpnail, int tag, String content) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.thumpnail = thumpnail;
		this.tag = tag;
		this.content = content;
	}
	public InitialNewsDto() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getThumpnail() {
		return thumpnail;
	}
	public void setThumpnail(String thumpnail) {
		this.thumpnail = thumpnail;
	}
	public int getTag() {
		return tag;
	}
	public void setTag(int tag) {
		this.tag = tag;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
	