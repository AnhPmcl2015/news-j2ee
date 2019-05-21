package com.uit.entity;
// Generated May 20, 2019 1:05:38 AM by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * News generated by hbm2java
 */
@Entity
@Table(name = "news", catalog = "news_database")
public class News implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 611578966784057736L;
	private String newsId;
	private AppUser appUserByAuthorId;
	private AppUser appUserByAcceptanceUserId;
	private String title;
	private String summary;
	private String thumpnail;
	private String content;
	private int priorityId;
	private int views;
	private Set<Tag> tags = new HashSet<Tag>(0);

	public News() {
	}

	public News(String newsId, String title, AppUser appUserByAuthorId, AppUser appUserByAcceptanceUserId, String summary,
			String thumpnail, String content, int views, int priorityId) {
		this.newsId = newsId;
		this.title = title;
		this.appUserByAuthorId = appUserByAuthorId;
		this.appUserByAcceptanceUserId = appUserByAcceptanceUserId;
		this.summary = summary;
		this.thumpnail = thumpnail;
		this.content = content;
		this.views = views;
		this.priorityId = priorityId;
	}

	public News(String newsId, String title, AppUser appUserByAuthorId, AppUser appUserByAcceptanceUserId, String summary,
			String thumpnail, String content, int views, int priorityId, Set<Tag> tags) {
		this.newsId = newsId;
		this.appUserByAuthorId = appUserByAuthorId;
		this.title = title;
		this.appUserByAcceptanceUserId = appUserByAcceptanceUserId;
		this.summary = summary;
		this.thumpnail = thumpnail;
		this.content = content;
		this.views = views;
		this.priorityId = priorityId;
		this.tags = tags;
	}

	@Id

	@Column(name = "news_id", unique = true, nullable = false, length = 14)
	public String getNewsId() {
		return this.newsId;
	}

	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "author_id", nullable = false)
	public AppUser getAppUserByAuthorId() {
		return this.appUserByAuthorId;
	}

	public void setAppUserByAuthorId(AppUser appUserByAuthorId) {
		this.appUserByAuthorId = appUserByAuthorId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "acceptance_user_id", nullable = false)
	public AppUser getAppUserByAcceptanceUserId() {
		return this.appUserByAcceptanceUserId;
	}

	public void setAppUserByAcceptanceUserId(AppUser appUserByAcceptanceUserId) {
		this.appUserByAcceptanceUserId = appUserByAcceptanceUserId;
	}

	@Column(name = "summary", nullable = false)
	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Column(name = "thumpnail", nullable = false, length = 200)
	public String getThumpnail() {
		return this.thumpnail;
	}

	public void setThumpnail(String thumpnail) {
		this.thumpnail = thumpnail;
	}

	@Column(name = "content", nullable = false, length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "priority_id", nullable = false)
	public int getPriorityId() {
		return this.priorityId;
	}

	public void setPriorityId(int priorityId) {
		this.priorityId = priorityId;
	}


	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "tag_news", catalog = "news_database", joinColumns = {
			@JoinColumn(name = "news_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "tag_id", nullable = false, updatable = false) })
	public Set<Tag> getTags() {
		return this.tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	@Column(name = "views")
	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	@Column(name = "title", nullable = false, length = 200)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	

}