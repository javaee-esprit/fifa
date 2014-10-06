package com.fifa.tests.inheritence;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.fifa.persistence.Employee;
import com.fifa.services.UserServiceRemote;

public class _03FindOnlyEmployees {
	
	public static void main(String[] args) {
		UserServiceRemote proxy = null;
		Context ctx = null;
		try{
			ctx = new InitialContext();
			proxy = (UserServiceRemote) ctx.lookup("ejb:/fifa-ejb/UserService!com.fifa.services.UserServiceRemote");
		}catch(NamingException ex){
			ex.printStackTrace();
		}
		
		List<Employee> employees = proxy.findAllEmployees();
		for(Employee emp : employees)
			System.out.println(emp);
	}

}
