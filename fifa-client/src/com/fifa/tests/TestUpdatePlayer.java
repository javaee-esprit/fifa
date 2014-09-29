package com.fifa.tests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.fifa.persistence.Player;
import com.fifa.services.PlayerServiceRemote;

public class TestUpdatePlayer {
	
	public static void main(String[] args) {
		PlayerServiceRemote proxy = null;
		Context ctx = null;
		try{
			ctx = new InitialContext();
			proxy = (PlayerServiceRemote) ctx.lookup("ejb:/fifa-ejb/PlayerService!com.fifa.services.PlayerServiceRemote");
		}catch(NamingException ex){
			ex.printStackTrace();
		}
		Player messi = new Player();
		messi.setId(1);
		messi.setName("Messi");
		messi.setNumber(12);
		proxy.update(messi);
	}

}
