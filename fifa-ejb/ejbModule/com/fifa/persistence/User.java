package com.fifa.persistence;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@Table(name="t_user")
public class User implements Serializable {

	
	private static final long serialVersionUID = 12L;
	
	
	private int id;
	private String login;
	private String password;

	public User() {
	}
	
	
	
	public User(String login, String password) {
		this.login = login;
		this.password = password;
	}



	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Column( unique = true )
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password
				+ "]";
	}
	
	
   
}
