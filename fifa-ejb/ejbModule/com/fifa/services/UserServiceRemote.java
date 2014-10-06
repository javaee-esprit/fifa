package com.fifa.services;

import java.util.List;

import javax.ejb.Remote;

import com.fifa.persistence.Employee;
import com.fifa.persistence.User;

@Remote
public interface UserServiceRemote {
	
	User authenticate(String login, String password);
	
	User create(User user);
	List<Employee> findAllEmployees();
	List<User> findAllUsers();
	

}
