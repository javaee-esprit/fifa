package com.fifa.client.ui;

import java.util.HashMap;
import java.util.Map;

public class Session {
	
	private static Session instance;
	
	private Session() {
		store = new HashMap<>();
	}
	
	public synchronized static Session getInstance() {
		if (instance == null) {
			instance = new Session();
		}
		return instance;
	}
	
	
	
	//***************************************/

	private Map<String, Object> store;
	

	public Map<String, Object> getStore() {
		return store;
	}

	public void setStore(Map<String, Object> store) {
		this.store = store;
	}
	
	

}
