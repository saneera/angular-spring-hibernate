package com.angular.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

@Entity
public class Contact {

	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Length(max=32)
    private String id;
	
	private String name;
	
	private String phoneNumber;
	
	private String email;
	
	public Contact(){
		
	}
	
	public Contact(String name, String phoneNumber, String email, String id) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    @Override
    public boolean equals(Object object) {
        if (object instanceof Contact){
            Contact contact = (Contact) object;
            return contact.id == id;
        }

        return false;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
