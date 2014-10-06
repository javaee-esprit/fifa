package com.fifa.persistence;

import com.fifa.persistence.User;
import java.io.Serializable;
import javax.persistence.*;

@Entity

public class Admin extends User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int level;

	public Admin() {
	} 
	public Admin(String login, String password, int level) {
		super(login, password);
		this.level = level;
	}
	public int getLevel() {
		return this.level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String toString() {
		return "Admin [level=" + level + ", id=" + getId()
				+ ", login=" + getLogin() + ", password="
				+ getPassword() + "]";
	}
	
	
   
}
