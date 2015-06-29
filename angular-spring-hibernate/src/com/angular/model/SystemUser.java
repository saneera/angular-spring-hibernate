package com.angular.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Index;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



@Entity
@Table(name = "systemuser")
public class SystemUser implements Serializable, UserDetails {

	
	private static final long serialVersionUID = -2612179593178553993L;

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Length(max=32)
	private String id;

	@Version
    protected Integer version;
	
	@NotEmpty
	@Column(unique=true, length=256)
	@Length(max=256)
	@Index(name="ix_systemuser_username")
	private String username;
	
	
	@Length(max=50)
	private String password;
	
	@Length(min=1,max=25)
	private String surname;
	
	@Length(min=1,max=25)
	private String firstName;
	
	
    @ManyToMany(fetch = FetchType.EAGER) 
    @JoinTable(
            name="user_role",
            joinColumns = { @JoinColumn( name="user_id") },
            inverseJoinColumns = @JoinColumn( name="role_id")
    )  	
    protected Set<SystemRole> roles = new HashSet<SystemRole>();
    
    protected boolean enabled;
    protected boolean accountExpired;
    protected boolean accountLocked;
    protected boolean credentialsExpired;
    
    
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
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Set<SystemRole> getRoles() {
		return roles;
	}
	public void setRoles(Set<SystemRole> roles) {
		this.roles = roles;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public boolean isAccountExpired() {
		return accountExpired;
	}
	public void setAccountExpired(boolean accountExpired) {
		this.accountExpired = accountExpired;
	}
	public boolean isAccountLocked() {
		return accountLocked;
	}
	public void setAccountLocked(boolean accountLocked) {
		this.accountLocked = accountLocked;
	}
	public boolean isCredentialsExpired() {
		return credentialsExpired;
	}
	
	public void setCredentialsExpired(boolean credentialsExpired) {
		this.credentialsExpired = credentialsExpired;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		 if (this.roles != null) {
			 authorities = Arrays.asList(this.roles.toArray(new GrantedAuthority[0])); 
		 }		

    	return authorities;
	}

	public boolean isAccountNonExpired() {
		return !isAccountExpired();
	}

	public boolean isAccountNonLocked() {
		return !isAccountLocked();
	}

	public boolean isCredentialsNonExpired() {
		return !isCredentialsExpired();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
    
   
}