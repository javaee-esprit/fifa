package com.fifa.client.delegate;

import java.util.List;

import com.fifa.client.locator.ServiceLocator;
import com.fifa.persistence.Employee;
import com.fifa.persistence.User;
import com.fifa.services.UserServiceRemote;

public class UserServiceDelegate{
	
	
	private static final String jndiName = "ejb:fifa/fifa-ejb/UserService!com.fifa.services.UserServiceRemote";
	
	private static UserServiceRemote getProxy(){
		return (UserServiceRemote) ServiceLocator.getInstance().getProxy(jndiName);
	}

	public static User authenticate(String login, String password) {
		return getProxy().authenticate(login, password);
	}

	public static User create(User user) {
		return getProxy().create(user);
	}

	public static List<Employee> findAllEmployees() {
		return getProxy().findAllEmployees();
	}

	public static List<User> findAllUsers() {
		return getProxy().findAllUsers();
	}

}
