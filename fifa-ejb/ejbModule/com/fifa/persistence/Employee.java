package com.fifa.persistence;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

@Entity

public class Employee extends User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	private String firstname;
	private String lastname;

	public Employee() {
	}
	
	public Employee(String login, String password, String firstname,
			String lastname) {
		super(login, password);
		this.firstname = firstname;
		this.lastname = lastname;
	}


	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}   
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "Employee [firstname=" + firstname + ", lastname=" + lastname
				+ ", id=" + getId() + ", login=" + getLogin()
				+ ", password=" + getPassword() + "]";
	}



	
	
   
}
