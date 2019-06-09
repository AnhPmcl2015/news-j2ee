package com.uit.dto;

import com.uit.common.base.BaseDto;

public class SimpleNewsDto extends BaseDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6062845461894049896L;

	private String id;
	private String thumpnail;
	private String editDate;
	private String title;
	private String description;
	private String tag_url;
	private String url;
	private String errorMessage;

	public SimpleNewsDto(String id, String thumpnail, String editDate, String title, String description, String tag_url,
			String url) {
		super();
		this.id = id;
		this.thumpnail = thumpnail;
		this.editDate = editDate;
		this.title = title;
		this.description = description;
		this.tag_url = tag_url;
		this.url = url;
		this.errorMessage = "Lỗi";
	}

	public SimpleNewsDto() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getThumpnail() {
		return thumpnail;
	}

	public void setThumpnail(String thumpnail) {
		this.thumpnail = thumpnail;
	}

	public String getEditDate() {
		return editDate;
	}

	public void setEditDate(String editDate) {
		this.editDate = editDate;
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

	public String getTag_url() {
		return tag_url;
	}

	public void setTag_url(String tag_url) {
		this.tag_url = tag_url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	

}
