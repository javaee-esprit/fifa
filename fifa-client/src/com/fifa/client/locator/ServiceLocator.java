package com.fifa.client.locator;

import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ServiceLocator {
	
	private static ServiceLocator instance;
	
	public synchronized static ServiceLocator getInstance() {
		if (instance == null) {
			instance = new ServiceLocator();
		}
		return instance;
	}
	private ServiceLocator() {
		cache = new HashMap<>();
		try {
			context = new InitialContext();
		} catch (NamingException e) {
			throw new ServiceLocatorException(e);
		}
	}
	private Map<String, Object> cache;
	private Context context = null;
	
	public synchronized Object getProxy(String jndiName){
		Object proxy = cache.get(jndiName);
		if (proxy == null) {
			try {
				proxy = context.lookup(jndiName);
			} catch (NamingException e) {
				throw new ServiceLocatorException(e);
			}
			cache.put(jndiName, proxy);
		}
		
		return proxy;
	}
}
