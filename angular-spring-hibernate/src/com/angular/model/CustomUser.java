package com.angular.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Index;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "customuser")
public class CustomUser implements Serializable {
	
	
	private static final long serialVersionUID = -6781779095000958805L;

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Length(max=32)
	private String id;

	
	@Version
	private Integer version;
	
	@NotEmpty
	@Length(max=40)
	private String name;
	
	@NotEmpty
	@Length(max=6)
	@Column(unique=true)	
	private String code;
	
	@NotEmpty
	@Length(max=40)
	private String surname;
	
	
	@NotEmpty
	@Length(max=256)
	@Column(length=256)
	private String email;
	
	
	@ManyToOne
	@NotNull
	@JsonIgnore
	@Index(name="customuser_systemuser_fk_idx")
	private SystemUser systemUser;
	
		
	private String systemRole;


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Integer getVersion() {
		return version;
	}


	public void setVersion(Integer version) {
		this.version = version;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public SystemUser getSystemUser() {
		return systemUser;
	}


	public void setSystemUser(SystemUser systemUser) {
		this.systemUser = systemUser;
	}


	public String getSystemRole() {
		return systemRole;
	}


	public void setSystemRole(String systemRole) {
		this.systemRole = systemRole;
	}
	
	

}
