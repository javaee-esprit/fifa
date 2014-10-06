package com.fifa.tests.inheritence;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.fifa.persistence.Admin;
import com.fifa.persistence.Employee;
import com.fifa.persistence.User;
import com.fifa.services.UserServiceRemote;

public class _04Authenticate {
	
	public static void main(String[] args) {
		UserServiceRemote proxy = null;
		Context ctx = null;
		try{
			ctx = new InitialContext();
			proxy = (UserServiceRemote) ctx.lookup("ejb:/fifa-ejb/UserService!com.fifa.services.UserServiceRemote");
		}catch(NamingException ex){
			ex.printStackTrace();
		}
		
		User user = proxy.authenticate("omar", "omar");
		if (user != null) {
			System.out.print("ACCESS GRANTED");
			if (user instanceof Employee) {
				System.out.println(" AS EMPLOYEE");
			}else if (user instanceof Admin) {
				System.out.println(" AS ADMIN");
			}
			else if (user instanceof User) {
				System.out.println(" AS USER");
			}
			
			
		} else {
			System.out.println("ACCESS DENIED");
		}
		
	}

}
