package com.fifa.services;

import javax.ejb.Local;

import com.fifa.persistence.User;

@Local
public interface UserServiceLocal {
	
	User authenticate(String login, String password);

}
