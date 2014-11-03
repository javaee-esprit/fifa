package com.fifa.services;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.fifa.persistence.Employee;
import com.fifa.persistence.User;

@Stateless
public class UserService implements UserServiceRemote, UserServiceLocal {
	
	@PersistenceContext
	private EntityManager em;

    public UserService() {
    }

	public User authenticate(String login, String password) {
		User found = null;
		String jpql = "select u from User u where u.login=:x and u.password=:y";
		TypedQuery<User> query = em.createQuery(jpql, User.class);
		query.setParameter("x", login);
		query.setParameter("y", password);
		try{
			found = query.getSingleResult();
		}catch(Exception e){
			Logger.getLogger(getClass().getName()).log(Level.WARNING, "auth attempt failed with login="+login+" and password="+password);
		}
		return found;
	}

	public User create(User user) {
		em.persist(user);
		return user;
	}

	public List<Employee> findAllEmployees() {
		return em.createQuery("select e from Employee e", Employee.class).getResultList();
	}

	public List<User> findAllUsers() {
		return em.createQuery("select u from User u", User.class).getResultList();
	}

	

}
