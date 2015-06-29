package com.angular.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;


@Entity
public class SystemRole implements Serializable, GrantedAuthority{

	
	private static final long serialVersionUID = 5142868985414894533L;

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Length(max=32)
	private String id;
	
	@NotEmpty
	@Column(unique=true)
	@Length(max=50)
    private String name;
	
	
	@NotEmpty
	@Length(max=255)
    private String description;
    
    /**
     * @see org.acegisecurity.GrantedAuthority#getAuthority()
     */
    @Transient
    public String getAuthority() {
        return getName();
    }
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
    public boolean equals(Object object) {
    	if (!(object instanceof SystemRole)) {
			return false;
		}
    	SystemRole rhs = (SystemRole) object;
		return new EqualsBuilder()
			.append(this.name, rhs.name)
			.isEquals();
    }

    public int hashCode() {
    	return new HashCodeBuilder(-979919235, 1158756145)
		.append(this.name)
		.toHashCode();
    }
	
    
}
