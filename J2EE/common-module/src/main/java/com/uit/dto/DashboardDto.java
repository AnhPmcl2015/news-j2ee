package com.uit.dto;

import com.uit.common.base.BaseDto;

public class DashboardDto extends BaseDto{

	/**
	 * 
	 */
	
	private String id;
	private String title;
	private String description;
	private String author;
	private String accepted;
	private String editDate;
	private String priority;
	private boolean isTrending;
	private String link;
	private String views;
	

	public DashboardDto() {
		super();
	}
	public DashboardDto(String id, String title, String description, String author, String accepted, String editDate,
			String priority, Boolean trending, String link, String views) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.author = author;
		this.accepted = accepted;
		this.editDate = editDate;
		this.priority = priority;
		this.isTrending = trending;
		this.link = link;
		this.views = views;
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAccepted() {
		return accepted;
	}
	public void setAccepted(String accepted) {
		this.accepted = accepted;
	}
	public String getEditDate() {
		return editDate;
	}
	public void setEditDate(String editDate) {
		this.editDate = editDate;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public Boolean getIsTrending() {
		return isTrending;
	}
	public void setIsTrending(Boolean trending) {
		this.isTrending = trending;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getViews() {
		return views;
	}
	public void setViews(String views) {
		this.views = views;
	}
	
	
	
}
