package com.uit.entity;
// Generated Apr 22, 2019 1:25:12 AM by Hibernate Tools 5.1.10.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * News generated by hbm2java
 */
@Entity
@Table(name = "news", catalog = "news_database")
public class News implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1474670939751781515L;
	private Integer id;
	private Appuser appuser;
	private Category category;
	private String title;
	private String content;
	private String description;
	private Date createdDate;
	private String thumpnail;

	public News() {
	}

	public News(Date createdDate) {
		this.createdDate = createdDate;
	}

	public News(Appuser appuser, Category category, String title, String content, String description, Date createdDate,
			String thumpnail) {
		this.appuser = appuser;
		this.category = category;
		this.title = title;
		this.content = content;
		this.description = description;
		this.createdDate = createdDate;
		this.thumpnail = thumpnail;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	public Appuser getAppuser() {
		return this.appuser;
	}

	public void setAppuser(Appuser appuser) {
		this.appuser = appuser;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id")
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name = "title")
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "content", length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false, length = 19)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "thumpnail")
	public String getThumpnail() {
		return this.thumpnail;
	}

	public void setThumpnail(String thumpnail) {
		this.thumpnail = thumpnail;
	}

}
