package com.uit.dto;

import java.awt.List;
import java.util.ArrayList;

import com.uit.common.base.BaseDto;

public class CreateSingleDto extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6937154656976049639L;

	private String id;
	private String title;
	private String description;
	private String thumpnail;
	private String tag;
	private String author;
	private String editDate;
	private String content;
	public CreateSingleDto(String id, String title, String description, String thumpnail, String tag, String content, String editDate, String author) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.thumpnail = thumpnail;
		this.tag = tag;
		this.content = content;
		this.author = author;
		this.editDate = editDate;
	}
	public CreateSingleDto() {
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
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return this.author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getEditDate() {
		return this.editDate;
	}
	public void setEditDate(String editDate) {
		this.editDate = editDate;
	}
	
	
}
	