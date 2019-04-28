package com.uit.entity;
// Generated Apr 22, 2019 1:25:12 AM by Hibernate Tools 5.1.10.Final

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

/**
 * Approle generated by hbm2java
 */
@Entity
@Table(name = "approle", catalog = "news_database")
public class Approle implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1473145438525883299L;
	private Integer id;
	private String roleName;
	private Set<UserRole> userRoles = new HashSet<UserRole>(0);

	public Approle() {
	}

	public Approle(String roleName, Set<UserRole> userRoles) {
		this.roleName = roleName;
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

	@Column(name = "role_name", length = 100)
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "approle")
	public Set<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

}
