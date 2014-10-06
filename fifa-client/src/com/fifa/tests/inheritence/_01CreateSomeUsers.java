package com.fifa.tests.inheritence;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.fifa.persistence.Admin;
import com.fifa.persistence.Employee;
import com.fifa.persistence.User;
import com.fifa.services.UserServiceRemote;

public class _01CreateSomeUsers {
	
	public static void main(String[] args) {
		UserServiceRemote proxy = null;
		Context ctx = null;
		try{
			ctx = new InitialContext();
			proxy = (UserServiceRemote) ctx.lookup("ejb:/fifa-ejb/UserService!com.fifa.services.UserServiceRemote");
		}catch(NamingException ex){
			ex.printStackTrace();
		}
		
		User u1 = new Admin("admin", "admin", 1);
		User u2 = new Admin("root", "root", 9);
		
		User u3 = new Employee("john", "john", "john", "doe");
		User u4 = new Employee("jean", "jean", "jean", "martin");
		User u5 = new Employee("omar", "omar", "omar", "tounsi");
		
		System.out.println(u1);
		System.out.println(proxy.create(u1));
		
		
		proxy.create(u2);
		proxy.create(u3);
		proxy.create(u4);
		proxy.create(u5);
		
	}

}
