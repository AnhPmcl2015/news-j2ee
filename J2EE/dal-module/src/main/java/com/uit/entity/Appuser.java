package com.uit.entity;
// Generated Apr 22, 2019 1:25:12 AM by Hibernate Tools 5.1.10.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Appuser generated by hbm2java
 */
@Entity
@Table(name = "appuser", catalog = "news_database")
public class Appuser implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6409950549409507404L;
	private Integer id;
	private String userName;
	private Date createdDate;
	private String userPassword;
	private String fullname;
	private Set<News> newses = new HashSet<News>(0);
	private Set<UserRole> userRoles = new HashSet<UserRole>(0);

	public Appuser() {
	}

	public Appuser(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Appuser(String userName, Date createdDate, String userPassword, String fullname, Set<News> newses,
			Set<UserRole> userRoles) {
		this.userName = userName;
		this.createdDate = createdDate;
		this.userPassword = userPassword;
		this.fullname = fullname;
		this.newses = newses;
		this.userRoles = userRoles;
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

	@Column(name = "user_name", length = 10)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false, length = 19)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "user_password")
	public String getUserPassword() {
		return this.userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Column(name = "fullname")
	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "appuser")
	public Set<News> getNewses() {
		return this.newses;
	}

	public void setNewses(Set<News> newses) {
		this.newses = newses;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "appuser")
	public Set<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

}
