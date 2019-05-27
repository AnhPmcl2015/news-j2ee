package com.uit.dto;

import com.uit.common.base.BaseDto;

public class SingleDto extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6356448238664991526L;

	private String id;
	private String title;
	private String editDate;
	private String thumpnail;
	private String content;
	private String author;

	public SingleDto(String id, String title, String editDate, String thumpnail, String content, String author) {
		super();
		this.id = id;
		this.title = title;
		this.editDate = editDate;
		this.thumpnail = thumpnail;
		this.content = content;
		this.author = author;
	}

	public SingleDto() {
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

	public String getEditDate() {
		return editDate;
	}

	public void setEditDate(String editDate) {
		this.editDate = editDate;
	}

	public String getThumpnail() {
		return thumpnail;
	}

	public void setThumpnail(String thumpnail) {
		this.thumpnail = thumpnail;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
